package login.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import login.action.HomeAction;
import login.action.LoginAction;
import login.action.LoginFormAction;
import login.action.LogoutAction;
import login.action.MemberDeleteAction;
import login.action.MemberListAction;
import login.action.MemberUpdateAction;
import login.action.MemberUpdateFormAction;
import login.action.MemberViewAction;
import login.action.RegisterAction;
import login.action.RegisterFormAction;
import pageMoveAction.PageMoveAction;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("*.login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("LoginController");
		//1.요청확인
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cmd = uri.substring(path.length(), uri.length());
		
		//2.uri분기
		Action action = null;
		PageMoveAction pageMoveAction= null;
		
		if(cmd.equals("/home.login")){
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
		}else if(cmd.equals("/loginForm.login")){
			action = new LoginFormAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/login.login")){
			action = new LoginAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/registerForm.login")){
			action = new RegisterFormAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/register.login")){
			action = new RegisterAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/logout.login")){
			action = new LogoutAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/memberList.login")){
			action = new MemberListAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/memberView.login")){
			action = new MemberViewAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/memberDelete.login")){
			action = new MemberDeleteAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/memberUpdateForm.login")){
			action = new MemberUpdateFormAction();
			try {
				pageMoveAction = action.execute(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/memberUpdate.login")){
			action = new MemberUpdateAction();
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
