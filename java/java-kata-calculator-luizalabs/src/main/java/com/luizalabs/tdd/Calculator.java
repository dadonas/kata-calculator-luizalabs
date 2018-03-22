package com.luizalabs.tdd;

public class Calculator {
	
	public static final String DELIMITER_NEWLINE = "\n";
	public static final String DELIMITER_COMMA = ",";

	public static long calculate(String expression) {
		if (expression == null || expression == "") {
			return 0;
		}
		
		long result = 0;
		
		expression = expression.replace(DELIMITER_NEWLINE, DELIMITER_COMMA);
		
		String[] nums = expression.split(DELIMITER_COMMA);
		
		for (String num : nums) {
			long _num = Integer.valueOf(num);
			
			if (_num < 0) {
				throw new RuntimeException("Numbers must be positives.");
			}
			
			if (_num > 1000) {
				_num = 0;
			}
			
			result += _num;
		}
		
		return result;
	}

}
