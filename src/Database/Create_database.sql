-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 06, 2019 lúc 07:32 AM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlythuvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `docgia`
--

CREATE TABLE `docgia` (
  `mathe` int(11) NOT NULL,
  `hoten` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `ngaysinh` date NOT NULL,
  `ngaydk` date NOT NULL,
  `diachi` text,
  `tongtienno` int(11) DEFAULT '0',
  `sachmuon` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `docgia`
--

INSERT INTO `docgia` (`mathe`, `hoten`, `email`, `ngaysinh`, `ngaydk`, `diachi`, `tongtienno`, `sachmuon`) VALUES
(1, 'Nguyễn Đức Long', '17020865@vnu.edu.com', '1999-02-22', '2019-05-02', 'Không nhớ', 0, 0),
(9, 'Vũ Thị Ngọc Lê', 'lethoi@pika.com', '1999-12-08', '2019-05-04', 'Bắc Giang', 5000, 0),
(11, 'Ngô Thái Khoai', 'sonkhoai@vnu.edu.vn', '2000-05-11', '2019-05-05', 'Đâu đó đất Nam Kỳ', 0, 0),
(12, 'Thấp Còn Hư', 'ngoancao@vtc.cc', '2001-10-15', '2019-05-05', 'Quất Lâm Resort', 35000, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieumuon`
--

CREATE TABLE `phieumuon` (
  `mapm` int(11) NOT NULL,
  `mathe` int(11) NOT NULL,
  `masach` int(11) NOT NULL,
  `ngaymuon` date NOT NULL,
  `trangthai` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieutra`
--

CREATE TABLE `phieutra` (
  `mapt` int(11) NOT NULL,
  `mathe` int(11) NOT NULL,
  `masach` int(11) NOT NULL,
  `ngaytra` date NOT NULL,
  `tienphatkinay` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quydinh`
--

CREATE TABLE `quydinh` (
  `mucphat` int(11) NOT NULL,
  `tuoimax` int(11) NOT NULL,
  `tuoimin` int(11) NOT NULL,
  `songayduocmuon` int(11) NOT NULL,
  `sosachduocmuon` int(11) NOT NULL,
  `tienphatmotngay` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `quydinh`
--

INSERT INTO `quydinh` (`mucphat`, `tuoimax`, `tuoimin`, `songayduocmuon`, `sosachduocmuon`, `tienphatmotngay`) VALUES
(3, 65, 14, 7, 3, 10000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `masach` int(11) NOT NULL,
  `tensach` varchar(50) NOT NULL,
  `theloai` varchar(25) NOT NULL,
  `tacgia` varchar(50) NOT NULL,
  `nxb` varchar(50) NOT NULL,
  `ngaynhap` date NOT NULL,
  `ngayxb` date NOT NULL,
  `giatri` int(11) NOT NULL,
  `soluong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`masach`, `tensach`, `theloai`, `tacgia`, `nxb`, `ngaynhap`, `ngayxb`, `giatri`, `soluong`) VALUES
(1, 'Dạy nấu cơm tập 1', 'truyện tranh', 'pikalong', 'kim đồng ngọc nữ', '2019-05-01', '2019-02-05', 99909, 5),
(2, 'Giải tích 1', 'Văn học', 'haha', 'gg', '2018-02-14', '2016-10-11', 5000, 9);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `docgia`
--
ALTER TABLE `docgia`
  ADD PRIMARY KEY (`mathe`);

--
-- Chỉ mục cho bảng `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD PRIMARY KEY (`mapm`),
  ADD KEY `fk_pm_mathe` (`mathe`),
  ADD KEY `fk_pm_masach` (`masach`);

--
-- Chỉ mục cho bảng `phieutra`
--
ALTER TABLE `phieutra`
  ADD PRIMARY KEY (`mapt`),
  ADD KEY `fk_pt_mathe` (`mathe`),
  ADD KEY `fk_pt_masach` (`masach`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`masach`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `docgia`
--
ALTER TABLE `docgia`
  MODIFY `mathe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `phieumuon`
--
ALTER TABLE `phieumuon`
  MODIFY `mapm` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `phieutra`
--
ALTER TABLE `phieutra`
  MODIFY `mapt` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `sach`
--
ALTER TABLE `sach`
  MODIFY `masach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `phieumuon`
--
ALTER TABLE `phieumuon`
  ADD CONSTRAINT `fk_pm_masach` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_pm_mathe` FOREIGN KEY (`mathe`) REFERENCES `docgia` (`mathe`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `phieutra`
--
ALTER TABLE `phieutra`
  ADD CONSTRAINT `fk_pt_masach` FOREIGN KEY (`masach`) REFERENCES `sach` (`masach`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_pt_mathe` FOREIGN KEY (`mathe`) REFERENCES `docgia` (`mathe`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
