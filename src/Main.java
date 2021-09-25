import java.util.Arrays;


public class Main
{

    public static void main(String[] args)
    {
        // write your code here


        String sætning = "snydetampen. Eller Vaskebjørn alt, ";
        String analyse = "0123456789  12345 0123456789 ";

        String[] ord = tekstSplit(sætning);


//        String s = "0123456789";
//        String subS = s.substring(s.length()-1, s.length() );
//        System.out.println(subS);

        //  System.out.println(specialTegn(ord[0]));


        System.out.println(findMaxOrd(sætning));
        System.out.println(findMaxIndex(sætning));

        //Farver farver = new Farver();
        //String rød = farver.RED_ANSI;
        // String rød = Farver.RED_ANSI;

        System.out.println(markerOrd(ord[0]));
        System.out.println(markerOrd(ord[1]));
        System.out.println(markerOrd(ord[2]));

        System.out.println(markerAlleMaxOrd(sætning));

    }   // her slutter min main;


    public static String markerAlleMaxOrd(String s)
    {
        String længsteOrd = findMaxOrd(s);
        String længsteOrdMarkeret = markerOrd(længsteOrd);

        String[] ord = tekstSplit(s);
        String tegn="";

        for (int i = 0; i < ord.length; i++) {

            if (rensOrd(ord[i]).equalsIgnoreCase(længsteOrd)) {

                tegn = specialTegn(ord[i]);
                ord[i] = længsteOrdMarkeret+tegn;
            }
        }
        return join(ord);
    }


    public static String markerOrd(String s)
    {

        String tegn = specialTegn(s);
        String rensetOrd = rensOrd(s);

        return Farver.RED_ANSI + rensetOrd + Farver.RESET_ANSI + tegn;
    }


    public static int findMaxIndex(String s)
    {

        String[] ord = tekstSplit(s);

        String maxOrd = "";
        int maxIndex = -1;

        for (int i = 0; i < ord.length; i++) {

            String temp = rensOrd(ord[i]);

            if (maxOrd.length() < temp.length()) {

                maxOrd = temp;
                maxIndex = i;
            }
        }
        return maxIndex;

    }

    public static String findMaxOrd(String s)
    {

        String[] ord = tekstSplit(s);

        String maxOrd = "";

        for (int i = 0; i < ord.length; i++) {

            String temp = rensOrd(ord[i]);

            if (maxOrd.length() < temp.length()) {

                maxOrd = temp;
            }

        }

        return maxOrd;
    }


    public static String rensOrd(String s)
    {

        String tegn = specialTegn(s);

        if (tegn.equals("")) {
            return s;
        }
        return s.substring(0, s.length() - 1);

    }


    public static String specialTegn(String s)
    {

        String særligeTegn = ",.";

        String tegn = s.substring(s.length() - 1, s.length());  // klipper det tegn ud

        if (særligeTegn.contains(tegn)) {    // her ser jeg om det er et , .

            return tegn;
        }
        return "";
    }


    // her fra er det de oprindelige metoder.


    public static String join(String[] strings)
    {

        String res = String.join(" ", strings);

        return res;
    }

    public static String[] tekstSplit(String tekst)
    {

        String[] ord = tekst.split(" ");

        return ord;
    }


}
