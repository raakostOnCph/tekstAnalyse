public class Main
{

    public static void main(String[] args)
    {
        nikolajUge4();
        jonUge5Lix();


    }   // her slutter min main;

    private static void jonUge5Lix()
    {
        System.out.println("*********** Gitte lix tekstanalyse ****************");
        String tekst = Tools.læsFil("gitte.txt");
        System.out.println("Længde: " + tekst.length() + " tegn");
        System.out.println("Antal sætninger: " + Tekst.findAntalSætninger(tekst));
        System.out.println("Antal ord: " + Tekst.findAntalOrd(tekst));
        String[] alleOrd = Tekst.findAlleOrd(tekst);
        System.out.println("Antal lange ord: " + Tekst.findAntalLangeOrd(alleOrd));
        System.out.println("Lix-tal: " + Tekst.lix(tekst));
        System.out.println(Tekst.findAlleOrdOgMarkerDeLange(alleOrd));
        //System.out.println(Tekst.findAlleOrdOgMarkerDeLange(Tekst.tekstSplit(tekst)));

    }

    private static void nikolajUge4()
    {
        String sætning = "snydetampen. Eller Vaskebjørn alt, ";
        String analyse = "0123456789  12345 0123456789 ";

        String[] ord = Tekst.tekstSplit(sætning);

//        String s = "0123456789";
//        String subS = s.substring(s.length()-1, s.length() );
//        System.out.println(subS);

        //  System.out.println(specialTegn(ord[0]));

        System.out.println(Tekst.findMaxIndex(sætning));
        System.out.println(Tekst.findMaxOrd(sætning));

        //Farver farver = new Farver();
        //String rød = farver.RED_ANSI;
        // String rød = Farver.RED_ANSI;

        System.out.println((Tekst.markerOrd(ord[0])));
        System.out.println(Tekst.markerOrd(ord[1]));
        System.out.println(Tekst.markerOrd(ord[2]));

        System.out.println(Tekst.markerAlleMaxOrd(sætning));
    }


}
