package district.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import district.DAO.DistrictDAO;
import district.DTO.DistrictDTO;
import login.DTO.LoginDTO;
import pageMoveAction.PageMoveAction;

public class HostListAction implements Action {

	@Override
	public PageMoveAction execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hostListAction");
		//1.요청 파라미터 처리
		String villageName = request.getParameter("villageName");
		//2.DB사용
		DistrictDAO dao = new DistrictDAO();
		List<DistrictDTO> hostList = dao.hostList(villageName);
		request.setAttribute("hostList", hostList);
		
		//3.페이지 이동 처리
		PageMoveAction pageMoveAction = new PageMoveAction();
		pageMoveAction.setPageName("hostList.jsp");
		pageMoveAction.setRedirect(false);
		
		return pageMoveAction;
	}

}
