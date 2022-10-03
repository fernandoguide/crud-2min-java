package br.com.fernandoguide.employeeservice.util;

import br.com.fernandoguide.employeeservice.dto.EmployeeDTO;
import br.com.fernandoguide.employeeservice.entity.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeBuilder {
    public static List<EmployeeDTO> getListDTO() {
        return Arrays.asList(new EmployeeDTO(1,"Teste QA","QA",3000.0),
                new EmployeeDTO(2,"Teste Dev","DEV",8000));
    }

    public static List<Employee> getListEntities() {
        return Arrays.asList(new Employee(1,"Teste QA","QA",3000.0),
                new Employee(2,"Teste Dev","DEV",8000));
    }

    public static Employee getEntity() {
      return  new Employee(1,"Teste Dev","DEV",8000);
    }

    public static EmployeeDTO getDTO() {
        return  new EmployeeDTO(1,"Teste Dev","DEV",8000);
    }
}
