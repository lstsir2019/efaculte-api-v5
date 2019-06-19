-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 19 juin 2019 à 15:09
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
-- Structure de la table `annonce`
--

CREATE TABLE `annonce` (
  `id` bigint(20) NOT NULL,
  `date_creation` date DEFAULT NULL,
  `desactiver` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `priorite` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `filiere` bigint(20) DEFAULT NULL,
  `type_annonce` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `annonce`
--

INSERT INTO `annonce` (`id`, `date_creation`, `desactiver`, `description`, `priorite`, `title`, `filiere`, `type_annonce`) VALUES
(8, '2019-05-02', b'1', 'jjhqhjsqhjhj', 0, 'Z', 2, 1),
(12, '2019-05-07', b'1', 'jjhqhjsqhjhj', 0, 'a', 2, 1),
(14, '2019-05-07', b'0', 'jjhqhjsqhjhj', 0, 'B', 2, 1),
(16, '2019-05-17', b'0', 'jjhqhjsqhjhj', 0, 'r', 2, 1),
(18, '2017-01-17', b'0', 'jjhqhjsqhjhj', 0, 'x', 2, 1),
(24, '2019-05-08', b'0', '<div style=\"text-align: center;\"><b style=\"background-color: transparent; font-size: 1rem;\">hellow</b><span style=\"background-color: transparent; font-size: 1rem;\"> word</span></div>', 0, 'hajar', NULL, NULL),
(25, '2019-05-01', b'0', '<div style=\"text-align: center;\"><span style=\"background-color: transparent; font-size: 1rem;\">hajarita</span></div>', 0, 'hajoura', NULL, NULL),
(26, NULL, b'0', '', 0, '', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `document`
--

CREATE TABLE `document` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `pathe` varchar(255) DEFAULT NULL,
  `annonce` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `document`
--

INSERT INTO `document` (`id`, `libelle`, `pathe`, `annonce`) VALUES
(7, 'emploie', 'hghyyt', 6),
(9, 'emploie', 'hghyyt', 8),
(13, 'emploie', 'hghyyt', 12),
(15, 'emploie', 'hghyyt', 14),
(17, 'emploie', 'hghyyt', 16),
(19, 'emploie', 'hghyyt', 18);

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
(92, 0, 'ee1', 'ee1', NULL, 'elkhalifai.hajar@gmail.com', 3, 'femme', 55522, 0, 'elkhalifa', 'hafsa', 'hafsa', 4),
(20, 0, 'ee2', 'ee2', NULL, 'elkhalifai.hajar@gmail.com', 2, 'femme', 55522, 0, 'elkhalifa', 'hajar', 'hajar', 4),
(21, 0, 'ee3', 'ee3', NULL, 'enaji.chaimaa@gmail.com', 2, 'femme', 55422, 0, 'enaji', 'chaimaa', 'chaimaa', 4),
(22, 0, 'G13456978', 'ee4', NULL, 'aitOuflla.imane@gmail.com', 2, 'femme', 45422, 0, 'ait ouflla', 'imane', 'imane', 4),
(23, 0, 'G135468978', 'ee5', NULL, 'elAissi.hajar@gmail.com', 2, 'femme', 25422, 0, 'el aissi', 'elaissi', 'hajar', 4);

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
(1, 'IRISI', 'Ingénierie en Réseauxs et Systèmes d’Information', 'cette formation permet de former un ingenieur pour intervenir à tous les niveaux du réseau et du système d’information. Il apporte ses compétences dans les domaines de l’administration des data center et bases de données, de l’administration des réseaux..', 'informatique', 2),
(2, 'SIR', 'Systeme informatique repartie', ' etre capable de concevoir, de développer et d’administrer des bases de Données, et de développer des applications Internet et Intranet', 'informatique', 1),
(3, 'BIO ANALYSE ', 'BIOLOGIE ANALYSE MEDICALE', 'hggq', 'biologie', 5),
(4, 'MIPC', 'MIPC', 'hggq', 'math', 4),
(6, 'IEEA', 'ELECTRONIQUE, ELECTROTECHNIQUE, AUTOMATIQUE ET INFORMATIQUE INDUSTRIELLE ', 'destiner à former des licencies dans les domaine du genie electrique avec ses differentes options ,est basée sur le caractére pratique de ses different composent', 'physique', 1),
(7, 'MIASI', 'MATHEMATIQUES ET INFORMATIQUE APPLIQUEES AUX SCIENCES DE L’INGENIEUR ', 'L’objectif étant de donner aux mathématiques la place qu’elles méritent d’occuper dans notre société. Et ceci en tenant compte de l’évolution des mathématiques au niveau enseignement, recherche et applications aux métiers de l’ingénieur.', 'math', 1),
(8, 'PCM', 'PHYSICO-CHIMIE DES MATERIAUX ', 'PCM est une formation qui se veut généraliste. Elle aspire à inculquer des connaissances de base dans le domaine des matériaux, en l’occurrence les métaux et  alliages,  les  céramiques  et  verres,  les  polymères et  composites ', 'physique', 1),
(9, 'GC', 'Genie Civil', 'L’objectif est la formation des cadres en Génie Civil de haut niveau scientifique et technique. La formation adonc vocation, en étroite collaboration avec les milieux professionnels, à participer au développement régional et national.', 'genie civil', 2),
(10, 'IFA', 'Ingénierie en Finance et Actuariat', ' cette formation prépare les étudiants pour maitriser les outilset méthodes mathématiques, notamment statistiques, et informatiques utilisées en finance et en assurance et dans la prévision et la gestion optimale des risques financiers.', 'math', 2),
(11, 'ISA', 'Industrie et Sécurité des Aliments', ' cette formation vise à former des cadres spécialisés compétents dans les techniques appliquées aux divers secteurs industriels, en particulier l’agro-alimentaire et la santé.', 'biologie', 2),
(12, 'GMP', 'Génie des Matériaux et Procédés', 'Cette filière d’ingénieur est une formation pluridisciplinaire et pratique visant à former des cadres dans l’industrie de production, de transformation et de l’utilisation des matériaux organiques et inorganiques. ', 'chimie', 2),
(13, 'BCG', 'Biologie, Chimie et Géologie', '\r\nTronc commun BCG a FSTG .Un cycle DEUST de 2 ans qui prépare l\'accès aux licences.\r\nIl s\'agit d\'un enseignement modulaire semestriel basé sur le controle contenu.', 'biologie', 4),
(14, 'MIP', 'Math, Informatique et Physique', '', 'math', 4);

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
(27),
(27),
(27),
(27),
(27),
(94),
(94),
(94);

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
(18, 'EE125648', 'SGBD', 'prof', 2, 17),
(19, 'EE125648', 'LINUX', 'prof', 2, 17),
(20, 'EE125648', 'JAVA', 'prof', 2, 17),
(21, 'EE125648', 'UML', 'prof', 2, 17),
(22, 'EE125648', 'WEB', 'prof', 2, 17),
(23, 'EE125648', 'RESEAU', 'prof', 2, 17),
(25, 'EE125648', 'SGBDR', 'prof', 2, 24),
(26, 'EE125648', 'JEE', 'prof', 2, 24),
(27, 'EE125648', 'IHM', 'prof', 2, 24),
(29, 'EE125648', 'Bio Statistique', 'prof', 3, 28),
(30, 'EE125648', 'Bio moleculaire', 'prof', 3, 28),
(31, 'EE125648', 'physiologie animale', 'prof', 3, 28),
(32, 'EE125648', 'biochimie', 'prof', 3, 28),
(33, 'EE125648', 'immunologie', 'prof', 3, 28),
(35, 'EE125648', 'micro biologie', 'prof', 3, 34),
(36, 'EE125648', 'hématologie', 'prof', 3, 34),
(37, 'EE125648', 'parasitologie', 'prof', 3, 34),
(38, 'EE125648', 'virologie', 'prof', 3, 34),
(40, 'EE125648', 'Microprocesseur', 'prof', 1, 39),
(41, 'EE125648', 'programmation oriente objet', 'prof', 1, 39),
(42, 'EE125648', 'Linux', 'prof', 1, 39),
(43, 'EE125648', 'RESEAU', 'prof', 1, 39),
(44, 'EE125648', 'SGBD', 'prof', 1, 39),
(45, 'EE125648', 'VB', 'prof', 1, 39),
(46, 'EE125648', 'Economie de l\'entreprise', 'prof', 1, 39),
(47, 'EE125648', 'Language et communication', 'prof', 1, 39),
(79, 'EE125648', 'Statistique & Probabilite', 'prof', 4, 77),
(78, 'EE125648', 'Analyse 3', 'prof', 4, 77),
(76, 'EE125648', 'Algo', 'prof', 4, 70),
(75, 'EE125648', 'Thermodynamique', 'prof', 4, 70),
(74, 'EE125648', 'TEC', 'prof', 4, 70),
(73, 'EE125648', 'Mecanique du point', 'prof', 4, 70),
(72, 'EE125648', 'Algébre 1', 'prof', 4, 70),
(71, 'EE125648', 'Analyse 1', 'prof', 4, 70),
(64, 'EE125648', 'Analyse 2', 'prof', 4, 63),
(65, 'EE125648', 'Algébre 2', 'prof', 4, 63),
(66, 'EE125648', 'Electricite', 'prof', 4, 63),
(67, 'EE125648', 'Electronique', 'prof', 4, 63),
(68, 'EE125648', 'TEC', 'prof', 4, 63),
(69, 'EE125648', 'Chimie atomique', 'prof', 4, 63),
(80, 'EE125648', 'Mecanique du solide', 'prof', 4, 77),
(81, 'EE125648', 'TEC', 'prof', 4, 77),
(82, 'EE125648', 'chimie', 'prof', 4, 77),
(83, 'EE125648', 'language C', 'prof', 4, 77),
(85, 'EE125648', 'Analyse 4', 'prof', 4, 84),
(86, 'EE125648', 'electromagnitisme', 'prof', 4, 84),
(87, 'EE125648', 'Chimie organique', 'prof', 4, 84),
(88, 'EE125648', 'Mecanique quantique', 'prof', 4, 84),
(89, 'EE125648', 'chimie minerale', 'prof', 4, 84),
(90, 'EE125648', 'language C++', 'prof', 4, 84);

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
(17, 'S5', 2),
(24, 'S6', 2),
(28, 'S5', 3),
(34, 'S6', 3),
(39, 'S1', 1),
(63, 'S2', 4),
(70, 'S1', 4),
(77, 'S3', 4),
(84, 'S4', 4);

-- --------------------------------------------------------

--
-- Structure de la table `type_annonce`
--

CREATE TABLE `type_annonce` (
  `id` bigint(20) NOT NULL,
  `code` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_annonce`
--

INSERT INTO `type_annonce` (`id`, `code`, `libelle`) VALUES
(1, 1, 'emploie');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfkr7dhsx440glg46r7s1r60lk` (`filiere`),
  ADD KEY `FKjfh9v4gijwpe1y083hli3qj1x` (`type_annonce`);

--
-- Index pour la table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKcac2sgkfqoy4pxqefjrnu82xi` (`annonce`);

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
-- Index pour la table `type_annonce`
--
ALTER TABLE `type_annonce`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `filiere`
--
ALTER TABLE `filiere`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
