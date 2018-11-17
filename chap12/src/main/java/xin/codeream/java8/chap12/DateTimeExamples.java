package xin.codeream.java8.chap12;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.TimeZone;

/**
 * DateTimeExamples
 *
 * @author NGLSL
 * @date 2018/11/17
 */
public class DateTimeExamples {
    public static void main(String[] args) {
        localDateExamples();
        System.out.println("==============");
        localTimeExamples();
        System.out.println("==============");
        localDateTimeExamples();
        System.out.println("==============");
        instantExamples();
        System.out.println("==============");
        durationExamples();
        System.out.println("==============");
        periodExamples();
        System.out.println("==============");
        withAttributeExamples();
        System.out.println("==============");
        localDateUpdateAttr();
        System.out.println("==============");
        temporalAdjusterExamples();
        System.out.println("==============");
        dateTimeFormatExamples();
        System.out.println("==============");
        dateTimeFormatterBuilderExamples();
        System.out.println("==============");
        zoneIdExamples();
        System.out.println("==============");
        zoneOffsetExamples();
    }

    private static void zoneOffsetExamples() {
        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");

        LocalDateTime dateTime = LocalDateTime.of(2018, 11, 17, 1, 45);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dateTime, newYorkOffset);

        System.out.println("offsetDateTime:" + offsetDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    private static void zoneIdExamples() {
        ZoneId shanghaiZone = ZoneId.of("Asia/Shanghai");
        System.out.println("zone:" + shanghaiZone);

        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println("TimeZone-default:" + zoneId);

        LocalDate date = LocalDate.of(2018, 11, 17);
        ZonedDateTime zdt1 = date.atStartOfDay(shanghaiZone);

        LocalDateTime dateTime = LocalDateTime.of(2018, 11, 27, 18, 13, 15);
        ZonedDateTime zdt2 = dateTime.atZone(shanghaiZone);

        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(shanghaiZone);

        System.out.println("zdt1:" + zdt1);
        System.out.println("zdt2:" + zdt2);
        System.out.println("zdt3:" + zdt3);
    }

    private static void dateTimeFormatterBuilderExamples() {
        DateTimeFormatter italianFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);

        LocalDate now = LocalDate.now();
        String s1 = now.format(italianFormatter);
        System.out.println("s1:" + s1);
    }

    private static void dateTimeFormatExamples() {
        LocalDate date1 = LocalDate.of(2018, 11, 17);
        // 20181117
        String s1 = date1.format(DateTimeFormatter.BASIC_ISO_DATE);
        // 2018-11-17
        String s2 = date1.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);


        LocalDate date2 = LocalDate.parse("20181117", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date3 = LocalDate.parse("2018-11-17", DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("date2:" + date2);
        System.out.println("date3:" + date3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date1.format(formatter);
        LocalDate date4 = LocalDate.parse(formattedDate, formatter);

        System.out.println("formattedDate:" + formattedDate);
        System.out.println("date4:" + date4);


        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date5 = LocalDate.of(2018, 11, 16);
        // 16. novembre 2018
        String formattedDate2 = date5.format(italianFormatter);
        LocalDate date6 = LocalDate.parse(formattedDate2, italianFormatter);

        System.out.println("formattedDate2:" + formattedDate2);
        System.out.println("date6:" + date6);
    }

    private static void temporalAdjusterExamples() {
        // 2018-11-17
        LocalDate date1 = LocalDate.of(2018, 11, 17);
        // 2018-11-19
        LocalDate date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        // 2018-11-30
        LocalDate date3 = date2.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println("date2:" + date2);
        System.out.println("date3:" + date3);
    }

    private static void localDateUpdateAttr() {
        // 2018-11-17
        LocalDate date1 = LocalDate.of(2018, 11, 17);
        // 2018-11-24
        LocalDate date2 = date1.plusWeeks(1);
        // 2015-11-24
        LocalDate date3 = date2.minusYears(3);
        // 2016-05-24
        LocalDate date4 = date3.plus(6, ChronoUnit.MONTHS);

        System.out.println("date1:" + date1);
        System.out.println("date2:" + date2);
        System.out.println("date3:" + date3);
        System.out.println("date4:" + date4);
    }

    private static void withAttributeExamples() {
        // 2018-11-17
        LocalDate date1 = LocalDate.of(2018, 11, 17);
        // 2019-11-17
        LocalDate date2 = date1.withYear(2019);
        // 2019-11-25
        LocalDate date3 = date2.withDayOfMonth(25);
        // 2019-09-25
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println("date1:" + date1);
        System.out.println("date2:" + date2);
        System.out.println("date3:" + date3);
        System.out.println("date4:" + date4);
    }

    private static void periodExamples() {
        Period period = Period.between(LocalDate.of(2018, 11, 7), LocalDate.of(2018, 11, 17));
        // P10D 相差10天
        System.out.println("Period between:" + period);

        Duration threeMinutes = Duration.ofMinutes(3);
        Duration fourMinutes = Duration.of(4, ChronoUnit.MINUTES);

        Period tenDay = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
    }

    private static void durationExamples() {
        LocalTime time1 = LocalTime.of(21, 50, 10);
        LocalTime time2 = LocalTime.of(22, 50, 10);
        LocalDateTime dateTime1 = LocalDateTime.of(2018, 11, 17, 21, 50, 10);
        LocalDateTime dateTime2 = LocalDateTime.of(2018, 11, 17, 23, 50, 10);
        Instant instant1 = Instant.ofEpochSecond(1000 * 60 * 2);
        Instant instant2 = Instant.ofEpochSecond(1000 * 60 * 3);

        Duration d1 = Duration.between(time1, time2);
        Duration d2 = Duration.between(dateTime1, dateTime2);
        Duration d3 = Duration.between(instant1, instant2);
        // PT1H 相差1小时
        System.out.println("d1:" + d1);
        // PT2H 相差2小时
        System.out.println("d2:" + d2);
        // PT16H40M 相差16小时40分钟
        System.out.println("d3:" + d3);
    }

    private static void instantExamples() {
        Instant.ofEpochSecond(3);
        Instant.ofEpochSecond(3, 0);
        // 2 秒之后再加上100万纳秒（1秒）
        Instant.ofEpochSecond(2, 1_000_000_000);
        // 4秒之前的100万纳秒（1秒）
        Instant.ofEpochSecond(4, -1_000_000_000);

        // Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: DayOfMonth
        // int day = Instant.now().get(ChronoField.DAY_OF_MONTH);
    }

    private static void localDateTimeExamples() {
        // 2018-11-17T21:31:50
        LocalTime time = LocalTime.of(21, 31, 50);
        LocalDate date = LocalDate.of(2018, 11, 17);

        LocalDateTime dt1 = LocalDateTime.of(2018, Month.NOVEMBER, 17, 21, 31, 50);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(21, 11, 17);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
    }

    private static void localTimeExamples() {
        LocalTime localTime = LocalTime.of(13, 45, 20);
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();

        System.out.println(String.format("hour:%s\nminute:%s\nsecond:%s", hour, minute, second));

        LocalTime time = LocalTime.parse("21:27:58");
        System.out.println(time);
    }

    private static void localDateExamples() {
        LocalDate localDate = LocalDate.of(2014, 3, 18);
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int day = localDate.getDayOfMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int len = localDate.lengthOfMonth();
        boolean leap = localDate.isLeapYear();

        System.out.println(String.format("year:%s\nmonth:%s\nday:%s\ndow:%s\nlen:%s\nleap:%s", year, month, day, dayOfWeek, len, leap));

        LocalDate today = LocalDate.now();

        localDate.get(ChronoField.YEAR);
        localDate.get(ChronoField.MONTH_OF_YEAR);
        localDate.get(ChronoField.DAY_OF_MONTH);

        LocalDate date = LocalDate.parse("2018-11-17");
        System.out.println(date);
    }
}
