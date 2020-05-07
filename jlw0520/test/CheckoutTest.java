package jlw0520.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jlw0520.constants.Constants;
import jlw0520.lib.Checkout;
import jlw0520.lib.RentalAgreement;
import jlw0520.lib.Tool;
import jlw0520.lib.data.DataLoader;

class CheckoutTest {

	static Checkout checkout = new Checkout();
	static DataLoader dl = new DataLoader();
	
	@Test
	void testMap() {
		
		Tool currentTool = dl.toolDataMapping.get(Constants.LADDER_CODE_ONE);
		RentalAgreement ra = checkout.performCheckout(currentTool, 5, 0, LocalDate.of(2020, 1, 1));
		
		ra.printAgreement();
		System.out.println();
	}
	
	@Test
	void testOne() {
		System.out.println("Test One");
		Tool currentTool = dl.toolDataMapping.get(Constants.JACKHAMMER_CODE_ONE);
		
		Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> checkout.performCheckout(currentTool, 5, 101, LocalDate.of(2015, 3, 9)));
	
		System.out.println(e.getMessage());
		System.out.println();
	}
	
	@Test
	void testTwo() {
		System.out.println("Test Two");
		Tool currentTool = dl.toolDataMapping.get(Constants.LADDER_CODE_ONE);
		
		RentalAgreement ra = checkout.performCheckout(currentTool, 3, 10, LocalDate.of(2020, 7, 2));
		ra.printAgreement();
		System.out.println();
	}
	
	@Test
	void testThree() {
		System.out.println("Test Three");
		Tool currentTool = dl.toolDataMapping.get(Constants.CHAINSAW_CODE_ONE);
		
		RentalAgreement ra = checkout.performCheckout(currentTool, 5, 25, LocalDate.of(2015, 7, 2));
		ra.printAgreement();
		System.out.println();
	}
	
	@Test
	void testFour() {
		System.out.println("Test Four");
		Tool currentTool = dl.toolDataMapping.get(Constants.JACKHAMMER_CODE_TWO);
		
		RentalAgreement ra = checkout.performCheckout(currentTool, 6, 0, LocalDate.of(2015, 9, 3));
		ra.printAgreement();
		System.out.println();
	}
	
	@Test
	void testFive() {
		System.out.println("Test Five");
		Tool currentTool = dl.toolDataMapping.get(Constants.JACKHAMMER_CODE_ONE);
		
		RentalAgreement ra = checkout.performCheckout(currentTool, 9, 0, LocalDate.of(2015, 7, 2));
		ra.printAgreement();
		System.out.println();
	}
	
	@Test
	void testSix() {
		System.out.println("Test Six");
		Tool currentTool = dl.toolDataMapping.get(Constants.JACKHAMMER_CODE_ONE);
		
		RentalAgreement ra = checkout.performCheckout(currentTool, 4, 50, LocalDate.of(2020, 7, 2));
		ra.printAgreement();
		System.out.println();
	}

}
