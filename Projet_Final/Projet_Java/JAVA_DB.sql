-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Mar 11 Juin 2013 à 00:44
-- Version du serveur: 5.1.44
-- Version de PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `java`
--

-- --------------------------------------------------------

--
-- Structure de la table `photo`
--

CREATE TABLE IF NOT EXISTS `photo` (
  `titre` varchar(1024) NOT NULL,
  `type` varchar(1024) NOT NULL,
  `date` date NOT NULL,
  `taille` varchar(1024) NOT NULL,
  `chemin` varchar(1024) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `photo`
--

INSERT INTO `photo` (`titre`, `type`, `date`, `taille`, `chemin`) VALUES
('Rukai Mask', '.gif', '2009-07-29', '2881 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Tribal Masks/Rukai Mask.gif'),
('Argentina', '.gif', '2009-07-29', '2513 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Flags/Argentina.gif'),
('Green Apple', '.gif', '2009-07-29', '2159 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Fruit/Green Apple.gif'),
('Diamond Square', '.gif', '2009-07-29', '2204 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Gems/Diamond Square.gif'),
('Dandelion', '.gif', '2009-07-29', '2728 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Flowers/Dandelion.gif'),
('Diamond Heart', '.gif', '2009-07-29', '2836 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Gems/Diamond Heart.gif'),
('Saturn', '.gif', '2009-07-29', '2547 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Planets/Saturn.gif'),
('African Daisy', '.gif', '2009-07-29', '2624 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Flowers/African Daisy.gif'),
('Ixia', '.gif', '2009-07-29', '2613 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Flowers/Ixia.gif'),
('Uranus', '.gif', '2009-07-29', '2247 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Planets/Uranus.gif'),
('Earth (Americas)', '.gif', '2009-07-29', '2454 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Planets/Earth (Americas).gif'),
('Ruby Round', '.gif', '2009-07-29', '2734 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Gems/Ruby Round.gif'),
('Extrasolar Giant', '.gif', '2009-07-29', '2340 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Planets/Extrasolar Giant.gif'),
('Emerald Round', '.gif', '2009-07-29', '2789 octes', '/Users/mohammedaminerahhali/Pictures/iChat Icons/Gems/Emerald Round.gif'),
('Pile Documents', '.pdf', '2013-02-04', '470877 octes', '/Users/mohammedaminerahhali/Documents/Pile Documents.pdf'),
('02 Omnia - The Light', '.mp3', '2013-02-15', '7682022 octes', '/Users/mohammedaminerahhali/Music/iTunes/iTunes Music/Music/MyEgy.Com/MyEgy.Com/02 Omnia - The Light.mp3');
