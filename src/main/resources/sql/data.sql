INSERT INTO `user` (`user_name`,`email`,`password`,`date_of_birth`) VALUES ('test_user','test_user@gmail.com','1234','2000-01-02 12:00:00');
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