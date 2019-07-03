package com.code.service;

import com.code.exception.MaxLimitExceededException;
import com.code.util.NumberToWordConstants;

public class NumberToWordServiceConverterImpl implements NumberToWordConverterService{


	/**
	 * This methods converts the given number into British English words
	 * 
	 * @param number the number which is to be converted to word
	 * @return string
	 * @throws Exception 
	 */

	public String convert(int number) throws MaxLimitExceededException{

		if(number>999999999){
			throw new MaxLimitExceededException(NumberToWordConstants.MAX_LIMIT_EXCEEDED_CODE,NumberToWordConstants.MAX_LIMIT_EXCEEDED_MESS);
		}
		if (number == 0) { 
			return "zero"; 
			}

		String prefix = "";

		if (number < 0) {
			number = -number;
			prefix = "negative";
		}

		String current = "";
		int place = 0;

		do {
			int n = number % 1000;
			if (n != 0){
				String s = convertLessThanOneThousand(n);
				current = s + NumberToWordConstants.specialNames[place] + current;
			}
			place++;
			number /= 1000;
		} while (number > 0);

		return (prefix + current).trim();
	}

	
	private String convertLessThanOneThousand(int number) {
		String current;

		if (number % 100 < 20){
			current = NumberToWordConstants.numNames[number % 100];
			number /= 100;
		}
		else {
			current = NumberToWordConstants.numNames[number % 10];
			number /= 10;

			current = NumberToWordConstants.tensNames[number % 10] + current;
			number /= 10;
		}
		if (number == 0) return current;
		return NumberToWordConstants.numNames[number] + " hundred" + current;
	}


}
