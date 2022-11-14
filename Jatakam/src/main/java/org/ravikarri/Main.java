package org.ravikarri;

import org.ravikarri.jatak.graha.GrahaData;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        GrahaData gd = new GrahaData();
        gd.setLocalDateTime(LocalDateTime.now());
        gd.calculateData();
    }
}