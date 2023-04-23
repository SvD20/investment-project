CREATE DATABASE  IF NOT EXISTS `investment_directory`;
USE `investment_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name_of_project` varchar(45) DEFAULT NULL,
  `date_of_analysis` date DEFAULT (CURRENT_DATE),
  `discount_rate` decimal(3,2),
  `loan_interest_rate` decimal(3,2),
  `initial_investment` decimal(10,2),
  `implementation_period` int,
  `profit_per_unit_of_the_implementation_period` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `project`
--


