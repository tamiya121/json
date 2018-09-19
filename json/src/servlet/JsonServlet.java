package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.DepartService;
import service.LevelService;
import service.MemberService;

class ErrMessage{
	private int errCode;
	
}
/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/json/*")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private DepartService ds = new DepartService();
	private LevelService ls = new LevelService();
    private MemberService ms = new MemberService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(cmd.equals("list")) {
			String json = gson.toJson(ds.getDepartInfoList());
			pw.print(json);
		}else if(cmd.equals("level")) {
			String json = gson.toJson(ls.getLevelInfoList());
			pw.print(json);
		}else if(cmd.equals("member")) {
			String json = gson.toJson(ms.getMemberInfoList());
			pw.print(json);	
		}else {
			response.setStatus(404);
			pw.print("너 주소 이상해");
			pw.flush();
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
