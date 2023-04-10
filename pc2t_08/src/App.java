public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Employee employee_1 = new Employee("Pavel".toCharArray(), "blebt", "ijkl");
        Employee employee_2 = new Employee();
        Employee employee_3 = new Employee();
        Employee employee_4 = new Employee();
        Employee employee_5 = new Employee();
        Secretarian secretarian_1 = new Secretarian();
        Secretarian secretarian_2 = new Secretarian();
        Manager<Secretarian> manager = new Manager<Secretarian>(secretarian_2);
    }
}