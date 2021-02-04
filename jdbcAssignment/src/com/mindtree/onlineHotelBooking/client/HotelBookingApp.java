package com.mindtree.onlineHotelBooking.client;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.onlineHotelBooking.entity.HotelEntity;
import com.mindtree.onlineHotelBooking.entity.RoomEntity;
import com.mindtree.onlineHotelBooking.service.ServiceInterface;
import com.mindtree.onlineHotelBooking.service.ServiceImplementation.HotelBookingService;

public class HotelBookingApp {
	
	static Scanner scan=new Scanner(System.in);
public static void main(String[] args) throws Exception {
	Set<HotelEntity> set=new HashSet<>();
	Set<RoomEntity> room=new HashSet<>();
	//ServiceInterface service=null;
	HotelBookingService service=new HotelBookingService();
	
	boolean check=true;
	do {
		System.out.println("Enter your choice:");
		System.out.println("1.Create Hotel\n2.Create room and assign to hotel\n3.Display all hotel information based on city\n4.Exit");
		int choice=scan.nextInt();
		switch(choice)
		{
		case 1:set=service.createHotel(set);
			break;
		case 2:
			set=service.createRoomAndAssignToHotel(set);
			break;
		case 3:service.displayAllHotelInformationBasedOnCity(set);
			break;
		case 4:check=false;
			break;
		}
	}while(check);
}

}
