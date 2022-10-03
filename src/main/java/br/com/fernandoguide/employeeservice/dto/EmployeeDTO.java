package br.com.fernandoguide.employeeservice.dto;

public class EmployeeDTO {
    private Integer id;
    private String name;
    private String departament;
    private double salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String name, String departament, double salary) {
        this.id = id;
        this.name = name;
        this.departament = departament;
        this.salary = salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getDepartament() {
        return this.departament;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }
}