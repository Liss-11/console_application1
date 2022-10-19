import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to create the Employees yourself? (answer YES or NO)");
        String resp = scanner.nextLine().trim().toLowerCase();
        var myEmployees = new ArrayList<Employee>();
        myEmployees = employeesList(resp);
        printInFile(myEmployees);
        scanner.close();
    }

    public static ArrayList<Employee> employeesList(String resp){

        if (resp.equals("yes")){
            return (manualGenerator());
     /*   }else if (resp.equals("no")){
            return (autoGenerator());*/
        }else
            errorMessage();
        return (null);
    }

    public static ArrayList<Employee> manualGenerator(){
        Scanner scan = new Scanner(System.in);
        var myEmployees = new ArrayList<Employee>();
        for (int i = 0; i < 2; i++) {
            System.out.println("Employees to insert: " + (10 - i));
            System.out.print("Do you want to create an: EMPLOYEE or an INTERN?\nWrite The Type!");
            String type = scan.nextLine().trim().toLowerCase();
            System.out.println("Enter a Employee name: ");
            String name = scan.nextLine();
            System.out.println("Enter a Employee Surname: ");
            String surname = scan.nextLine();
            System.out.println("Enter a Employee age: ");
            int age = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter a Employee DNI (Make sure it is not repeated): ");
            String dni = scan.nextLine();
            if (myEmployees.size() > 0) {
                if (userExists(dni, myEmployees)) errorMessage();
            }
            System.out.println("Enter a Employee Salary: ");
            int salary = scan.nextInt();
            scan.nextLine();
            if (type.equals("employee")) {
                myEmployees.add(new Employee(name, surname, age, dni, salary));
            }
            else if (type.equals("intern")) {
                myEmployees.add(new Intern(name, surname, age, dni, salary));
            }
            else
                errorMessage();
            System.out.println("ADDED Employee " + myEmployees.get(i).getId() +
                    "\n" + name + " " + surname + ", " + age + " years old.\n" +
                    "With DNI: " + dni + " and Salary: " + myEmployees.get(i).getSalary() + "\n");
        }
        scan.close();
        return (myEmployees);
    }



    public static boolean userExists(String dni, ArrayList<Employee> myEmployees){

       for(Employee myEmployee : myEmployees){
           if (myEmployee.getDni().equals(dni))
               return (true);
       }
       return (false);
    }

    public static void errorMessage(){
        System.out.println("Sorry, you answer is no valid");
        System.exit(202);
    }

    public static void printInFile(ArrayList<Employee> myEmployees) throws IOException {
        FileWriter writer = new FileWriter("employees.txt", true);
        for (Employee myEmployee : myEmployees){
            writer.write("EMPLOYEE with id: " + myEmployee.getId() +
                    "\nName: " + myEmployee.getName() +
                    "\nSurname: " + myEmployee.getSurname() +
                    "\nAge: " + myEmployee.getAge() +
                    "\nDNI: " + myEmployee.getDni() +
                    "\nSalary: " + myEmployee.getSalary() + "\n" +
                    "===================================================\n");
        }
        writer.close();
    }

}