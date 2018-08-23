package com.learning.labs.java7;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

public class DateTest {


    @Test
    public void givenJava7DateObject_whenCompareCurrentYear_thenAssertionFalseForYear(){
        Date date = new Date();
        assertNotEquals(2018, date.getYear());
    }

    @Test
    public void givenJava7DateObject_whenCompareCurrentYear_thenAssertionTrueForYear(){
        Date date = new Date();
        assertEquals(118, date.getYear());
    }

    @Test
    public void givenCalenderInstance_whenCompareCurrentYear_thenAssertionPassForYear(){
        Calendar calendar = Calendar.getInstance();
        assertEquals(2018, calendar.get(Calendar.YEAR));
    }

    @Test
    public void givenCalenderInstance_whenCompareCurrentMonth_thenAssertionsFail(){
        Calendar calendar = Calendar.getInstance();
        assertNotEquals(8, calendar.get(Calendar.MONTH));
    }

    @Test
    public void givenCalenderInstance_whenCompareCurrentMonth_thenAssertionsPass(){
        Calendar calendar = Calendar.getInstance();
        assertEquals(7, calendar.get(Calendar.MONTH));
    }

    @Test
    public void givenDate_whenFormatDate_thenNoError(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        String formatedDate = format.format(date);
        String expectedDate = "2018/08/11";

        assertEquals(expectedDate, formatedDate);

    }

    @Test
    public void givenDate_whenFormatterSharedWithMultipleThread_thenOutputNotPredictable(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        class FormatterWorker implements Runnable{

            private DateFormat formatter;
            private Date date;

            FormatterWorker(DateFormat formatter, Date date){
               this.formatter = formatter;
               this.date = date;
            }

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " " +  formatter.format(date));
            }
        }

        Runnable task = new FormatterWorker(format, new Date());
        Runnable task1 = new FormatterWorker(format, new Date(114, 2,18));
        Runnable task2 = new FormatterWorker(format, new Date(118,1,18));

        Executor executor = Executors.newFixedThreadPool(2);

        executor.execute(task);
        executor.execute(task1);
        executor.execute(task2);

    }
}
