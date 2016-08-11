package login.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import pageMoveAction.PageMoveAction;

public class LoginFormAction implements Action {

	@Override
	public PageMoveAction execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LoginFormAction");
		//1.요청 파라미터 처리
		//2.DB연동
		//3.페이지 이동 처리
		PageMoveAction pageMoveAction = new PageMoveAction();
		pageMoveAction.setPageName("loginForm.jsp");
		pageMoveAction.setRedirect(true);
		return pageMoveAction;		
	}

}
