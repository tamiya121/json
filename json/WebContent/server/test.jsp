
<%@page import="common.DBCon"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%! 



public class DepartInfo {
	private Long diNum;
	private String diCode;
	private String diName;
	private String diDesc;
	
	public DepartInfo(){
		
	}
	

	public Long getDiNum() {
		return diNum;
	}

	public void setDiNum(Long diNum) {
		this.diNum = diNum;
	}

	public String getDiCode() {
		return diCode;
	}

	public void setDiCode(String diCode) {
		this.diCode = diCode;
	}

	public String getDiName() {
		return diName;
	}

	public void setDiName(String diName) {
		this.diName = diName;
	}

	public String getDiDesc() {
		return diDesc;
	}

	public void setDiDesc(String diDesc) {
		this.diDesc = diDesc;
	}

	@Override
	public String toString() {
		return "DepartInfo [diNum=" + diNum + ", diCode=" + diCode + ", diName=" + diName + ", diDesc=" + diDesc + "]";
	}
	
	
}
%>
<%
String param = request.getParameter("param");
Gson gson = new Gson();
DepartInfo di = gson.fromJson(request.getReader(), DepartInfo.class);

Connection con = DBCon.getCon();
String sql = "select * from depart_info";
PreparedStatement ps = con.prepareStatement(sql);
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
out.println(gson.toJson(diList));
%>    
