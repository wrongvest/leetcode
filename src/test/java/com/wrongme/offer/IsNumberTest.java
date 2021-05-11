package com.wrongme.offer;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class IsNumberTest {

    @Test
    public void isNumber() {
        IsNumber number =new IsNumber();
//        assertTrue(number.isNumber("+100"));
//        assertTrue(number.isNumber( "-123"));
//        assertTrue(number.isNumber( "5e2"));
//        assertTrue(number.isNumber( "-1E-16"));
//        assertTrue(number.isNumber( "0123"));
//        assertTrue(number.isNumber( "0123"));
//        assertFalse(number.isNumber( "12e+5.4"));
//        assertFalse(number.isNumber( "+-5"));
//        assertFalse(number.isNumber( "12e"));
//        assertTrue(number.isNumber( "0"));
//        assertFalse(number.isNumber( "e9"));
        assertFalse(number.isNumber( " "));
        assertFalse(number.isNumber( ".3"));
    }
}