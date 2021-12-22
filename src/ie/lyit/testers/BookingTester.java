package ie.lyit.testers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.*;

import ie.lyit.flight.*;


public class BookingTester {
	private Booking b1, b2, b3;
	private ArrayList<Passenger> passengers, passengersNull;
	private Passenger p1;

	@Before
	public void setUp() throws Exception {
		// list of passengers
		passengers = new ArrayList<Passenger>();

		// construct passenger p1
		p1 = new Passenger(new Name("Mr", "Homer", "Simpson"), new Date(25, 10, 1965), 2, true);
		// p1 to passengers
		passengers.add(p1);

//		// construct booking b1
		b1 = new Booking(new Flight("BR418", "Chicago", "Wuhan", new Date(30, 12, 2018), new Time(10, 15), 23.00),
				new Flight("BR348", "Wuhan", "Chicago", new Date(24, 7, 2018), new Time(10, 25), 5.00), passengers);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBooking() {
		// construct booking b2 with illegal input for day in outbound flight
		b1 = new Booking(new Flight("BR311", "Toronto", "Houston", new Date(34, 5, 2018), new Time(11, 15), 23.00),
				new Flight("BR365", "Houston", "Toronto", new Date(21, 4, 2018), new Time(11, 25), 15.00), passengers);
	}

	@Test
	public void testFindPassenger() {
		// check if booking b1 contains passenger p1
		assertEquals(b1.findPassenger(p1), true);
	}

	@Test
	public void testCalculatePrice() {
		// check is total price for booking b1 is €28, b1 ticket price is added by
		// outbound and inbound to get 28
		assertEquals(b1.calculatePrice(), 28, 00);
	}

	@Test
	public void testSetTotalPrice() {
		b1 = new Booking(new Flight("BR423", "Tokyo", "Mexico City", new Date(23, 12, 2018), new Time(10, 15), 80.00),
				new Flight("BR322", "Mexico City", "Tokyo", new Date(14, 7, 2018), new Time(10, 25), 119.00),
				passengers);
		b1.setTotalPrice();
		assertEquals(b1.getTotalPrice(), 199, 00);
	}

	@Test // toString method
	public void testToString() {
		// check if toString is giving required output
		b2 = new Booking(new Flight("BR215", "Paris", "New York", new Date(23, 12, 2018), new Time(10, 15), 24.99),
				new Flight("BR322", "New York", "Paris", new Date(14, 7, 2018), new Time(10, 25), 14.99), passengers);
		
		assertEquals(b2.toString(), 	
				 "BOOKING # 1002"
				+ "\nOUTBOUND FLIGHT BR215 from Paris to New York 23/12/2018 @ 10:15 hours"
				+ "\nINBOUND FLIGHT BR322 from New York to Paris 14/7/2018 @ 10:25 hours"
				+ "\nPASSENGERS[Mr Homer Simpson, 2 bags, Priority Boarding]"
				+ "\nTOTAL PRICE €39.98");
	
		
		
	}
	
			//handle exception for outbound flight and passengers
		
	@Test(expected = NullPointerException.class) //Outbound flight cannot be null
	public void testSetOutbound(){
		b1 = new Booking(new Flight("","","",new Date(),new Time(),.00),
				new Flight("BR322","Mexico City","Tokyo",new Date(14,7,2018),new Time(10,25),119.00),
				passengers);
		b1.setOutboundFlight(null); //set out bound flight test
	
		//System.out.println(b1 );
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class) //Cant  have more than 9 less than 1 passengers
	public void testNull () {
		
		passengersNull = new ArrayList<Passenger>(); // 0 passengers in this list


	 b3 = new Booking(new Flight("BR423","Tokyo","Mexico City",new Date(23,12,2018),new Time(10,15),80.00),
			new Flight("BR322","Mexico City","Tokyo",new Date(14,7,2018),new Time(10,25),119.00),
			passengersNull);
		//System.out.println(b3 + "\n");
	 
	}
		

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
