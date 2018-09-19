import java.util.List;

import dao.DepartDAO;
import vo.DepartInfo;

public class Test {
	private DepartDAO ddao = new DepartDAO();

	List<DepartInfo> getDepartInfoList() {
		return ddao.selectDepartInfoList();
	}
}