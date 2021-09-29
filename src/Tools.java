import java.io.*;
import java.util.Scanner;

public class Tools
{
    public static int getInt(String s)
    {

        int tal = 0;

        while (true) {
            try {
                String svar = getString(s);
                tal = Integer.parseInt(svar);   // hvis det fejler, så springer jeg brak linjen over og griber
                // fejlen.

                break;  // her hopper jeg ud af mit while loop terminerer funktionen.

            } catch (NumberFormatException e) {
                System.out.println("husk ikke et tal ord");
            }
        }


        return tal;

    }

    public static String getString(String s)
    {

        udskriv(s);
        Scanner scanner = new Scanner(System.in);

//        String res = scanner.nextLine();
//        return  res;

        return scanner.nextLine();

    }

    public static void udskriv(String s)
    {
        System.out.print(s + " : ");
    }

    public static void udskriv(int i)
    {
        System.out.print(i + " : ");
    }

    public static String smartFilLæsning()
    {

        while (true) {
            String filnavn = getString("angiv filnavn eller tryk q for quit");
            String tekst = læsFil(filnavn);
            if (!tekst.equals("filen fandtes ikke")) {

                return tekst;

            }
            if (filnavn.equalsIgnoreCase("q")) {
                return "ingen fil er valgt";
            }
        }


    }

    public static String læsFil(String filNavn)
    {

        File file = new File(filNavn);

        String res = "";

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {

            res = res  + scanner.nextLine() + "\n";

            }

            return res;



            // kan du skrivet line 28-29 i linje.


        } catch (FileNotFoundException e) {

            return "filen fandtes ikke";
        }


    }

    public static boolean skrivFil(String text, String filNavn)
    {

        try {

            Writer writer = new FileWriter(filNavn);
            writer.write(text);
            writer.flush();
            return true;

        } catch (IOException e) {
            return false;
        }

    }
}