package jlw0520.constants;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;

/*
 * Constants for all the information we have about tools. In a real sitchuation this 
 * data would live in objects stored in a database.
 */
public final class Constants {
	public static final BigDecimal LADDER_DAILY_CHARGE = new BigDecimal(1.99);
	public static final BigDecimal CHAINSAW_DAILY_CHARGE = new BigDecimal(1.49);
	public static final BigDecimal JACKHAMMER_DAILY_CHARGE = new BigDecimal(2.99);
	
	public static final boolean LADDER_WEEKDAY_CHARGE = true;
	public static final boolean CHAINSAW_WEEKDAY_CHARGE = true;
	public static final boolean JACKHAMMER_WEEKDAY_CHARGE = true;
	
	public static final boolean LADDER_WEEKEND_CHARGE = true;
	public static final boolean CHAINSAW_WEEKEND_CHARGE = false;
	public static final boolean JACKHAMMER_WEEKEND_CHARGE = false;
	
	public static final boolean LADDER_HOLIDAY_CHARGE = false;
	public static final boolean CHAINSAW_HOLIDAY_CHARGE = true;
	public static final boolean JACKHAMMER_HOLIDAY_CHARGE = false;
	
	public static final String LADDER_CODE_ONE = "LADW";
	public static final String CHAINSAW_CODE_ONE = "CHNS";
	public static final String JACKHAMMER_CODE_ONE = "JAKR";
	public static final String JACKHAMMER_CODE_TWO = "JAKD";
	
	public static final String LADDER_BRAND_ONE = "Werner";
	public static final String CHAINSAW_BRAND_ONE = "Stihl";
	public static final String JACKHAMMER_BRAND_ONE = "Ridgid";
	public static final String JACKHAMMER_BRAND_TWO = "DeWalt";
	
	
}

