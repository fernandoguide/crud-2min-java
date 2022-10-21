package br.com.fernandoguide.employeeservice.mapper;

import br.com.fernandoguide.employeeservice.dto.CompanyDTO;
import br.com.fernandoguide.employeeservice.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends GenericMapper<Company, CompanyDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    Company asEntity(CompanyDTO dto);
}