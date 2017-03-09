-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 09 Mars 2017 à 21:51
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `events`
--

-- --------------------------------------------------------

--
-- Structure de la table `departement`
--

CREATE TABLE IF NOT EXISTS `departement` (
  `IDdept` int(11) NOT NULL AUTO_INCREMENT,
  `NomDept` varchar(10) NOT NULL,
  `IDChef` int(11) NOT NULL,
  PRIMARY KEY (`IDdept`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE IF NOT EXISTS `employe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Password` varchar(10) NOT NULL,
  `Poste` varchar(20) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `Prenom` varchar(20) NOT NULL,
  `IDdept` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_foreign_key` (`IDdept`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `IDEvent` int(11) NOT NULL AUTO_INCREMENT,
  `Titre` varchar(40) NOT NULL,
  `Secteur` varchar(20) NOT NULL,
  `Thème` varchar(40) NOT NULL,
  `DateEvent` date NOT NULL,
  `Lieu` varchar(20) NOT NULL,
  `Description` varchar(20) NOT NULL,
  `Type` varchar(20) NOT NULL,
  `IDorg` int(10) NOT NULL,
  PRIMARY KEY (`IDEvent`),
  UNIQUE KEY `IDorg` (`IDorg`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `eventdept`
--

CREATE TABLE IF NOT EXISTS `eventdept` (
  `IDEvent` int(11) NOT NULL,
  `IDDept` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `participations`
--

CREATE TABLE IF NOT EXISTS `participations` (
  `IDEvent` int(11) NOT NULL,
  `IDEmp` int(11) NOT NULL,
  `Date` int(11) NOT NULL,
  PRIMARY KEY (`IDEvent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `fk_foreign_key` FOREIGN KEY (`IDdept`) REFERENCES `departement` (`IDdept`);

--
-- Contraintes pour la table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `fk_event` FOREIGN KEY (`IDorg`) REFERENCES `employe` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
