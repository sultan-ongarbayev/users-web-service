-- Create user and database

CREATE USER IF NOT EXISTS 'users_service'@'%' IDENTIFIED BY 'password';

CREATE DATABASE IF NOT EXISTS `users_db`;

GRANT ALL PRIVILEGES ON `users_db`.* TO 'users_service'@'%';

USE `users_db`;

CREATE TABLE IF NOT EXISTS `users` (
	`user_id` INT NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR(100) NOT NULL,
    `user_email` VARCHAR(100) NOT NULL,
    PRIMARY KEY(`user_id`)
);

-- Write sample data

INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Edwin J. Guthrie", "edwinjguthrie@rhyta.com");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Christine H. Steen", "christinehsteen@dayrep.com");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Brian T. Bradley", "briantbradley@armyspy.com");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Pauline T. Eye", "paulineteye@rhyta.com");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Candace G. Brunette", "candacegbrunette@jourrapide.com");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Kevin A. Williams", "kevinawilliams@teleworm.us");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Rudolph C. Fleming", "rudolphcfleming@rhyta.com");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Dwight V. Ferguson", "dwightvferguson@teleworm.us");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Melissa P. Peck", "melissappeck@rhyta.com");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Billie D. Johnson", "billiedjohnson@teleworm.us");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Mellisa C. Fender", "mellisacfender@rhyta.com");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Ryan M. Jewell", "ryanmjewell@teleworm.us");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Deborah D. Benson", "deborahdbenson@armyspy.com");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Anthony S. Bolt", "anthonysbolt@jourrapide.com");
INSERT IGNORE INTO `users` (`user_name`, `user_email`) VALUES ("Darlene W. Marasco", "darlenewmarasco@jourrapide.com");