package org.ravikarri.jatak.panchanga;

import org.ravikarri.jatak.graha.GrahaData;

import java.time.LocalDateTime;

public class Panchanga {


    public Panchanga(){

        GrahaData panchang = new GrahaData(LocalDateTime.now(),17.0005,81.8040);

        PanchangaData pd = new PanchangaData(panchang);
    }

}
