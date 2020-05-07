package jlw0520.lib;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/*
 * Class for performing the checkout of a tool. Contains one static method 
 * which performs the checkout and returns a RentalAgreement object
 */
public class Checkout {
	// Default constructor 
	public Checkout() {}
	
	//Method to perform checkout, takes a tool object, days to rent the tool, 
	// discount percentage, and checkout date and returns a RentalAgreement object
	public static RentalAgreement performCheckout(Tool tool, Integer rentalDayCount, Integer rentalDiscountPercentage, LocalDate checkoutDate) {
		// Input validation
		if(rentalDayCount < 1 ) {
			throw new IllegalArgumentException("It looks like the number of rental days specified is zero, tools must be rented for at least one day");
		}
		if(rentalDiscountPercentage > 100) {
			throw new IllegalArgumentException("We cannont apply a discount greater than 100%, please specify a percentage in the range 0%-100%");
		}
		if(rentalDiscountPercentage < 0) {
			throw new IllegalArgumentException("We cannont apply a discount below 0%, please specify a percentage in the range 0%-100%");
		}
		
		//Create the data objects for our rental agreement
		LocalDate dueDate = LocalDate.from(checkoutDate.plusDays(rentalDayCount));
		LocalDate currentDate = LocalDate.from(checkoutDate);
		
		Integer weekdays = 0;
		Integer weekendDays = 0;
		Integer holidays = 0;
		Integer chargeDays = 0;
		
		BigDecimal preDiscountCharge = BigDecimal.ZERO;
		BigDecimal discountAmount = BigDecimal.ZERO;
		BigDecimal finalCharge = BigDecimal.ZERO;
		
		// Loop through every day from checkout date to due date and calculate 
		// the number of weekdays, weekendDays, and holidays. 
		for(int day = 0; day < rentalDayCount; day++) {
			// Check if today is the fourth of July
			if(isFourthOfJuly(currentDate)) {
				// If it is the fourth, and a weekend we need to determine if the 4th of July was already 
				// celebrated, or if it will be celebrated in the future
				if(isWeekend(currentDate)) {
					// Check if we are on Saturday making the 4th be last Friday
					if(currentDate.getDayOfWeek() == DayOfWeek.SATURDAY && ChronoUnit.DAYS.between(currentDate, checkoutDate) > 0) {
						holidays++;
						weekendDays++;
						weekdays--;
					// Check if the current day is Sunday making the 4th a Monday
					} else if(currentDate.getDayOfWeek() == DayOfWeek.SUNDAY && ChronoUnit.DAYS.between(currentDate, dueDate) > 0) {
						weekendDays++;
						holidays++;
						day++;
					}
				} else {
					holidays++;
				}
			// Check for Labor Day
			} else if(isLaborDay(currentDate)) {
				holidays++;
			// Check for weekend
			} else if(isWeekend(currentDate)) {
				weekendDays++;
			// Otherwise we add to weekday
			} else {
				weekdays++;
			}
			
			// Incriminate date
			currentDate = currentDate.plusDays(1);
		}
		
		// If we charge for weekdays add to charge days
		if(tool.isWeekdayCharge()) {
			chargeDays += weekdays;
		}
		
		// If we charge for weekend days add to charge days
		if(tool.isWeekendCharge()) {
			chargeDays += weekendDays;
		}
		
		// If we charge for holidays add to charge days
		if(tool.isHolidayCharge()) {
			chargeDays += holidays;
			
		}
		
		// Calculate the charge amount, discount amount, and final price
		preDiscountCharge = tool.getDailyChargeRate().multiply(new BigDecimal(chargeDays));
		discountAmount = preDiscountCharge.multiply(new BigDecimal(rentalDiscountPercentage/100.0)) ;
		finalCharge = preDiscountCharge.subtract(discountAmount);
		
		//Create and return Rental agreement
		RentalAgreement rentalAgreement = new RentalAgreement(tool, rentalDayCount, checkoutDate, dueDate, chargeDays, preDiscountCharge, rentalDiscountPercentage, discountAmount, finalCharge);
		return rentalAgreement;
	}
	
	// Helper to check if date is weekend
	private static boolean isWeekend(LocalDate currentDate) {
		return currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfWeek() == DayOfWeek.SUNDAY;
	}
	
	// Helper to check if date is 4th of July
	private static boolean isFourthOfJuly(LocalDate currentDate) {
		return currentDate.getDayOfMonth() == 4 && currentDate.getMonth() == Month.JULY;
	}
	
	// Helper to check if current date is labor day
	private static boolean isLaborDay(LocalDate currentDate) {
		if(currentDate.getMonth() != Month.SEPTEMBER) {
			return false;
		}
		if(currentDate.getDayOfWeek() != DayOfWeek.MONDAY) {
			return false;
		}
		
		LocalDate weekBack = currentDate.minusDays(7);
		return weekBack.getMonth() != Month.SEPTEMBER;
	}
}
