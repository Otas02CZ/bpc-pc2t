public class Employee {
    private char[] nickname;
    private char[] email;
    private char[] password;
    private EmployeeType employeeType;

    Employee(char[] name, char[] email, char[] password) {
        this.nickname = name;
        this.email = email;
        this.password = password;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }
    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public char[] getPassword() {
        return password;
    }
    public void setPassword(char[] password) {
        this.password = password;
    }

    public char[] getEmail() {
        return email;
    }
    public void setEmail(char[] email) {
        this.email = email;
    }

    public char[] getNickname() {
        return nickname;
    }
    public void setNickname(char[] nickname) {
        this.nickname = nickname;
    }
}
