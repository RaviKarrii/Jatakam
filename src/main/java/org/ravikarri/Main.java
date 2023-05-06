package org.ravikarri;

import org.ravikarri.jatak.Asthakoot.Astakoot;
import org.ravikarri.jatak.graha.GrahaData;
import org.ravikarri.jatak.panchanga.Panchanga;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;

public class Main {
    public static void main(String[] args) {
        Astakoot astakoot = new Astakoot(1,1,1,1);
        System.out.println(astakoot.getString());

    }
}