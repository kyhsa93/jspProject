package login.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import login.DAO.LoginDAO;
import pageMoveAction.PageMoveAction;

public class MemberDeleteAction implements Action {

	@Override
	public PageMoveAction execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		//1.요청 파라미터 처리
		String id = request.getParameter("id");
		//2.DB사용
		LoginDAO dao = new LoginDAO();
		//3.페이지 이동 처리
		PageMoveAction pageMoveAction = new PageMoveAction();
		if(dao.memberDelete(id)==1){
			pageMoveAction.setPageName("memberList.login");
			pageMoveAction.setRedirect(false);
		}else{
			pageMoveAction.setPageName("error.jsp");
			pageMoveAction.setRedirect(true);
		}
		
		return pageMoveAction;
	}

}
