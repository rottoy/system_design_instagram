package com.clone.instagram.dao;

import com.clone.instagram.model.UserFeed;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface FeedDao extends CassandraRepository<UserFeed, String> {

    Slice<UserFeed> findByUserName(String username, Pageable pageable);
}
