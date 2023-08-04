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
