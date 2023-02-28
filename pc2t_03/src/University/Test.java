package University;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BPC1 bpc1 = new BPC1();
        BPC2 bpc2 = new BPC2();
        BPIS bpis = new BPIS();
        System.out.println("VUT STUDIS 0.1a");
        System.out.println("Vítejte v informačním systému.");


        System.out.println("Předmět BPC1");
        while (true) {
            System.out.printf("Zadejte body za cviceni %s nebo zaporne cislo pro ukonceni: ", bpc1.getSubjectName());
            while (!sc.hasNextShort()) {
                System.out.println("Mel jste zadat male cislo.");
                sc.nextLine();
                System.out.printf("Zadejte body za cviceni %s: ", bpc1.getSubjectName());
            }
            short input = sc.nextShort();
            if (input < 0)
                break;
            if (bpc1.addPointsForExercise(input))
                System.out.println("Body uspesne udeleny.");
            else
                System.out.println("Chyba pri pridavani bodu. Zaporne cislo nebo jich je moc.");
        }
        if (bpc1.canCreditBeGiven()) {
            System.out.printf("V predmetu %s mame %d bodu za cviceni, zapocet muze byt udelen.", bpc1.getSubjectName(), (int) (bpc1.getSubjectPoints()));
            System.out.printf("Zadejte body za zkousku %s: ", bpc1.getSubjectName());
            while (!sc.hasNextShort()) {
                System.out.println("Mel jste zadat male cislo.");
                sc.nextLine();
                System.out.printf("Zadejte body za zkousku %s: ", bpc1.getSubjectName());
            }
            if (bpc1.addPointsForExam(sc.nextShort()))
                System.out.println("Body za zkousku uspesne udeleny.");
            else
                System.out.println("Chyba pri pridavani bodu. Zaporne cislo nebo jich je moc.");
        }
        else
            System.out.printf("V predmetu %s mame %d bodu za cviceni, zapocet nemuze byt udelen.", bpc1.getSubjectName(), (int)(bpc1.getSubjectPoints()));

        System.out.println("Předmět BPC2");
        System.out.printf("Zadejte body za projekt %s: ", bpc2.getSubjectName());
        while (!sc.hasNextShort()) {
            System.out.println("Mel jste zadat male cislo.");
            sc.nextLine();
            System.out.printf("Zadejte body za projekt %s: ", bpc2.getSubjectName());
        }
        if (bpc2.addPointsForProject(sc.nextShort()))
            System.out.println("Body uspesne udeleny.");
        else
            System.out.println("Chyba pri pridavani bodu. Zaporne cislo nebo jich je moc.");

        System.out.printf("Zadejte body za pulsemestralni zkousku %s: ", bpc2.getSubjectName());
        while (!sc.hasNextShort()) {
            System.out.println("Mel jste zadat male cislo.");
            sc.nextLine();
            System.out.printf("Zadejte body za projekt %s: ", bpc2.getSubjectName());
        }
        if (bpc2.addPointsForHalfSemesterExam(sc.nextShort()))
            System.out.println("Body uspesne udeleny.");
        else
            System.out.println("Chyba pri pridavani bodu. Zaporne cislo nebo jich je moc.");
        if (bpc2.canCreditBeGiven()) {
            System.out.printf("V predmetu %s mame %d bodu za cviceni, zapocet muze byt udelen.", bpc2.getSubjectName(), (int)(bpc2.getSubjectPoints()));
            System.out.printf("Zadejte body za zkousku %s: ", bpc2.getSubjectName());
            while (!sc.hasNextShort()) {
                System.out.println("Mel jste zadat male cislo.");
                sc.nextLine();
                System.out.printf("Zadejte body za zkousku %s: ", bpc2.getSubjectName());
            }
            if (bpc2.addPointsForExam(sc.nextShort()))
                System.out.println("Body za zkousku uspesne udeleny.");
            else
                System.out.println("Chyba pri pridavani bodu. Zaporne cislo nebo jich je moc.");

        }
        else
            System.out.printf("V predmetu %s mame %d bodu za cviceni, zapocet nemuze byt udelen.", bpc2.getSubjectName(), bpc2.getSubjectPoints());

        System.out.println("Předmeť BPIS");
        System.out.printf("Chcete udelit zapocet v predmetu %s a/jine:", bpis.getSubjectName());
        sc.nextLine();
        if (sc.nextLine().equals("a"))
            bpis.giveCredit();
        if (bpis.isCreditGiven())
            System.out.print("V predmetu BPIS byl zapocet udelen");
        else
            System.out.print("V predmetu BPIS nebyl zapocet udelen");
    }
}
