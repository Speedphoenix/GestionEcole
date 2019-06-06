-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  jeu. 06 juin 2019 à 08:04
-- Version du serveur :  8.0.13-4
-- Version de PHP :  7.2.17-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `G6H93QtWu6`
--

-- --------------------------------------------------------

--
-- Structure de la table `anneescolaire`
--

CREATE TABLE `anneescolaire` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `anneescolaire`
--

INSERT INTO `anneescolaire` (`id`) VALUES
(1),
(2),
(3),
(4),
(5);

-- --------------------------------------------------------

--
-- Structure de la table `bulletin`
--

CREATE TABLE `bulletin` (
  `id` int(11) NOT NULL,
  `trimestreId` int(11) NOT NULL,
  `inscriptionId` int(11) NOT NULL,
  `appreciation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `bulletin`
--

INSERT INTO `bulletin` (`id`, `trimestreId`, `inscriptionId`, `appreciation`) VALUES
(1, 2, 1, 'De mauvais résultats dans toute vos matières étudiés... Pas ouf comme dirait ma tata.'),
(15, 2, 1, 'Très bonne participation en générale, mais niveau moyen. Continuez vos efforts'),
(19, 2, 1, 'Cette personne est inconnue de tous, revenez');

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `ecoleId` int(11) NOT NULL,
  `niveauId` int(11) NOT NULL,
  `anneeScolId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id`, `nom`, `ecoleId`, `niveauId`, `anneeScolId`) VALUES
(1, 'TD 01', 1, 1, 1),
(5, 'TD 01', 1, 16, 1),
(14, 'TD 01', 1, 15, 1),
(15, 'TD 02', 1, 15, 1),
(16, 'TD 02', 1, 16, 1),
(17, 'TD 02', 1, 1, 1),
(18, 'TD 01 ', 1, 17, 1),
(19, 'TD 02 ', 1, 17, 1),
(20, 'TD 01', 1, 18, 1),
(21, 'TD 02', 1, 18, 1);

-- --------------------------------------------------------

--
-- Structure de la table `detailbulletin`
--

CREATE TABLE `detailbulletin` (
  `id` int(11) NOT NULL,
  `bulletinId` int(11) NOT NULL,
  `enseignementId` int(11) NOT NULL,
  `appreciation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `detailbulletin`
--

INSERT INTO `detailbulletin` (`id`, `bulletinId`, `enseignementId`, `appreciation`) VALUES
(1, 1, 1, 'Votre tête est un système thermodynamique peu rentable, de faibles résultats fournis pour beaucoup de travail apporté...'),
(2, 1, 2, 'Il va falloir faire une transformation totale de votre manière de travail pour espéré avoir la moyenne.'),
(7, 15, 2, 'Vos notes sont très mauvaises mais au moins vous êtes gentil');

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

CREATE TABLE `discipline` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `discipline`
--

INSERT INTO `discipline` (`id`, `nom`) VALUES
(1, 'Thermodynamique'),
(2, 'Analyse de Fourrier'),
(3, 'Java'),
(4, 'C'),
(5, 'Anglais'),
(6, 'Espagnol'),
(7, 'Arabe'),
(8, 'Russe'),
(9, 'Japonais'),
(10, 'Coréen'),
(11, 'Droit du travail'),
(12, 'Anthropologie'),
(13, 'PSTE'),
(14, 'Système bouclé'),
(15, 'Traitement du Signal'),
(16, 'Probabilité'),
(17, 'Couture'),
(18, 'Préparation de cocktail'),
(19, 'Economie'),
(20, 'Management');

-- --------------------------------------------------------

--
-- Structure de la table `ecole`
--

CREATE TABLE `ecole` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ecole`
--

INSERT INTO `ecole` (`id`, `nom`) VALUES
(1, 'ECE Paris'),
(3, 'ESILV'),
(4, 'EPF'),
(5, 'Polytechnique'),
(6, 'INSA Lyon'),
(7, 'ECE Lyon');

-- --------------------------------------------------------

--
-- Structure de la table `enseignement`
--

CREATE TABLE `enseignement` (
  `id` int(11) NOT NULL,
  `classeId` int(11) NOT NULL,
  `disciplineId` int(11) NOT NULL,
  `personneId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `enseignement`
--

INSERT INTO `enseignement` (`id`, `classeId`, `disciplineId`, `personneId`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

CREATE TABLE `evaluation` (
  `id` int(11) NOT NULL,
  `detailBulletinId` int(11) NOT NULL,
  `note` double NOT NULL,
  `appreciation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`id`, `detailBulletinId`, `note`, `appreciation`) VALUES
(7, 1, 2, 'bof quoi');

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE `inscription` (
  `id` int(11) NOT NULL,
  `classeId` int(11) NOT NULL,
  `personneId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id`, `classeId`, `personneId`) VALUES
(1, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

CREATE TABLE `niveau` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`id`, `nom`) VALUES
(1, 'Bac+3'),
(15, 'Bac+1'),
(16, 'Bac+2'),
(17, 'Bac+4'),
(18, 'Bac+5');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL DEFAULT 'Connor',
  `prenom` varchar(255) NOT NULL DEFAULT 'John',
  `type` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `type`) VALUES
(1, 'Pullicino', 'Mr.', 1),
(2, 'Rossignolo', 'Polo', 0),
(3, 'Desliles', 'Mr.', 1),
(10, 'Connor', 'John', 0),
(11, 'Turzi', 'Francesco', 1),
(12, 'Maupile', 'Mr.', 1),
(13, 'Martin', 'Mr.', 1),
(14, 'Bernard', 'Mr.', 1),
(15, 'Thomas', 'Mr.', 1),
(16, 'Petit', 'Mme.', 1),
(17, 'Richard', 'Mme.', 1),
(18, 'Robert', 'Mme.', 1),
(19, 'Palasi', 'Mme.', 1),
(20, 'Busca', 'Mr.', 1),
(21, 'Mokhber', 'Mr.', 1),
(22, 'Le Cor', 'Mr.', 1),
(23, 'Djoudi', 'Mr.', 1),
(24, 'Chaari', 'Mr.', 1),
(25, 'Lopez', 'Mr.', 1),
(26, 'Reese', 'Mr.', 1),
(27, 'Segado', 'Mr.', 1),
(28, 'Hina', 'Mr.', 1),
(29, 'Crimail', 'Mr.', 1),
(30, 'Coudray', 'Mme.', 1),
(31, 'Rendler', 'Mme.', 1),
(32, 'Boubezoul', 'Mr.', 1),
(33, 'Mouradian', 'Mr.', 1),
(34, 'Song', 'Mme.', 1),
(35, 'Hurbain', 'Mr.', 1),
(36, 'Durand.', 'Mr.', 1),
(37, 'Dubois', 'Mme.', 1),
(38, 'Moreau', 'Mme.', 1),
(39, 'Laurent', 'Mr.', 1),
(40, 'Simon', 'Mr.', 1),
(41, 'Michel', 'Mme.', 1),
(42, 'Lefèvre', 'Mr.', 1),
(43, 'Leroy', 'Mme.', 1),
(44, 'Roux', 'Mr.', 1),
(45, 'Chaillou', 'Mme.', 1),
(46, 'Belghuit', 'Mr.', 1),
(47, 'Belalane', 'Mme.', 1),
(48, 'Lalane', 'Mr.', 1),
(49, 'Chabal', 'Mr.', 1),
(50, 'Zirani', 'Mme.', 1),
(51, 'Terapieh', 'Mme.', 1),
(52, 'Lalane', 'Françis', 0),
(53, 'Souchon', 'Alain', 0),
(54, 'Tapie', 'Bertrand', 0),
(55, 'Zidane', 'Zinedine', 0),
(56, 'Mbappé', 'Kilian', 0),
(57, 'Bartez', 'Fabien', 0),
(58, 'Nadal', 'Federer', 0),
(59, 'Tsonga', 'Jo-Wilfried', 0),
(60, 'Rinner', 'Teddy', 0),
(61, 'Marquez', 'Fabrice', 0),
(62, 'Manaudou', 'Laure', 0),
(63, 'Manaudou', 'Florent', 0),
(64, 'Pokora', 'Matt', 0),
(65, 'Vincent', 'Franky', 0),
(66, 'Griezmann', 'Antoine', 0),
(67, 'Federer', 'Roger', 0),
(68, 'Loeb', 'Sébastien', 0),
(69, 'Djokovic', 'Novak', 0),
(70, 'Parker', 'Tony', 0),
(71, 'Pogba', 'Paul', 0),
(72, 'Douillet', 'David', 0),
(73, 'Taubira', 'Christiane', 0),
(74, 'Hidalgo', 'Anne', 0),
(75, 'Cotillard', 'Marion', 0),
(76, 'Polony', 'Natasha', 0),
(77, 'Pulvar', 'Audrey', 0),
(78, 'Sublet', 'Alexandra', 0),
(79, 'Foresti', 'Florence', 0),
(80, 'Krief', 'Bérengère', 0),
(81, 'Paradis', 'Vanessa', 0),
(82, 'Robin', 'Murielle', 0),
(83, 'Duflot', 'Cecile', 0),
(84, 'Royal', 'Ségolène', 0),
(85, 'Veil', 'Simone', 0),
(86, 'Putois', 'Camille', 0),
(87, 'Seydoux', 'Léa', 0),
(88, 'Farmer', 'Mylène', 0),
(89, 'Chazal', 'Claire', 0),
(90, 'Zuckerberg', 'Mark', 0),
(91, 'Johnson', 'Dwayne', 0),
(92, 'Obama', 'Michelle', 0),
(93, 'Swift', 'Taylor', 0),
(94, 'Lebron', 'James', 0),
(95, 'Clarke', 'Emilia', 0),
(96, 'Grande', 'Ariana', 0),
(97, 'Malek', 'Rami', 0),
(98, 'Gaga', 'Lady', 0),
(99, 'Woods', 'Tiger', 0),
(100, 'Murphy', 'Ryan', 0),
(101, 'Morgan', 'Alex', 0);

-- --------------------------------------------------------

--
-- Structure de la table `trimestre`
--

CREATE TABLE `trimestre` (
  `id` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `debut` date NOT NULL,
  `fin` date NOT NULL,
  `anneeScolId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `trimestre`
--

INSERT INTO `trimestre` (`id`, `numero`, `debut`, `fin`, `anneeScolId`) VALUES
(2, 2, '2019-02-10', '2019-06-14', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `anneescolaire`
--
ALTER TABLE `anneescolaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `bulletin`
--
ALTER TABLE `bulletin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `InscriptionId` (`inscriptionId`),
  ADD KEY `trimestreId` (`trimestreId`);

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ecoleId` (`ecoleId`),
  ADD KEY `anneeScolId` (`anneeScolId`),
  ADD KEY `niveauId` (`niveauId`);

--
-- Index pour la table `detailbulletin`
--
ALTER TABLE `detailbulletin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bulletinId` (`bulletinId`),
  ADD KEY `enseignementId` (`enseignementId`);

--
-- Index pour la table `discipline`
--
ALTER TABLE `discipline`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ecole`
--
ALTER TABLE `ecole`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `enseignement`
--
ALTER TABLE `enseignement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classeId` (`classeId`),
  ADD KEY `disciplineId` (`disciplineId`),
  ADD KEY `PersonneId` (`personneId`);

--
-- Index pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `detailBulletinId` (`detailBulletinId`);

--
-- Index pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classeId` (`classeId`),
  ADD KEY `personneId` (`personneId`);

--
-- Index pour la table `niveau`
--
ALTER TABLE `niveau`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `trimestre`
--
ALTER TABLE `trimestre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `trimestre_ibfk_1` (`anneeScolId`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `anneescolaire`
--
ALTER TABLE `anneescolaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `bulletin`
--
ALTER TABLE `bulletin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `detailbulletin`
--
ALTER TABLE `detailbulletin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `discipline`
--
ALTER TABLE `discipline`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `ecole`
--
ALTER TABLE `ecole`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `enseignement`
--
ALTER TABLE `enseignement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `evaluation`
--
ALTER TABLE `evaluation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;

--
-- AUTO_INCREMENT pour la table `niveau`
--
ALTER TABLE `niveau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT pour la table `trimestre`
--
ALTER TABLE `trimestre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bulletin`
--
ALTER TABLE `bulletin`
  ADD CONSTRAINT `bulletin_ibfk_1` FOREIGN KEY (`inscriptionId`) REFERENCES `inscription` (`id`),
  ADD CONSTRAINT `bulletin_ibfk_2` FOREIGN KEY (`trimestreId`) REFERENCES `trimestre` (`id`);

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_1` FOREIGN KEY (`ecoleId`) REFERENCES `ecole` (`id`),
  ADD CONSTRAINT `classe_ibfk_2` FOREIGN KEY (`anneeScolId`) REFERENCES `anneescolaire` (`id`),
  ADD CONSTRAINT `classe_ibfk_3` FOREIGN KEY (`niveauId`) REFERENCES `niveau` (`id`);

--
-- Contraintes pour la table `detailbulletin`
--
ALTER TABLE `detailbulletin`
  ADD CONSTRAINT `detailbulletin_ibfk_1` FOREIGN KEY (`bulletinId`) REFERENCES `bulletin` (`id`),
  ADD CONSTRAINT `detailbulletin_ibfk_2` FOREIGN KEY (`enseignementId`) REFERENCES `enseignement` (`id`);

--
-- Contraintes pour la table `enseignement`
--
ALTER TABLE `enseignement`
  ADD CONSTRAINT `enseignement_ibfk_1` FOREIGN KEY (`classeId`) REFERENCES `classe` (`id`),
  ADD CONSTRAINT `enseignement_ibfk_2` FOREIGN KEY (`disciplineId`) REFERENCES `discipline` (`id`),
  ADD CONSTRAINT `enseignement_ibfk_3` FOREIGN KEY (`personneId`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `evaluation_ibfk_1` FOREIGN KEY (`detailBulletinId`) REFERENCES `detailbulletin` (`id`);

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `inscription_ibfk_1` FOREIGN KEY (`classeId`) REFERENCES `classe` (`id`),
  ADD CONSTRAINT `inscription_ibfk_2` FOREIGN KEY (`personneId`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `trimestre`
--
ALTER TABLE `trimestre`
  ADD CONSTRAINT `trimestre_ibfk_1` FOREIGN KEY (`anneeScolId`) REFERENCES `anneescolaire` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
