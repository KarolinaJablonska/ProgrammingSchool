-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: ProgrammingSchool
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Excercise`
--

DROP TABLE IF EXISTS `Excercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Excercise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `description` text COLLATE utf8_polish_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Excercise`
--

LOCK TABLES `Excercise` WRITE;
/*!40000 ALTER TABLE `Excercise` DISABLE KEYS */;
INSERT INTO `Excercise` VALUES (1,'for each loop','use for each loop to print all numbers from table [0...12]'),(2,'first app','use java to make your very first working app printing Hello World on the screen'),(3,'guess a number','write the app: you pick one number from 0 to 100 and your computer guesses what is the number'),(4,'create database','your task is to create new database using Linux terminal. Add three tables: id, name, time'),(5,'do your best','write an app that count how many times per second you can click a mouse button'),(6,'create your web','create your very first website using html & css, maybe you tell people about your hobbys?'),(7,'print a Christmas tree','use table and loop to print Christmas tree consisting of *'),(8,'remember 10 words','write an app that will print 10 words for 10 seconds and then hide it, your job is to write them all'),(9,'darts calculator','create simple 501 darts game calculator that will subtrackt given score from 501 up to exact 0'),(10,'pinball game','your task is to create pinball game engine in java'),(11,'Is even or not','write function that returns true if input is even & returns false if input is odd'),(12,'convert to uppercase','write method that returns input string always uppercased'),(13,'name search','prepare method that returns boolean result of query: does input text include input name?'),(14,'digit occurence in array','prepare function that returns occurences number of input digit in input array'),(15,'decimal to hex','convert decimal number to hex number in created method'),(16,'math operators','write calculator app using all standard mathematic operators in Java');
/*!40000 ALTER TABLE `Excercise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Solution`
--

DROP TABLE IF EXISTS `Solution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Solution` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `description` text COLLATE utf8_polish_ci,
  `excercise_id` int(11) NOT NULL,
  `users_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `excercise_id` (`excercise_id`),
  KEY `users_id` (`users_id`),
  CONSTRAINT `Solution_ibfk_1` FOREIGN KEY (`excercise_id`) REFERENCES `Excercise` (`id`) ON DELETE CASCADE,
  CONSTRAINT `Solution_ibfk_2` FOREIGN KEY (`users_id`) REFERENCES `Users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Solution`
--

LOCK TABLES `Solution` WRITE;
/*!40000 ALTER TABLE `Solution` DISABLE KEYS */;
/*!40000 ALTER TABLE `Solution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_group`
--

DROP TABLE IF EXISTS `User_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_group`
--

LOCK TABLES `User_group` WRITE;
/*!40000 ALTER TABLE `User_group` DISABLE KEYS */;
INSERT INTO `User_group` VALUES (1,'Sharks'),(2,'Butterflies'),(3,'Elefants'),(4,'Hippos');
/*!40000 ALTER TABLE `User_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `password` varchar(245) COLLATE utf8_polish_ci DEFAULT NULL,
  `person_group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `person_group_id` (`person_group_id`),
  CONSTRAINT `Users_ibfk_1` FOREIGN KEY (`person_group_id`) REFERENCES `User_group` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,'Martin','martin@outlook.com','$2a$10$rNkLLkWB1oTRFDvYgMWADOEaXMdd1TnoLpDKb84HNRSIEGdrRDoIa',1),(2,'Jeremy','jeremy@gmail.com','$2a$10$VZLlbm9ifMosaDF1KurKVuXvg6mo/RfF1KK5pc6.wndzdWwFQaaAS',1),(3,'Wendy','wendy@bbc.com','$2a$10$Smqq7fsG1o0GJOsHKpkuT.SasDedp7Tud47jFhcn14kqo/89HzSBy',2),(4,'George','george@gmail.com','$2a$10$nx2sgzJz/2QImFUGoWLbEerzNq9FmxnS8HT0BLYGN0CbWtccGriei',3),(5,'Victoria','vicktoria@vicky.com','$2a$10$l8PxtOkX/wEJRK0.LJQe2.TTLLOVVWNSIyfmcYkDeoVX0BMAu6EPW',4),(6,'Joanne','joanne@dailymail.co.uk','$2a$10$MogRSB2c5G/Q1zCjCiKGquwogy0KXp0VAmxYjUxYWdhVw66yYvLg.',2),(7,'Madison','madison@madison.fr','$2a$10$4vQpsb1lNG9/QZmp5ifPrOAH5ac53XflC/KKTvT4S3zz1EUtibp3m',3),(8,'Quentin','quentin@gmail.com','$2a$10$fv29nELrXCwxGy1qNLU4YeqMknPTJXKseAJ/ZsWxB8e3inIX4nsdy',2),(9,'Carol','carol@outlook.com','$2a$10$bp/HUrcrqJo3aHMQkTHDg.p1P7eChhA2/dyEVE4ZCercLHhF0Dbvi',2),(10,'Nicky','nicky@gmail.com','$2a$10$RtKKQojs/UnT/Di22pgYd.8JXVb3fphQY.sxAkyUmhyTj.DioXIPe',4);
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-20 15:56:46
