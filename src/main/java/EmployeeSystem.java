import Employee.Employee;

import java.util.ArrayList;

public class EmployeeSystem {
    ArrayList<Employee> arrEmp = new ArrayList<Employee>();
    private double Salary;

    public void AddEmployee(Employee emp) {
        arrEmp.add(emp);
    }

    public void RemoveEmployee(Employee emp) {
        arrEmp.remove(emp);
    }


    public void RaiseSalaryForAllEmployees(int increment) {
    double salary;
        if (increment < 100 && increment > 0) {
            for (int i = 0; i < arrEmp.size(); i++) {
                Salary = arrEmp.get(i).GetEmployeeSalary();
                Salary = Salary + (Salary * increment) / 100;
                arrEmp.get(i).setSalary(Salary);
            }
        }
    }


    public void RaiseSalary(int CompanyID, int increment) throws Exception {
        //double salary;
        if (increment < 100 && increment > 0) {
            for (int i = 0; i < arrEmp.size(); i++) {
                if (arrEmp.get(i).GetCompanyID() == CompanyID) {
                    Salary = arrEmp.get(i).GetEmployeeSalary();
                    Salary = Salary + ((Salary * increment) / 100);
                    arrEmp.get(i).setSalary(Salary);
                }
            }
        }
    }
}
