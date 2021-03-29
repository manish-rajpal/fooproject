package Employee;

public class Employee {
    String FirstName;
    String LastName;
    int Age;
    int CompanyID;
    double Salary;
    private static int counter=0;

    public Employee(String F_Name , String L_Name, int emp_Age,double Sal) {
        counter = counter + 1;
        FirstName=F_Name;
        LastName=L_Name;
        Age = emp_Age;
        Salary = Sal;
        CompanyID = counter;
    }


    public String GetFirstName(String FirstName) {
        return FirstName;
    }

    public String GetLastName(String LastName) {
        return LastName;
    }

    public int GetEmployeeAge(int Age) {
        return Age;
    }

    public int GetCompanyID() {
        return CompanyID;
    }

    public double GetEmployeeSalary(){
        return Salary;
    }


    public void SetFirstName(String FirstName) {
        this.FirstName = FirstName;
        //return FirstName;
    }

    public void SetLastName(String LastName) {
        this.LastName = LastName;
        //return LastName;
    }

    public void SetAge(int Age) { ;
        this.Age = Age;
        //return Age
    }

    public void SetCompanyID(int CompanyID) {
        this.CompanyID= CompanyID;
    }



    public double setSalary(double Salary) {
        this.Salary = Salary;
        return Salary;
    }
}
