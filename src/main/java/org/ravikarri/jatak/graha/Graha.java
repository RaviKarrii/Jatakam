package org.ravikarri.jatak.graha;

import de.thmac.swisseph.SweConst;
import de.thmac.swisseph.SweDate;
import de.thmac.swisseph.SwissEph;

public class Graha {


    public Integer getSearch_int() {
        return search_int;
    }

    public void setSearch_int(Integer search_int) {
        this.search_int = search_int;

    }

    private String derivedLat;

    private Boolean isRetrograde = Boolean.FALSE;

    public Boolean getRetrograde() {
        return isRetrograde;
    }

    public void setRetrograde(Boolean retrograde) {
        isRetrograde = retrograde;
    }

    private Double speed;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getDerivedLat() {
        return derivedLat;
    }

    public void setDerivedLat(String derivedLat) {
        this.derivedLat = derivedLat;
    }

    public String getRaasi() {
        return raasi;
    }

    public void setRaasi(String raasi) {
        this.raasi = raasi;
    }

    private String raasi;

    private Integer search_int;

    private Double lon,lat;

    public Double getLon() {
        return lon;
    }


    public Double getLat() {
        return lat;
    }


    public void generateLatLon(SweDate sd){
        SwissEph sw = new SwissEph();
        double julDay = sd.getJulDay();
        double [] xx = new double[6];
        StringBuffer serr = new StringBuffer();
        int iflag = SweConst.SEFLG_SWIEPH | SweConst.SEFLG_SPEED  | SweConst.SEFLG_SIDEREAL;

        sw.swe_calc_ut(julDay,this.search_int,iflag,xx,serr);

        this.lat = xx[0];
        this.lon = xx[1];
        this.speed = xx[3];

        if(this.speed < 0){
            this.isRetrograde = true;
        }

        GrahaConstants gc = new GrahaConstants();
        String[] arr = dms(this.lat).split(":");
        this.derivedLat = deriveLat(Integer.parseInt(arr[0]))+"˚"+arr[1]+"ˈ"+arr[2]+"ˈˈ";
        this.raasi = gc.raasiMapping[RaasiFinder(Integer.parseInt(arr[0]))];
        System.out.println(gc.planetMapping[this.search_int]+ " -  Raasi : "+ this.raasi +" ,Pos : "+this.derivedLat+" ,Speed : "+this.speed+" ,isRetrograde : "+this.isRetrograde);
    }

    private String dms(double val){
        String res = new String();
        if (val < 0){
            val = Math.abs(val);
            res = res + "-";
        }
        int deg = (int)val;
        //System.out.print(deg+" : ");
        double mindob = (val-deg)* 60;
        int min = (int)(mindob);
        int sec = (int)((mindob - min)*60);
        //System.out.println(min+" : "+sec);
        res = res + deg+":"+min+":"+sec;
        return res;
    }
    private Integer deriveLat(int laInt) {
        while (30 <= laInt){
            laInt = laInt-30;
        }
        return laInt;
    }
    public int RaasiFinder(int originalAngle)
    {
        if (originalAngle >= 0 && originalAngle < 30){
            return 1;
        }
        else if (originalAngle >= 30 && originalAngle < 60){
            return 2;
        }
        else if (originalAngle >= 60 && originalAngle < 90){
            return 3;
        }
        else if (originalAngle >= 90 && originalAngle < 120){
            return 4;
        }
        else if (originalAngle >= 120 && originalAngle < 150){
            return 5;
        }
        else if (originalAngle >= 150 && originalAngle < 180){
            return 6;
        }
        else if (originalAngle >= 180 && originalAngle < 210){
            return 7;
        }
        else if (originalAngle >= 210 && originalAngle < 240){
            return 8;
        }
        else if (originalAngle >= 240 && originalAngle < 270){
            return 9;
        }
        else if (originalAngle >= 270 && originalAngle < 300){
            return 10;
        }
        else if (originalAngle >= 300 && originalAngle < 330){
            return 11;
        }
        else if (originalAngle >= 330 && originalAngle < 360){
            return 12;
        }
        return 0;
    }
}
