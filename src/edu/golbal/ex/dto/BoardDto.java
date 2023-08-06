package edu.golbal.ex.dto;

import java.sql.Timestamp;

//이름       널?       유형           
//-------- -------- ------------ 
//CUSTNO   NOT NULL NUMBER(6)    
//CUSTNAME          VARCHAR2(20) 
//PHONE             VARCHAR2(13) 
//ADDRESS           VARCHAR2(60) 
//JOINDATE          DATE         
//GRADE             CHAR(1)      
//CITY              CHAR(2) 

//Dto
// 데이터를 전송하기 위한 객체 
// 주로 비즈니스 로직과 사용자 인터페이스 간의 데이터 전달에 사용
// 데이터베이스에서 조회한 데이터를 객체로 변환하거나, 웹 페이지에서 사용자 입력을 객체로 전달하는 등의 용도로 사용

// 비즈니스 로직?  컴퓨터 프로그램 안에서 실제 일하는 부분. 사용자의 요구 사항을 처리하고, 데이터를 다루며, 규칙을 적용하여 원하는 결과를 만들어낸다. 
//             예를 들어 새로운 사용자가 회원가입을 하면 그 정보를 데이터 베이스에 저장하고 필요한 검사를 수행하는것이 비지니스 로직


public class BoardDto {
	
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private Timestamp joindate;
	private String grade;
	private String city;
	private int price;
	
	
	public BoardDto() {
	}
	public BoardDto(int custno, String custname, String phone, String address, Timestamp joindate, String grade, String city, int price) {
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
		this.price = price;
	}
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getJoindate() {
		return joindate;
	}
	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
