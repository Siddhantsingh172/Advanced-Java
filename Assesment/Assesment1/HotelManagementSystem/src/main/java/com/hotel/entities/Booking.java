package com.hotel.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "booking_details")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(nullable = false)
    private String customerName;

    private String roomType;
    private String checkInDate;
    private String checkOutDate;

    private double totalAmount;

    public Booking() {}

    public Booking(String customerName, String roomType,
                   String checkInDate, String checkOutDate) {

        this.customerName = customerName;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;

        calculateTotalAmount();
    }

    public void calculateTotalAmount() {

        int pricePerDay = 0;

        if(roomType.equals("Standard"))
            pricePerDay = 2000;
        else if(roomType.equals("Deluxe"))
            pricePerDay = 3500;
        else if(roomType.equals("Suite"))
            pricePerDay = 5000;
        else
            throw new IllegalArgumentException("Invalid Room Type");

        LocalDate in = LocalDate.parse(checkInDate);
        LocalDate out = LocalDate.parse(checkOutDate);

        long days = ChronoUnit.DAYS.between(in, out);

        totalAmount = days * pricePerDay;
    }

    // Getters & Setters

    public int getBookingId() { 
    	return bookingId; 
    	}

    public String getCustomerName() { 
    	return customerName; 
    	}
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCheckInDate() { 
    	return checkInDate; 
    	}
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() { 
    	return checkOutDate; 
    	}
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalAmount() { 
    	return totalAmount; 
    	}

    @Override
    public String toString() {
        return bookingId + " | " + customerName + " | " +
                roomType + " | Total: " + totalAmount;
    }
}
