package com.mindtree.onlineHotelBooking.daoLayer;

import java.util.Set;

import com.mindtree.onlineHotelBooking.entity.HotelEntity;
import com.mindtree.onlineHotelBooking.entity.RoomEntity;
import com.mindtree.onlineHotelBooking.exception.DaoExceptions.CityNotFoundException;

public interface DaoHotelBookingInterface {

	void addHotelDetails(int hotelId,String hotelName,String city) throws Exception,CityNotFoundException;

	void addRoomDetails(int roomNumber,String roomType,double cost,int hotelId) throws Exception;

	void displayAllHotelDetails(Set<HotelEntity> set) throws Exception;

}
