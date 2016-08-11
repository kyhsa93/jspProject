package district.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import district.DAO.DistrictDAO;
import district.DTO.DistrictDTO;
import pageMoveAction.PageMoveAction;

public class NoApproveHostListAction implements Action {

	@Override
	public PageMoveAction execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		//1.요청파라미터 처리
		//2.DB사용
		DistrictDAO dao = new DistrictDAO();
		List<DistrictDTO> noApproveHostList = dao.noApproveHostList();
		request.setAttribute("noApproveHostList", noApproveHostList);
		
		//3.페이지 이동 처리
		PageMoveAction pageMoveAction = new PageMoveAction();
		pageMoveAction.setPageName("noApproveHostList.jsp");
		pageMoveAction.setRedirect(false);
		
		return pageMoveAction;
	}

}
