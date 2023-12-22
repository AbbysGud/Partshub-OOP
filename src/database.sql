-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.24-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for partshub
DROP DATABASE IF EXISTS `partshub`;
CREATE DATABASE IF NOT EXISTS `partshub` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `partshub`;

-- Dumping structure for table partshub.barang
DROP TABLE IF EXISTS `barang`;
CREATE TABLE IF NOT EXISTS `barang` (
  `id_barang` int(11) NOT NULL AUTO_INCREMENT,
  `id_jenisbarang` bigint(20) unsigned NOT NULL,
  `nama_barang` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `merk_barang` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `harga_barang` int(11) NOT NULL,
  `stok_barang` int(11) NOT NULL,
  PRIMARY KEY (`id_barang`),
  KEY `FK-barang_id-jenisbarang` (`id_jenisbarang`),
  CONSTRAINT `FK-barang_id-jenisbarang` FOREIGN KEY (`id_jenisbarang`) REFERENCES `jenis_barang` (`id_jenisbarang`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table partshub.barang: ~5 rows (approximately)
INSERT INTO `barang` (`id_barang`, `id_jenisbarang`, `nama_barang`, `merk_barang`, `harga_barang`, `stok_barang`) VALUES
	(1, 2, 'Kampas Rem', 'Honda', 180000, 5),
	(2, 2, 'Cakram rem', 'Honda', 200000, 5),
	(3, 3, 'Shock Absorber', 'Suzuki', 300000, 5),
	(4, 4, 'Radiator', 'Yamaha', 10000, 5);

-- Dumping structure for table partshub.cart
DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `id_user` bigint(20) unsigned NOT NULL,
  `id_barang` int(11) NOT NULL,
  `nama_jenisbarang` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  KEY `FK_id-user` (`id_user`),
  KEY `FK_id-barang` (`id_barang`),
  KEY `FK_nama-jenis` (`nama_jenisbarang`),
  CONSTRAINT `FK_id-barang` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_id-user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_nama-jenis` FOREIGN KEY (`nama_jenisbarang`) REFERENCES `jenis_barang` (`nama_jenisbarang`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table partshub.cart: ~1 rows (approximately)
INSERT INTO `cart` (`id_user`, `id_barang`, `nama_jenisbarang`, `harga_barang`, `jumlah`, `total`) VALUES
	(2, 1, 'Sistem Rem', 180000, 5, 900000);

-- Dumping structure for table partshub.jenis_barang
DROP TABLE IF EXISTS `jenis_barang`;
CREATE TABLE IF NOT EXISTS `jenis_barang` (
  `id_jenisbarang` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nama_jenisbarang` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_jenisbarang`),
  KEY `nama_jenisbarang` (`nama_jenisbarang`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table partshub.jenis_barang: ~4 rows (approximately)
INSERT INTO `jenis_barang` (`id_jenisbarang`, `nama_jenisbarang`) VALUES
	(1, 'Sistem Kelistrikan'),
	(4, 'Sistem Pendingin'),
	(2, 'Sistem Rem'),
	(3, 'Sistem Suspensi');

-- Dumping structure for table partshub.transaksi
DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE IF NOT EXISTS `transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(20) unsigned NOT NULL,
  `id_barang` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `waktu_transaksi` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id_transaksi`),
  KEY `FK-Transaksi_id-user` (`id_user`),
  KEY `FK-Transaksi_id-barang` (`id_barang`),
  CONSTRAINT `FK-Transaksi_id-barang` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK-Transaksi_id-user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table partshub.transaksi: ~14 rows (approximately)
INSERT INTO `transaksi` (`id_transaksi`, `id_user`, `id_barang`, `jumlah`, `total`, `waktu_transaksi`) VALUES
	(1, 2, 1, 10, 1800000, '2023-05-26 15:03:04'),
	(2, 2, 3, 3, 900000, '2023-05-26 15:06:45'),
	(3, 1, 4, 5, 50000, '2023-05-26 15:08:48'),
	(4, 1, 1, 5, 900000, '2023-05-26 15:24:20'),
	(5, 2, 1, 3, 540000, '2023-05-28 11:07:01'),
	(6, 2, 1, 2, 360000, '2023-05-28 11:58:20'),
	(7, 2, 2, 5, 1000000, '2023-05-28 11:58:13'),
	(8, 3, 3, 5, 1500000, '2023-05-28 11:58:00'),
	(9, 3, 3, 5, 1500000, '2023-05-28 11:57:59'),
	(10, 3, 4, 10, 100000, '2023-05-28 11:57:39'),
	(11, 2, 1, 3, 540000, '2023-05-28 12:05:28'),
	(12, 6, 1, 2, 360000, '2023-05-29 00:19:39'),
	(13, 1, 1, 5, 900000, '2023-05-29 13:03:19'),
	(14, 7, 2, 5, 1000000, '2023-05-31 07:19:34'),
	(15, 2, 4, 5, 50000, '2023-06-02 02:33:00');

-- Dumping structure for table partshub.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `full_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone_number` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table partshub.user: ~8 rows (approximately)
INSERT INTO `user` (`id`, `username`, `full_name`, `address`, `phone_number`, `password`) VALUES
	(1, 'ariq.bagus', 'Ariq Bagus Sugiharto', 'Jl. Nata Endah Gg. Pa Elil No. 31', '085321115400', '12345'),
	(2, 'test', 'Orang Pertama', 'itenas', 'test', 'test'),
	(3, 'test2', 'testing kedua', 'itenas', 'test2', 'test'),
	(4, 'test3', 'Testing 2', 'itenas', 'test', 'test'),
	(5, 'ramzi', 'Ramzi Syuhada', 'Rancaekek', '12345', '12345'),
	(6, 'riq', 'Ariq BS 2', 'kopo', '085321115400', 'test'),
	(7, 'coba', 'testing', 'itenas', '12345', 'test');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
