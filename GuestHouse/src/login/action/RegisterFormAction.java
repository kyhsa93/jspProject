package login.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import pageMoveAction.PageMoveAction;

public class RegisterFormAction implements Action {

	@Override
	public PageMoveAction execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		//1.요청 파라미터 처리
		//2.DB사용
		//3.페이지 이동 처리
		PageMoveAction pageMoveAction = new PageMoveAction();
		pageMoveAction.setPageName("registerForm.jsp");
		pageMoveAction.setRedirect(false);
		return pageMoveAction;
	}

}
