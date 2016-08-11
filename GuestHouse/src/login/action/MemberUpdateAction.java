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

public class MemberUpdateAction implements Action {

	@Override
	public PageMoveAction execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("memberUpdateAction");
		//1.요청파라미터 처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String email = request.getParameter("e-mail");
		String addr = request.getParameter("address");
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("id");
		System.out.println(pwd);
		//2.DB사용
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setPhoneNumber(phone);
		dto.setEmail(email);
		dto.setAddr(addr);
		if(loginId.equals("admin")){
			String approve = request.getParameter("approve");
			dto.setApprove(approve);
		}
		
		//3.페이지 이동 처리
		PageMoveAction pageMoveAction = new PageMoveAction();
		if(dao.memberUpdate(dto, request, response)==1){
			dto = dao.memberView(id);
			request.setAttribute("dto", dto);
			pageMoveAction.setPageName("memberView.jsp");
			pageMoveAction.setRedirect(false);
		}else{
			pageMoveAction.setPageName("error.jsp");
			pageMoveAction.setRedirect(true);
		}
		return pageMoveAction;
	}

}
