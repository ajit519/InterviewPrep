package com.learning.labs.java8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

import static org.junit.Assert.assertEquals;

public class DateTimeTest {

    @Test
    public void createLocalDate_fromFactoryMethod_now(){
        LocalDate now = LocalDate.now();

        assertEquals(2018, now.getYear());
        assertEquals(8, now.getMonthValue());
        assertEquals(12, now.get(ChronoField.DAY_OF_MONTH));

    }

    @Test
    public void createLocalDate_fromFactoryMethod_of(){
        LocalDate today = LocalDate.of(2014,3,18);

        assertEquals(2014, today.getYear());
        assertEquals(3, today.getMonthValue());
        assertEquals(18, today.get(ChronoField.DAY_OF_MONTH));
    }

    @Test
    public void readLocalDateValues_withTemporalField(){
       // TemporalField implements ChronoField

        LocalDate date = LocalDate.now();

        assertEquals(2018, date.get(ChronoField.YEAR));
        assertEquals(8,date.get(ChronoField.MONTH_OF_YEAR));
        assertEquals(12, date.get(ChronoField.DAY_OF_MONTH));
    }

    @Test
    public void createLocalTime_fromFactoryMethod(){
        LocalTime time = LocalTime.of(14,2,30);

        assertEquals(14, time.getHour());
        assertEquals(2, time.getMinute());
        assertEquals(30, time.getSecond());

        LocalTime time1 = LocalTime.now(ZoneId.systemDefault());

        assertEquals(14, time1.getHour());
        assertEquals(LocalTime.now().getMinute(), time1.getMinute());
        assertEquals(LocalTime.now().getSecond(), time1.getSecond());
    }

    @Test
    public void createLocalTime_readValuesFrom(){
        LocalTime time = LocalTime.of(8,25,45);

        assertEquals(8, time.get(ChronoField.HOUR_OF_DAY));
        assertEquals(25, time.get(ChronoField.MINUTE_OF_HOUR));
        assertEquals(45, time.get(ChronoField.SECOND_OF_MINUTE));
    }

    @Test
    public void givenString_whenParseToLocalDate_thenNoError(){
        String time = "2014-09-30";

        LocalDate date = LocalDate.parse(time);

        assertEquals(2014, date.getYear());
        assertEquals(9, date.getMonthValue());
        assertEquals(30, date.getDayOfMonth());
    }


    @Test(expected = DateTimeParseException.class)
    public void givenDateString_whenParseToLocalDate_thenThrowException(){
        String time = "2014/09/30";

        LocalDate date = LocalDate.parse(time);
    }

    @Test
    public void givenTimeString_whenParseToLocalTime_thenNoError(){
        String time = "08:14:23";

        LocalTime now = LocalTime.parse(time);

        assertEquals(8, now.getHour());
        assertEquals(14, now.getMinute());
        assertEquals(23, now.getSecond());
    }

    @Test(expected = DateTimeParseException.class)
    public void givenTimeString_whenParseToLocalTime_thenThrowError(){
        String time = "08-14-23";

        LocalTime now = LocalTime.parse(time);

        assertEquals(8, now.getHour());
        assertEquals(14, now.getMinute());
        assertEquals(23, now.getSecond());
    }

    @Test
    public void createLocalDateTime_withAllCombination(){
        // LocalDateTime = LocalDate + LocalTime

        LocalDateTime localDateTime = LocalDateTime.of(2014, Month.MARCH, 18, 14, 24, 45);

        LocalDateTime localDateTime1 = LocalDateTime.now();

        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        LocalTime time = LocalTime.now();
        LocalDateTime localDateTime3 = time.atDate(LocalDate.now());

        LocalDate now = LocalDate.now();
        LocalDateTime localDateTime4 = now.atTime(time);
    }

    @Test
    public void givenLocalDateTime_fetchLocalDateAndLocalTime(){
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDate date = localDateTime.toLocalDate();
        LocalTime time = localDateTime.toLocalTime();

        assertEquals(2018, date.getYear());
        assertEquals(8, time.getHour());

    }
}
