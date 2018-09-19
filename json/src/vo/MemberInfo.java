package vo;

public class MemberInfo {
	private Integer miNum;
	private String miId;
	private String miName;
	private String miPwd;
	private String diCode;
	private Integer liLevel;
	private String miEmal;
	private String miDesc;
	private String miPhone;
	private String miZipCode;
	private String miAddress1;
	private String miAddress2;
	
	public MemberInfo() {
		
	}

	public MemberInfo(Integer miNum, String miId, String miName, String miPwd, String diCode, Integer liLevel,
			String miEmal, String miDesc, String miPhone, String miZipCode, String miAddress1, String miAddress2) {
		super();
		this.miNum = miNum;
		this.miId = miId;
		this.miName = miName;
		this.miPwd = miPwd;
		this.diCode = diCode;
		this.liLevel = liLevel;
		this.miEmal = miEmal;
		this.miDesc = miDesc;
		this.miPhone = miPhone;
		this.miZipCode = miZipCode;
		this.miAddress1 = miAddress1;
		this.miAddress2 = miAddress2;
	}

	public Integer getMiNum() {
		return miNum;
	}

	public void setMiNum(Integer miNum) {
		this.miNum = miNum;
	}

	public String getMiId() {
		return miId;
	}

	public void setMiId(String miId) {
		this.miId = miId;
	}

	public String getMiName() {
		return miName;
	}

	public void setMiName(String miName) {
		this.miName = miName;
	}

	public String getMiPwd() {
		return miPwd;
	}

	public void setMiPwd(String miPwd) {
		this.miPwd = miPwd;
	}

	public String getDiCode() {
		return diCode;
	}

	public void setDiCode(String diCode) {
		this.diCode = diCode;
	}

	public Integer getLiLevel() {
		return liLevel;
	}

	public void setLiLevel(Integer liLevel) {
		this.liLevel = liLevel;
	}

	public String getMiEmal() {
		return miEmal;
	}

	public void setMiEmal(String miEmal) {
		this.miEmal = miEmal;
	}

	public String getMiDesc() {
		return miDesc;
	}

	public void setMiDesc(String miDesc) {
		this.miDesc = miDesc;
	}

	public String getMiPhone() {
		return miPhone;
	}

	public void setMiPhone(String miPhone) {
		this.miPhone = miPhone;
	}

	public String getMiZipCode() {
		return miZipCode;
	}

	public void setMiZipCode(String miZipCode) {
		this.miZipCode = miZipCode;
	}

	public String getMiAddress1() {
		return miAddress1;
	}

	public void setMiAddress1(String miAddress1) {
		this.miAddress1 = miAddress1;
	}

	public String getMiAddress2() {
		return miAddress2;
	}

	public void setMiAddress2(String miAddress2) {
		this.miAddress2 = miAddress2;
	}

	@Override
	public String toString() {
		return "MemberInfo [miNum=" + miNum + ", miId=" + miId + ", miName=" + miName + ", miPwd=" + miPwd + ", diCode="
				+ diCode + ", liLevel=" + liLevel + ", miEmal=" + miEmal + ", miDesc=" + miDesc + ", miPhone=" + miPhone
				+ ", miZipCode=" + miZipCode + ", miAddress1=" + miAddress1 + ", miAddress2=" + miAddress2 + "]";
	}
	
	
}
