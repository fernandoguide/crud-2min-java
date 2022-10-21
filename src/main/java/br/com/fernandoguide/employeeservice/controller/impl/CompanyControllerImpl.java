package br.com.fernandoguide.employeeservice.controller.impl;

import br.com.fernandoguide.employeeservice.controller.CompanyController;
import br.com.fernandoguide.employeeservice.dto.CompanyDTO;
import br.com.fernandoguide.employeeservice.entity.Company;
import br.com.fernandoguide.employeeservice.mapper.CompanyMapper;
import br.com.fernandoguide.employeeservice.service.CompanyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/company")
@RestController
public class CompanyControllerImpl implements CompanyController {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    public CompanyControllerImpl(CompanyService companyService, CompanyMapper companyMapper) {
        this.companyService = companyService;
        this.companyMapper = companyMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyDTO save(@RequestBody CompanyDTO companyDTO) {
        Company company = companyMapper.asEntity(companyDTO);
        return companyMapper.asDTO(companyService.save(company));
    }

    @Override
    @GetMapping("/{id}")
    public CompanyDTO findById(@PathVariable("id") Integer id) {
        Company company = companyService.findById(id).orElse(null);
        return companyMapper.asDTO(company);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        companyService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<CompanyDTO> list() {
        return companyMapper.asDTOList(companyService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CompanyDTO> pageQuery(Pageable pageable) {
        Page<Company> companyPage = companyService.findAll(pageable);
        List<CompanyDTO> dtoList = companyPage
                .stream()
                .map(companyMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, companyPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public CompanyDTO update(@RequestBody CompanyDTO companyDTO, @PathVariable("id") Integer id) {
        Company company = companyMapper.asEntity(companyDTO);
        return companyMapper.asDTO(companyService.update(company, id));
    }
}