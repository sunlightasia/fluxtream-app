CREATE TABLE `Facet_MovesMove` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `api` int(11) NOT NULL,
  `apiKeyId` bigint(20) DEFAULT NULL,
  `comment` longtext,
  `end` bigint(20) NOT NULL,
  `fullTextDescription` longtext,
  `guestId` bigint(20) NOT NULL,
  `isEmpty` char(1) NOT NULL,
  `objectType` int(11) NOT NULL,
  `start` bigint(20) NOT NULL,
  `tags` longtext,
  `timeUpdated` bigint(20) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `endTimeStorage` varchar(255) DEFAULT NULL,
  `startTimeStorage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `isEmpty_index` (`isEmpty`),
  KEY `end_index` (`end`),
  KEY `start_index` (`start`),
  KEY `api_index` (`api`),
  KEY `objectType_index` (`objectType`),
  KEY `guestId_index` (`guestId`),
  KEY `date` (`date`),
  KEY `apiKey` (`apiKeyId`),
  KEY `timeUpdated_index` (`timeUpdated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `Facet_MovesPlace` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `api` int(11) NOT NULL,
  `apiKeyId` bigint(20) DEFAULT NULL,
  `comment` longtext,
  `end` bigint(20) NOT NULL,
  `fullTextDescription` longtext,
  `guestId` bigint(20) NOT NULL,
  `isEmpty` char(1) NOT NULL,
  `objectType` int(11) NOT NULL,
  `start` bigint(20) NOT NULL,
  `tags` longtext,
  `timeUpdated` bigint(20) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `endTimeStorage` varchar(255) DEFAULT NULL,
  `startTimeStorage` varchar(255) DEFAULT NULL,
  `foursquareId` varchar(255) DEFAULT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `placeId` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `isEmpty_index` (`isEmpty`),
  KEY `end_index` (`end`),
  KEY `start_index` (`start`),
  KEY `api_index` (`api`),
  KEY `objectType_index` (`objectType`),
  KEY `guestId_index` (`guestId`),
  KEY `date` (`date`),
  KEY `apiKey` (`apiKeyId`),
  KEY `timeUpdated_index` (`timeUpdated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `MovesActivity` (
  `ActivityID` bigint(20) NOT NULL,
  `activity` varchar(255) DEFAULT NULL,
  `activityURI` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `distance` int(11) NOT NULL,
  `end` bigint(20) NOT NULL,
  `endTimeStorage` varchar(255) DEFAULT NULL,
  `start` bigint(20) NOT NULL,
  `startTimeStorage` varchar(255) DEFAULT NULL,
  `steps` int(11) DEFAULT NULL,
  KEY `FK51B7E3D1185495D1` (`ActivityID`),
  KEY `FK51B7E3D1738B879` (`ActivityID`),
  CONSTRAINT `FK51B7E3D1738B879` FOREIGN KEY (`ActivityID`) REFERENCES `Facet_MovesPlace` (`id`),
  CONSTRAINT `FK51B7E3D1185495D1` FOREIGN KEY (`ActivityID`) REFERENCES `Facet_MovesMove` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;