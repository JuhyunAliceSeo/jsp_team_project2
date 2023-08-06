package edu.golbal.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardCommand {
	//Command = 컨트롤러(Controller)와 비즈니스 로직 사이의 중재자 역할을 수행하는 패턴
	//사용자 요청에 따라 적절한 비즈니스 로직을 실행하고, 그 결과를 컨트롤러에 반환
	//컨트롤러의 역할을 단순화하고, 재사용 가능한 로직을 분리하여 관리
	// 비즈니스 로직?  컴퓨터 프로그램 안에서 실제 일하는 부분. 사용자의 요구 사항을 처리하고, 데이터를 다루며, 규칙을 적용하여 원하는 결과를 만들어낸다. 
    //  예를 들어 새로운 사용자가 회원가입을 하면 그 정보를 데이터 베이스에 저장하고 필요한 검사를 수행하는것이 비지니스 로직
	 
	public void execute(HttpServletRequest request, HttpServletResponse response);
	// 인터페이스에서 정의한 메서드 시그니처입니다. 이 메서드는 주로 커맨드 디자인 패턴을 구현할 때 사용되며, 다양한 작업을 처리하기 위한 명령을 담고 있는 클래스들이 이 메서드를 구현하게된다.
	// HttpServletRequest = 웹브라우저에서 서버로 전송된 요청정보를 담고있는 객체 , 사용자의 요청정보를 읽어오는 메서드 제공
	// HttpServletRequest = 응답정보를 담고잇는 객체로 클라이언트에게 데이터를 전송하거나 리다이렉트하는 메서드 제공

}
