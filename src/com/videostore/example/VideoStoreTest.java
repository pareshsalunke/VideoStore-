package com.videostore.example;


import junit.framework.TestCase;

import org.junit.Test;

public class VideoStoreTest extends TestCase {
	private Customer cust;
	private Movie movie;
	private Movie regular;
	private Movie new_release;
	
	@Test
	protected void setUp() {
		cust = new Customer("Paresh");
		movie = new Movie("Lord of the Rings",2);
		regular = new Movie("Regular Movie", 0);
		new_release = new Movie("New Release",1);	
		
	}
	
	private void assertAmountAndPointsForReport(double expectedAmount, int expectedPoints) {
		String message;
		assertEquals(message = "Passed",expectedAmount, cust.getTotalCharge());	
		System.out.println(message);
	    assertEquals("Passed",expectedPoints, cust.getTotalFrequentRenterPoints());
	}
	
	public void testSingleChildrensStatement() {
		cust.addRental(new Rental(movie, 4));
	    assertAmountAndPointsForReport(3,1);
	  }
	
	public void testSingleRegularStatement() {
		cust.addRental(new Rental(regular, 2));
		assertAmountAndPointsForReport(2,1);
	}
	
	public void testSingleNewReleaseStatement() {
		cust.addRental(new Rental(new_release, 5));
		assertAmountAndPointsForReport(15,2);
	}
	
}

