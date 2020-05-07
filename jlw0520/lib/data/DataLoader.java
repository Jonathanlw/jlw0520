package jlw0520.lib.data;

import java.util.HashMap;

import jlw0520.constants.*;
import jlw0520.lib.*;

public class DataLoader {
	public final static HashMap<String, Tool> toolDataMapping = new HashMap<>();
	
	public DataLoader() {
		Tool ladderOne = new Tool(ToolTypes.Ladder, Constants.LADDER_CODE_ONE, Constants.LADDER_BRAND_ONE);
		toolDataMapping.put(Constants.LADDER_CODE_ONE, ladderOne);
		
		Tool chainsawOne = new Tool(ToolTypes.Chainsaw, Constants.CHAINSAW_CODE_ONE, Constants.CHAINSAW_BRAND_ONE);
		toolDataMapping.put(Constants.CHAINSAW_CODE_ONE, chainsawOne);
		
		Tool jackhammerOne = new Tool(ToolTypes.Jackhammer, Constants.JACKHAMMER_CODE_ONE, Constants.JACKHAMMER_BRAND_ONE);
		toolDataMapping.put(Constants.JACKHAMMER_CODE_ONE, jackhammerOne);
		
		Tool jackhammerTwo = new Tool(ToolTypes.Jackhammer, Constants.JACKHAMMER_CODE_TWO, Constants.JACKHAMMER_BRAND_TWO);
		toolDataMapping.put(Constants.JACKHAMMER_CODE_TWO, jackhammerTwo);
	}
}
