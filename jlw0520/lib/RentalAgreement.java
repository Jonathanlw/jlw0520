package jlw0520.lib;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;


/*
 * Class to contain all the data for a rental agreement and provide a
 * method to print it out to the console
 */
public class RentalAgreement {
	// RentalAgreement data
	private final Tool tool;
	private final Integer rentalDays;
	private final LocalDate checkoutDate;
	private final LocalDate dueDate;
	private final Integer chargeDays;
	private final BigDecimal preDiscountCharge;
	private final Integer discountPercentage;
	private final BigDecimal discountAmount;
	private final BigDecimal finalCharge;
	
	// Initializing constructor
	public RentalAgreement(Tool tool, Integer rentalDays, LocalDate checkoutDate, LocalDate dueDate, Integer chargeDays, BigDecimal preDiscountCharge, Integer discountPercentage, BigDecimal discountAmount, BigDecimal finalCharge ) {
		this.tool = tool;
		this.rentalDays = rentalDays;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.chargeDays = chargeDays;
		this.preDiscountCharge = preDiscountCharge;
		this.discountPercentage = discountPercentage;
		this.discountAmount = discountAmount;
		this.finalCharge = finalCharge;
	}
	
	// Method to print out formatted RentalAgreement
	public void printAgreement() {
		System.out.println("Tool code: " + this.tool.getToolCode());
		System.out.println("Tool type: " + this.tool.getToolType());
		System.out.println("Tool brand: " + this.tool.getToolBrand());
		System.out.println("Rental Days: " + this.rentalDays);
		System.out.println("Checkout Date: " + this.checkoutDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));
		System.out.println("Due Date: " + this.dueDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));
		System.out.println("Charge Days: " + this.chargeDays);
		System.out.println("Pre discount charge: " + NumberFormat.getCurrencyInstance(Locale.US).format(this.preDiscountCharge));
		System.out.println("Discount precentage: " + this.discountPercentage + "%");
		System.out.println("Discount Amount: " + NumberFormat.getCurrencyInstance(Locale.US).format(this.discountAmount));
		System.out.println("Final charge: " + NumberFormat.getCurrencyInstance(Locale.US).format(this.finalCharge));
	}
}
