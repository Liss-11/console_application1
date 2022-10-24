import java.io.FileNotFoundException;
import java.io.FileReader;
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

    public static ArrayList<Employee> employeesList(String resp) throws FileNotFoundException {

        if (resp.equals("yes")){
            return (manualGenerator());
       }else if (resp.equals("no")){
            return (autoGenerator());
        }else{
            System.out.println("This option is not Available. Have a nice Day!!");
            System.exit(404);
        }
        return (null);
    }

    public static ArrayList<Employee> manualGenerator(){
        Scanner scan = new Scanner(System.in);
        var myEmployees = new ArrayList<Employee>();
        for (int i = 0; i < 10; i++) {
            System.out.println("Employees to insert: " + (10 - i));
            System.out.print("Write the type you want to create: an EMPLOYEE or an INTERN\n");
            String type = scan.nextLine().trim().toLowerCase();
            if(type.equals("employee") || (type.equals("intern"))){
                System.out.println("Enter a " + type + " name: ");
                String name = scan.nextLine();
                System.out.println("Enter a " + type + " Surname: ");
                String surname = scan.nextLine();
                System.out.println("Enter a " + type + " age: ");
                int age = scan.nextInt();
                scan.nextLine();
                System.out.println("Enter a " + type + " DNI (Make sure it is not repeated): ");
                String dni = scan.nextLine();
                System.out.println("Enter a " + type + " Salary: ");
                int salary = scan.nextInt();
                scan.nextLine();
                if (type.equals("employee")) {
                    myEmployees.add(new Employee(type, name, surname, age, dni, salary));
                } else {
                    myEmployees.add(new Intern(type, name, surname, age, dni, salary));
                }

                if (myEmployees.get(i).getDni().equals("NO VALID")) {
                    myEmployees.remove(myEmployees.size() - 1);
                    i--;
                } else {
                    System.out.println("ADDED " + type + " with ID  " + myEmployees.get(i).getId() +
                            "\n" + name + " " + surname + ", " + age + " years old.\n" +
                            "DNI: " + dni + " and Salary: " + myEmployees.get(i).getSalary() + "\n");
                }
            }else {
                System.out.println("This type of user is INVALID, it has to be an \"employee\" or an \"intern\" !");
                i--;
            }
        }
        scan.close();
        return (myEmployees);
    }

    public static ArrayList<Employee> autoGenerator() throws FileNotFoundException {
        ArrayList<Employee> myEmployees = new ArrayList<>();
        FileReader myFile = new FileReader("users_information.csv");
        Scanner reader = new Scanner(myFile);
        int i = 0;
        while (reader.hasNextLine() && i < 11) {
            String [] usr = reader.nextLine().split(", ");
            if (usr[0].trim().equalsIgnoreCase("employee") ||
                    usr[0].trim().equalsIgnoreCase("intern")) {

                if (usr[0].trim().equalsIgnoreCase("employee")) {
                    myEmployees.add(new Employee(usr[0], usr[1], usr[2], Integer.parseInt(usr[3]),
                            usr[4], Integer.parseInt(usr[5])));
                } else if (usr[0].trim().equalsIgnoreCase("intern")) {
                    myEmployees.add(new Intern(usr[0], usr[1], usr[2], Integer.parseInt(usr[3]),
                            usr[4], Integer.parseInt(usr[5])));
                }

                if (myEmployees.get(i).getDni().equals("NO VALID")) {
                    myEmployees.remove(myEmployees.size() - 1);
                    i--;
                }
                i++;
            }else{
                System.out.println("This type of user is INVALID, it has to be an \"employee\" or an \"intern\" !");
                i--;
            }
        }
        reader.close();
        return myEmployees;
    }

    public static void printInFile(ArrayList<Employee> myEmployees) throws IOException {
        FileWriter writer = new FileWriter("employees.txt", true);
        for (Employee myEmployee : myEmployees){
            writer.write(myEmployee.getType() + " with id: " + myEmployee.getId() +
                    "\nName: " + myEmployee.getName() + " " + myEmployee.getSurname() +
                    "\nAge: " + myEmployee.getAge() +
                    "\nDNI: " + myEmployee.getDni() +
                    "\nSalary: " + myEmployee.getSalary() + "\n" +
                    "===================================================\n");
        }
        writer.close();
    }

}