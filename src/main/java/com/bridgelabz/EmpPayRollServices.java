package com.bridgelabz;
/*
Importing Java Packages
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Declaring Employee Pay Roll Services
 */
public class EmpPayRollServices {
  private  List<EmpPayRollData> empPayRollList;
    public EmpPayRollServices(List<EmpPayRollData> empPayRollList) {
        this.empPayRollList = empPayRollList;
    }
    /*
    Declaring Main Method Here
    And Calling The Methods
     */
    public static void main(String[] args){
        ArrayList<EmpPayRollData> empPayRollList = new ArrayList<>();
        EmpPayRollServices empPayRollServices = new EmpPayRollServices(empPayRollList);
        Scanner consoleInputReader = new Scanner(System.in);
        empPayRollServices.readEmpPayRollData(consoleInputReader);
        empPayRollServices.writeEmpPayRollData();
    }
    /*
    Declaring the Write Employee Roll Data Method
    Printing The Details Of Employee
     */
    private void writeEmpPayRollData() {
        System.out.println("Writing Employee Data To Console :" +empPayRollList);
    }
    /*
    Declaring Read Emp Pay Roll Data Method
    Reading The Details From The Scanner
    Adding The Details To List
     */
    private void readEmpPayRollData( Scanner consoleInputReader) {
        System.out.println("Enter Employee Id :");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name :");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary :");
        double salary = consoleInputReader.nextDouble();
        empPayRollList.add(new EmpPayRollData(id,name,salary));
    }
}
