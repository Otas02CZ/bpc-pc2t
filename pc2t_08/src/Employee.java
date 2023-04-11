public class Employee {
    private String nickname;
    private String email;
    private String password;
    private EmployeeType employeeType;

    Employee(String name, String email, String password, EmployeeType type) {
        this.nickname = name;
        this.email = email;
        this.password = password;
        this.employeeType = type;
    }

    @Override
    public String toString() {
        return "Employee [" +
                "\nnickname: " + this.nickname +
                "\nemail: " + this.email +
                "\npassword: " + this.password +
                "\ntype: " + this.employeeType.toString() + "]";
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }
    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
