import java.util.ArrayList;
import java.util.List;

public class Manager<T> extends Employee{
    private List<Employee> listOfEmployees = new ArrayList<>();
    private T listOfRelationships;

    Manager(char[] name, char[] email, char[] password, T iden) {
        super(name, email, password);
        this.listOfRelationships = iden;
    }

    public void addEmployee(Employee employee) {
        this.listOfEmployees.add(employee);
    }

    public void printRelationships() {
        System.out.printf("I am manager %s\nMy Secretarian is %s\n", this.getNickname(), this.listOfRelationships);
    }
}
