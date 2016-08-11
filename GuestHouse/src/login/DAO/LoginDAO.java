package login.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import district.DTO.DistrictDTO;
import login.DTO.LoginDTO;

public class LoginDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	
	public LoginDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean memberLogin(LoginDTO dto){
		boolean login = false;
		String sql = "select pwd from memberTable where id=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(dto.getPwd().equals(rs.getString("pwd"))){
					login = true;
				}else{
					login = false;
				}
			}else{
				login = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return login;
	}
	
	public int memberRegister(LoginDTO dto){
		int result = 0;
		String sql = "insert into memberTable values(?, ?, ?, ?, ?, ?, ?, ? , sysdate, ?, '미승인')";
		
		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getMemberName());
			pstmt.setString(4, dto.getPhoneNumber());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getBirthDate());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getAddr());
			pstmt.setString(9, dto.getCompetence());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public List<LoginDTO> memberList() {
		// TODO Auto-generated method stub
		List<LoginDTO> memberList = new ArrayList<LoginDTO>();
		
		String sql = "select * from memberTable order by id asc";
		
		try {
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				LoginDTO dto = new LoginDTO();
				dto.setId(rs.getString("id"));
				dto.setCompetence(rs.getString("competence"));
				memberList.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberList;
	}
	public LoginDTO memberView(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from memberTable where id=?";
		LoginDTO dto = new LoginDTO();
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				dto.setId(id);
				dto.setPwd(rs.getString("pwd"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setGender(rs.getString("gender"));
				dto.setBirthDate(rs.getString("birthDate"));
				dto.setPhoneNumber(rs.getString("phoneNumber"));
				dto.setEmail(rs.getString("email"));
				dto.setAddr(rs.getString("address"));
				dto.setRegisterDate(rs.getString("registerDate"));
				dto.setCompetence(rs.getString("competence"));
				dto.setApprove(rs.getString("approve"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
	public List<DistrictDTO> hostView(String id){
		String sql = "select * from districtTable where hostId=?";
		List<DistrictDTO> hostList = new ArrayList<DistrictDTO>();		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				DistrictDTO dto = new DistrictDTO();
				dto.setHostingTitle(rs.getString("hostingTitle"));
				dto.setHouseAddress(rs.getString("houseAddress"));
				hostList.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hostList;
	}
	public int memberDelete(String id){
		int result = 0;
		String sql = "delete memberTable where id=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int memberUpdate(LoginDTO dto,HttpServletRequest request, HttpServletResponse response){
		int result = 0;
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("id");
		System.out.println(dto.getPwd());
		try {
			if(loginId.equals("admin")){
				String sql = "update memberTable set pwd=?, phoneNumber=?, email=?, address=?, approve=? where id=?";
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, dto.getPwd());
				pstmt.setString(2, dto.getPhoneNumber());
				pstmt.setString(3, dto.getEmail());
				pstmt.setString(4, dto.getAddr());
				pstmt.setString(5, dto.getApprove());
				pstmt.setString(6, dto.getId());
				result = pstmt.executeUpdate();
			}else{
				String sql = "update memberTable set pwd=?, phoneNumber=?, email=?, address=? where id=?";
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, dto.getPwd());
				pstmt.setString(2, dto.getPhoneNumber());
				pstmt.setString(3, dto.getEmail());
				pstmt.setString(4, dto.getAddr());
				pstmt.setString(5, dto.getId());
				result = pstmt.executeUpdate();
				System.out.println(dto.getPwd());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
