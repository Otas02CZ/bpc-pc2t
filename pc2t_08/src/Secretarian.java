public class Secretarian extends Employee{
    private int age;

    Secretarian(String name, String email, String password, EmployeeType type, int age) {
        super(name, email, password, type);
    }

    @Override
    public String toString() {
        return "Secretarian [" +
                "\nnickname: " + this.getNickname() +
                "\nemail: " + this.getEmail() +
                "\npassword: " + this.getPassword() +
                "\ntype: " + this.getEmployeeType().toString() +
                "\nage: " +  this.age + "]";
    }

}
