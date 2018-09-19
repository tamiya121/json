package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBCon;
import vo.MemberInfo;

public class MemberDAO {
	public List<MemberInfo> selectMemberInfoList(){
	Connection con = DBCon.getCon();
	String sql = "select * from Member_Info";
	List<MemberInfo> miList = new ArrayList<MemberInfo>();
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			MemberInfo mi = new MemberInfo(rs.getInt("miNum"),
					rs.getString("miId"),
					rs.getString("miName"),
					rs.getString("miPwd"),
					rs.getString("diCode"),
					rs.getInt("liLevel"),
					rs.getString("miEmail"),
					rs.getString("miDesc"),
					rs.getString("miPhone"),
					rs.getString("miZipCode"),
					rs.getString("miAddress1"),
					rs.getString("miAddress2"));
			miList.add(mi);
		}
		ps.close();
		rs.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		DBCon.close();
	}
	return miList;
}
}

