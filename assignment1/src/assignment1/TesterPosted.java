package assignment1;

import java.math.BigInteger;

public class TesterPosted {

    public static void main(String[] args) throws Exception {

        // You can test the correctness of your NaturalNumber implementation
        // by using Java's BigInteger class.

        // Here is an example.

    	int base = 10;
    	String s1 = "10";
    	String s2 = "10";
        boolean failure = false;

        for (int i = 0; i < 32; i++) {

            switch(i) {
                case 0:
                    base = 5;
                    s1 = "10341034212313023410320320410303402034103024013204133240341304303403403240130432401320130241020230410023403203034030430234102311014410430104021023410324031023403231012132010333013131003430241302124030130231403241021023102341023402340310310234024302431024132130213214324310412430241324302431024130243102420410322430011021030303303030330034040302432043234103020334100441330303330334410103201031010101003340403300330341024134030300303033033000414302413023102430314141414412412124212142341322412130343040303403040104100041041014014014100413014141041004124324322414212323204101401432310204241030430204230343404203403232432032304021024243240324132430232302042432342032030302132030241323132132023424123231200230402342042043021021204301131243124104043132141411414143023412412432323023023042042042302303012142042420320310320230403424301302031242042030420423042342001302042132234324120320302032322032302042132303003302020320323132203042422023123324103243243202323212302342303030403241032244232323233233333333333333333333333333333333333333333333333333333332";
                    s2 = "4204204130133031034132122443401142422441401341212422441414121012242424214433124301323423132034032";
                    break;
                case 1:
                    base = 8;
                     s1 = "42345614234561000343453440000343453440";
                     s2 = "22320000423456100034345344000042";
                    break;
                case 2:
                    base = 9;
                     s1 = "880";
                     s2 = "88";
                    break;
                case 3:
                    base = 3;
                     s1 = "221020";
                     s2 = "22000";
                    break;
                case 4:
                    base = 5;
                     s1 = "1234321";
                     s2 = "201";
                    break;
                case 5:
                    base = 9;
                     s1 = "12300020004323442312312115464234504500043";
                     s2 = "12543434244054320474788282201540";
                    break;
                case 6:
                    base = 7;
                     s1 = "12364040420";
                     s2 = "10445412";
                    break;
                case 7:
                    base = 2;
                     s1 = "10101000101001";
                     s2 = "10001010101111";
                    break;
                case 8:
                    base = 6;
                     s1 = "11212353550";
                     s2 = "11212353550";
                    break;
                case 9:
                    base = 10;
                     s1 = "10101000100102";
                     s2 = "100234578377";
                    break;
                case 10:
                    base = 2;
                     s1 = "1000000000000000000000000000000000000000001";
                     s2 = "101";
                    break;
                case 11:
                    base = 4;
                     s1 = "222222222";
                     s2 = "22222";
                    break;
                case 12:
                    base = 6;
                     s1 = "12355055005";
                     s2 = "4000044204";
                    break;
                case 13:
                    base = 8;
                     s1 = "7212453415123434535343435312133453421001104045340";
                     s2 = "3";
                    break;
                case 14:
                    base = 10;
                     s1 = "10";
                     s2 = "10";
                    break;
                case 15:
                    base = 3;
                     s1 = "202000110210";
                     s2 = "220";
                    break;
                case 16:
                    base = 5;
                     s1 = "444444444444444";
                     s2 = "404040101010";
                    break;
                case 17:
                    base = 7;
                     s1 = "1024165301101450011110151200404045024240";
                     s2 = "1024165301101450011110151200404045024240";
                    break;
                case 18:
                    base = 9;
                     s1 = "233023120214450";
                     s2 = "300245534";
                    break;
                case 19:
                    base = 10;
                     s1 = "4384539500000";
                     s2 = "100";
                    break;
                case 20:
                    base = 2;
                    s1 = "100110101010100110";
                    s2 = "10101101010";
                    break;
                case 21:
                    base = 3;
                    s1 = "12011221121211201200102010210201201202101201012021010120120122";
                    s2 = "120212211201201201201201020120120";
                    break;
                case 22:
                    base = 4;
                    s1 = "33032102312303213203210231021323200120";
                    s2 = "1";
                    break;
                case 23:
                    base = 5;
                    s1 = "3214042033440043030030332100020";
                    s2 = "1000000000";
                    break;
                case 24:
                    base = 6;
                    s1 = "3051212401010101010030302022504202000000000";
                    s2 = "10101010202020303030";
                    break;
                case 25:
                    base = 7;
                    s1 = "106654000351313543206516503016661351013003013530000001";
                    s2 = "222222525223200030000530541";
                    break;
                case 26:
                    base = 8;
                    s1 = "1520741630254123654743654230365252412652547420265254202545654125425425236541236541254741252365235420";
                    s2 = "2";
                    break;
                case 27:
                    base = 9;
                    s1 = "74102586321456252020202020225414528528526362852582174141251251200000000000000008";
                    s2 = "8888888844520322";
                    break;
                case 28:
                    base = 10;
                    s1 = "986506549865069874131676984208763125648796541202529204938969645202258968245785248";
                    s2 = "10";
                    break;
                case 29:
                    base = 5;
                    s1 = "121332121321212141412220023211102141232014123202220140001";
                    s2 = "430120";
                    break;
                case 30:
                    base = 10;
                    s1 = "200";
                    s2 = "4";
                    break;
                case 31:
                    base = 5;
                    s1 = "10";
                    s2 = "10";
                    break;
            }

            BigInteger big1 = new BigInteger(s1, base);
            BigInteger big2 = new BigInteger(s2, base);

            NaturalNumber n1 = new NaturalNumber(s1, base);
            NaturalNumber n2 = new NaturalNumber(s2, base);

            System.out.println("==========================================================" + i);
            System.out.println("n1 is    " + n1);
            System.out.println("n2 is    " + n2);
            System.out.println();

            // The BigInteger class uses an 'add' method for addition, but NaturalNumber uses 'plus'
            // instead, to avoid confusion with the LinkedList's 'add' method which inserts an element.
            String bigP = big1.add(big2).toString(base);
            NaturalNumber natP = n1.plus(n2);
            if (!("(" + bigP + ")_" + base).equals(natP.toString())) {
                System.out.println("sum: big1+big2 =        (" + bigP + ")_" + base);
                System.out.println("sum: n1+n2     =        " + natP);
                System.out.println();
                failure = true;
            }

            // The BigInteger class uses a 'subtract' method for addition, but NaturalNumber uses
            // 'minus' instead.  This name was chosen because it was a better match for 'plus'.
            String bigM = big1.subtract(big2).toString(base);
            NaturalNumber natM = n1.minus(n2);
            if (!("(" + bigM + ")_" + base).equals(natM.toString())) {
                System.out.println("diff: big1-big2 =       (" + bigM + ")_" + base);
                System.out.println("diff: n1-n2     =       " + natM);
                System.out.println();
                failure = true;
            }

            // The BigInteger class uses a 'multiply' method for addition. NaturalNumber
            // uses 'times' instead.
            String bigT = big1.multiply(big2).toString(base);
            NaturalNumber natT = n1.times(n2);
            if (!("(" + bigT + ")_" + base).equals(natT.toString())) {
                System.out.println("multiply: big1*big2  =  (" + bigT + ")_" + base);
                System.out.println("multiply: n1*n2      =  " + natT);
                System.out.println();
                // System.out.println("slow multiply: n1*n2 =  " + n1.slowTimes(n2));
                // System.out.println(n1.slowTimes(n2));
                // System.out.println();
                failure = true;
            }

            // The BigInteger class uses a 'divide' method for addition. NaturalNumber
            // uses 'divide' instead.
            String bigD = big1.divide(big2).toString(base);
            NaturalNumber natD = n1.divide(n2);
            if (!("(" + bigD + ")_" + base).equals(natD.toString())) {
                System.out.println("divide: big1/big2  =     (" + bigD + ")_" + base);
                System.out.println("divide: n1/n2      =     " + natD);
                System.out.println();
                // System.out.println("slow divide: n1/n2 =     " + n1.slowDivide(n2));
                // System.out.println(n1.slowDivide(n2));
                // System.out.println();
                failure = true;
            }

            /*   mod
            System.out.print("mod = ");
            System.out.println(big1.subtract(big1.divide(big2).multiply(big2)));
            System.out.println(big1.mod(big2));
            */

        }

        if (failure) {
            System.out.println("You can't do anything right.");
        } else {
            System.out.println("Kiet.");
            }
    }
}
