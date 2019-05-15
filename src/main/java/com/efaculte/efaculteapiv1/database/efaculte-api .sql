-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 15 mai 2019 à 13:58
-- Version du serveur :  10.1.35-MariaDB
-- Version de PHP :  7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `efaculte-api`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id` bigint(20) NOT NULL,
  `bloquer` int(11) NOT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `cne` varchar(255) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `etat_deust` int(11) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `napogee` bigint(20) DEFAULT NULL,
  `nb_connexion_reston` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `filiere` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id`, `bloquer`, `cin`, `cne`, `date_naissance`, `email`, `etat_deust`, `gender`, `napogee`, `nb_connexion_reston`, `nom`, `password`, `prenom`, `filiere`) VALUES
(8, 0, 'ee2', 'ee2', NULL, 'enaji.chaimaa@gmail.com', 3, 'femme', 35522, 0, 'enaji', 'hafsa', 'chaimaa', 3),
(10, 0, 'ee1', 'ee1', NULL, 'elkhalifai.hajar@gmail.com', 3, 'femme', 55522, 0, 'elkhalifa', 'hafsa', 'hafsa', 3);

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

CREATE TABLE `filiere` (
  `id` bigint(20) NOT NULL,
  `abreviation` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `objectif` varchar(255) DEFAULT NULL,
  `reference_entite_administratif` varchar(255) DEFAULT NULL,
  `type_filiere` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `filiere`
--

INSERT INTO `filiere` (`id`, `abreviation`, `libelle`, `objectif`, `reference_entite_administratif`, `type_filiere`) VALUES
(1, 'MIASI', 'MIASI', 'hggq', 'departement physique', 2),
(2, 'IFA', 'IFA', 'hggq', 'departement physique', 3),
(3, 'SIR', 'SIR', 'hggq', 'departement informatique', 2),
(4, 'IRISI', 'IRISI', 'hggq', 'departement informatique', 3);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(11),
(11),
(11);

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE `module` (
  `id` bigint(20) NOT NULL,
  `cin_personnel` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `type_personnel` varchar(255) DEFAULT NULL,
  `filiere` bigint(20) DEFAULT NULL,
  `semestre` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `module`
--

INSERT INTO `module` (`id`, `cin_personnel`, `libelle`, `type_personnel`, `filiere`, `semestre`) VALUES
(2, 'EE125648', 'SGBD', 'prof', NULL, 1),
(3, 'EE125648', 'Reseau', 'prof', NULL, 1),
(4, 'EE125648', 'UML', 'prof', NULL, 1),
(5, 'EE125648', 'Linux', 'prof', NULL, 1),
(6, 'EE125648', 'Programmation web', 'prof', NULL, 1),
(7, 'EE125648', 'JAVA', 'prof', NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `semestre`
--

CREATE TABLE `semestre` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `filiere` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `semestre`
--

INSERT INTO `semestre` (`id`, `libelle`, `filiere`) VALUES
(1, 'S5', 3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpyn9kbuvgxp1bkl2pfdse8fq1` (`filiere`);

--
-- Index pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8d4ld0n17ciyhk29cyxy2lipx` (`filiere`),
  ADD KEY `FKof98q5mac8sdb710wrarm7uca` (`semestre`);

--
-- Index pour la table `semestre`
--
ALTER TABLE `semestre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKi2hs6uox5yghds2nw1w3sr799` (`filiere`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `filiere`
--
ALTER TABLE `filiere`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
