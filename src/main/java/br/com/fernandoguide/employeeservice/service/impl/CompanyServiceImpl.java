package br.com.fernandoguide.employeeservice.service.impl;

import br.com.fernandoguide.employeeservice.dao.CompanyRepository;
import br.com.fernandoguide.employeeservice.entity.Company;
import br.com.fernandoguide.employeeservice.service.CompanyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Company save(Company entity) {
        return repository.save(entity);
    }

    @Override
    public List<Company> save(List<Company> entities) {
        return (List<Company>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Company> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Company> findAll() {
        return (List<Company>) repository.findAll();
    }

    @Override
    public Page<Company> findAll(Pageable pageable) {
        Page<Company> entityPage = repository.findAll(pageable);
        List<Company> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Company update(Company entity, Integer id) {
        Optional<Company> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}