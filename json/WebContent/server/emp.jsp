<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
public class Emp {
	private String empNo;
	private String empName;
	private String empjob;
	private String empMgr;
	private String hireDate;
	private String sal;
	
	
	public Emp(String empNo, String empName, String empjob, String empMgr, String hireDate, String sal) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empjob = empjob;
		this.empMgr = empMgr;
		this.hireDate = hireDate;
		this.sal = sal;
	}


	public String getEmpNo() {
		return empNo;
	}


	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpjob() {
		return empjob;
	}


	public void setEmpjob(String empjob) {
		this.empjob = empjob;
	}


	public String getEmpMgr() {
		return empMgr;
	}


	public void setEmpMgr(String empMgr) {
		this.empMgr = empMgr;
	}


	public String getHireDate() {
		return hireDate;
	}


	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}


	public String getSal() {
		return sal;
	}


	public void setSal(String sal) {
		this.sal = sal;
	}


	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empName=" + empName + ", empjob=" + empjob + ", empMgr=" + empMgr
				+ ", hireDate=" + hireDate + ", sal=" + sal + "]";
	}
	
	
	
}
%>
<%
String param = request.getParameter("param");
Gson gson = new Gson();
Emp emp = gson.fromJson(param, Emp.class);
out.println(emp);
%>