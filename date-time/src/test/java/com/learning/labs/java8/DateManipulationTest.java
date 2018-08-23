package com.learning.labs.java8;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

import static org.junit.Assert.assertEquals;

public class DateManipulationTest {

    @Test
    public void givenDate_whenManipulate_thenSuccess(){
        // Every time we create or change 
        LocalDate date = LocalDate.now();

        date = date.with(ChronoField.YEAR, 2019);

        assertEquals(2019, date.getYear());

        date = date.withMonth(3);

        assertEquals(3, date.getMonthValue());

        date = date.withDayOfMonth(13);

        assertEquals(13, date.getDayOfMonth());
    }
}
