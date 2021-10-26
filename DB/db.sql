CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comment` mediumtext NOT NULL,
  `write_date_time` datetime NOT NULL,
  `users_id` int NOT NULL,
  `posts_id` int NOT NULL,
  `posts_users_id` int NOT NULL,
  PRIMARY KEY (`id`,`users_id`,`posts_id`,`posts_users_id`),
  KEY `fk_comments_users1_idx` (`users_id`),
  KEY `fk_comments_posts1_idx` (`posts_id`,`posts_users_id`),
  CONSTRAINT `fk_comments_posts1` FOREIGN KEY (`posts_id`, `posts_users_id`) REFERENCES `posts` (`id`, `users_id`),
  CONSTRAINT `fk_comments_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `posts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `content` longtext NOT NULL,
  `post_category` enum('frontend','backend','mobile') NOT NULL,
  `published_date_time` datetime NOT NULL,
  `users_id` int NOT NULL,
  PRIMARY KEY (`id`,`users_id`),
  KEY `fk_posts_users_idx` (`users_id`),
  CONSTRAINT `fk_posts_users` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tokens` (
  `id` int NOT NULL AUTO_INCREMENT,
  `token` varchar(45) NOT NULL,
  `created_date` datetime NOT NULL,
  `users_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tokens_users1_idx` (`users_id`),
  CONSTRAINT `fk_tokens_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `active` tinyint NOT NULL DEFAULT '0',
  `role` enum('user','moderator','admin') NOT NULL DEFAULT 'user',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
