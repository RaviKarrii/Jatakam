package org.ravikarri;

import org.ravikarri.jatak.Asthakoot.Astakoot;
import org.ravikarri.jatak.graha.GrahaData;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("================BOY====================");
        GrahaData boy = new GrahaData(LocalDateTime.of(1993,9,16,17,55,00),16.9334,82.2167);
        System.out.println("================GIRL===================");
        GrahaData girl = new GrahaData(LocalDateTime.of(1995,8,6,00,07,00),16.7334,81.1501);
        Astakoot koot = new Astakoot(boy.getMoon().getNakshatraNumber(),girl.getMoon().getNakshatraNumber(),boy.getMoon().getRaasiNumber(),girl.getMoon().getRaasiNumber());
        System.out.println(koot.getString());

    }
}