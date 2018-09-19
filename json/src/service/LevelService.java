package service;

import java.util.List;

import dao.LevelDAO;
import vo.LevelInfo;

public class LevelService {
	private LevelDAO ldao = new LevelDAO();
	
	public List<LevelInfo> getLevelInfoList(){
		return ldao.selectLevelInfoList();
	}

}
