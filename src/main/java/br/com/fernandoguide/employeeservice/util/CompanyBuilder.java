package br.com.fernandoguide.employeeservice.util;

import br.com.fernandoguide.employeeservice.dto.CompanyDTO;
import br.com.fernandoguide.employeeservice.entity.Company;

import java.util.Arrays;
import java.util.List;

public class CompanyBuilder {
    public static List<CompanyDTO> getListDTO() {
        return Arrays.asList(
                new CompanyDTO(
                        1L,
                        "TESTE 1",
                        "5456465",
                        "2002-05-04",
                        "2002-05-03",
                        EmployeeBuilder.getListEntities()
                ),
                new CompanyDTO(
                        1L,
                        "TESTE 2",
                        "123456789",
                        "2002-05-03",
                        "2002-05-03",
                        EmployeeBuilder.getListEntities()
                )
        );
    }

    public static List<Company> getListEntities() {
        return Arrays.asList(new Company(1L,
                        "TESTE 1",
                        "123456789",
                        "2002-05-03",
                        "2002-05-03",
                        EmployeeBuilder.getListEntities()
                ),
                new Company(    1L,
                        "TESTE 1",
                        "123456789",
                        "2002-05-03",
                        "2002-05-03",
                        EmployeeBuilder.getListEntities()
                )
        );
    }

    public static Company getEntity() {
      return  new Company(    1L,
              "TESTE 1",
              "123456789",
              "2002-05-03",
              "2002-05-03",
              EmployeeBuilder.getListEntities()
      );
    }

    public static CompanyDTO getDTO() {
        return  new CompanyDTO(1L,
                "TESTE 1",
                "123456789",
                "2002-05-03",
                "2002-05-03",
                EmployeeBuilder.getListEntities()
        );
    }
}
