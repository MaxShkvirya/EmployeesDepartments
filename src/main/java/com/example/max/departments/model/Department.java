package com.example.max.departments.model;


import com.example.max.departments.service.DepartmentServiceImpl;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.ValidateWithMethod;

public class Department {

    private Integer id;

    @NotNull(message = "field must be not null")
    @NotEmpty(message = "name must  be not empty")
    @Length(min = 0, max = 15, message = "Max length 15 min 1 char")
    @ValidateWithMethod(methodName = "checkDepartmentName", parameterType = String.class,message = "name already exists")
    private String name;

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }

    public boolean checkDepartmentName(String name) {
        return 0 == new DepartmentServiceImpl().getDepartmentNameCount(name);
    }
}
