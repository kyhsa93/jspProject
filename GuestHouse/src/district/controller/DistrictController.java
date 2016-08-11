package district.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import district.action.HostAddAction;
import district.action.HostAddFormAction;
import district.action.HostListAction;
import district.action.HostUpdateAction;
import district.action.HostUpdateFormAction;
import district.action.HostViewAction;
import district.action.NoApproveHostListAction;
import district.action.HostViewAction;
import login.action.HomeAction;
import pageMoveAction.PageMoveAction;

/**
 * Servlet implementation class DistrictController
 */
@WebServlet("*.district")
public class DistrictController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistrictController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("DistrictController");
		//1.요청확인
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cmd = uri.substring(path.length(), uri.length());
		
		//2.uri분기
		Action action = null;
		PageMoveAction pageMoveAction = null;
		if(cmd.equals("/home.district")){
			action = new HomeAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/hostList.district")){
			action = new HostListAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/hostView.district")){
			action = new HostViewAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/noApproveHostList.district")){
			action = new NoApproveHostListAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/addHost.district")){
			action = new HostAddAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/addHostForm.district")){
			action = new HostAddFormAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/hostUpdateForm.district")){
			action = new HostUpdateFormAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/hostUpdate.district")){
			action = new HostUpdateAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//3.페이지 이동
		if(pageMoveAction.isRedirect() == true){
			try {
				response.sendRedirect(pageMoveAction.getPageName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				request.getRequestDispatcher(pageMoveAction.getPageName()).forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
