package login.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import login.DAO.LoginDAO;
import login.DTO.LoginDTO;
import pageMoveAction.PageMoveAction;

public class MemberListAction implements Action {

	@Override
	public PageMoveAction execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("memberListAction");
		//1.요청 파라미터 처리
		//2.DB사용
		LoginDAO dao = new LoginDAO();
		List<LoginDTO> memberList = dao.memberList();
		request.setAttribute("memberList", memberList);
		
		//3.페이지 이동 처리
		PageMoveAction pageMoveAction = new PageMoveAction();
		pageMoveAction.setPageName("memberList.jsp");
		pageMoveAction.setRedirect(false);
		
		return pageMoveAction;
	}

}
