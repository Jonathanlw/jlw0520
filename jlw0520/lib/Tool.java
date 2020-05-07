package jlw0520.lib;

import java.math.BigDecimal;

import jlw0520.constants.*;

/*
 * This is the main storage mechanism for a tool in our code. We are 
 * essentially using it as a smart container. It does not perform any 
 * actions on it's own, but stores data for us and has some rules about
 * how to create itself in different situations. This class is immutable
 * which was done to ensure our data is not corrupted or updated incorrectly.
 * This requires creating a new Tool class every time there is an update.
 * If tools or update regularly it would make sense to make a tool mutable so we 
 * can update on the fly. In this particular case the Tools never change so we 
 * can make it immutable.
 */

public final class Tool {
	// Information about a specific tool
	private final ToolTypes toolType;
	private final String toolBrand;
	private final String toolCode;
	
	// General information about a tooltype
	private final BigDecimal dailyChargeRate;
	private final boolean weekdayCharge;
	private final boolean weekendCharge;
	private final boolean holidayCharge;

	/*
	 * Convenience constructor, since we can determine a lot of the basic information 
	 * based on the toolType we do not need to explicitly pass it to the constructor.
	 * There are other ways to do this which might make more sense in a give situation 
	 * such as creating child classes for each tool type. The downside of this is when constructing
	 * a tool object the user needs to know which object to construct so they will end up 
	 * having to look at the tool type and select the correct class based on it. A better approach
	 * could be to create another class ToolGeneralInformation which contains dailyChargeRate,
	 * weekendCharge, etc and we can pull the info out as needed. 
	 */
	 
	public Tool(ToolTypes toolType, String toolCode, String toolBrand){
		this.toolType = toolType;
		this.toolBrand = toolBrand;
		this.toolCode = toolCode;
		
		switch (toolType) {
			case Ladder:
				dailyChargeRate = Constants.LADDER_DAILY_CHARGE;
				weekdayCharge = Constants.LADDER_WEEKDAY_CHARGE;
				weekendCharge = Constants.LADDER_WEEKEND_CHARGE;
				holidayCharge = Constants.LADDER_HOLIDAY_CHARGE;
				break;
				
			case Chainsaw:
				dailyChargeRate = Constants.CHAINSAW_DAILY_CHARGE;
				weekdayCharge = Constants.CHAINSAW_WEEKDAY_CHARGE;
				weekendCharge = Constants.CHAINSAW_WEEKEND_CHARGE;
				holidayCharge = Constants.CHAINSAW_HOLIDAY_CHARGE;
				break;
				
			case Jackhammer:
				dailyChargeRate = Constants.JACKHAMMER_DAILY_CHARGE;
				weekdayCharge = Constants.JACKHAMMER_WEEKDAY_CHARGE;
				weekendCharge = Constants.JACKHAMMER_WEEKEND_CHARGE;
				holidayCharge = Constants.JACKHAMMER_HOLIDAY_CHARGE;
				break;
			default:
				dailyChargeRate = BigDecimal.ZERO;
				weekdayCharge = false;
				weekendCharge = false;
				holidayCharge = false;
				break;
		}
	}
	
	/*
	 * The full construction if the user of this class has all the information
	 */
	public Tool(ToolTypes toolType, String toolBrand, String toolCode, BigDecimal dailyChargeRate, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge){
		this.toolType = toolType;
		this.toolBrand = toolBrand;
		this.toolCode = toolCode;
		this.dailyChargeRate = dailyChargeRate;
		this.weekdayCharge = weekdayCharge;
		this.weekendCharge = weekendCharge;
		this.holidayCharge = holidayCharge;
				
	}
	
	/*
	 * Getters for the info. We made this class immutable for safety so there are no setters
	 */
	public ToolTypes getToolType() {
		return toolType;
	}

	public String getToolBrand() {
		return toolBrand;
	}

	public String getToolCode() {
		return toolCode;
	}

	public BigDecimal getDailyChargeRate() {
		return dailyChargeRate;
	}

	public boolean isWeekdayCharge() {
		return weekdayCharge;
	}

	public boolean isWeekendCharge() {
		return weekendCharge;
	}

	public boolean isHolidayCharge() {
		return holidayCharge;
	}
	
}
