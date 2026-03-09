package com.employeeSalary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeSalaryCalculatorTest {

    @Test
    void testValidSalaryCalculation() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(20000, 5000, 10);

        calc.validateSalary();
        assertEquals(27900, calc.calculateNetSalary(), 0.01);
    }

    @Test
    void testHRA() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(20000, 5000, 10);

        assertEquals(4000, calc.calculateHRA(), 0.01);
    }

    @Test
    void testDA() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(20000, 5000, 10);

        assertEquals(2000, calc.calculateDA(), 0.01);
    }

    @Test
    void testGrossSalary() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(20000, 5000, 10);

        assertEquals(31000, calc.calculateGrossSalary(), 0.01);
    }

    @Test
    void testNetSalary() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(20000, 5000, 10);

        assertEquals(27900, calc.calculateNetSalary(), 0.01);
    }

    

    @Test
    void testBasicSalaryZero() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(0, 5000, 10);

        assertThrows(IllegalArgumentException.class, calc::validateSalary);
    }

    @Test
    void testNegativeSalary() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(-10000, 5000, 10);

        assertThrows(IllegalArgumentException.class, calc::validateSalary);
    }

    @Test
    void testInvalidTax() {
        EmployeeSalaryCalculator calc =
                new EmployeeSalaryCalculator(20000, 5000, 150);

        assertThrows(IllegalArgumentException.class, calc::validateSalary);
    }
}

