package com.mindtree.onlineHotelBooking.service;

import java.util.Set;

import com.mindtree.onlineHotelBooking.entity.HotelEntity;
import com.mindtree.onlineHotelBooking.entity.RoomEntity;
import com.mindtree.onlineHotelBooking.exception.serviceExceptions.ServiceException;

public interface ServiceInterface {

	

	Set<HotelEntity> createRoomAndAssignToHotel(RoomEntity value, Set<HotelEntity> set) throws Exception;

	void displayAllHotelInformationBasedOnCity(Set<HotelEntity> set) throws Exception, ServiceException;

	Set<HotelEntity> createHotel(HotelEntity hotel) throws Exception;

}
