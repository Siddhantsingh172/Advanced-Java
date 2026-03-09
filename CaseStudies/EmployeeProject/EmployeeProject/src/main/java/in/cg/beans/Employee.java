package in.cg.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @Value("101")
    private int empId;

    @Value("Siddhant")
    private String empName;

    @Value("50000")
    private double salary;

    public void display() {

        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee Salary: " + salary);

    }
}