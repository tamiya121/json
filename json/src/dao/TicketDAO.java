package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBCon;
import vo.Ticket;

public class TicketDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps;

	private void close() {
		
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBCon.close();
	}

	public List<Ticket> selectTicketList(Ticket ti) {
		List<Ticket> ticketList = new ArrayList<Ticket>();
		Connection con = DBCon.getCon();
		try {
			String sql = "select * from TICKET_MOVIE ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ti = new Ticket(rs.getInt("tmnum"), rs.getString("tmname"), rs.getInt("tmprice"),
						rs.getString("tmstartdat"), rs.getString("tmenddat"), rs.getString("tmcredat"),
						rs.getString("tmdesc"), rs.getInt("tmcnt"), rs.getString("tmimg"));
				ticketList.add(ti);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return ticketList;
	}

	public Ticket selectTicket(Ticket ticket) {
		Connection con = DBCon.getCon();
		try {
			String sql = "select * from TICKET_MOVIE where tmnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ticket.getTmnum());
			rs = ps.executeQuery();
			while (rs.next()) {
				ticket = new Ticket(rs.getInt("tmnum"), rs.getString("tmname"), rs.getInt("tmprice"),
						rs.getString("tmstartdat"), rs.getString("tmenddat"), rs.getString("tmcredat"),
						rs.getString("tmdesc"), rs.getInt("tmcnt"), rs.getString("tmimg"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return ticket;
	}

	public int insertTicket(Ticket ticket) {
		con = DBCon.getCon();
		String sql = "insert into ticket_movie (tmnum, tmname, tmprice, tmstartdat, tmenddat, tmcredat, tmdesc, tmcnt, tmimg)";
		sql += " values(seq_tmnum.nextval,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ticket.getTmname());
			ps.setInt(2, ticket.getTmprice());
			ps.setString(3, ticket.getTmstartdat());
			ps.setString(4, ticket.getTmenddat());
			ps.setString(5, ticket.getTmcredat());
			ps.setString(6, ticket.getTmdesc());
			ps.setInt(7, ticket.getTmcnt());
			ps.setString(8, ticket.getTmimg());
			int cnt = ps.executeUpdate();
			con.commit();
			 return cnt;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}
	public int updateItcket(Ticket ticket) {
		con = DBCon.getCon();
		String sql = "update ticket_movie set "+
				" tmname=?, " +
				" tmstartdat=?," +
				" tmenddat=?," +
				" tmcredat=?," +
				" tmcnt=?" +
				" where tmnum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ticket.getTmname());
			ps.setString(2, ticket.getTmstartdat());
			ps.setString(3, ticket.getTmenddat());
			ps.setString(4, ticket.getTmcredat());
			ps.setInt(5, ticket.getTmcnt());
			ps.setInt(6, ticket.getTmnum());
		
			
			int cnt = ps.executeUpdate();
			con.commit();
			return cnt;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}

	public int deleteTicket(Ticket ticket) {

		con = DBCon.getCon();
		String sql = "delete from ticket_movie where tmnum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ticket.getTmnum());
			int cnt = ps.executeUpdate();
			con.commit();
			 return cnt;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}
}
