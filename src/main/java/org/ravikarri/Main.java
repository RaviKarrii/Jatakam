package org.ravikarri;

import org.ravikarri.jatak.graha.GrahaData;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class Main {
    public static void main(String[] args) {
        GrahaData gd = new GrahaData(LocalDateTime.now());
    }
}