package com.mindtree.onlineHotelBooking.entity;

import java.util.HashSet;
import java.util.Set;

public class HotelEntity {
private int hotelId;
private String hotelName;
private String city;
Set<RoomEntity> room=new HashSet<RoomEntity>();
public int getHotelId() {
	return hotelId;
}
public void setHotelId(int hotelId) {
	this.hotelId = hotelId;
}
public String getHotelName() {
	return hotelName;
}
public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

public Set<RoomEntity> getRoom() {
	return room;
}
public void setRoom(Set<RoomEntity> room) {
	this.room = room;
}
public HotelEntity() {
	super();
}
public HotelEntity(int hotelId, String hotelName, String city) {
	super();
	this.hotelId = hotelId;
	this.hotelName = hotelName;
	this.city = city;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + hotelId;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	HotelEntity other = (HotelEntity) obj;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (hotelId != other.hotelId)
		return false;
	return true;
}
@Override
public String toString() {
	return "HotelEntity [hotelId=" + hotelId + ", hotelName=" + hotelName + ", city=" + city + "]";
}

}
