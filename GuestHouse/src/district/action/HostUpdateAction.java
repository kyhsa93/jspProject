package district.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import district.DAO.DistrictDAO;
import district.DTO.DistrictDTO;
import pageMoveAction.PageMoveAction;

public class HostUpdateAction implements Action {

	@Override
	public PageMoveAction execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HostUpdateAction");
		//1.요청 파라미터 처리
		String houseAddress = request.getParameter("houseAddress");
		String approve = request.getParameter("approve");
		System.out.println(houseAddress);
		//2.DB사용
		DistrictDAO dao = new DistrictDAO();
		DistrictDTO dto = new DistrictDTO();
		dto.setHouseAddress(houseAddress);
		dto.setApprove(approve);
		dao.hostUpdate(dto);
		//3.페이지 이동 처리
		PageMoveAction pageMoveAction = new PageMoveAction();
		if(dao.hostUpdate(dto)==1){
			dto = dao.hostView(houseAddress);
			request.setAttribute("dto", dto);
			pageMoveAction.setPageName("hostView.jsp");
			pageMoveAction.setRedirect(false);
		}else{
			pageMoveAction.setPageName("error.jsp");
			pageMoveAction.setRedirect(true);
		}
		return pageMoveAction;
	}

}
