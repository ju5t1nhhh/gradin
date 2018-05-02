# Create Database
CREATE DATABASE IF NOT EXISTS `gradin` CHARSET utf8;


# Change Database
USE `gradin`;


### User Part

# SensitiveWord
CREATE TABLE `sensitive_word`(
	`sw_section` INT,
	`sw_word` VARCHAR(10),
	`sw_replace` VARCHAR(10),
	INDEX (`sw_section`)
)ENGINE=MYISAM CHARSET utf8;

# Section
CREATE TABLE `section`(
	`sec_id` INT,
	`sec_name` VARCHAR(10),
	`sec_intro` VARCHAR(200) COMMENT 'intro words lower than 200',
	`sec_url` VARCHAR(100),
	PRIMARY KEY (`sec_id`)
)ENGINE=MYISAM CHARSET utf8;

# Post
CREATE TABLE `post`(
	`post_id` BIGINT AUTO_INCREMENT,
	`post_author` BIGINT,
	`post_multmedia` TEXT,
	`post_text` TEXT,
	`post_creatime` DATETIME,
	`post_section` INT,
	PRIMARY KEY (`post_id`),
	INDEX (`post_author`),
	INDEX (`post_section`,`post_creatime`)
)ENGINE=INNODB CHARSET utf8;

# Tag
CREATE TABLE `tag`(
	`tag_name` VARCHAR(20),
	`tag_post` BIGINT,
	INDEX (`tag_name`,`tag_post`)
)ENGINE=INNODB CHARSET utf8;

# Complaint
CREATE TABLE `complaint`(
	`com_user` BIGINT,
	`com_post` BIGINT,
	`com_cmtid` INT,
	`com_msg` VARCHAR(200) COMMENT 'complaint words lower than 200',
	`com_creatime` DATETIME,
	INDEX (`com_creatime`)
)ENGINE=INNODB CHARSET utf8;
CREATE TABLE `complaint_post`(
  `cp_post` BIGINT,
  `cp_cmtid` INT,
  `cp_times` INT,
  `cp_status` INT,
  PRIMARY KEY(`cp_post`),
  INDEX (`cp_post`,`cp_cmtid`)
)ENGINE=INNODB CHARSET utf8;

# Comment
CREATE TABLE `comment`(
	`cmt_post` BIGINT,
	`cmt_cmtid` INT,
	`cmt_cmtor` BIGINT,
	`cmt_cmtorid` VARCHAR(20),
	`cmt_text` VARCHAR(150) COMMENT 'comment text lower than 150',
	`cmt_creatime` DATETIME,
	INDEX (`cmt_post`,`cmt_cmtid`,`cmt_creatime`)
)ENGINE=INNODB CHARSET utf8;

# Favorite
CREATE TABLE `favorite`(
	`fav_user` BIGINT,
	`fav_post` BIGINT,
	INDEX (`fav_user`)
)ENGINE=INNODB CHARSET utf8;

# Score
CREATE TABLE `score`(
	`sco_user` BIGINT,
	`sco_post` BIGINT,
	`sco_score` INTEGER,
	INDEX(`sco_user`),
	INDEX(`sco_post`)
)ENGINE=INNODB CHARSET utf8;

# Likes
CREATE TABLE `likes`(
	`like_post` BIGINT,
	`like_cmtid` INT,
	`like_liker` BIGINT,
	INDEX(`like_post`,`like_cmtid`),
	INDEX(`like_liker`)
)ENGINE=INNODB CHARSET utf8;

# Gain
CREATE TABLE `gain`(
	`gain_post` BIGINT,
	`gain_giver` BIGINT,
	`gain_gins` INT,
	INDEX (`gain_post`)
)ENGINE=INNODB CHARSET utf8;

# Follow
CREATE TABLE `follow`(
	`flw_user` BIGINT,
	`flw_4user` BIGINT,
	INDEX (`flw_user`),
	INDEX (`flw_4user`)
)ENGINE=INNODB CHARSET utf8;

# User
CREATE TABLE `user`(
	`user_autoid` BIGINT AUTO_INCREMENT,
	`user_id` VARCHAR(20),
	`user_email` VARCHAR(30),
	`user_status` INT,
	`user_pwd` VARCHAR(200),
	`user_gins` INT,
	PRIMARY KEY (`user_autoid`),
	INDEX (`user_id`,`user_pwd`),
	INDEX (`user_email`,`user_pwd`)
)ENGINE=INNODB CHARSET utf8;

# Message
CREATE TABLE `message`(
	`msg_rcvder` BIGINT,
	`msg_senderid` VARCHAR(20),
	`msg_text` VARCHAR(100),
	`msg_status` INT,
	`msg_creatime` DATETIME,
	INDEX (`msg_rcvder`,`msg_creatime`)
)ENGINE=INNODB CHARSET utf8;

# UserDetail
CREATE TABLE `user_detail`(
	`ud_user` BIGINT,
	`ud_avatar` VARCHAR(100),
	`ud_brief` VARCHAR(200),
	`ud_website` VARCHAR(50),
	`ud_phone` VARCHAR(20),
	`ud_gender` CHAR(1),
	`ud_wechat` VARCHAR(30),
	PRIMARY KEY (`ud_user`)
)ENGINE=INNODB CHARSET utf8;

# Payment
CREATE TABLE `payment`(
	`pay_code` VARCHAR(100),
	`pay_user` BIGINT,
	`pay_creatime` DATETIME,
	`pay_status` INT,
	PRIMARY KEY (`pay_code`)
)ENGINE=INNODB CHARSET utf8;



### Admin Part

# Admin
CREATE TABLE `admin`(
	`admin_loginid` VARCHAR(20),
	`admin_pwd` VARCHAR(200),
	`admin_role` INT,
	PRIMARY KEY (`admin_loginid`)
)ENGINE=MYISAM CHARSET utf8;

# Role
CREATE TABLE `role`(
	`role_id` INT AUTO_INCREMENT,
	`role_name` VARCHAR(20),
	PRIMARY KEY (`role_id`)
)ENGINE=INNODB CHARSET utf8;

# RolePermission
CREATE TABLE `role_permission`(
	`rp_role` INT,
	`rp_permission` INT,
	INDEX (`rp_role`)
)ENGINE=MYISAM CHARSET utf8;

# Permission
CREATE TABLE `permission`(
	`pmsn_id` INT,
	`pmsn_name` VARCHAR(20),
	`pmsn_url` VARCHAR(100),
	`pmsn_type` INT,
	`pmsn_parent` INT,
	PRIMARY KEY (`pmsn_id`)
)ENGINE=MYISAM CHARSET utf8;

# LogRecord
CREATE TABLE `log_record`(
	`lr_admin` VARCHAR(20),
	`lr_text` VARCHAR(200),
	`lr_creatime` DATETIME,
	INDEX (`lr_creatime`)
)ENGINE=INNODB CHARSET utf8;