package login.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import login.DAO.LoginDAO;
import login.DTO.LoginDTO;
import pageMoveAction.PageMoveAction;

public class MemberUpdateFormAction implements Action {

	@Override
	public PageMoveAction execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("memberUpdateFormAction");
		//1.요청 파라미터 처리
		String id = request.getParameter("id");
		//2.DB사용
		LoginDAO dao = new LoginDAO();		
		LoginDTO dto = dao.memberView(id);
		request.setAttribute("dto", dto);
		//3.페이지 이동 처리
		PageMoveAction pageMoveAction = new PageMoveAction();
		pageMoveAction.setPageName("memberUpdateForm.jsp");
		pageMoveAction.setRedirect(false);
		return pageMoveAction;
	}

}
