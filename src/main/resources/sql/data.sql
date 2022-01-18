INSERT INTO `user` (`user_name`,`email`,`password`,`date_of_birth`,`is_public`) VALUES ('teemo','teemo@gmail.com','1234','2000-01-02 12:00:00','Y');
INSERT INTO `user` (`user_name`,`email`,`password`,`date_of_birth`,`is_public`) VALUES ('darius','darius@gmail.com','1234','2001-02-03 12:00:00','N');
INSERT INTO `user` (`user_name`,`email`,`password`,`date_of_birth`,`is_public`) VALUES ('garen','garen@gmail.com','1234','2002-03-04 12:00:00','Y');


INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (1,3);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (1,4);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (1,5);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (2,1);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (2,3);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (4,2);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (4,5);
INSERT INTO `user_follow` (`follower_id`,`following_id`) VALUES (5,1);