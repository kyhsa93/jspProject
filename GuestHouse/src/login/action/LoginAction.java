package login.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import login.DAO.LoginDAO;
import login.DTO.LoginDTO;
import pageMoveAction.PageMoveAction;

public class LoginAction implements Action {

	@Override
	public PageMoveAction execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LoginAction");
		//1.요청 파라미터 처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//2.DB사용
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		
		//3.페이지 이동 처리
		PageMoveAction pageMoveAction = new PageMoveAction();
		if(dao.memberLogin(dto)==true){
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			pageMoveAction.setPageName("index.jsp");
			pageMoveAction.setRedirect(false);
		}else{
			pageMoveAction.setPageName("error.jsp");
			pageMoveAction.setRedirect(true);
		}
		
		return pageMoveAction;
	}

}
