package br.com.fernandoguide.employeeservice.dao;

import br.com.fernandoguide.employeeservice.entity.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer> {
}