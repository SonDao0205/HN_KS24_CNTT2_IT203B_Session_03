package demo.DateTime;

import java.time.*;

public class Main {
    public static void main(String[] args) {
        // tạo 1 ngày 02-02-2007
        // DateTimeApi
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("LocalDate : " + localDate);
        System.out.println("LocalTime : " + localTime);
        System.out.println("LocalDateTime : " + localDateTime);
        System.out.println("ZonedDateTime : " + zonedDateTime);

        LocalDate bornIn = LocalDate.of(2006, Month.MAY, 2);
        Period age = Period.between(bornIn, localDate);
        System.out.println("age : " + age);
    }
}
