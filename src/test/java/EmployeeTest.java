import Employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class EmployeeTest {
    EmployeeSystem ps = new EmployeeSystem();
    Employee emp1;
    Employee emp2;
    Employee emp3;
    Employee emp4;
    Employee emp5;

    @Test
    @DisplayName("Testing by adding the employees list")
    public void AddEmployee() {
        Employee emp1 = new Employee("manish", "rajpal", 48, 22500);
        ps.AddEmployee(emp1);
        Employee emp2 = new Employee("Anand", "ravi", 25, 45000);
        ps.AddEmployee(emp2);
        Employee emp3 = new Employee("Priya ", "Palli", 36, 38000);
        ps.AddEmployee(emp3);
        Employee emp4 = new Employee("Ravii", "nair", 35, 34000);
        ps.AddEmployee(emp4);
        Employee emp5 = new Employee("pooja", "Shirango", 33, 45000);
        ps.AddEmployee(emp5);
        Assertions.assertEquals(5, ps.arrEmp.size());
        int size = ps.arrEmp.size();
        ps.RemoveEmployee(emp5);
        //assertEquals(size - 1,ps.arrEmp.size());

        Assertions.assertEquals(4, ps.arrEmp.size());
    }

    
    @Test
    public void RaiseSalaryForAllEmployees(){
        AddEmployeeList();
        ps.RaiseSalaryForAllEmployees(50);
        Assertions.assertEquals(57000,ps.arrEmp.get(2).GetEmployeeSalary());
    }
    @Test
    @DisplayName("Here we test the increaes in salary for all employees")
    public void RaiseSalary() throws Exception {
        AddEmployeeList();
        ps.RaiseSalary(1,10);
        Assertions.assertEquals(34000,ps.arrEmp.get(0).GetEmployeeSalary());

        ps.RaiseSalary(2,20);
        Assertions.assertEquals(45000,ps.arrEmp.get(1).GetEmployeeSalary());

        ps.RaiseSalary(3,20);
        Assertions.assertEquals(38000,ps.arrEmp.get(2).GetEmployeeSalary());

        ps.RaiseSalary(4,50);
        Assertions.assertEquals(34000,ps.arrEmp.get(3).GetEmployeeSalary());

        ps.RaiseSalary(5,10);
        Assertions.assertEquals(45000,ps.arrEmp.get(4).GetEmployeeSalary());
    }

}
