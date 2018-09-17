package vo;

public class TestInfo {
	private Long tiNum;
	private String tiId;
	private String tiName;
	private String tiText;
	
	
	public TestInfo(Long tiNum, String tiId, String tiName, String tiText) {
		super();
		this.tiNum = tiNum;
		this.tiId = tiId;
		this.tiName = tiName;
		this.tiText = tiText;
	}


	public Long getTiNum() {
		return tiNum;
	}


	public void setTiNum(Long tiNum) {
		this.tiNum = tiNum;
	}


	public String getTiId() {
		return tiId;
	}


	public void setTiId(String tiId) {
		this.tiId = tiId;
	}


	public String getTiName() {
		return tiName;
	}


	public void setTiName(String tiName) {
		this.tiName = tiName;
	}


	public String getTiText() {
		return tiText;
	}


	public void setTiText(String tiText) {
		this.tiText = tiText;
	}


	@Override
	public String toString() {
		return "TestInfo [tiNum=" + tiNum + ", tiId=" + tiId + ", tiName=" + tiName + ", tiText=" + tiText + "]";
	}
	
	
	
	
	
}
