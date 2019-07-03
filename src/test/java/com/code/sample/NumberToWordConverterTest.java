package com.code.sample;

import static org.junit.Assert.*;

import org.junit.Test;

import com.code.exception.MaxLimitExceededException;
import com.code.service.NumberToWordServiceConverterImpl;

/**
 * Unit test for simple App.
 */
public class NumberToWordConverterTest 
{
    /**
     * Rigorous Test :-)
     * @throws MaxLimitExceededException 
     */
    @Test
    public void numberToWordPositiveTest() throws MaxLimitExceededException
    {
    	NumberToWordServiceConverterImpl obj=new NumberToWordServiceConverterImpl();
        assertEquals("ninety nine million nine hundred ninety nine thousand nine hundred ninety nine",obj.convert(99999999));
    }
    
    @Test(expected=MaxLimitExceededException.class)
    public void numberToWordNegativeTest() throws MaxLimitExceededException
    {
    	NumberToWordServiceConverterImpl obj=new NumberToWordServiceConverterImpl();
        obj.convert(1999999999);
    }
}
