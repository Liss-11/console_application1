import java.util.ArrayList;

public class Intern extends Employee{
    private final int SALARY_LIMIT;

    public Intern(String type, String name, String surname, int age, String dni, int salary) {
        super(type, name, surname, age, dni, salary);
        this.SALARY_LIMIT = 20000;
    }

    @Override
    public void setSalary(int salary) {
        if (salary > getSALARY_LIMIT()) super.setSalary(20000);
        else super.setSalary(salary);
    }

    public int getSALARY_LIMIT() {
        return SALARY_LIMIT;
    }
}
