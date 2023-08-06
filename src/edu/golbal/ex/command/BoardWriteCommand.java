package edu.golbal.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.golbal.ex.Dao.BoardDao;

public class BoardWriteCommand implements BoardCommand {
	//회원정보를 입력하는 가능을 담당하는 클래스 
	//사용자가 입력한 회원종보를 받아와서 BoardDao를 통해 데이터베이스에 새로운 회원정보를 추가하는 역활
	
	//정보를 추가하는 역활   
	   @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) {
	   
	      System.out.println("BwriteCommand entry.."); //디버깅을 위한 코드
	       
	      
	      String custName = request.getParameter("custName"); 
	      //request.getParameter("custName") = 웹에서 사용자가 웹 페이지의 폼을 통해 전송한 데이터를 받아오는 메서드. 
	      //폼을 제출하면 브라우저는 입력 필드의 내용을 서버로 전송하게 되어 request.getParameter을 통해 서버에서 이 값을 받아올수 잇음.
	      String custTel = request.getParameter("custTel"); 
	      String custAdress = request.getParameter("custAdress");
	      String custRegiDate = request.getParameter("custRegiDate");
	      String custGrade = request.getParameter("custGrade");
	      String cityCode = request.getParameter("cityCode");
	     
	                  
	      BoardDao boardDao = new BoardDao();
	           
	      boardDao.write(custName,custTel,custAdress,custRegiDate,custGrade,cityCode);
	      
	      //사용자로부터 입력받은 회원정보를 변수에 저장후 BoardDao객체 생성 -> BoardDao의 write메서드 호출하여 데이터 베이스에 회원정보 추가
	       
	   }
	}
