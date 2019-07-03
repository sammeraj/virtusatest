package com.code;

import com.code.exception.MaxLimitExceededException;
import com.code.service.NumberToWordServiceConverterImpl;

/**
 * Hello world!
 *
 */
public class NumberToWordConverter 
{
    public static void main( String[] args ) throws MaxLimitExceededException
    {
        System.out.println( "Hello World!" );
        NumberToWordServiceConverterImpl obj=new NumberToWordServiceConverterImpl();
        System.out.println("Number is:  " +obj.convert(99999999));
    }
}
