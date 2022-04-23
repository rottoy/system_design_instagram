DROP TABLE `user` IF EXISTS;
DROP TABLE `user_follow` IF EXISTS;
CREATE TABLE `user`
(
    `id`                  int         NOT NULL AUTO_INCREMENT,
    `user_name`           varchar(45) NOT NULL,
    `email`               varchar(45) NOT NULL,
    `password`            varchar(45) NOT NULL,
    `date_of_birth`       datetime    NOT NULL,
    `post_update_date`    timestamp   NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_public`           char(1)     NOT NULL DEFAULT 'Y',
    `number_of_post`      int         NOT NULL DEFAULT '0',
    `number_of_follower`  int         NOT NULL DEFAULT '0',
    `number_of_following` int         NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uq_username` (`user_name`)
) ENGINE = InnoDB AUTO_INCREMENT = 1;

CREATE TABLE `user_follow`
(
    `id`           int NOT NULL AUTO_INCREMENT,
    `follower_id`  int NOT NULL,
    `following_id` int NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uq_folllowerid_followingid` (`follower_id`, `following_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1;

CREATE TABLE `post` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `title` varchar(45) DEFAULT NULL,
                        `user_name` varchar(45) DEFAULT NULL,
                        `number_of_likes` int NOT NULL DEFAULT '0',
                        `update_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        `create_date` datetime DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT = 1;
