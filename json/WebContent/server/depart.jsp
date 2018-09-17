<%@page import="java.util.ArrayList"%>
<%@page import="vo.DepartInfo"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.DBCon"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
public class Depart {
	private String dinum;
	private String diname;
	private String ditype;
	
	public Depart(String dinum, String diname, String ditype) {
		super();
		this.dinum = dinum;
		this.diname = diname;
		this.ditype = ditype;
	}

	public String getDinum() {
		return dinum;
	}

	public void setDinum(String dinum) {
		this.dinum = dinum;
	}

	public String getDiname() {
		return diname;
	}

	public void setDiname(String diname) {
		this.diname = diname;
	}

	public String getDitype() {
		return ditype;
	}

	public void setDitype(String ditype) {
		this.ditype = ditype;
	}

	@Override
	public String toString() {
		return "Depart [dinum=" + dinum + ", diname=" + diname + ", ditype=" + ditype + "]";
	}
	
	
}
%>
<%
String param = request.getParameter("param");
System.out.print(param);
Gson gson = new Gson();
DepartInfo dp = gson.fromJson(param, DepartInfo.class);

Connection con = DBCon.getCon();
String sql = "select * from depart_info where diName like '%' || ? || '%' "; 
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1, dp.getDiName());
ResultSet rs = ps.executeQuery();
List<DepartInfo> diList = new ArrayList<DepartInfo>(); 

while(rs.next()){
	DepartInfo d = new DepartInfo();
	d.setDiNum(rs.getLong("diNum"));
	d.setDiCode(rs.getString("diCode"));
	d.setDiName(rs.getString("diName"));
	d.setDiDesc(rs.getString("diDesc"));
	diList.add(d);	
}

System.out.println(diList);
String json = gson.toJson(diList);
System.out.println("난 변환된 Json : " + json);
out.println(json);
%>
