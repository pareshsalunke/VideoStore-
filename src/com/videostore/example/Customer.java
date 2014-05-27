package com.videostore.example;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();
	
	public Customer (String name){ 
		_name = name;
	}
	
	public void addRental(Rental arg) { 
		_rentals.addElement(arg);
	}
	
	public String getName (){
		return _name; 
	}
	
	public String statement () {
		/*double totalAmount = 0;
		int	frequentRenterPoints = 0;*/
		
		Enumeration<Rental> rentals = _rentals.elements ();
		String result = "Rental Record for " + getName () + "\n";
	
		while (rentals.hasMoreElements ()) {
			
			Rental each = (Rental)rentals.nextElement ();
			
			//show figures for this rental
			result += "\t" + each.getMovie ().getTitle () + "\t"
						   + String.valueOf (each._movie.getCharge(each.getDaysRented())) + "\n";
			
	}
	
	result += "You owed " + String.valueOf (getTotalCharge()) + "\n";
	result += "You earned " + String.valueOf (getTotalFrequentRenterPoints()) + " frequent renter points\n";
		
	return result;
    }
	
	public String htmlStatement() {
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			//show figures for each rental
			result += each.getMovie().getTitle()+ ": " + String.valueOf(each.getCharge()) + "<BR>\n";
			
		}
		//add footer lines
		result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "<EM><P>\n";
		result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) 
				+ "</EM> frequent renter points<P>";
		
		return result;
	}

	double getTotalCharge() {
		double result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each._movie.getCharge(each.getDaysRented());
		}
		return result;
		
	}
	
	int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result +=  each.getFrequentRenterPoints();
		}
		return result;
	}
	
	/*private double amountFor(Rental aRental) {
		return aRental._movie.getCharge(aRental.getDaysRented());
	}*/
	
	public static void main(String[] args) {
		VideoStoreTest test = new VideoStoreTest();
		test.setUp();
		test.testSingleChildrensStatement();
		/*Customer cust = new Customer("Paresh");
		Customer cust1 = new Customer("Ed");
		Movie movie = new Movie("Lord",2);
		Rental rent = new Rental(movie, 4);
		Movie movie1 = new Movie("Godzilla",1);
		Rental rent1 = new Rental(movie1, 3);
		
		cust.addRental(rent);
		cust.addRental(rent1);
		
		cust1.addRental(rent1);
		System.out.println(cust.statement());
	//	System.out.println(cust.getName());
	//	System.out.println(cust.statement());
*/	}
}
