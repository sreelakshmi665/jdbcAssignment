package com.mindtree.onlineHotelBooking.service;

import java.util.Set;

import com.mindtree.onlineHotelBooking.entity.HotelEntity;
import com.mindtree.onlineHotelBooking.entity.RoomEntity;

public interface ServiceInterface {

	Set<HotelEntity> createHotel(Set<HotelEntity> set) throws Exception;

	Set<HotelEntity> createRoomAndAssignToHotel(Set<HotelEntity> set) throws Exception;

	void displayAllHotelInformationBasedOnCity(Set<HotelEntity> set) throws Exception;

}
