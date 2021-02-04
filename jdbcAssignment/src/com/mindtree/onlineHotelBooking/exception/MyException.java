package com.mindtree.onlineHotelBooking.exception;

public class MyException extends Exception {
	String sentence;
	public MyException(String sentence)
	{
		this.sentence=sentence;
	}
	public String toString() {
		return sentence;
		
	}
}