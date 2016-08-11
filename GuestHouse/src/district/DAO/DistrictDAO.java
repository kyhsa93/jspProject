package district.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import district.DTO.DistrictDTO;

public class DistrictDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	
	public DistrictDAO(){
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

	public List<DistrictDTO> hostList(String villageName) {
		// TODO Auto-generated method stub
		List<DistrictDTO> hostList = new ArrayList<DistrictDTO>();
		if(villageName.equals("all")){
			String sql = "select * from districtTable";
			
			try {
				pstmt = connection.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					DistrictDTO dto = new DistrictDTO();
					dto.setApprove(rs.getString("approve"));
					dto.setHouseAddress(rs.getString("houseAddress"));
					dto.setHostingTitle(rs.getString("hostingTitle"));
					dto.setVillageName(rs.getString("villageName"));
					if(dto.getApprove().equals("승인"))
						hostList.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			String sql = "select * from districtTable where villageName=?";
			
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, villageName);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					DistrictDTO dto = new DistrictDTO();
					dto.setApprove(rs.getString("approve"));
					dto.setHouseAddress(rs.getString("houseAddress"));
					dto.setHostingTitle(rs.getString("hostingTitle"));
					dto.setVillageName(rs.getString("villageName"));
					if(dto.getApprove().equals("승인"))
						hostList.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return hostList;
	}

	public List<DistrictDTO> noApproveHostList() {
		// TODO Auto-generated method stub
		List<DistrictDTO> noApproveHostList = new ArrayList<DistrictDTO>();
		String sql = "select * from districtTable";
		try {
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				DistrictDTO dto = new DistrictDTO();
				dto.setApprove(rs.getString("approve"));
				dto.setHouseAddress(rs.getString("houseAddress"));
				dto.setHostingTitle(rs.getString("hostingTitle"));
				dto.setVillageName(rs.getString("villageName"));
				if(dto.getApprove().equals("미승인"))
					noApproveHostList.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noApproveHostList;
	}

	public int addHost(DistrictDTO dto) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "insert into districtTable values(?, ?, ?, ?, ?, ?, ?, ?, '미승인')";
		try {
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, dto.getHostingTitle());
			pstmt.setString(2, dto.getHostId());
			pstmt.setString(3, dto.getHostName());
			pstmt.setString(4, dto.getHostPhone());
			pstmt.setString(5, dto.getHouseAddress());
			pstmt.setString(6, dto.getVillageName());
			pstmt.setString(7, dto.getBankAccount());
			pstmt.setString(8, dto.getIntroduction());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int hostUpdate(DistrictDTO dto) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "update districtTable set approve=? where houseAddress=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, dto.getApprove());
			pstmt.setString(2, dto.getHouseAddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public DistrictDTO hostView(String houseAddress) {
		// TODO Auto-generated method stub
		DistrictDTO dto = new DistrictDTO();
		String sql = "select * from districtTable where houseAddress=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, houseAddress);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				dto.setApprove(rs.getString("approve"));
				dto.setBankAccount(rs.getString("bankAccount"));
				dto.setHostId(rs.getString("hostId"));
				dto.setHostingTitle(rs.getString("hostingTitle"));
				dto.setHostName(rs.getString("hostName"));
				dto.setHostPhone(rs.getString("hostPhone"));
				dto.setHouseAddress(rs.getString("houseAddress"));
				dto.setIntroduction(rs.getString("introduction"));
				dto.setVillageName(rs.getString("villageName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
}
