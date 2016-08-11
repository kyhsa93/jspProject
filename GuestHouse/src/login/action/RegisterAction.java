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

public class RegisterAction implements Action {

	@Override
	public PageMoveAction execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		//1.요청 파라미터 처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("e-mail");
		String birthDate = request.getParameter("birthDate");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String competence = request.getParameter("competence");
		
		//2.DB사용
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setMemberName(name);
		dto.setPhoneNumber(phone);
		dto.setEmail(email);
		dto.setBirthDate(birthDate);
		dto.setGender(gender);
		dto.setAddr(address);
		dto.setCompetence(competence);
		
		//3.페이지 이동 처리
		PageMoveAction pageMoveAction = new PageMoveAction();

		if(dao.memberRegister(dto) == 1){
			pageMoveAction.setPageName("index.jsp");
			pageMoveAction.setRedirect(true);
		}else{
			pageMoveAction.setPageName("error.jsp");
			pageMoveAction.setRedirect(true);
		}
		return pageMoveAction;
	}

}
