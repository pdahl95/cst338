package Project1;

public class Instructor {

    private int employeeNum;
    private String name;
    private String email;
    private String phoneNumber;

    public Instructor(int employeeNum, String name, String email, String phoneNumber) {
        this.employeeNum = employeeNum;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString(){
        return "\t" + name + "\n";
    }
}
