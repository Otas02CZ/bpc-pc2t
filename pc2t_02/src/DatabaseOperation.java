import java.util.Scanner;

public class DatabaseOperation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("WELCOME TO THE EMPLOYEE DB");
        System.out.print("Define the amount of employees in the db: ");
        while (!scan.hasNextShort()) {
            System.out.println("You should have inputted a number!!");
            scan.nextLine();
            System.out.print("Define the amount of employees in the db: ");
        }
        short tempDBLength = scan.nextShort();
        scan.nextLine();
        Database[] EmployeesDB = new Database[tempDBLength];
        for(int i=0;i< EmployeesDB.length;i++) {
            System.out.printf("Insert info about employee %d out of %d\n", i+1, EmployeesDB.length);
            System.out.print("Insert name of the employee: ");
            while (!scan.hasNextLine()) {
                System.out.println("You should have inputted a string!!");
                scan.nextLine();
                System.out.print("Insert name of the employee: ");
            }
            String workerName = scan.nextLine();
            System.out.print("Insert birth year of the employee: ");
            while (!scan.hasNextShort()) {
                System.out.println("You should have inputted a number!!!!");
                scan.nextLine();
                System.out.print("Insert birth year of the employee: ");
            }
            short birthYear = scan.nextShort();
            scan.nextLine();
            EmployeesDB[i] = new Database(workerName, birthYear);
        }
        System.out.print("Please set max work load: ");
        while (!scan.hasNextFloat()) {
            System.out.println("You should have inputted a decimal number!!!!");
            scan.nextLine();
            System.out.print("Please set max work load: ");
        }
        Database.setMaxWorkLoad(scan.nextFloat());
        scan.nextLine();

        while (true) {
            for (int i=0;i< EmployeesDB.length;i++)
                printInfoAboutEmployee(EmployeesDB, i);
            System.out.printf("Max possible workload is %f\n", Database.getMaxWorkLoad());
            System.out.println("Please specify employee index to edit or < 0 to exit:");
            if (!scan.hasNextShort()){
                System.out.println("You should have inputted a number!!!!");
                scan.hasNextLine();
                System.out.println("Please specify employee index to edit or <= 0 to exit:");
            }
            short choice = scan.nextShort();
            scan.nextLine();
            if (choice < 0 || choice >= EmployeesDB.length) {
                System.out.print("Shutting down.");
                break;
            }
            else {
                System.out.println("Please specify by how much would you like to increase the work load: ");
                if (scan.hasNextFloat()) {
                    if (!EmployeesDB[choice].updateWorkload(scan.nextFloat())) {
                        System.out.println("Maximal work load was reached.");
                    }
                    else {
                        System.out.println("Work load successfully changed");
                        printInfoAboutEmployee(EmployeesDB, choice);
                    }
                    System.out.println("Press enter to continue ...... ");
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