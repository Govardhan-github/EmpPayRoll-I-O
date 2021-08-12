package com.bridgelabz;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
/*
Declaring Employee Pay Roll IO Services Class
 */
public class EmpPayRollIOServices {
    public static String PAYROLL_FILE_NAME = "payroll-file.txt";
    /*
    Declaring WriteData Method
     */
    public void writeData(List<EmpPayRollData> empPayRollDataList){
        StringBuffer empBuffer = new StringBuffer();
        empPayRollDataList.forEach(employee-> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try{
            Files.write(Paths.get(PAYROLL_FILE_NAME),empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    Declaring The Print Data Method
    Printing The Each Line In The File IO
     */
    public void printData() {
        try{
            Files.lines(new File( PAYROLL_FILE_NAME).toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    Declaring The Count Entries Method
    Count The Each Line In The File IO
     */
    public long countEntries() {
        long entries = 0;
        try{
           entries =  Files.lines(new File(PAYROLL_FILE_NAME).toPath())
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }
}