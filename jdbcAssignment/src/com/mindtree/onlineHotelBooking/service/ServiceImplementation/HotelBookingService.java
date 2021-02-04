package com.mindtree.onlineHotelBooking.service.ServiceImplementation;

import java.util.Scanner;
import java.util.Set;

import com.mindtree.onlineHotelBooking.daoLayer.DaoImplementation.DaoHotelBookingImplementation;
import com.mindtree.onlineHotelBooking.entity.HotelEntity;
import com.mindtree.onlineHotelBooking.entity.RoomEntity;
import com.mindtree.onlineHotelBooking.exception.MyException;
import com.mindtree.onlineHotelBooking.service.ServiceInterface;

public class HotelBookingService implements ServiceInterface {
	static Scanner scan=new Scanner(System.in);
	DaoHotelBookingImplementation dao=new DaoHotelBookingImplementation();
	@Override
	public Set<HotelEntity> createHotel(Set<HotelEntity> set) throws Exception {
		int hotelId;
		String hotelName;
		String city;
		System.out.println("Enter hotel Id");
		hotelId = integerValidate();
		System.out.println("Enter hotel name:");
		hotelName = scan.next();
		System.out.println("Enter city");
		city = scan.next();
		HotelEntity emp = new HotelEntity(hotelId, hotelName, city);
		set.add(emp);
		System.out.println("added succesfully");
		dao.addHotelDetails(hotelId,hotelName,city);
		
		return set;
	}

	@Override
	public Set<HotelEntity> createRoomAndAssignToHotel(Set<HotelEntity> set) throws Exception {
		int roomNumber;
		String roomType;
		double cost;
		System.out.println("Enter room number:");
		roomNumber = integerValidate();
		System.out.println("Enter room type:");
		roomType = validRoomType();
		System.out.println("Enter cost of the room");
		cost = doubleValidate();
		System.out.println("Enter hotelId");
		int hotelId=scan.nextInt();
		boolean verify=false;
		
		
			for(HotelEntity hotel:set)
			{
				if(hotel.getHotelId()==hotelId)
				{
					verify=true;
					hotel.getRoom().add(new RoomEntity(roomNumber,roomType,cost));
					dao.addRoomDetails(roomNumber,roomType,cost,hotelId);
				}
			}
			try {
				
				if(!verify)
					throw new MyException("Hotel not found");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return set;
	}

	@Override
	public void displayAllHotelInformationBasedOnCity(Set<HotelEntity> set) throws Exception {
		// TODO Auto-generated method stub
		dao.displayAllHotelDetails(set);
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
	private double doubleValidate() {
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
	private String validRoomType() {
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
