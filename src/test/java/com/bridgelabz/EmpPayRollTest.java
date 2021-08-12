package com.bridgelabz;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
public class EmpPayRollTest {
    /*
     Test Method To Given 3 Employee Written To File
     */
    @Test
        public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries(){
            EmpPayRollData[] arrayOfEmps={
                    new EmpPayRollData(1,"GOPI",30000.0),
                    new EmpPayRollData(2,"Govardhan Reddy",35000.0),
                    new EmpPayRollData(2,"Govardhan",40000.0),
            };
            EmpPayRollServices empPayRollServices =new EmpPayRollServices(Arrays.asList(arrayOfEmps));
            empPayRollServices.writeEmpPayRollData(EmpPayRollServices.IOServices.FILE_IO);
        }
}