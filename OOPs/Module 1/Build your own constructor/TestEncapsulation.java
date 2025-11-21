// TestEncapsulation class to test the Employee class

public class TestEncapsulation {

    public static void main(String[] args) {
        // Step 1: Create two instances of the Employee class
        // One using the parameterized constructor and one using default constructor with setters
        Employee employee1 = new Employee("Mpho Matseka", 21, 35000);
        Employee employee2 = new Employee("Madara Uchiha", 20, 3000);

        // Step 2: Print details of both employees
        System.out.println("\nInitial Employee Details:");
        System.out.println(employee1);
        System.out.println(employee2);
        // Step 3: Try setting invalid values (null name, age outside range, negative salary)
        // and see if your validation works
        
        System.out.println("Testing validation with invalid values:");
        employee1.setName("");  // Invalid: empty name
        employee1.setAge(700);   // Invalid: age outside range
        employee2.setSalary(-100000); // Invalid: negative salary
        
        System.out.println("\nEmployee Details After Invalid Values:");
        employee1.displayDetails();
        employee2.displayDetails();

        // Step 4: Give both employees a 10% raise and display their details again
        employee1.giveRaise(10);
        employee2.giveRaise(10);
        System.out.println("\nEmployee Details After Raise:");
        employee1.displayDetails();
        employee2.displayDetails();

        // Step 5: Clone the first employee and display the cloned employee details
        // Hint: Use try-catch block to handle CloneNotSupportedException
        // Employee clonedEmployee = (Employee) employee1.clone();
        try {
            Employee clonedEmployee = (Employee) employee1.clone();
            System.out.println("Cloned Employee Details:");
            clonedEmployee.displayDetails();

            // Step 14: Modify the original employee to show clones are separate objects
            System.out.println("Modifying the original employee's salary...");
            employee1.setSalary(6000.0);

            System.out.println("\nOriginal Employee After Modification:");
            employee1.displayDetails();

            System.out.println("Cloned Employee After Original was Modified:");
            clonedEmployee.displayDetails();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported: " + e.getMessage());
        }
        // Step 6: Modify the original employee and verify that the clone remains unchanged
        // This demonstrates that cloning creates a separate object
        String result = compareSalaries(employee1, employee2);
        System.out.println("Salary Comparison Result: " + result);
    }

        // Step 7: Create a method that compares the salaries of two employees
        // and returns the name of the employee with the higher salary
        // If salaries are equal, return "Equal salaries"


    public static String compareSalaries(Employee employee1, Employee employee2) {
        if (employee1.getSalary() > employee2.getSalary()) {
           return employee1.getName() + "has a higher salary";
        } else if (employee1.getSalary() < employee2.getSalary()) {
            return employee2.getName() + "has a higher salary";
        } else {
            return  "Equal salaries";
        }
    }
}
