package com.bridgelabz;
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
}