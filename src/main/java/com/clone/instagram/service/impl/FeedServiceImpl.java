package com.clone.instagram.service.impl;

import com.clone.instagram.constants.AppConstants;
import com.clone.instagram.dao.FeedDao;
import com.clone.instagram.dao.PostDao;
import com.clone.instagram.model.Post;
import com.clone.instagram.model.User;
import com.clone.instagram.model.UserFeed;
import com.clone.instagram.model.payload.SlicedResult;
import com.clone.instagram.service.FeedService;
import com.clone.instagram.service.PostService;
import com.clone.instagram.service.UserService;
import com.datastax.oss.driver.api.core.cql.PagingState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;


@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    private UserService userService;

    @Autowired
    private PostDao postDao;

    @Autowired
    private FeedDao feedDao; // cassandra


    @Override
    public SlicedResult<Post> getUserFeed(String username, Optional<String> pagingState){

        //1. request userFeed for username

        CassandraPageRequest request = pagingState
                .map(p -> CassandraPageRequest.of(
                        PageRequest.of(0,AppConstants.PAGE_SIZE),
                        (ByteBuffer) PagingState.fromString(p))
                )
                .orElse(CassandraPageRequest.first(AppConstants.PAGE_SIZE));

        System.out.println(request);

        Slice<UserFeed> page =
                feedDao.findByUserName(username, request);

        String pageState = null;
        if(!page.isLast()) {
           pageState = ((CassandraPageRequest)page.getPageable()).getPagingState().toString();
        }

        System.out.println("pageState : " + pageState + ", pageSize : " + page.getNumberOfElements());

        //2.get posts with returned postIds
        List<Integer> postIds = page.stream()
                .map(UserFeed::getPostId)
                .collect(toList());

        List<Post> postList = postDao.selectPostIn(postIds);

        return SlicedResult
                .<Post>builder()
                .isLast(page.isLast())
                .pageState(pageState)
                .content(postList)
                .build();
    }

    /**
    *
    * */
    @Override
    public void generateUserFeed(Post post){

        //1. get following list from user "username"
        int page = 0;
        int size = AppConstants.PAGE_SIZE;

        boolean isLast = false;

        for(; !isLast; page++){
            int userId = userService.getUser(post.getUserName()).getId();
            List<User> followingList = userService.getFollowingList(userId, PageRequest.of(page, size));
            if(followingList.isEmpty()){
                isLast = true;
            }
            else{
            //2. make userFeed from user and post, insert userFeed to follower
            //insert post before insert userfeed.
                followingList
                        .stream()
                        .map(user -> makeUserFeed(user, post))
                        .forEach(feedDao::insert);
            }

        }


    }


    private UserFeed makeUserFeed(User user, Post post){
        System.out.println("making userfeed for user :{}, post :{}"+user+", post : "+post);
        return UserFeed.builder()
                .postId(post.getId())
                .userId(user.getId())
                .userName(user.getUserName())
                .createdAt(new Date())
                .build();
    }
}
