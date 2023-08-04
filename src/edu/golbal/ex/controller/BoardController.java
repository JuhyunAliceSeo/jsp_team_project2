package edu.golbal.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.golbal.ex.Dao.BoardDao;
import edu.golbal.ex.dto.BoardDto;
import edu.golbal.ex.command.BoardCommand;
import edu.golbal.ex.command.BoardListCommand;
import edu.golbal.ex.command.BoardWriteCommand;
import edu.golbal.ex.command.ListCommand;

@WebServlet("*.do") // .do로 들어오는 모든 것들은 다 웹서블렛에서 받아내겠다는 뜻
public class BoardController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public BoardController() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // doGet메소드를 탈시에 console에기록하기위해넣음(디버깅위해)
      System.out.println("doGet() ..");
      actionDo(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // doPost메소드를 탈시에 console에기록하기위해넣음(디버깅위해)
      System.out.println("doPost() ..");
      actionDo(request, response);
   }

   private void actionDo(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      System.out.println("actionDo() .."); // doGet으로 오든 doPost로 오든 action을 타도록 통일함
      request.setCharacterEncoding("UTF-8");

      String viewPage = null;
      BoardCommand command = null;

      // 위의 세 줄은 http://localhost:8282/jsp_board/list.do에서 list.do를 꺼내기 위한 코드들
      String uri = request.getRequestURI();
      String conPath = request.getContextPath();
      String com = uri.substring(conPath.length());
      
      System.out.println(com);
      
      if (com.equals("/listViewMember.do")) {
    	  command = new ListCommand();// BCommand인터페이스를 구현할 자손이므로 클래스생성해야함
         command.execute(request, response);
         // 해당request객체를 전달할 view결정
         viewPage = "listViewMember.jsp";
      } else if (com.equals("/regMember.do")) {
    	  command = new BoardListCommand();// BCommand인터페이스를 구현할 자손이므로 클래스생성해야함
          command.execute(request, response);
          // 해당request객체를 전달할 view결정
          viewPage = "regMember.jsp";
      }else if (com.equals("/salesView.do")) {
    	  command = new BoardListCommand();// BCommand인터페이스를 구현할 자손이므로 클래스생성해야함
          command.execute(request, response);
          // 해당request객체를 전달할 view결정
          viewPage = "salesView.jsp";
      }else if (com.equals("/write.do")) {
          command = new BoardWriteCommand();
          command.execute(request, response);
          
          viewPage = "listViewMember.do";
       }else if (com.equals("/insert.do")) {
           command = new BoardWriteCommand();
           command.execute(request, response);
           
           viewPage = "listViewMember.do";
        }
      /*
           클라이언트에게 list.do는 list.jsp로 forwarding을 시키겠다는 의미이다. forwarding은
           BListCommand클래스에게 메모리를 올린 request, response 객체 정보를 list.jsp에서는 사용가능하다는 의미이다.
           forwarding 될 떼까지 정보가 살아있기 때문이다. 고로 list.jsp에서 forEach 문을 사용하여 데이터를 꺼낼 수 있다.
       */

      RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
      dispatcher.forward(request, response); //뷰페이지에 리퀘,리스폰을 포워드시켜줌

   }
}