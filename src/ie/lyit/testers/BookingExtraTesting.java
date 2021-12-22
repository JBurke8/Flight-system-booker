package ie.lyit.testers;

import java.util.ArrayList;

import ie.lyit.flight.Booking;
import ie.lyit.flight.Date;
import ie.lyit.flight.Flight;
import ie.lyit.flight.Name;
import ie.lyit.flight.Passenger;
import ie.lyit.flight.Time;


//Class for default testing
public class BookingExtraTesting {

	public static void main(String[] args) {


		
		ArrayList<Passenger> passengertest = new ArrayList<Passenger>();
		Passenger p2 = new Passenger(new Name("Mr","Homer","Simpson"),new Date(25,10,1965), 2, true);
		Passenger p3 = new Passenger(new Name("Mr","Homere","Simpson"),new Date(25,10,1965), 2, true);
//		Passenger p4 = new Passenger(new Name("Mr","Homer","Simpson"),new Date(25,10,1965), 2, true);
//		Passenger p5 = new Passenger(new Name("Mr","Homer","Simpson"),new Date(25,10,1965), 2, true);
//		Passenger p6 = new Passenger(new Name("Mr","Homer","Simpson"),new Date(25,10,1965), 2, true);
//		Passenger p7 = new Passenger(new Name("Mr","Homer","Simpson"),new Date(25,10,1965), 2, true);
//		Passenger p8 = new Passenger(new Name("Mr","Homer","Simpson"),new Date(25,10,1965), 2, true);
//		Passenger p9 = new Passenger(new Name("Mr","Homer","Simpson"),new Date(25,10,1965), 2, true);
//		Passenger p10 = new Passenger(new Name("Mr","Homer","Simpson"),new Date(25,10,1965), 2, true);
//		Passenger p11= new Passenger(new Name("Mr","Homer","Simpson"),new Date(25,10,1965), 2, true);
//		Passenger p3 = new Passenger(new Name("Mr","Homer","Simpson"),new Date(25,10,1965), 2, true);
		passengertest.add(p2);
//		passengertest.add(p3);
//		passengertest.add(p4);
//		passengertest.add(p5);
//		passengertest.add(p6);
//		passengertest.add(p7);
//		passengertest.add(p8);
//		passengertest.add(p9);
//		passengertest.add(p10);
//		passengertest.add(p11);

		Booking b5 = new Booking(new Flight("","Tokyo","Mexico City",new Date(23,12,2018),new Time(10,15),80.00),
			new Flight("","Mexico City","Tokyo",new Date(14,7,2018),new Time(10,25),119.00),
			passengertest);
		//b5.setOutboundFlight(null);
		System.out.println(b5 );
		System.out.println(passengertest.size());
		
		//is passenger true
		System.out.println(b5.findPassenger(p3) + " this passenger is in");
	}

}