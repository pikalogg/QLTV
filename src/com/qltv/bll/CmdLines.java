package com.qltv.bll;

public interface CmdLines {
	public static interface tableName{
		String DOCGIA = "docgia";
		String SACH = "sach";
		String PHIEUMUON = "phieumuon";
		String PHIEUTRA = "phieutra";
		String QUYDINH = "quydinh";
	}
	public static interface selectTable{
		String DOCGIA = "SELECT CONCAT('DG',RIGHT(CONCAT('000000',CAST(mathe AS CHAR)), 6)) AS mathe, hoten, email, ngaysinh, ngaydk, diachi, CONCAT(CAST(tongtienno AS CHAR),' VND') AS tongtienno FROM docgia";
		String SACH = "SELECT CONCAT('MS',RIGHT(CONCAT('000000',CAST(masach AS CHAR)), 6)) AS masach, tensach, theloai,tacgia, nxb, CONCAT(CAST(giatri AS CHAR),' VND') AS giatri, soluong FROM sach";
		String PHIEUMUON = "SELECT CONCAT('PM',RIGHT(CONCAT('000000',CAST(mapm AS CHAR)), 6)) AS mapm,	CONCAT('DG',RIGHT(CONCAT('000000',CAST(mathe AS CHAR)), 6)) AS mathe,	CONCAT('MS',RIGHT(CONCAT('000000',CAST(masach AS CHAR)), 6)) AS masach, ngaymuon, CASE trangthai WHEN 1 THEN 'complete' WHEN 0 THEN '' END AS trangthai FROM phieumuon";
		String PHIEUTRA = "SELECT CONCAT('PT',RIGHT(CONCAT('000000',CAST(mapt AS CHAR)), 6)) AS mapt,	CONCAT('DG',RIGHT(CONCAT('000000',CAST(mathe AS CHAR)), 6)) AS mathe,	CONCAT('MS',RIGHT(CONCAT('000000',CAST(masach AS CHAR)), 6)) AS masach,	ngaytra, tienphatkinay FROM phieutra";
		String QUYDINH = "SELECT * FROM quydinh";
	}
	public static interface columnNames{
		String[] DOCGIA = {
		        "Mã thẻ", "Họ Tên", "Email", "Ngày Sinh","Ngày ĐK","Địa chỉ","Tiền nợ"
		    };
		String[] SACH = {
				"Mã sách", "Tên sách", "Thể loại", "Tác giả", "NXB" , "giá trị", "số lượng"
			};
		String[] QUYDINH = {
				
		};
		String[] PHIEUTRA = {
				"Mã P.Trả","Mã thẻ","Mã sách","Ngày Trả","Tiền Phạt"
		};
		String[] PHIEUMUON = {
				"Mã P.Mượn","Mã thẻ","Mã sách","Ngày Mượn","Trạng thái"
		};
	}
}
