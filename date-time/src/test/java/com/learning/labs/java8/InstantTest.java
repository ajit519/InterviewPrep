package com.learning.labs.java8;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

public class InstantTest {

    @Test
    public void createInstantInstance_formFactoryMethod() {
        Instant instant = Instant.now();
        Instant.ofEpochSecond(3);
    }

    @Test
    public void createDurationInstance_withTimeInstance() {
        // Duration meant for computer to calculate date so it will return time in seconds or nano second
        // if we trying to find human readable format then we will get exception.


        LocalTime time1 = LocalTime.of(7, 11);
        LocalTime time2 = LocalTime.now();
        Duration duration = Duration.between(time1, time2);

        LocalDateTime localDateTime = LocalDateTime.of(2014, 3, 14, 14, 25, 00);
        LocalDateTime localDateTime1 = LocalDateTime.of(2014, 4, 14, 14, 25, 00);

        Duration duration1 = Duration.between(localDateTime, localDateTime1);

        Instant instant = Instant.ofEpochSecond(5);
        Instant now = Instant.now();

        Duration.between(instant, now);

        Duration.ofDays(365);
        Duration.of(3, ChronoUnit.MINUTES);

    }

    @Test(expected = DateTimeException.class)
    public void givenLocalDateAndLocalTime_whenCreatingDuration_failBecauseDurationCanNotCreatedForTime() {
        LocalDate date = LocalDate.now();

        Instant instant = Instant.now();

        Duration.between(date, instant);
    }

    @Test
    public void createPeriod_whenHumanReadableDateGiven() {
        LocalDate date = LocalDate.of(2016, 9, 14);

        Period period = Period.between(date, LocalDate.now());

        assertEquals(1, period.getYears());
        assertEquals(10, period.getMonths());
    }

    @Test
    public void createPeriod_withFactoryMethod() {
        Period period = Period.of(2, 5, 19);

        assertEquals(2, period.getYears());

        Period period1 = Period.ofDays(388);
        assertEquals(388, period1.getDays());
    }
}
