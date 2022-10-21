package br.com.fernandoguide.employeeservice.controller;

import br.com.fernandoguide.employeeservice.dto.CompanyDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Company API")
public interface CompanyController {
    @ApiOperation("Add new data")
    public CompanyDTO save(@RequestBody CompanyDTO company);

    @ApiOperation("Find by Id")
    public CompanyDTO findById(@PathVariable("id") Integer id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Integer id);

    @ApiOperation("Find all data")
    public List<CompanyDTO> list();

    @ApiOperation("Pagination request")
    public Page<CompanyDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public CompanyDTO update(@RequestBody CompanyDTO dto, @PathVariable("id") Integer id);
}