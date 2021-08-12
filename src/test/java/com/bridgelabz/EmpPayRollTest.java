package com.bridgelabz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
public class EmpPayRollTest {
    /*
     Test Method To Given 3 Employee Written To File
     Writing The Employee Data To IO File
     Printing The Data Of Employee
     Count The Entries Of File
     */
    @Test
        public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries(){
            EmpPayRollData[] arrayOfEmps={
                    new EmpPayRollData(1,"GOPI",30000.0),
                    new EmpPayRollData(2,"Govardhan Reddy",35000.0),
                    new EmpPayRollData(3,"Govardhan",40000.0),
            };
            EmpPayRollServices empPayRollServices =new EmpPayRollServices(Arrays.asList(arrayOfEmps));
            empPayRollServices.writeEmpPayRollData(EmpPayRollServices.IOServices.FILE_IO);
            empPayRollServices.printData(EmpPayRollServices.IOServices.FILE_IO);
            long entries = empPayRollServices.countEntries(EmpPayRollServices.IOServices.FILE_IO);
             Assertions.assertEquals(3,entries);
        }
    @Test
    public void givenFileOnReadingFromFileShouldMatchEmployeeCount(){
        EmpPayRollServices empPayRollServices=new EmpPayRollServices();
         empPayRollServices.readData(EmpPayRollServices.IOServices.FILE_IO);
    }
}