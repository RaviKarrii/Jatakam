package org.ravikarri.jatak.graha;

import swisseph.SweConst;
import swisseph.SweDate;

import java.time.LocalDateTime;

public class GrahaData {

    public GrahaData(){
        setSun(new Graha());
        setMars(new Graha());
        setMoon(new Graha());
        setVenus(new Graha());
        setMercury(new Graha());
        setSaturn(new Graha());
        setJupitor(new Graha());
        setRahu(new Graha());
        setKetu(new Graha());
    }

    private LocalDateTime localDateTime;
    private Double lon,Lat;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return Lat;
    }

    public void setLat(Double lat) {
        Lat = lat;
    }

    private Graha sun,moon,mars,venus,mercury,jupitor,saturn,rahu,ketu;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Graha getSun() {
        return sun;
    }

    public void setSun(Graha sun) {
        this.sun = sun;
        this.sun.setSearch_int(SweConst.SE_SUN);
    }

    public Graha getMoon() {
        return moon;
    }

    public void setMoon(Graha moon) {
        this.moon = moon;
        this.moon.setSearch_int(SweConst.SE_MOON);
    }

    public Graha getMars() {
        return mars;
    }

    public void setMars(Graha mars) {
        this.mars = mars;
        this.mars.setSearch_int(SweConst.SE_MARS);
    }

    public Graha getVenus() {
        return venus;
    }

    public void setVenus(Graha venus) {
        this.venus = venus;
        this.venus.setSearch_int(SweConst.SE_VENUS);
    }

    public Graha getMercury() {
        return mercury;
    }

    public void setMercury(Graha mercury) {
        this.mercury = mercury;
        this.mercury.setSearch_int(SweConst.SE_MERCURY);
    }

    public Graha getJupitor() {
        return jupitor;
    }

    public void setJupitor(Graha jupitor) {
        this.jupitor = jupitor;
        this.jupitor.setSearch_int(SweConst.SE_JUPITER);
    }

    public Graha getSaturn() {
        return saturn;
    }

    public void setSaturn(Graha saturn) {
        this.saturn = saturn;
        this.saturn.setSearch_int(SweConst.SE_SATURN);
    }

    public Graha getRahu() {
        return rahu;
    }

    public void setRahu(Graha rahu) {
        this.rahu = rahu;
        this.rahu.setSearch_int(SweConst.SE_MEAN_NODE);
    }

    public Graha getKetu() {
        return ketu;
    }

    public void setKetu(Graha ketu) {
        this.ketu = ketu;
        this.ketu.setSearch_int(SweConst.SE_TRUE_NODE);
    }


    public void calculateData(){
        int year = this.localDateTime.getYear();
        int month = this.localDateTime.getMonthValue();
        int day = this.localDateTime.getDayOfMonth();
        int hour =this.localDateTime.getHour();
        int min =this.localDateTime.getMinute();

        double time2 = decimal(hour,min,00);
        SweDate sd=new SweDate(year,month,day,time2);


        this.sun.generateLatLon(sd);
        this.moon.generateLatLon(sd);
        this.mercury.generateLatLon(sd);
        this.venus.generateLatLon(sd);
        this.mars.generateLatLon(sd);
        this.jupitor.generateLatLon(sd);
        this.saturn.generateLatLon(sd);
        this.rahu.generateLatLon(sd);
        this.ketu.generateLatLon(sd);
    }
    public double decimal( int deg, int min, int sec ) {

        double temp = ( ( ( deg * 60 ) + min ) * 60 ) + sec;
        double res = ( double ) ( temp / 3600 );

        //System.out.println("res " + res);
        return res;

    }
}
