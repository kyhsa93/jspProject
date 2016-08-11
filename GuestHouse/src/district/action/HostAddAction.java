package district.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import district.DAO.DistrictDAO;
import district.DTO.DistrictDTO;
import pageMoveAction.PageMoveAction;

public class HostAddAction implements Action {

	@Override
	public PageMoveAction execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		//1.요청파라미터 처리
		HttpSession session = request.getSession();
		String hostId = (String)session.getAttribute("id");
		String hostingTitle = request.getParameter("hostingTitle");
		String hostName = request.getParameter("hostName");
		String hostPhone = request.getParameter("hostPhone");
		String villageName = request.getParameter("villageName");
		String houseAddress = request.getParameter("houseAddress");
		String bankAccount = request.getParameter("bankAccount");
		String introduction = request.getParameter("introduction");
		
		//2.DB사용
		DistrictDAO dao = new DistrictDAO();
		DistrictDTO dto = new DistrictDTO();
		dto.setHostId(hostId);
		dto.setHostingTitle(hostingTitle);
		dto.setHostName(hostName);
		dto.setHostPhone(hostPhone);
		dto.setVillageName(villageName);
		dto.setHouseAddress(houseAddress);
		dto.setBankAccount(bankAccount);
		dto.setIntroduction(introduction);
		
		//3.페이지 이동 처리
		PageMoveAction pageMoveAction = new PageMoveAction();

		if(dao.addHost(dto) == 1){
			pageMoveAction.setPageName("index.jsp");
			pageMoveAction.setRedirect(true);
		}else{
			pageMoveAction.setPageName("error.jsp");
			pageMoveAction.setRedirect(true);
		}
		return pageMoveAction;
	}

}
