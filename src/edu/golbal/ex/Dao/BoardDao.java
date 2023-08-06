package edu.golbal.ex.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.golbal.ex.dto.BoardDto;


public class BoardDao {
	//DAO = 데이터베이스와의 상호작용을 담당하는 계층 , 데이터베이스와의 CRUD(Create, Read, Update, Delete) 작업을 처리
	//      데이터베이스 연결, 쿼리 실행, 결과 처리 등과 관련된 로직을 포함
	
	 private DataSource datasource = null;

	   public BoardDao() {
	      try {
	         Context context = new InitialContext();
	         datasource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");

	      } catch (Exception e) {
	         // TODO: handle exception
	         e.printStackTrace();
	      }
	   }

	   
	   public List<BoardDto> list() {

	      ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();

	      Connection con = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;

	      try {
	         String query = "select * from member_tbl_02 ORDER BY custno"; // (가지고 오고자하는 쿼리문을 넣어준다)

	         con = datasource.getConnection();
	         stmt = con.prepareStatement(query);
	         rs = stmt.executeQuery();

	         // 반복문을 사용해서 ArrayList에 가져온 데이터를 집어넣는다.
	         while (rs.next()) {
	        	 BoardDto dto = new BoardDto();
	        	 
	        	 dto.setCustno(rs.getInt("custno"));
	        	 dto.setCustname(rs.getString("custname"));
	        	 dto.setPhone(rs.getString("phone"));
	        	 dto.setAddress(rs.getString("address"));
	        	 dto.setJoindate(rs.getTimestamp("joindate"));
	        	 dto.setGrade(rs.getString("grade"));
	        	 dto.setCity(rs.getString("city"));

	            dtos.add(dto);

	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         // ※제일 나중에 연거를 먼저 닫아줘야한다. Connection, Statement, ResultSet순서로
	         // 열었으므로 거꾸로 닫아준다.
	         try {
	            if (rs != null)
	               rs.close();
	            if (stmt != null)
	               stmt.close();
	            if (con != null)
	               con.close();

	         } catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }

	      return dtos;

	   }

	public void write(String custname, String phone, String address,String joindate,String grade,String city) {
		 Connection con = null;
		    PreparedStatement stmt = null;
		    ResultSet rs = null;

		    try {
		        String getMaxCustNoQuery = "SELECT MAX(custno) FROM member_tbl_02";
		        
		        con = datasource.getConnection();
		        stmt = con.prepareStatement(getMaxCustNoQuery);
		        rs = stmt.executeQuery();
		        
		        int maxCustNo = 100007;
		        if(rs.next()){
		            maxCustNo = rs.getInt("MAX(custno)");
		        }
		        
		        int newCustNo = maxCustNo + 1;

		        String insertQuery = "INSERT INTO member_tbl_02 " +
		                            "(custNo, custname, phone, address, joindate, grade, city) " +
		                            "VALUES (?, ?, ?, ?, ?, ?, ?)";

		        stmt = con.prepareStatement(insertQuery);

		        stmt.setInt(1, newCustNo);
		        stmt.setString(2, custname);
		        stmt.setString(3, phone);
		        stmt.setString(4, address);
		        stmt.setString(5, joindate);
		        stmt.setString(6, grade);
		        stmt.setString(7, city);

		        int rn = stmt.executeUpdate();
		        System.out.println("Insert한 갯수: " + rn);

		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (rs != null)
		                rs.close();
		            if (stmt != null)
		                stmt.close();
		            if (con != null)
		                con.close();
		        } catch (Exception e2) {
		            e2.printStackTrace();
		        }
	      }
	   }

	public void insert(BoardDto dto) {
	    Connection con = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        String getMaxCustNoQuery = "SELECT MAX(custno) FROM member_tbl_02";
	        
	        con = datasource.getConnection();
	        stmt = con.prepareStatement(getMaxCustNoQuery);
	        rs = stmt.executeQuery();
	        
	        int maxCustNo = 100007;
	        if (rs.next()) {
	            maxCustNo = rs.getInt(1);
	        }
	        
	       
	        int newCustNo = maxCustNo + 1;

	        String insertQuery = "INSERT INTO member_tbl_02 " +
	                            "(custNo, custName, custTel, custAdress, custRegiDate, custGrade, city) " +
	                            "VALUES (?, ?, ?, ?, ?, ?, ?)";

	        stmt = con.prepareStatement(insertQuery);

	        stmt.setInt(1, newCustNo);
	        stmt.setString(2, dto.getCustname());
	        stmt.setString(3, dto.getPhone());
	        stmt.setString(4, dto.getAddress());
	        stmt.setTimestamp(5, new Timestamp(dto.getJoindate().getTime()));
	        stmt.setString(6, dto.getGrade());
	        stmt.setString(7, dto.getCity());

	        int rn = stmt.executeUpdate();
	        System.out.println("Insert한 갯수: " + rn);

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null)
	                rs.close();
	            if (stmt != null)
	                stmt.close();
	            if (con != null)
	                con.close();
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	}
}	