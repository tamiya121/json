package vo;

public class DepartInfo {
	private Integer diNum;
	private String diCode;
	private String diName;
	private String diDesc;
	
	public DepartInfo() {
		
	}
	public DepartInfo(Integer diNum, String diCode, String diName, String diDesc) {
		super();
		this.diNum = diNum;
		this.diCode = diCode;
		this.diName = diName;
		this.diDesc = diDesc;
	}


	public Integer getDiNum() {
		return diNum;
	}


	public void setDiNum(Integer diNum) {
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
