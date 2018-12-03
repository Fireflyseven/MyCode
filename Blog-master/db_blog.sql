DROP DATABASE IF EXISTS db_blog;
/*创建数据库，并设置编码*/
CREATE DATABASE db_blog DEFAULT CHARACTER SET utf8;

USE db_blog;

CREATE TABLE `t_blogger` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(50) NOT NULL ,
  `password` VARCHAR(100) NOT NULL ,
  `profile` TEXT ,
  `nickname` VARCHAR(50) DEFAULT NULL ,
  `sign` VARCHAR(100) DEFAULT NULL ,
  `imagename` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `t_link` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `linkname` VARCHAR(100) DEFAULT NULL,
  `linkurl` VARCHAR(200) DEFAULT NULL ,
  `orderNum` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `t_blogtype` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `typeName` VARCHAR(30) DEFAULT NULL ,
  `orderNum` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

CREATE TABLE `t_blog` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL ,
  `summary` VARCHAR(400) DEFAULT NULL ,
  `releaseDate` DATETIME DEFAULT NULL ,
  `clickHit` INT(11) DEFAULT NULL ,
  `replyHit` INT(11) DEFAULT NULL,
  `content` TEXT,
  `keyWord` VARCHAR(200) DEFAULT NULL ,
  `type_id` INT(11) DEFAULT NULL ,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `t_blog_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_blogtype` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

CREATE TABLE `t_comment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userIp` VARCHAR(50) DEFAULT NULL ,
  `content` VARCHAR(1000) DEFAULT NULL ,
  `commentDate` DATETIME DEFAULT NULL ,
  `state` INT(11) DEFAULT NULL,
  `blog_id` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `blog_id` (`blog_id`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


