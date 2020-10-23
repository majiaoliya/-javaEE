public class Employee {
    private String empId, empName, empSal;

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empSal='" + empSal + '\'' +
                '}';
    }

    public void work() { }

    public String getEmpId() {
        return empId;
    }

    public void fuck() {
        System.out.println("employee fucking dog !");
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSal() {
        return empSal;
    }

    public void setEmpSal(String empSal) {
        this.empSal = empSal;
    }

    public Employee() {
    }

    public Employee(String empId, String empName, String empSal) {
        this.empId = empId;
        this.empName = empName;
        this.empSal = empSal;
    }
}
