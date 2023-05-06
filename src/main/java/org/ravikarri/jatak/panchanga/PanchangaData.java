package org.ravikarri.jatak.panchanga;

import org.ravikarri.jatak.graha.GrahaData;

public class PanchangaData {
    private GrahaData gd;
    protected String[] month={"January","February","March","April","May","June",
            "July","August","September","October","November","December"};

    protected String[] rashi={"Mesha","Vrishabha","Mithuna","Karka","Simha","Kanya","Tula",
            "Vrischika","Dhanu","Makara","Kumbha","Meena"};

    protected String[] day={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    protected String[] tithi={"Prathame","Dwithiya","Thrithiya","Chathurthi","Panchami",
            "Shrashti","Saptami","Ashtami","Navami","Dashami","Ekadashi",
            "Dwadashi","Thrayodashi","Chaturdashi","Poornima","Prathame",
            "Dwithiya","Thrithiya","Chathurthi","Panchami","Shrashti",
            "Saptami","Ashtami","Navami","Dashami","Ekadashi","Dwadashi",
            "Thrayodashi","Chaturdashi","Amavasya"};

    protected String[] karan={"Bava","Balava","Kaulava","Taitula","Garija","Vanija",
            "Visti","Sakuni","Chatuspada","Naga","Kimstughna"};

    protected String[] yoga={"Vishkambha","Prithi","Ayushman","Saubhagya","Shobhana",
            "Atiganda","Sukarman","Dhrithi","Shoola","Ganda","Vridhi",
            "Dhruva","Vyaghata","Harshana","Vajra","Siddhi","Vyatipata",
            "Variyan","Parigha","Shiva","Siddha","Sadhya","Shubha","Shukla",
            "Bramha","Indra","Vaidhruthi"};

    protected String[] nakshatra={"Ashwini","Bharani","Krittika","Rohini","Mrigashira","Ardhra",
            "Punarvasu","Pushya","Ashlesa","Magha","Poorva Phalguni","Uttara Phalguni",
            "Hasta","Chitra","Swathi","Vishaka","Anuradha","Jyeshta","Mula",
            "Poorva Ashada","Uttara Ashada","Sravana","Dhanishta","Shatabisha",
            "Poorva Bhadra","Uttara Bhadra","Revathi"};

    public PanchangaData(GrahaData gd){
        this.gd = gd;
        calculatePanchang();
    }

    private void calculatePanchang() {
        String tithi = calculateTithi();
        System.out.println(tithi);
        //calculateNakshatra();
        //calculateBhava();
        //calculateYoga();
        //calculateRashi();
    }
    private String calculateTithi() {
     return "";
    }
}
