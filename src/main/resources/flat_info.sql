-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 02, 2024 at 07:45 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flatinfodb`
--
CREATE DATABASE IF NOT EXISTS `flatinfodb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `flatinfodb`;

-- --------------------------------------------------------

--
-- Table structure for table `amenities`
--

CREATE TABLE `amenities` (
  `amen_id` int(11) NOT NULL,
  `flat_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `amenities`
--

INSERT INTO `amenities` (`amen_id`, `flat_id`, `name`) VALUES
(1, 1, 'Swimming Pool'),
(2, 1, 'Gym'),
(3, 2, 'Security System'),
(4, 3, 'Parking Lot'),
(5, 3, 'Playground');

-- --------------------------------------------------------

--
-- Table structure for table `flat_info`
--

CREATE TABLE `flat_info` (
  `id` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `Location` varchar(255) DEFAULT NULL,
  `Flat_title` varchar(200) DEFAULT NULL,
  `bhk_type` int(11) DEFAULT NULL,
  `g_map_location` varchar(300) DEFAULT NULL,
  `area` double DEFAULT NULL,
  `manual_address` varchar(255) DEFAULT NULL,
  `pin_code` int(11) DEFAULT NULL,
  `is_furnished` varchar(30) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `is_constructed` tinyint(1) DEFAULT NULL,
  `parking` int(11) DEFAULT NULL,
  `avaiable_indicator` tinyint(1) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `has_balcony` tinyint(1) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `under_construction` tinyint(1) DEFAULT NULL,
  `prop_age` int(11) DEFAULT NULL,
  `no_of_bathroom` int(11) DEFAULT NULL,
  `prop_floor` int(11) DEFAULT NULL,
  `prop_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flat_info`
--

INSERT INTO `flat_info` (`id`, `type`, `Location`, `Flat_title`, `bhk_type`, `g_map_location`, `area`, `manual_address`, `pin_code`, `is_furnished`, `price`, `is_constructed`, `parking`, `avaiable_indicator`, `floor`, `has_balcony`, `description`, `under_construction`, `prop_age`, `no_of_bathroom`, `prop_floor`, `prop_type`) VALUES
(1, 'Apartment', 'City Center', 'Luxury Apartment', 2, '123.456,789.012', 120.5, '123 Main St', 12345, 'fully', 150000, 1, 1, 1, 5, 1, 'Spacious apartment with great views', 0, 2, 2, 0, 'cc'),
(2, 'Townhouse', 'Suburb Area', 'Cozy Townhouse 1', 2, '111.222,333.444', 90.5, '789 Elm St', 67890, 'non', 100000, 1, 1, 1, 2, 1, 'Comfortable townhouse in a quiet neighborhood', 0, 5, 2, 0, ''),
(3, 'Apartment', 'City Center', 'Modern Apartment 2', 1, '444.555,666.777', 150, '555 Pine St', 23456, 'fully', 180000, 1, 1, 1, 10, 0, 'Stylish apartment with panoramic city views', 1, 1, 3, 0, ''),
(4, 'Townhouse', 'Suburb Area', 'Cozy Townhouse 1', 2, '111.222,333.444', 90.5, '789 Elm St', 67890, 'non', 100000, 1, 1, 1, 2, 1, 'Comfortable townhouse in a quiet neighborhood', 0, 5, 2, 0, ''),
(5, 'Apartment', 'City Center', 'Modern Apartment 2', 1, '444.555,666.777', 150, '555 Pine St', 23456, 'fully', 180000, 1, 1, 1, 10, 0, 'Stylish apartment with panoramic city views', 1, 1, 3, 0, '');

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `image_id` int(11) NOT NULL,
  `flat_id` int(11) DEFAULT NULL,
  `image_address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `images`
--

INSERT INTO `images` (`image_id`, `flat_id`, `image_address`) VALUES
(5, 1, 'https://example.com/image1.jpg'),
(6, 1, 'https://example.com/image2.jpg'),
(7, 2, 'https://example.com/image3.jpg'),
(8, 2, 'https://example.com/image4.jpg'),
(9, 3, 'https://example.com/image5.jpg'),
(10, 3, 'https://example.com/image6.jpg'),
(11, 4, 'https://example.com/image7.jpg'),
(12, 4, 'https://example.com/image8.jpg'),
(13, 5, 'https://example.com/image9.jpg'),
(14, 5, 'https://example.com/image10.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `amenities`
--
ALTER TABLE `amenities`
  ADD PRIMARY KEY (`amen_id`),
  ADD KEY `flat_id` (`flat_id`);

--
-- Indexes for table `flat_info`
--
ALTER TABLE `flat_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`image_id`),
  ADD KEY `flat_id` (`flat_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `amenities`
--
ALTER TABLE `amenities`
  MODIFY `amen_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `flat_info`
--
ALTER TABLE `flat_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `image_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `amenities`
--
ALTER TABLE `amenities`
  ADD CONSTRAINT `amenities_ibfk_1` FOREIGN KEY (`flat_id`) REFERENCES `flat_info` (`id`);

--
-- Constraints for table `images`
--
ALTER TABLE `images`
  ADD CONSTRAINT `images_ibfk_1` FOREIGN KEY (`flat_id`) REFERENCES `flat_info` (`id`);


-- --------------------------------------------------------
