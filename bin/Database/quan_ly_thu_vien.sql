-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 21, 2019 lúc 03:53 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quan_ly_thu_vien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cacloaidocgia`
--

CREATE TABLE `cacloaidocgia` (
  `loaidg` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cacloaisach`
--

CREATE TABLE `cacloaisach` (
  `loaisach` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ct_phieumuon`
--

CREATE TABLE `ct_phieumuon` (
  `mapm` int(11) NOT NULL,
  `masach` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ct_phieutra`
--

CREATE TABLE `ct_phieutra` (
  `songaydamuon` int(11) NOT NULL,
  `tienphatsach` int(11) NOT NULL,
  `mapt` int(11) NOT NULL,
  `masach` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `docgia`
--

CREATE TABLE `docgia` (
  `mathe` int(11) NOT NULL,
  `hoten` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `ngaysinh` datetime NOT NULL,
  `ngaydk` datetime NOT NULL,
  `diachi` text,
  `loaidocgia` varchar(50) NOT NULL,
  `tongtienno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giahan`
--

CREATE TABLE `giahan` (
  `solangiahan` int(11) NOT NULL,
  `masach` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieumuon`
--

CREATE TABLE `phieumuon` (
  `mapm` int(11) NOT NULL,
  `ngaymuon` datetime NOT NULL,
  `mathe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuthutienphat`
--

CREATE TABLE `phieuthutienphat` (
  `maphieuthu` int(11) NOT NULL,
  `ngaythu` datetime NOT NULL,
  `tienthu` int(11) NOT NULL,
  `mathe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieutra`
--

CREATE TABLE `phieutra` (
  `mapt` int(11) NOT NULL,
  `ngaytra` datetime NOT NULL,
  `tienphatkinay` int(11) NOT NULL,
  `mathe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quydinh`
--

CREATE TABLE `quydinh` (
  `tienphattrasachtremoingay` int(11) NOT NULL,
  `tuoimax` int(11) NOT NULL,
  `tuoimin` int(11) NOT NULL,
  `songayduocmuon` int(11) NOT NULL,
  `sosachduocmuon` int(11) NOT NULL,
  `kcnamxuatban` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `masach` int(11) NOT NULL,
  `tensach` varchar(50) NOT NULL,
  `theloai` varchar(50) NOT NULL,
  `tacgia` varchar(50) NOT NULL,
  `nxb` varchar(50) DEFAULT NULL,
  `ngaynhap` datetime NOT NULL,
  `ngayxb` datetime NOT NULL,
  `giatri` int(11) NOT NULL,
  `trangthai` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ct_phieumuon`
--
ALTER TABLE `ct_phieumuon`
  ADD KEY `masach` (`masach`),
  ADD KEY `mapm` (`mapm`);

--
-- Chỉ mục cho bảng `ct_phieutra`
--
ALTER TABLE `ct_phieutra`
  ADD PRIMARY KEY (`mapt`,`masach`),
  ADD KEY `masach` (`masach`);

--
-- Chỉ mục cho bảng `docgia`
--
ALTER TABLE `docgia`
  ADD PRIMARY KEY (`mathe`);

--
-- Chỉ mục cho bảng `giahan`
--
ALTER TABLE `giahan`
  ADD KEY `masach` (`masach`);

--
-- Chỉ mục cho bảng `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD PRIMARY KEY (`mapm`),
  ADD KEY `fk_htk_docgia` (`mathe`);

--
-- Chỉ mục cho bảng `phieuthutienphat`
--
ALTER TABLE `phieuthutienphat`
  ADD PRIMARY KEY (`maphieuthu`),
  ADD KEY `mathe` (`mathe`);

--
-- Chỉ mục cho bảng `phieutra`
--
ALTER TABLE `phieutra`
  ADD PRIMARY KEY (`mapt`),
  ADD KEY `fk_ptk_docgia` (`mathe`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`masach`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ct_phieumuon`
--
ALTER TABLE `ct_phieumuon`
  ADD CONSTRAINT `ct_phieumuon_ibfk_1` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`),
  ADD CONSTRAINT `ct_phieumuon_ibfk_2` FOREIGN KEY (`mapm`) REFERENCES `phieumuon` (`mapm`);

--
-- Các ràng buộc cho bảng `ct_phieutra`
--
ALTER TABLE `ct_phieutra`
  ADD CONSTRAINT `ct_phieutra_ibfk_1` FOREIGN KEY (`mapt`) REFERENCES `phieutra` (`mapt`),
  ADD CONSTRAINT `ct_phieutra_ibfk_2` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`);

--
-- Các ràng buộc cho bảng `giahan`
--
ALTER TABLE `giahan`
  ADD CONSTRAINT `giahan_ibfk_1` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`);

--
-- Các ràng buộc cho bảng `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD CONSTRAINT `fk_htk_docgia` FOREIGN KEY (`mathe`) REFERENCES `docgia` (`mathe`);

--
-- Các ràng buộc cho bảng `phieuthutienphat`
--
ALTER TABLE `phieuthutienphat`
  ADD CONSTRAINT `phieuthutienphat_ibfk_1` FOREIGN KEY (`mathe`) REFERENCES `docgia` (`mathe`);

--
-- Các ràng buộc cho bảng `phieutra`
--
ALTER TABLE `phieutra`
  ADD CONSTRAINT `fk_ptk_docgia` FOREIGN KEY (`mathe`) REFERENCES `docgia` (`mathe`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
