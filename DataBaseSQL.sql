-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for casestudy
CREATE DATABASE IF NOT EXISTS `casestudy` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `casestudy`;

-- Dumping structure for table casestudy.drone
CREATE TABLE IF NOT EXISTS `drone` (
  `DRONEID` int(11) NOT NULL AUTO_INCREMENT,
  `cameraRes` varchar(5) DEFAULT NULL,
  `category` varchar(50) NOT NULL,
  `imageName` varchar(255) DEFAULT NULL,
  `make` varchar(50) NOT NULL,
  `maxrange` int(11) NOT NULL,
  `maxspeed` int(11) NOT NULL,
  `model` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `rating` double DEFAULT NULL,
  `weight` double NOT NULL,
  PRIMARY KEY (`DRONEID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table casestudy.drone_review
CREATE TABLE IF NOT EXISTS `drone_review` (
  `Drone_DRONEID` int(11) NOT NULL,
  `reviewList_RID` int(11) NOT NULL,
  PRIMARY KEY (`Drone_DRONEID`,`reviewList_RID`),
  KEY `FK_drone_review_reviewList_RID` (`reviewList_RID`),
  CONSTRAINT `FK_drone_review_Drone_DRONEID` FOREIGN KEY (`Drone_DRONEID`) REFERENCES `drone` (`DRONEID`),
  CONSTRAINT `FK_drone_review_reviewList_RID` FOREIGN KEY (`reviewList_RID`) REFERENCES `review` (`RID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table casestudy.review
CREATE TABLE IF NOT EXISTS `review` (
  `RID` int(11) NOT NULL AUTO_INCREMENT,
  `rating` double NOT NULL,
  `textBody` varchar(200) NOT NULL,
  `author` varchar(255) NOT NULL,
  PRIMARY KEY (`RID`),
  KEY `FK_review_author` (`author`),
  CONSTRAINT `FK_review_author` FOREIGN KEY (`author`) REFERENCES `user` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table casestudy.user
CREATE TABLE IF NOT EXISTS `user` (
  `EMAIL` varchar(255) NOT NULL,
  `password` varchar(30) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
