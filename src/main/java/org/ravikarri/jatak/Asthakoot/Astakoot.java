package org.ravikarri.jatak.Asthakoot;

public class Astakoot {
    int boyNak,girlNak,boyRaasi,girlRaasi;
    Constants Arrays = new Constants();
    public Astakoot(int boyNak,int girlNak,int boyRaasi,int girlRaasi){
        this.boyNak = boyNak;
        this.girlNak = girlNak;
        this.boyRaasi = boyRaasi;
        this.girlRaasi = girlRaasi;
    }
    public String getString(){
        return "Varna :"+calcVarnaKoota() +",Bahkut: "+calcBahkut()+",Nadi: "+calcNadi()+",Kuta: "+calcGanaKuta()+",Vasya: "+calcVasyaKoota()+",Maitri: "+calcMaitri()+",Tara: "+calcTara()+",Yoni: "+calcYoni();
    }
    public int calcVarnaKoota(){
        int Bvkpoint = 3,Gvkpoint = 3;
        if (boyRaasi == 4 || boyRaasi == 8 || boyRaasi == 12){
            Bvkpoint = 0;
        }
        if (boyRaasi == 1 || boyRaasi == 5 || boyRaasi == 9){
            Bvkpoint = 1;
        }
        if (boyRaasi == 2 || boyRaasi == 6 || boyRaasi == 10){
            Bvkpoint = 2;
        }
        if (girlRaasi == 4 || girlRaasi == 8 || girlRaasi == 12){
            Gvkpoint = 0;
        }
        if (girlRaasi == 1 || girlRaasi == 5 || girlRaasi == 9){
            Gvkpoint = 1;
        }
        if (girlRaasi == 2 || girlRaasi == 6 || girlRaasi == 10){
            Gvkpoint = 2;
        }


        return Arrays.VarnaArray[Gvkpoint][Bvkpoint];
    }

    public Double calcVasyaKoota() {
        int Bvkpoint = 4, Gvkpoint = 4;
        //Human
        if (boyRaasi == 3 || boyRaasi == 6 || boyRaasi == 7 || boyRaasi == 9 || boyRaasi == 11)    {
            Bvkpoint = 0;
        }
        if (girlRaasi == 3 ||girlRaasi == 6 ||girlRaasi == 7 ||girlRaasi == 9 || girlRaasi == 11)    {
            Gvkpoint = 0;
        }
        //Leo
        if (boyRaasi == 5){
            Bvkpoint = 1;
        }
        if (girlRaasi == 5){
            Gvkpoint = 1;
        }
        //Quadruped
        if (boyRaasi == 1 || boyRaasi == 2 || boyRaasi == 10)    {
            Bvkpoint = 2;
        }
        if (girlRaasi == 1 ||girlRaasi == 2 ||girlRaasi == 10)    {
            Gvkpoint = 2;
        }
        //Jalachara
        if (boyRaasi == 4 || boyRaasi == 10 || boyRaasi == 12)    {
            Bvkpoint = 3;
        }
        if (girlRaasi == 4 ||girlRaasi == 10 ||girlRaasi == 12)    {
            Gvkpoint = 3;
        }

        return Arrays.VasyaArray[Bvkpoint][Gvkpoint];
    }




    public double calcDinaKuta() {
        double res = 0.0;
        int count = (boyNak - girlNak);

        if (count <= 0) {

            count = count + 27;

        }

        count = count % 9;

        // System.out.println(boyNak + " - " + girlNak + " Count : " + count);
        if ((count % 2) == 0) {

            res += 1.5;

        } else {

            res += 0;

        }
        count = (girlNak - boyNak);

        if (count <= 0) {

            count = count + 27;

        }

        count = count % 9;

        // System.out.println(boyNak + " - " + girlNak + " Count : " + count);
        if ((count % 2) == 0) {

            res += 1.5;

        } else {

            res += 0;

        }
        return res;

    }
    public int calcGanaKuta() {

        int boyGana = findGana(boyNak);
        int girlGana = findGana(girlNak);

        return Arrays.GanArray[girlGana][boyGana];

    }

    private int findGana(int nak) {

        int gana = 0;

        switch (nak) {

            case 0:
            case 4:
            case 6:
            case 7:
            case 12:
            case 14:
            case 16:
            case 21:
            case 26:
                gana = 0;

                break;

            case 1:
            case 3:
            case 5:
            case 10:
            case 11:
            case 19:
            case 20:
            case 24:
            case 25:
                gana = 1;

                break;

            case 2:
            case 8:
            case 9:
            case 13:
            case 15:
            case 17:
            case 18:
            case 22:
            case 23:
                gana = 2;

                break;

        }

        return gana;

    }
    public String calcTara()
    {
        int bn = 0;
        int gn = 0;
        int bbn = boyNak+1;
        int bgn = girlNak+1;
        if (bbn<10){
            bn = bbn - 1;
        }
        else if(bbn<=18){
            bn =Integer.parseInt(String.valueOf(bbn).substring(1));
        }
        else{
            bn =Integer.parseInt(String.valueOf(bbn).substring(1))+1;

        }
        if (bgn<10){
            gn = bgn - 1;
        }
        else if(bgn<=18){
            //gn = girlNak - 10;
            gn =Integer.parseInt(String.valueOf(bgn).substring(1));

        }
        else{
            gn =Integer.parseInt(String.valueOf(bgn).substring(1))+1;
        }

        return String.valueOf(Arrays.TaraConst[bn][gn]);
    }




    public String calcYoni(){
        //System.out.println(nakshatra[boyNak] + " " + nakshatra[girlNak]);
        //System.out.println(boyNak + " " + girlNak);
        return String.valueOf(Arrays.YoniArray[Arrays.animalMappings[girlNak]][Arrays.animalMappings[boyNak]]);
    }
    public Double calcMaitri(){
        return Arrays.MaitriArray[Arrays.MaitriMappings[girlRaasi]][Arrays.MaitriMappings[boyRaasi]];
    }
    public int calcBahkut(){
        return Arrays.BahkutArray[girlRaasi-1][boyRaasi-1];

    }
    public int calcNadi(){
        int bv = 2  ,gv = 2 ;

        if (boyNak == 0 || boyNak == 5 ||boyNak == 6 ||boyNak == 11 ||boyNak == 12 ||boyNak == 17 ||boyNak == 18 ||boyNak == 23 ||boyNak == 24){
            bv = 0;
        }
        if (girlNak == 0 || girlNak == 5 ||girlNak == 6 ||girlNak == 11 ||girlNak == 12 ||girlNak == 17 ||girlNak == 18 ||girlNak == 23 ||girlNak == 24){
            gv = 0;
        }
        if (boyNak == 1 || boyNak == 4 ||boyNak == 7 ||boyNak == 10 ||boyNak == 13 ||boyNak == 16 ||boyNak == 19 ||boyNak == 22 ||boyNak == 25){
            bv = 1;
        }
        if (girlNak == 1 || girlNak == 4 ||girlNak == 7 ||girlNak == 10 ||girlNak == 13 ||girlNak == 16 ||girlNak == 19 ||girlNak == 22 ||girlNak == 25){
            gv = 1;
        }

        return Arrays.NadiArray[gv][bv];

    }

}