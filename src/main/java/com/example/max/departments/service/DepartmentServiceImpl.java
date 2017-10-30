package com.example.max.departments.service;

import com.example.max.departments.dao.DepartDao;
import com.example.max.departments.dao.DepartDaoImpl;
import com.example.max.departments.model.Department;
import com.example.max.utils.ValidationUtils;
import com.example.max.utils.exceptions.ExceptionsMessages;
import com.example.max.utils.exceptions.ValidationExceptions;

import java.util.List;


public class DepartmentServiceImpl implements DepartmentsService, ExceptionsMessages {

    private DepartDao departDao;

    public DepartmentServiceImpl() {
        departDao = new DepartDaoImpl();
    }

    @Override
    public void addUpdateDepartment(Department department) {
        // try{
        //  if (ValidationUtils.validateDepartmentName(department.getName())){
        departDao.addUpdateDepartment(department);
//            }else {
//              throw new ValidationExceptions(DEPARTMENT_NAME_EXCEPTION);
//            }

//        } catch (ValidationExceptions validationExceptions) {
//            System.out.println(validationExceptions.getMessage());
//        }
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departDao.getDepartmentById(id);
    }

    @Override
    public int getDepartmentNameCount(String name) {
        return departDao.getDepartmentNameCount(name);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departDao.getAllDepartments();
    }

    @Override
    public void deleteDepartment(Integer id) {
        departDao.deleteDepartment(id);
    }


}
