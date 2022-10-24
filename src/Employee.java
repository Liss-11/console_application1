import java.util.ArrayList;

public class Employee {
    private static int numberEmployees = 1;
    private static ArrayList<String> allDni = new ArrayList<>();

    private String type;
    private int id;
    private String name;
    private String surname;
    private int age;
    private String dni;
    private int salary;

    public Employee(String type, String name, String surname, int age, String dni, int salary) {
        this.type = type;
        this.id = numberEmployees++;
        this.name = name;
        this.surname = surname;
        this.age = age;
        setDni(dni);
        setSalary(salary);
        this.allDni.add(dni);

    }

    public ArrayList<String> getAllDni(){
        return allDni;
    }

  /*  public void setId(int id){
        this.id = id;
    }*/

    public int getId() {
        return id;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){return type;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni.length() != 9) {
            System.out.println("User " + name + " " + surname + ", has incorrect document format, it has to contain 9 characters!\n" +
                    "We can't add it");
            this.dni = "NO VALID";
            numberEmployees--;
        }else if (getAllDni().contains(dni)){
            System.out.println("User " + name + " " + surname + ", has a DNI that already exists in the DataBase, we can't add it!");
            this.dni = "NO VALID";
            numberEmployees--;
        }else{
            this.dni = dni;
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
