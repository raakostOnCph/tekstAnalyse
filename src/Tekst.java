

public class Tekst
{
    public static String markerAlleMaxOrd(String s)
    {
        String længsteOrd = findMaxOrd(s);
        String længsteOrdMarkeret = markerOrd(længsteOrd);

        String[] ord = tekstSplit(s);
        String tegn = "";

        for (int i = 0; i < ord.length; i++)
        {

            if (rensOrd(ord[i]).equalsIgnoreCase(længsteOrd))
            {

                tegn = specialTegn(ord[i]);
                ord[i] = længsteOrdMarkeret + tegn;
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

        for (int i = 0; i < ord.length; i++)
        {

            String temp = rensOrd(ord[i]);

            if (maxOrd.length() < temp.length())
            {

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

        for (int i = 0; i < ord.length; i++)
        {

            String temp = rensOrd(ord[i]);

            if (maxOrd.length() < temp.length())
            {

                maxOrd = temp;
            }

        }

        return maxOrd;
    }


    public static String rensOrd(String s)
    {

        String tegn = specialTegn(s);

        if (tegn.equals(""))
        {
            return s;
        }
        return s.substring(0, s.length() - 1);

    }


    public static String specialTegn(String s)
    {

        String særligeTegn = ",.";

        String tegn = s.substring(s.length() - 1, s.length());  // klipper det tegn ud

        if (særligeTegn.contains(tegn))
        {    // her ser jeg om det er et , .

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

    // Lix analyse metoder

    public static int lix(String tekst)
    {
        /*
            O = antal ord i teksten
            P = antal punktummer i teksten (antal sætninger)
            L = antal lange ord (over 6 bogstaver lange)
            LIX = O / P + (L * 100) / O
        */
        String[] alleOrd = Tekst.findAlleOrd(tekst);

        int P = findAntalSætninger(tekst);
        int O = findAntalOrd(tekst);
        int L = findAntalLangeOrd(alleOrd);
        int lixtal = O / P + (L * 100) / O;

        return lixtal;
    }

    public static String lixSværhedsgrad(int lixtal)
    {
        if (lixtal < 25)
            return "Let tekst for alle læsere, børnelitteratur";
        else if (lixtal < 35)
            return "Let for øvede læsere, ugebladslitteratur og let skønlitteratur for voksne";
        else if (lixtal < 45)
            return "Middel, dagblade og tidsskrifter.";
        else if (lixtal < 55)
            return "Svær, saglige bøger, populærvidenskabelige værker, akademiske udgivelser.";
        else
            return "Meget svær, faglitteratur på akademisk niveau, lovtekster.";
    }

    public static int findAntalSætninger(String tekst)
    {
        int P = 0;
        for (int i = 0; i < tekst.length(); i++)
        {
            switch (tekst.charAt(i))
            {
                case '.': P++; break;
                case '!': P++; break;
                case ':': P++; break;
                case '?': P++; break;
                case ';': P++; break;
            }
        }
        return P;
    }

    public static int findAntalOrd(String tekst)
    {
        int wordCount = 0;
        boolean isInsideWord = false;
        char currentChar;

        for (int i = 0; i < tekst.length(); i++)
        {
            currentChar = tekst.charAt(i);

            if (isWordCharacter(currentChar))
            {
                if (!isInsideWord)
                {
                    wordCount++;
                    isInsideWord = true;
                }
            } else
            {
                if (isInsideWord)
                {
                    isInsideWord = false;
                }
            }
        }
        return wordCount;
    }

    public static boolean isWordCharacter(char c)
    {
        String ordTegn = "é0123456789abcdefghijklmnopqrstuvwxyzæøåABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        return ordTegn.indexOf(c) != -1;
    }

    public static String[] findAlleOrd(String tekst)
    {
        int L = findAntalOrd(tekst);
        String[] ord = new String[L];
        boolean isInsideWord = false;
        char currentChar;
        int arrayIndex = 0;
        String currentWord = "";

        for (int i = 0; i < tekst.length(); i++)
        {
            currentChar = tekst.charAt(i);

            if (isWordCharacter(currentChar))
            {
                currentWord += currentChar;

                if (!isInsideWord) // Entering a new word
                {
                    isInsideWord = true;
                }
            } else  // Non word characters
            {
                if (isInsideWord)  // On exit from a word boundry
                {
                    ord[arrayIndex] = currentWord;
                    arrayIndex++;
                    isInsideWord = false;
                    currentWord = "";
                }
            }
        }
        return ord;
    }

    public static int findAntalLangeOrd(String[] ord)
    {
        int L = 0;
        for (int i = 0; i < ord.length ; i++)
        {
            if (ord[i].length() >= 7){
                L++;
            }
        }
        return L;
    }

    public static String findAlleOrdOgMarkerDeLange(String[] ordArray){

        String alleOrd = "";
        String næsteOrd = "";

        for (int i = 0; i < ordArray.length ; i++)
        {
            næsteOrd = ordArray[i];
            if (næsteOrd.length() >= 7){
                næsteOrd = Tekst.markerOrd(næsteOrd);
            }
            alleOrd += næsteOrd + " ";
            if ((i + 1) % 15 == 0)
            {
                alleOrd += "\n";
            }
        }
        return alleOrd;
    }
}
