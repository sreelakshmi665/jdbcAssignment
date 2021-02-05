package com.mindtree.onlineHotelBooking.client;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.onlineHotelBooking.entity.HotelEntity;
import com.mindtree.onlineHotelBooking.entity.RoomEntity;
import com.mindtree.onlineHotelBooking.exception.HotelBookingExceptions;
import com.mindtree.onlineHotelBooking.exception.serviceExceptions.IdNotFoundException;
import com.mindtree.onlineHotelBooking.exception.serviceExceptions.ServiceException;
import com.mindtree.onlineHotelBooking.service.ServiceInterface;
import com.mindtree.onlineHotelBooking.service.ServiceImplementation.HotelBookingService;

public class HotelBookingApp {
	
	static Scanner scan=new Scanner(System.in);
	static HotelEntity hotel=new HotelEntity();
	static RoomEntity value=new RoomEntity();
public static void main(String[] args) throws Exception {
	Set<HotelEntity> set=new HashSet<>();
	//ServiceInterface service=null;
	
	HotelBookingService service=new HotelBookingService();
	
	boolean check=true;
	do {
		System.out.println("Enter your choice:");
		System.out.println("1.Create Hotel\n2.Create room and assign to hotel\n3.Display all hotel information based on city\n4.Exit");
		int choice=scan.nextInt();
		switch(choice)
		{
		case 1:try{
			hotel=hotelDetails();
			set=service.createHotel(hotel);
			}
			catch(ServiceException e)
		{
				try {
					throw new HotelBookingExceptions("Duplicate Entry");
				}
				catch(HotelBookingExceptions exception)
				{
					System.out.println(exception.getMessage());
				}
		}
		
			break;
		case 2:try {
			value=roomDetails();
			set=service.createRoomAndAssignToHotel(value,set);
		}
		catch(IdNotFoundException e)
		{
			try {
				throw new HotelBookingExceptions("id is not found");
			}
			catch(HotelBookingExceptions exception)
			{
				System.out.println(exception.getMessage());
			}
		}
			break;
		case 3:try{
			service.displayAllHotelInformationBasedOnCity(set);
		}
		catch(ServiceException e)
		{
			try {
				throw new HotelBookingExceptions("No such City are there");
			}
			catch(HotelBookingExceptions exception)
			{
				System.out.println(exception.getMessage());
			}
			
		}
		
			break;
		case 4:check=false;
			break;
		}
	}while(check);
}
private static RoomEntity roomDetails() {
	int roomNumber;
	String roomType;
	double cost;
	System.out.println("Enter room number:");
	roomNumber = integerValidate();
	System.out.println("Enter room type:");
	roomType = validRoomType();
	System.out.println("Enter cost of the room");
	cost = doubleValidate();
	value=new RoomEntity(roomNumber,roomType,cost);
	return value;
}
private static HotelEntity hotelDetails() {
	int hotelId;
	String hotelName;
	String city;
	System.out.println("Enter hotel Id");
	hotelId = integerValidate();
	System.out.println("Enter hotel name:");
	hotelName = scan.next();
	System.out.println("Enter city");
	city = scan.next();
	hotel=new HotelEntity(hotelId,hotelName,city);
	return hotel;
}
public static int integerValidate() {
	int data = 0;
	boolean validate = false;
	while (validate == false) {
		if (scan.hasNextInt()) {
			data = scan.nextInt();
			validate = true;
		} else if (!scan.hasNextInt()) {
			System.out.println("Please Enter a Number in Integer!");
			scan.next();
		}
	}
	return data;
}
private static double doubleValidate() {
	double data = 0;
	boolean validate = false;
	while (validate == false) {
		if (scan.hasNextDouble()) {
			data = scan.nextDouble();
			validate = true;
		} else if (!scan.hasNextDouble()) {
			System.out.println("Please Enter a Number in Integer!");
			scan.next();
		}
	}
	return data;
}
private static String validRoomType() {
	boolean valid=true;
	String roomType="";
	while(valid)
	{
		roomType=scan.next();
		if(roomType.equalsIgnoreCase("Luxury") || roomType.equalsIgnoreCase("semiLuxury")||roomType.equalsIgnoreCase("deluxe"))
		{
			valid=false;
		}
		else
			System.out.println("Please enter proper role");
	}
	
	return roomType;
}


}
