package edu.golbal.ex.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.golbal.ex.Dao.BoardDao;
import edu.golbal.ex.dto.BoardDto;

public class ListCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardDao dao = new BoardDao();
		List<BoardDto> list = dao.list();
		
		request.setAttribute("list", list);
		
	}

}
