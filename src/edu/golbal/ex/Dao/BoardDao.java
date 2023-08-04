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

	   /*
	    * 리턴타입이 BDto인 이유 : 글목록을 다 표시하려면 ArrayList를 써줘야하지만, 글하나의 내용만 표시하려면 테이블의 한 행만
	    * 가져오면 되므로 BDto로 타입을 지정하였다.
	    * 
	    * 파라미터가 String bid만 있는 이유 : list.jsp에서 contentView.do로 넘어갈때 참조태그에 ${dto.bid}가
	    * 넘어가므로 bid를 받아줘야한다.
	    */

	   
	   public List<BoardDto> list() {

	      ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();

	      Connection con = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;

	      try {
	         String query = "select * from member_tbl_02"; // (가지고 오고자하는 쿼리문을 넣어준다)

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

	public void write(int custno, String custname, String phone, String address,String joindate,String grade,String city) {
		System.out.println("write()...");
	      Connection con = null;
	      PreparedStatement stmt = null;

	      // 이때 ?,?,? 물음표는 아래에서 setString메소드로 넣어줄 값을 표현하는 것
	      
	      try {
	         String query = "insert into member_tbl_02 " + "(custno, custname, phone, address, joindate, grade, city)"
	               + "VALUES (?, ?, ?, ?, ?, ?, ?)";

	         con = datasource.getConnection();
	         stmt = con.prepareStatement(query);

	         stmt.setInt(1, custno);
	         stmt.setString(2, custname);
	         stmt.setString(3, phone);
	         stmt.setString(4, address);
	         stmt.setString(5, joindate);
	         stmt.setString(6, grade);
	         stmt.setString(7, city);

	         int rn = stmt.executeUpdate();

	         System.out.println("write 한 갯수" + rn);

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         // ※제일 나중에 연거를 먼저 닫아줘야한다. Connection, Statement, ResultSet순서로
	         // 열었으므로 거꾸로 닫아준다.
	         try {
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

	    try {
	        String query = "INSERT INTO member_tbl_02 " +
	                       "(custNum, custName, custTel, custAdress, custRegiDate, custGrade, cityCode) " +
	                       "VALUES (member_tbl_02_seq.nextval, ?, ?, ?, ?, ?, ?)";

	        con = datasource.getConnection();
	        stmt = con.prepareStatement(query);

	        stmt.setString(1, dto.getCustname());
	        stmt.setString(2, dto.getPhone());
	        stmt.setString(3, dto.getAddress());
	        stmt.setTimestamp(4, new Timestamp(dto.getJoindate().getTime()));
	        stmt.setString(5, dto.getGrade());
	        stmt.setString(6, dto.getCity());

	        int rn = stmt.executeUpdate();
	        System.out.println("Insert한 갯수: " + rn);

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
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