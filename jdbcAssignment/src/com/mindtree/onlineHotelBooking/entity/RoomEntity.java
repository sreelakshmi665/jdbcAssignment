package com.mindtree.onlineHotelBooking.entity;



public class RoomEntity {
private int roomNumber;
private String roomType;
private double cost;
//private int hotelId;

public int getRoomNumber() {
	return roomNumber;
}
public void setRoomNumber(int roomNumber) {
	this.roomNumber = roomNumber;
}
public String getRoomType() {
	return roomType;
}
public void setRoomType(String roomType) {
	this.roomType = roomType;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}

//public int getHotelId() {
//	return hotelId;
//}
//public void setHotelId(int hotelId) {
//	this.hotelId = hotelId;
//}
public RoomEntity() {
	super();
}
public RoomEntity(int roomNumber, String roomType, double cost) {
	super();
	this.roomNumber = roomNumber;
	this.roomType = roomType;
	this.cost = cost;
	//this.hotelId=hotelId;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + roomNumber;
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
	RoomEntity other = (RoomEntity) obj;
	if (roomNumber != other.roomNumber)
		return false;
	return true;
}
@Override
public String toString() {
	return "RoomEntity [roomNumber=" + roomNumber + ", roomType=" + roomType + ", cost=" + cost + 
			 "]";
}


}
