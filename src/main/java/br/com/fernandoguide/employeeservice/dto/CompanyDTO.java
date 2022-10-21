package br.com.fernandoguide.employeeservice.dto;

import br.com.fernandoguide.employeeservice.entity.Employee;

import java.util.List;

public class CompanyDTO extends AbstractDTO<Long> {
    private Long id;
    private String razaoSocial;
    private String cnpj;

    private String dataCriacao;

    private String dataAtualizacao;
    private List<Employee> funcionarios;

    public CompanyDTO(Long id, String razaoSocial, String cnpj, String dataCriacao, String dataAtualizacao, List<Employee> funcionarios) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.funcionarios = funcionarios;
    }

    public CompanyDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getDataAtualizacao() {
        return this.dataAtualizacao;
    }

    public void setFuncionarios(java.util.List<br.com.fernandoguide.employeeservice.entity.Employee> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public java.util.List<br.com.fernandoguide.employeeservice.entity.Employee> getFuncionarios() {
        return this.funcionarios;
    }
}