import java.util.Scanner;

public class DatabaseOperation {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Database[] EmployeesDB = new Database[3];
        Scanner scan = new Scanner(System.in);
        for(int i=0;i< EmployeesDB.length;i++) {
            System.out.printf("Zadáváte informace o pracovníkovi číslo %d ze %d\n", i+1, EmployeesDB.length);

            String workerName = "";
            short birthYear = 0;

            System.out.print("Zadejte pracovníkovo jméno: ");
            if (scan.hasNextLine()) workerName = scan.nextLine();
            System.out.print("Zadejte pracovníkův rok narození: ");
            if (scan.hasNextShort()) birthYear = scan.nextShort();
            EmployeesDB[i] = new Database(workerName, birthYear);
            scan.nextLine();
        }
        System.out.print("Zadejte maximální povolenou výši úvazku: ");
        if (scan.hasNextFloat()) Database.setMaxWorkingTime(scan.nextFloat());

        while (true) {
            for (int i=0;i< EmployeesDB.length;i++)
                printInfoAboutEmployee(EmployeesDB, i);
            if (!scan.hasNextShort())
                continue;
            short choice = scan.nextShort();
            if (choice < 0 || choice >= EmployeesDB.length) {
                System.out.print("Ukončuji.");
                break;
            }
            else {
                if (scan.hasNextFloat()) {
                    if (!EmployeesDB[choice].updateWorkingTime(scan.nextFloat())) {
                        System.out.println("Maximální úvazek již byl dosažen.");
                    }
                    else {
                        System.out.println("Úvazek byl úspěšně změněn.");
                        printInfoAboutEmployee(EmployeesDB, choice);
                    }
                    System.out.println("Stiskněte Enter pro pokračování......");
                    scan.nextLine();
                }
            }


        }

        scan.close();
    }

    static void printInfoAboutEmployee(Database[] EmployeesDB, int index) {
        System.out.printf("%d - %s\n", index, EmployeesDB[index].getInfo());
    }
}