SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

CREATE TABLE `studenti` (
  `id` int(11) NOT NULL,
  `Os_c` varchar(9) NOT NULL,
  `Prijmeni` varchar(100) NOT NULL,
  `Stud_program` varchar(5) NOT NULL,
  `Rocnik` int(11) NOT NULL,
  `Tel_cislo` int(10) NOT NULL,
  `Rok_narozeni` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `studenti` (`id`, `Os_c`, `Prijmeni`, `Stud_program`, `Rocnik`,`Tel_cislo`, `Rok_narozeni`) VALUES
(1, 'K19B9311P', 'David Chromý', 'IM', 2, 722554785, 2000),
(2, 'K19B2312P', 'Roman Novák', 'IM', 3, 728554785, 1998),
(3, 'K19B8897P', 'Václav Novák', 'PE', 2, 724554785, 1997),
(4, 'K19B0098P', 'Petr Novák', 'MR', 1, 602554785, 1999),
(5, 'K21B0983P', 'Aleš Bohr', 'MR', 4, 607514785, 1999),
(6, 'K21B1232P', 'Jan Novák', 'PE', 5, 777514785, 1998  );

ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `studenti`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
 
ALTER TABLE `studenti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

