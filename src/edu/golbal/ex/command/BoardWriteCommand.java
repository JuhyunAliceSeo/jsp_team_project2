package edu.golbal.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.golbal.ex.Dao.BoardDao;

public class BoardWriteCommand implements BoardCommand {
	   
	   @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) {
	   
	      System.out.println("BwriteCommand entry.."); //디버깅을 위한 코드
	      
	      int custNum = Integer.valueOf(request.getParameter("custNum")); 
	      
	      String custName = request.getParameter("custName"); 
	      String custTel = request.getParameter("custTel"); 
	      String custAdress = request.getParameter("custAdress");
	      String custRegiDate = request.getParameter("custRegiDate");
	      String custGrade = request.getParameter("custGrade");
	      String cityCode = request.getParameter("cityCode");
	     
	                  
	      BoardDao boardDao = new BoardDao();
	           
	      boardDao.write(custNum,custName,custTel,custAdress,custRegiDate,custGrade,cityCode);
//	       
	   }
	}
