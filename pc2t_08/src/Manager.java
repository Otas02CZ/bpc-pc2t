import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Manager<T> extends Employee{
    private List<Employee> listOfEmployees = new ArrayList<Employee>();
    private List<T> listOfRelationships = new ArrayList<T>();

    Manager(String name, String email, String password, EmployeeType type, T iden) {
        super(name, email, password, type);
        this.listOfRelationships.add(iden);
    }

    @Override
    public String toString() {
        String relationships = "";
        String employees = "";
        for (Employee employee : this.listOfEmployees) {
            employees += employee.toString() + ",\n";
        }
        for (T object : this.listOfRelationships) {
            relationships += object.toString() + ",\n";
        }
        return "Manager [" +
                "\nnickname: " + this.getNickname() +
                "\nemail: " + this.getEmail() +
                "\npassword: " + this.getPassword() +
                "\ntype: " + this.getEmployeeType().toString() +
                "\nrelationships: " + relationships  +
                "\nemployees: " + employees + "]";
    }

    public void addEmployee(Employee employee) {
        this.listOfEmployees.add(employee);
    }
    public void sortEmployeesByEmail() {
        this.listOfEmployees.sort((o1, o2) -> o1.getEmail().compareTo(o2.getEmail()));
    }
}