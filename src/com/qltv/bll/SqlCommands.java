package com.qltv.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.qltv.dal.MyConnector;

import net.proteanit.sql.DbUtils;

public class SqlCommands {
	private static Connection con = new MyConnector().Connect("quanlythuvien");
	private final static String TIMENOW = java.time.LocalDate.now().toString();
	public static int mucphat = quydinh()[0];
	public static int tuoimax = quydinh()[1];	
	public static int tuoimin = quydinh()[2];	
	public static int songayduocmuon = quydinh()[3];	
	public static int sosachduocmuon = quydinh()[4];
	public static int tienphatmotngay = quydinh()[5];
	public static String usename = root()[0];
	public static String pass = root()[1];
	/////
	private static int[] quydinh() {
		ResultSet rs = null;
 		rs = SelectCommands("SELECT * FROM quydinh");
		try {
			if (rs.next()) {
				int[] a = new int[] {rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)};
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new int[] {10,100,0,10,5,10000};
	}
	
	private static String[] root() {
		ResultSet rs = null;
 		rs = SelectCommands("SELECT * FROM root");
		try {
			if (rs.next()) {
				String[] a = new String[] {rs.getString(1),rs.getString(2)};
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String[] {"",""};
	}
	public static boolean Updateroot_pa(String usename, String pass) {
		String sqlCommand = "UPDATE root set usename = ?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			pst.setString(1, usename);
			pst.setString(2, pass);
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}
		return false;
	}
	public static boolean Updateroot_qd(int mucphat,int tuoimax ,int tuoimin ,int songayduocmuon ,int sosachduocmuon , int tienphatmotngay) {
		String sqlCommand = "UPDATE quydinh set mucphat = ?, tuoimax = ?,tuoimin = ?,songayduocmuon =?, sosachduocmuon =?, tienphatmotngay = ? ";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			pst.setInt(1, mucphat);
			pst.setInt(2, tuoimax);
			pst.setInt(3, tuoimin);
			pst.setInt(4, songayduocmuon);
			pst.setInt(5, sosachduocmuon);
			pst.setInt(6, tienphatmotngay);
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}
		return false;
	}
	////
	public static int Datediff(int mathe, int masach) {
		PreparedStatement ps = null;
		String sql = "SELECT DATEDIFF(CURDATE(), ngaymuon) AS days FROM phieumuon WHERE mathe = ? AND masach = ?";
		ResultSet rs = null;
		try {
			ps =  con.prepareStatement(sql);
			ps.setInt(1, mathe);
			ps.setInt(2, masach);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("error selest" + e.toString());
		}
		try {
			return rs.getInt(1);
		} catch (SQLException e) {
			return 0;
		}
	}
	public static int Giasach(int masach) {
		int giasach = 0;
		PreparedStatement ps = null;
		String sql = "SELECT giatri FROM sach WHERE masach = ?";
		ResultSet rs = null;
		try {
			ps =  con.prepareStatement(sql);
			ps.setInt(1, masach);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("error selest" + e.toString());
		}
		try {
			giasach = rs.getInt(1);
		} catch (SQLException e) {
		}
		return giasach;
	}
	////
	public static ResultSet SelectCommands(String sql) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps =  con.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet SelectCommands(String sql , String[] data) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			for (int i =0; i<data.length; i++)
				ps.setString(i+1, data[i]);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static DefaultTableModel GetTableModel(ResultSet rs, String[] columnNames) {
		DefaultTableModel datamodel = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
		Vector<String> columnvector = new Vector<String>();
		for (String name : columnNames)
			columnvector.add(name);
		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(datamodel.getDataVector(),columnvector){ 
			public boolean isCellEditable(int rowIndex, int columnIndex) { 
			    return false; 
			} 
			};
		return model;
	}
	
	//Qldg
	public static boolean Insertdg(String hoten, String email, String ngaysinh, String diachi) {
		String sqlCommand = "INSERT INTO docgia(hoten,email,ngaysinh,ngaydk,diachi) value(?, ?, ?, ?, ?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			// replace three "?" by id, Name and point of Studnet s
			pst.setString(1, hoten);
			pst.setString(2, email);
			pst.setString(3, ngaysinh);
			pst.setString(4, TIMENOW);
			pst.setString(5, diachi);
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("insert error \n" + e.toString());
		}
		return false;
	}
	public static boolean Updatedg(int mathe, String hoten, String email, String ngaysinh, String diachi, int tienno) {
		String sqlCommand = "UPDATE docgia set hoten = ?, email = ?, ngaysinh = ?, diachi = ?, tongtienno = ? WHERE mathe = ?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			pst.setString(1, hoten);
			pst.setString(2, email);
			pst.setString(3, ngaysinh);
			pst.setString(4, diachi);
			pst.setInt(5, tienno);
			pst.setInt(6, mathe);
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}
		return false;
	}
	public static boolean Deletedg(int mathe) {
		String sqlCommand = "DELETE FROM docgia WHERE mathe = ?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			pst.setInt(1, mathe);
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("delete error \n" + e.toString());
		}
		return false;
	}
	public static ResultSet SelectDG_mathe(int mathe) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = CmdLines.selectTable.DOCGIA + " WHERE mathe = ?";
		try {
			ps = con.prepareStatement(mysql);
			ps.setInt(1, mathe);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//// MT
	public static ResultSet SelectPM_mdg(int mathe) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = CmdLines.selectTable.PHIEUMUON + " WHERE mathe = ?";
		try {
			ps = con.prepareStatement(mysql);
			
			ps.setInt(1, mathe);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return rs;
	}
	public static int SelectPM_mdg(int mathe, int masach) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = "SELECT mapm FROM phieumuon WHERE trangthai = 0 AND mathe = ? AND masach = ?";
		try {
			ps = con.prepareStatement(mysql);
			
			ps.setInt(1, mathe);
			ps.setInt(2, masach);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return 0;
	}
	public static ResultSet SelectSach_ms(int masach) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = CmdLines.selectTable.SACH + " WHERE masach = ? AND soluong > ?";
		try {
			ps = con.prepareStatement(mysql);
			ps.setInt(1, masach);
			ps.setInt(2, 0);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	private static boolean Muonsach(int masach) {
		String sqlCommand = "UPDATE sach set soluong = soluong-1 WHERE masach = ?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			pst.setInt(1, masach);
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}
		return false;
	}
	private static boolean Muonsach_m(int mathe) {
		String sqlCommand = "UPDATE docgia set sachmuon = sachmuon+1 WHERE mathe = ?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			pst.setInt(1, mathe);
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}
		return false;
	}
	public static boolean Muonsach(int mathe, int masach) {
		String sqlCommand = "INSERT INTO phieumuon(mathe,masach,ngaymuon) value(?, ?, ?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			// replace three "?" by id, Name and point of Studnet s
			pst.setInt(1, mathe);
			pst.setInt(2, masach);
			pst.setString(3, TIMENOW);
			if (pst.executeUpdate() == 0) {
				return false;
			} 
			return Muonsach(masach)?Muonsach_m(mathe):false;
		} catch (SQLException e) {
			return false;
		}
	}
	public static ResultSet SelectPT_mdg(int mathe) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = CmdLines.selectTable.PHIEUTRA + " WHERE mathe = ?";
		try {
			ps = con.prepareStatement(mysql);
			
			ps.setInt(1, mathe);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return rs;
	}
	private static boolean Trasach(int masach) {
		String sqlCommand = "UPDATE sach set soluong = soluong+1 WHERE masach = ?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			pst.setInt(1, masach);
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}
		return false;
	}
	private static boolean Trasach_m(int mathe, int tienno) {
		String sqlCommand = "UPDATE docgia set sachmuon = sachmuon-1 , tongtienno = tongtienno+? WHERE mathe = ?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			pst.setInt(1, tienno);
			pst.setInt(2, mathe);
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}
		return false;
	}
	private static boolean Trasach_pm(int mathe, int masach) {
		int mapm = SelectPM_mdg(mathe, masach);
		
		String sqlCommand = "UPDATE phieumuon set trangthai = 1 WHERE mapm = ?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			pst.setInt(1, mapm);
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}
		return false;
	}
	public static boolean Trasach(int mathe, int masach, int tienphat) {
		String sqlCommand = "INSERT INTO phieutra(mathe,masach,ngaytra,tienphatkinay) value(?, ?, ?, ?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			// replace three "?" by id, Name and point of Studnet s
			pst.setInt(1, mathe);
			pst.setInt(2, masach);
			pst.setString(3, TIMENOW);
			pst.setInt(4, tienphat);
			if (pst.executeUpdate() == 0) {
				return false;
			} 
			if(Trasach(masach)&&Trasach_m(mathe,tienphat)&&Trasach_pm(mathe, masach))
				return true;
		} catch (SQLException e) {
			return false;
		}
		return false;
	}
	public static boolean Matsach(int mathe, int masach, int tienphat) {
		if(Trasach(masach)&&Trasach_m(mathe,tienphat)&&Trasach_pm(mathe, masach))
			return true;
		return false;
	}
	//QLsach
	public static boolean Insertsach(String tensach,String theloai,String tacgia,String nxb,String ngayxb,int giatri,int soluong) {
		String sqlCommand = "INSERT INTO sach(tensach,theloai,tacgia,nxb,ngayxb,ngaynhap,giatri,soluong) value(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			// replace three "?" by id, Name and point of Studnet s
			pst.setString(1, tensach);
			pst.setString(2, theloai);
			pst.setString(3, tacgia);
			pst.setString(4, nxb);
			pst.setString(5, ngayxb);
			pst.setString(6, TIMENOW);
			pst.setInt(7, giatri);
			pst.setInt(8, soluong);
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("insert error \n" + e.toString());
		}
		return false;
	}
	public static boolean Updatesach(int masach, String tensach,String theloai,String tacgia,String nxb,String ngayxb,int giatri,int soluong) {
		String sqlCommand = "UPDATE sach set tensach = ?, theloai = ?, tacgia = ?, nxb = ?, ngayxb = ?, giatri = ? , soluong = ? WHERE masach = ?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			pst.setString(1, tensach);
			pst.setString(2, theloai);
			pst.setString(3, tacgia);
			pst.setString(4, nxb);
			pst.setString(5, ngayxb);
			pst.setInt(6, giatri);
			pst.setInt(7, soluong);
			pst.setInt(8, masach);
			if (pst.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("update error \n" + e.toString());
		}
		return false;
	}
	public static boolean Deletesach(int masach) {
		String sqlCommand = "DELETE FROM sach WHERE masach = ?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sqlCommand);
			pst.setInt(1, masach);
			if (pst.executeUpdate() > 0) {
				return true ;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("delete error \n" + e.toString());
		}
		return false;
	}
	public static ResultSet SelectSach_masach(int masach) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = CmdLines.selectTable.SACH + " WHERE masach = ?";
		try {
			ps = con.prepareStatement(mysql);
			ps.setInt(1, masach);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	///TimkiemSach
	public static ResultSet SelectSach_tk(String tensach, String tacgia, String theloai, String nxb) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = CmdLines.selectTable.SACH + " WHERE tensach LIKE ? AND tacgia LIKE ? AND theloai LIKE ? AND nxb LIKE ?";
		try {
			ps = con.prepareStatement(mysql);
			ps.setString(1, "%"+tensach+"%");
			ps.setString(2, "%"+tacgia+"%");
			ps.setString(3, "%"+theloai+"%");
			ps.setString(4, "%"+nxb+"%");
			
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	///Thongke
	public static ResultSet Select_tngay_pm(String tungay, String denngay) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = CmdLines.selectTable.PHIEUMUON + " WHERE ngaymuon >= ? AND ngaymuon <= ?";
		try {
			ps = con.prepareStatement(mysql);
			ps.setString(1, tungay);
			ps.setString(2, denngay);
			
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet Select_tngay_pt(String tungay, String denngay) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = CmdLines.selectTable.PHIEUTRA + " WHERE ngaytra >= ? AND ngaytra <= ?";
		try {
			ps = con.prepareStatement(mysql);
			ps.setString(1, tungay);
			ps.setString(2, denngay);
			
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet Select_tngay_quahan(int gioihan) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = CmdLines.selectTable.PHIEUMUON + " WHERE DATEDIFF(CURDATE(), ngaymuon) <= ?";
		try {
			ps = con.prepareStatement(mysql);
			ps.setInt(1, gioihan);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet Select_tthang_pm(String thang, String nam) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = CmdLines.selectTable.PHIEUMUON + " WHERE ngaymuon LIKE ?";
		try {
			ps = con.prepareStatement(mysql);
			ps.setString(1, nam+"-"+thang+"%");
			
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return rs;
	}
	public static ResultSet Select_thang_pt(String thang, String nam) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String mysql = CmdLines.selectTable.PHIEUTRA + " WHERE ngaytra LIKE ?";
		try {
			ps = con.prepareStatement(mysql);
			ps.setString(1, nam+"-"+thang+"%");
			
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
