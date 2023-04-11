import java.io.IOException;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Employee employee_1 = new Employee("Peter", "example.com", "petko123", EmployeeType.ACTIVE);
        Employee employee_2 = new Employee("Pavel", "mojMail", "456", EmployeeType.ACTIVE);
        Employee employee_3 = new Employee("Čučoriedka", "tvojMail", "789", EmployeeType.ACTIVE);
        Employee employee_4 = new Employee("Gustav", "gustavko@net.com", "", EmployeeType.ACTIVE);
        Employee employee_5 = new Employee("Emilek", "emilian@domain.blebt", "blebt", EmployeeType.ACTIVE);
        Secretarian secretarian_1 = new Secretarian("Petra", "sekretar.petra@firma.cz", "petruska123", EmployeeType.ACTIVE, 99);
        Secretarian secretarian_2 = new Secretarian("Petra", "sekretar.petra@firma.cz", "petruska123", EmployeeType.ACTIVE, 99);
        Manager<Secretarian> manager = new Manager<Secretarian>("Ota", "otasik@kastan.comunicate", "1234567890", EmployeeType.ACTIVE, secretarian_1);
        manager.addEmployee(employee_1);
        manager.addEmployee(employee_2);
        manager.addEmployee(employee_3);
        manager.addEmployee(employee_4);
        manager.addEmployee(employee_5);
        manager.sortEmployeesByEmail();
        System.out.print(manager.toString());

        Cat terka = new Cat();
        Dog ferda = new Dog();
        Pig pepa = new Pig();
        Cow klara = new Cow();
        Goat jolanda = new Goat();

        terka.sound();
        ferda.sound();
        pepa.sound();
        klara.sound();
        jolanda.sound();

        CatImpl terka1 = new CatImpl();
        DogImpl ferda1 = new DogImpl();
        PigImpl pepa1 = new PigImpl();
        CowImpl klara1 = new CowImpl();
        GoatImpl jolanda1 = new GoatImpl();

        terka1.sound();
        ferda1.sound();
        pepa1.sound();
        klara1.sound();
        jolanda1.sound();
        try
        {
            terka1.writeMeToFile();
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}