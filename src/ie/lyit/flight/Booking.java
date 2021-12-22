package ie.lyit.flight;

import java.util.ArrayList;
import java.util.Scanner;

public class Booking {
	private Flight outbound;
	private Flight inbound;
	private ArrayList<Passenger> passengers; // list of passengers
	private double totalPrice;
	private int bookingNo;
	private static int nextBookingNumber = 1000; // static for unique booking number - starts at 1000

	// Default Constructor
	public Booking() {
		outbound = new Flight();
		inbound = new Flight();
		passengers = new ArrayList<Passenger>();
		totalPrice = 0;
		bookingNo = nextBookingNumber++; // increment the booking number

	}

//	There must be at least 1 Passenger, and a maximum of 9 Passengers per
//	Booking, and the outBound Flight cannot be null.
	public Booking(Flight oF, Flight iF, ArrayList<Passenger> p)throws ArrayIndexOutOfBoundsException, NullPointerException {
		if (p.isEmpty() || p.size() > 9) {
			throw new ArrayIndexOutOfBoundsException("More than 1 less than 9");
		}
		if (oF.getFlightNumber() == "") {
			throw new NullPointerException("There has to be an outbound flight");
		}
		outbound = oF;
		inbound = iF;
		passengers = p;
		totalPrice = calculatePrice();
		bookingNo = nextBookingNumber++;
	}

	@Override
	public String toString() {
		return "BOOKING # " + bookingNo

				+ "\nOUTBOUND FLIGHT " + outbound.getFlightNumber() + " from " + outbound.getSource() + " to "
				+ outbound.getDestination() + " " + outbound.getDate() + " @ " + outbound.getTime() + " hours"

				+ "\nINBOUND FLIGHT " + this.inbound.getFlightNumber() + " from " + inbound.getSource() + " to "
				+ inbound.getDestination() + " " + inbound.getDate() + " @ " + inbound.getTime() + " hours"

				+ "\nPASSENGERS" + passengers.toString() + "\nTOTAL PRICE €" + totalPrice;

	}
//	toString example	
//	"BOOKING # 1000
//	OUTBOUND FLIGHT 781DER from Derry to London Stanstead 23/12/2021 @ 8:30 hours
//	INBOUND FLIGHT BR418 from Stanstead to Derry 30/12/1018 @ 10:15 hours
//	PASSENGERS [Mr Bart Simpson, 2 bags, no Priority Boarding]
//	TOTAL PRICE € 105.99"

	// equals method
	@Override
	public boolean equals(Object obj) {
		Booking bObject;
		if (obj instanceof Booking) {
			bObject = (Booking) obj;
		} else
			return false;
		return bookingNo == bObject.bookingNo;
		// Number unique doesn't need to
		// Compare all fields
	}

	// find Passenger if exists
	public boolean findPassenger(Passenger p) {
		return passengers.contains(p);
	}

	// Calculate price is outbound + inbound by number od passengers in arraylist
	public double calculatePrice() {
		return (this.outbound.getPrice() + this.inbound.getPrice()) * this.passengers.size();
	}

	
	//SET GET ERS

	public int getBookingNumber() {
		return bookingNo;
	}

	public void setTotalPrice() {
		totalPrice = calculatePrice();
		System.out.println(totalPrice);
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	// outbound get/set ers
	public Flight getOutboundFlight() {
		return this.inbound;
	}
	
	//outbound cant be null
	public void setOutboundFlight(Flight outBoundF) throws NullPointerException { 
		if (outBoundF == null) {
			throw new NullPointerException("outBound is null");
		}
		this.outbound = outBoundF;
	}

	// inbound get/set ers
	public Flight getInboundFlight() {
		return this.inbound;
	}

	public void setInboundFlight(Flight inBoundF) {
		this.inbound = inBoundF;
	}

}

