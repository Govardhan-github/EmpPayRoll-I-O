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
    public EmpPayRollServices() {
    }
    public enum IOServices{CONSOLE_IO, FILE_IO,DB_IO,REST_IO}
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
        //Calling Write Employee Pay Roll Data Method To Console
        empPayRollServices.writeEmpPayRollData(IOServices.CONSOLE_IO);
    }
    /*
    Declaring the Write Employee Roll Data Method
    Printing The Details Of Employee
     */
    public void writeEmpPayRollData(IOServices ioServices) {
        if(ioServices.equals(IOServices.CONSOLE_IO))
            System.out.println("Writing Employee Data To Console :" +empPayRollList);
        else if(ioServices.equals(IOServices.FILE_IO));
            new EmpPayRollIOServices().writeData(empPayRollList);
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
    /*
    Declaring The PrintData Method
    Calling The Print Data Method In IO Services
    */
    public void printData(IOServices ioServices) {
        if(ioServices.equals(IOServices.FILE_IO)){
            new EmpPayRollIOServices().printData();
        }
    }
    /*
    Declaring The CountEntries Method
    Calling The Count Entries Method In IO Services
    */
    public long countEntries(IOServices ioServices) {
        if(ioServices.equals(IOServices.FILE_IO))
            return new EmpPayRollIOServices().countEntries();
        return 0;
    }
    /*
   Declaring The Read Data Method
   Calling The Read Data Method In IO Services
   */
    public void readData(IOServices ioServices) {
        if(ioServices.equals(IOServices.FILE_IO))
       new EmpPayRollIOServices().readData();
    }
}