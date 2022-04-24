INSERT INTO `user` (`user_name`,`email`,`password`,`date_of_birth`) VALUES ('test_user','t22est_user@gmail.com','1234','2000-01-02 12:00:00');
INSERT INTO `user` (`user_name`,`email`,`password`,`date_of_birth`) VALUES ('1q2w3e4r','1q2w3e4r@gmail.com','1234','2000-01-02 12:00:00');
INSERT INTO `user` (`user_name`,`email`,`password`,`date_of_birth`) VALUES ('teemo','teemo@gmail.com','1234','2000-01-02 12:00:00');
INSERT INTO `user` (`user_name`,`email`,`password`,`date_of_birth`) VALUES ('darius','darius@gmail.com','1234','2001-02-03 12:00:00');
INSERT INTO `user` (`user_name`,`email`,`password`,`date_of_birth`) VALUES ('garen','garen@gmail.com','1234','2002-03-04 12:00:00');


INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (1,3);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (1,4);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (1,5);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (2,1);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (2,3);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (4,2);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (4,5);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (5,1);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (5,2);

INSERT INTO `post` (`id`,`title`,`number_of_likes`,`user_name`) VALUES (10000,'test_post_1',3,'test_user');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10001,'test_post_1','1q2w3e4r');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10002,'test_post_1','teemo');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10003,'test_post_1','darius');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10004,'test_post_1','garen');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10005,'test_post_1','test_user');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10006,'test_post_1','1q2w3e4r');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10007,'test_post_1','teemo');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10008,'test_post_1','darius');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10009,'test_post_1','garen');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10010,'test_post_1','test_user');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10011,'test_post_1','1q2w3e4r');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10012,'test_post_1','teemo');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10013,'test_post_1','darius');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10014,'test_post_1','garen');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10015,'test_post_1','test_user');
INSERT INTO `post` (`id`,`title`,`user_name`) VALUES (10016,'test_post_1','1q2w3e4r');

INSERT INTO `likes` (`id`,`type`,`user_id`,`post_id`,`create_date`) VALUES (20000, 0, 5, 10000, now());
INSERT INTO `likes` (`id`,`type`,`user_id`,`post_id`,`create_date`) VALUES (20001, 0, 3, 10000, now());
INSERT INTO `likes` (`id`,`type`,`user_id`,`post_id`,`create_date`) VALUES (20002, 0, 2, 10000, now());

