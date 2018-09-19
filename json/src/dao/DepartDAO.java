package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBCon;
import vo.DepartInfo;

public class DepartDAO {

	public List<DepartInfo> selectDepartInfoList() {
		Connection con = DBCon.getCon();
		String sql = "select * from depart_info";
		List<DepartInfo> diList = new ArrayList<DepartInfo>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DepartInfo di = new DepartInfo(rs.getInt("diNum"), rs.getString("diCode"), 
												rs.getString("diName"),rs.getString("diDesc"));
				diList.add(di);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBCon.close();
		}
		return diList;
	}
}
