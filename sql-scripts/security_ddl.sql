CREATE DATABASE  IF NOT EXISTS `investment_directory`;
USE `investment_directory`;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users`(
    `username` varchar(50) NOT NULL,
    `password` varchar(68) NOT NULL,
    `enabled` tinyint(1) NOT NULL,

    PRIMARY KEY (`username`)

)
ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities`(
    `username` varchar(50) NOT NULL,
    `authority` varchar(50) NOT NULL,

    UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
    CONSTRAINT `authorities_ibfk_1`
    FOREIGN KEY (`username`)
    REFERENCES `users` (`username`)
)
    ENGINE=InnoDB DEFAULT CHARSET=latin1;


