package library;

public class Student extends User {

    private String department;

    public Student(String userId, String name, String email, String department) {
        super(userId, name, email);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void displayUser() {
        System.out.println("Student ID: " + getUserId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Department: " + department);
    }

    @Override
    public String toString() {
        return getUserId() + " | "
                + getName() + " | "
                + getEmail() + " | "
                + department;
    }
}