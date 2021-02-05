package com.mindtree.onlineHotelBooking.service.ServiceImplementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.onlineHotelBooking.daoLayer.DaoImplementation.DaoHotelBookingImplementation;
import com.mindtree.onlineHotelBooking.entity.HotelEntity;
import com.mindtree.onlineHotelBooking.entity.RoomEntity;

import com.mindtree.onlineHotelBooking.exception.DaoExceptions.CityNotFoundException;
import com.mindtree.onlineHotelBooking.exception.DaoExceptions.DaoExceptions;
import com.mindtree.onlineHotelBooking.exception.serviceExceptions.IdNotFoundException;
import com.mindtree.onlineHotelBooking.exception.serviceExceptions.ServiceException;
import com.mindtree.onlineHotelBooking.service.ServiceInterface;

public class HotelBookingService implements ServiceInterface {
	static Scanner scan=new Scanner(System.in);
	DaoHotelBookingImplementation dao=new DaoHotelBookingImplementation();
	@Override
	public Set<HotelEntity> createHotel(HotelEntity hotel) throws Exception {
		
		Set<HotelEntity> set=new HashSet<HotelEntity>();
		HotelEntity emp = new HotelEntity(hotel.getHotelId(),hotel.getHotelName(),hotel.getCity());
		set.add(emp);
		
		try {
		dao.addHotelDetails(hotel.getHotelId(),hotel.getHotelName(),hotel.getCity());
		}
		catch(DaoExceptions e)
		{
		throw new DaoExceptions("Duplicate Entry");	
		}
		
		return set;
	}

	
	@Override
	public void displayAllHotelInformationBasedOnCity(Set<HotelEntity> set) throws Exception ,ServiceException{
		// TODO Auto-generated method stub
		try {
		dao.displayAllHotelDetails(set);
		}
		catch(CityNotFoundException e)
		{
			throw new ServiceException("No such City are there");
		}
	}

	@Override
	public Set<HotelEntity> createRoomAndAssignToHotel(RoomEntity value, Set<HotelEntity> set) throws Exception {
		
		System.out.println("Enter hotelId");
		int hotelId=scan.nextInt();
		boolean verify=false;
		
		
			for(HotelEntity hotel:set)
			{
				if(hotel.getHotelId()==hotelId)
				{
					verify=true;
					hotel.getRoom().add(new RoomEntity(value.getRoomNumber(),value.getRoomType(),value.getCost()));
					dao.addRoomDetails(value.getRoomNumber(),value.getRoomType(),value.getCost(),hotelId);
				}
			}
			try {
				
				if(!verify)
					throw new IdNotFoundException("Hotel not found");
			}
			catch(IdNotFoundException e)
			{
				throw new IdNotFoundException("Hotel not found");
			}
		return set;
	}
	
}
