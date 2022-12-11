package org.ravikarri.jatak.graha;

import de.thmac.swisseph.SweConst;
import de.thmac.swisseph.SweDate;
import de.thmac.swisseph.SwissEph;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.TimeZone;

public class GrahaData {

    public GrahaData(LocalDateTime localDateTime,Double lat,Double lon){
        setLocalDateTime(localDateTime);
        this.lon = lon;
        this.lat = lat;
        setSun(new Graha());
        setMars(new Graha());
        setMoon(new Graha());
        setVenus(new Graha());
        setMercury(new Graha());
        setSaturn(new Graha());
        setJupitor(new Graha());
        setRahu(new Graha());
        setKetu(new Graha());
        calculateAllData();
    }

    private LocalDateTime localDateTime;
    private Double lon,lat;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        lat = lat;
    }

    public String getLagna() {
        return lagna;
    }

    private String lagna;

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


    public void
    calculateAllData(){

        String[] date = SRtime().split(" ")[0].split("-");
        String[] time = SRtime().split(" ")[1].split(":");
        double time2 = decimal(Integer.parseInt(time[0]),Integer.parseInt(time[1]),Integer.parseInt(time[2]));
        SweDate sd=new SweDate(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]),time2);

        this.sun.generateLatLon(sd);
        this.moon.generateLatLon(sd);
        this.mercury.generateLatLon(sd);
        this.venus.generateLatLon(sd);
        this.mars.generateLatLon(sd);
        this.jupitor.generateLatLon(sd);
        this.saturn.generateLatLon(sd);
        this.rahu.generateLatLon(sd);
        this.ketu.generateLatLon(sd);
        this.lagna  = getLagnainfo(sd);
        System.out.println(this.lagna);
    }

    private String TZcalc(){
        return "IST";
    }
    public String SRtime(){

        int year = this.localDateTime.getYear();
        int month = this.localDateTime.getMonthValue();
        int day = this.localDateTime.getDayOfMonth();
        int hour =this.localDateTime.getHour();
        int min =this.localDateTime.getMinute();

        String input = day+"-"+month+"-"+year+" "+ hour +":"+min+":00";//"31-12-1998 23:37:50";
        DateFormat dfNy = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ROOT);
        dfNy.setTimeZone(TimeZone.getTimeZone(TZcalc()));
        DateFormat dfUtc = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ROOT);
        dfUtc.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            return dfUtc.format(dfNy.parse(input));
        } catch (Exception e) {

        }return "";
    }
    public double decimal( int deg, int min, int sec ) {

        double temp = ( ( ( deg * 60 ) + min ) * 60 ) + sec;
        double res = ( double ) ( temp / 3600 );

        //System.out.println("res " + res);
        return res;

    }

    private String getLagnainfo(SweDate sd) {
        SwissEph sw = new SwissEph();
        double longitude = this.lon;
        double latitude = this.lat;
        int flags = SweConst.SEFLG_SIDEREAL;
        double[] cusps = new double[13];
        double[] acsc = new double[10];

        int result = sw.swe_houses(sd.getJulDay(),
                flags,
                latitude,
                longitude,
                'P',
                cusps,
                acsc);

        return "Ascendant " + toDMS(acsc[0]) + "\n";
    }

    static String toDMS(double d) {
        d += 0.5/3600./10000.;	// round to 1/1000 of a second
        int deg = (int) d;
        d = (d - deg) * 60;
        int min = (int) d;
        d = (d - min) * 60;
        double sec = d;

        return String.format("%3d° %02d' %07.4f\"", deg, min, sec);
    }
}
