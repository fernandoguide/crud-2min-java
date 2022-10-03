package br.com.fernandoguide.employeeservice.mapper;


import br.com.fernandoguide.employeeservice.dto.EmployeeDTO;
import br.com.fernandoguide.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends GenericMapper<Employee, EmployeeDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    Employee asEntity(EmployeeDTO dto);
}