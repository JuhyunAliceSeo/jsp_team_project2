package edu.golbal.ex.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.golbal.ex.Dao.BoardDao;
import edu.golbal.ex.Dao.BoardDao_Sales;
import edu.golbal.ex.dto.BoardDto;



public class BoardListCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao_Sales boardDao = new BoardDao_Sales();
		
		List<BoardDto> dtos = boardDao.list();
		
		request.setAttribute("list", dtos);
	
	}

	

}
