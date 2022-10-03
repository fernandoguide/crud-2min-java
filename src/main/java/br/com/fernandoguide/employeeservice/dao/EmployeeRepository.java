package br.com.fernandoguide.employeeservice.dao;

import br.com.fernandoguide.employeeservice.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
}