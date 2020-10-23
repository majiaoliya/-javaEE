public class Main {
    public static void main(String[] args) {
        Manager ma = new Manager();
        ma.work();
        ma.fuck();
        Employee emp = ((Employee)ma);
        emp.fuck();
    }
}
