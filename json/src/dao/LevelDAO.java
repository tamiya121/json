package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBCon;
import vo.LevelInfo;

public class LevelDAO {
	public List<LevelInfo> selectLevelInfoList(){
	Connection con = DBCon.getCon();
	String sql = "select * from level_info";
	List<LevelInfo> liList = new ArrayList<LevelInfo>();
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			LevelInfo li = new LevelInfo(rs.getInt("liNum"), rs.getInt("liLevel"), rs.getString("liName"), rs.getString("liDesc"));
			liList.add(li);
		}
		ps.close();
		rs.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		DBCon.close();
	}
	
	
	return liList;
	}
}
