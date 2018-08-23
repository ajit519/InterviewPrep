package com.learning.labs.java8;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static org.junit.Assert.assertEquals;

public class TemporalAdjustersTest {

    @Test
    public void givenDate_manipulateDateWithTemporalAdjusters(){
        LocalDate now = LocalDate.now();

        LocalDate date = now.with(nextOrSame(DayOfWeek.SATURDAY));

        assertEquals(25, date.getDayOfMonth());

    }
}
