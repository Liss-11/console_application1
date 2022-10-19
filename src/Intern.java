public class Intern extends Employee{
    private final int SALARY_LIMIT;

    public Intern(String name, String surname, int age, String dni, int salary) {
        super(name, surname, age, dni, salary);
        this.SALARY_LIMIT = 20000;
    }

    @Override
    public void setSalary(int salary) {
        System.out.println("intern");
        if (salary > 20000) super.setSalary(20000);
        else super.setSalary(salary);
    }

    public int getSALARY_LIMIT() {
        return SALARY_LIMIT;
    }
}
