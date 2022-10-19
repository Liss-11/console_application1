public class Employee {
    private static int numberEmployees = 1;
    private int id;
    private String name;
    private String surname;
    private int age;
    private String dni;
    private int salary;

    public Employee(String name, String surname, int age, String dni, int salary) {
        this.id = numberEmployees++;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dni = dni;
        setSalary(salary);
    }


    public int getId() {
        return id;
    }

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
        this.dni = dni;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        System.out.println("soy el PAPA");
        this.salary = salary;
    }
}
