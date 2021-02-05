package com.mindtree.onlineHotelBooking.daoLayer.DaoImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.onlineHotelBooking.daoLayer.DaoHotelBookingInterface;
import com.mindtree.onlineHotelBooking.entity.HotelEntity;
import com.mindtree.onlineHotelBooking.entity.RoomEntity;

import com.mindtree.onlineHotelBooking.exception.DaoExceptions.CityNotFoundException;
import com.mindtree.onlineHotelBooking.exception.DaoExceptions.DaoExceptions;
import com.mindtree.onlineHotelBooking.utility.DBUtill;

public class DaoHotelBookingImplementation implements DaoHotelBookingInterface{
static Scanner scan=new Scanner(System.in);
Connection con;

	
	
	@Override
	public void displayAllHotelDetails(Set<HotelEntity> set) throws Exception ,CityNotFoundException{
		// TODO Auto-generated method stub
		System.out.println("Enter the city");
		String city=scan.next();
		boolean check=true;
		
		con =DBUtill.getMyConnection();
		Statement st = con.createStatement();
		//String query = "select * from hotel where city=" + "'" + city + "'" ;
		String query="select *from hotel join room on hotel.hotelId=room.hotelId where city="+ "'" + city + "'" ;
		ResultSet rs = st.executeQuery(query);
		try {
		if(rs.next()!=false)
		{
			System.out.println(rs.getInt("hotelId")+" "+rs.getString("hotelName") + " " + rs.getString("city")+" "+rs.getInt("roomId")+" "+rs.getString("roomType")
			+" "+rs.getDouble("cost"));

		while (rs.next()) {
			//System.out.println(rs.getInt("hotelId") + " " + rs.getString("hotelName") + " " + rs.getString("city") );
			System.out.println(rs.getInt("hotelId")+" "+rs.getString("hotelName") + " " + rs.getString("city")+" "+rs.getInt("roomId")+" "+rs.getString("roomType")
			+" "+rs.getDouble("cost"));
		}
		
		}
		else
			throw new CityNotFoundException("No such City are there");
		}
	catch(CityNotFoundException e) {
		throw new CityNotFoundException("No such City are there");
	}
		DBUtill.closeResource(st);
		DBUtill.closeResource(con);
		}

	public void addHotelDetails(int hotelId, String hotelName, String city) throws Exception{
		// TODO Auto-generated method stub
		try {
			con = DBUtill.getMyConnection();
			Statement st = con.createStatement();
			String sree = "insert into hotel values(" + hotelId + "," + "'" + hotelName + "'" + "," + "'"
					+ city + "')";
			st.executeUpdate(sree);
			DBUtill.closeResource(st);
			DBUtill.closeResource(con);
			}catch(SQLException e) {throw new DaoExceptions("Duplicate Entry");}
	}
	public void addRoomDetails(int roomNumber, String roomType, double cost, int hotelId) throws Exception {
		// TODO Auto-generated method stub
		try {
			con = DBUtill.getMyConnection();
			Statement st = con.createStatement();
			String sree = "insert into room values(" + roomNumber + "," + "'" + roomType + "'" + ","  + cost+ ","+ hotelId+")";
			st.executeUpdate(sree);
			DBUtill.closeResource(st);
			DBUtill.closeResource(con);
			}catch(SQLException e) {throw new DaoExceptions("Duplicate Entry");}
			
	}
			
		
	}

	


