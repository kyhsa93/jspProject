package district.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		request.setCharacterEncoding("UTF-8");
		String filePath = request.getServletContext().getRealPath("upload");
		System.out.println(filePath);
		MultipartRequest multi = 
				new MultipartRequest(request, filePath, 1024*1024*100, 
						"UTF-8", new DefaultFileRenamePolicy());
		HttpSession session = request.getSession();
		String hostId = (String)session.getAttribute("id");
		String hostingTitle = multi.getParameter("hostingTitle");
		String hostName = multi.getParameter("hostName");
		String hostPhone = multi.getParameter("hostPhone");
		String villageName = multi.getParameter("villageName");
		String houseAddress = multi.getParameter("houseAddress");
		String bankAccount = multi.getParameter("bankAccount");
		String introduction = multi.getParameter("introduction");
		String fileName = multi.getFilesystemName("file");
		
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
		dto.setFileName(fileName);
		
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
