package com.example.sakuban;

public class WorkLogDate {

	private int year;
	private int month;
	private int day;
	private Integer hour;
	private Integer min;
	private String crlf = System.getProperty("line.separator");

	public int getYear() {
		return year;
	}
	public void setYear(int i) {
		this.year = i;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int i) {
		this.day = i;
	}
	public Integer getMin() {
		return min;
	}
	public void setMin(Integer integer) {
		this.min = integer;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer integer) {
		this.hour = integer;
	}

	public String printLog(){
		String log = year + "/" +
					 month + "/" +
					 day + "-" +
					 hour + ":" +
					 min + crlf;
		return log;
	}
}
