package com.example.max.employee.dao;

import com.example.max.employee.model.Employee;
import com.example.max.utils.ConnectionsUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {

    // ???????? ?? ????? SQL (???? ???????? ? ???????? ????? ?????)
    // ?????? ?????????? ? ???? ????????? - id=? ??????? ?????????
    // id - ???????? ??????? ???? ? ????? ???? ? ??????? employee
    // ? - ???????? ??????? ?? ????? ?????????? ? ???? ? ???? id
    // ????????? ?????? - id=? id=2

    // ??????? ????????? ?????????? ??? ??????? ???????? ?????????
    private static final String ADD_SQL = "INSERT INTO employees (email,age,date,iddepartment) VALUES(?, ?, ?,?)";

    private static final String GET_ONE_SQL = "SELECT * FROM emploees WHERE id=?";

    private static final String GET_ALL_SQL = "SELECT * FROM employees";

    private static final String GET_ALL_BY_DEPARTMENT_ID_SQL = "SELECT * FROM employees WHERE iddepartment=?";

    private static final String DELETE_SQL = "DELETE FROM employees WHERE id=?";

    private static final String UPDATE_SQL = "UPDATE employees SET email=?, age=?, date=?, idDepartment=? WHERE id=?;";

    private static final String COUNT_SQL = "SELECT COUNT(*) AS countEmail FROM demployees WHERE email=?";


    @Override
    public Employee getEmployeeById(Integer id) {
        Connection conn = ConnectionsUtils.getConnection();
        Employee employee = new Employee();
        try {
            PreparedStatement ps = conn.prepareStatement(GET_ONE_SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();           //методы connection посмотреть
            while (rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setEmail(rs.getString("email"));
                employee.setAge(rs.getInt("age"));
                employee.setDate(rs.getDate("date"));
                employee.setIdDepartment(rs.getInt("iddepartment"));

            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionsUtils.close(conn);
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return getAll(null);
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(Integer id) {
        return getAll(id);
    }

    private List<Employee> getAll(Integer id) {
        List<Employee> employees = new ArrayList<Employee>();
        Connection conn = ConnectionsUtils.getConnection();
        try {

            String sql = id != null ? GET_ALL_BY_DEPARTMENT_ID_SQL : GET_ALL_SQL;

            PreparedStatement ps = conn.prepareStatement(sql);

            //ResultSet -  ???????? ?????? ?? ????
            //PreparedStatement  ????????? ??? ?????? GET_ALL_SQL ? ?????????? ??? ?????? ?? ??
            //?????? ?????? ??? ???????????? ??? ????????? ?????? ?? ????
            // ???????? ?????? ?????????
            if (id != null) {
                ps.setInt(1, id);
            }
            ResultSet rs = ps.executeQuery();

            // ???? ? ?????????? ???? ???????? ??????????? ?? ? ????? ? ???? ??????
            while (rs.next()) {

                // ?????? ??? ??????? ???? ????? ?????????? ????? ????
                // ? ???????? ?? ?????? ????????? ????? ?????? ? ?????? ? ????
                Employee employee = new Employee();

                //(rs.getInt("id") ????????? ??????????? ?? ???? ?????? ?? ????? ???? ? ???????
                employee.setId(rs.getInt("id"));
                employee.setEmail(rs.getString("email"));
                employee.setAge(rs.getInt("age"));
                employee.setDate(rs.getDate("date"));
                employee.setIdDepartment(rs.getInt("iddepartment"));
                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionsUtils.close(conn);
        }
        return employees;
    }

    @Override
    public void deleteEmployee(Integer id) {

        Connection conn = ConnectionsUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE_SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionsUtils.close(conn);
        }
    }

    @Override
    public void addUpdateEmployee(Employee employee) {
        Connection conn = ConnectionsUtils.getConnection();
        try {
            PreparedStatement ps = null;
            if (employee.getId() == null) {
                ps = conn.prepareStatement(ADD_SQL);
                ps.setString(1, employee.getEmail());
                ps.setInt(2, employee.getAge());
                ps.setDate(3, new Date(employee.getDate().getTime()));
                ps.setInt(4, employee.getIdDepartment());
            } else {
                ps = conn.prepareStatement(UPDATE_SQL);
                ps.setString(1, employee.getEmail());
                ps.setInt(2, employee.getAge());
                ps.setDate(3, new Date(employee.getDate().getTime()));
                ps.setInt(4, employee.getIdDepartment());
                ps.setInt(5, employee.getId());
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionsUtils.close(conn);
        }
    }

    @Override
    public int getEmployeeEmailCount(String email) {
        Connection conn = ConnectionsUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(COUNT_SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("countEmail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionsUtils.close(conn);
        }
        return -1;
    }


//    @Override
//    public void addUpdateEmployeeByDepartment(Employee employee) {
//        Connection conn = ConnectionsUtils.getConnection();
//        try {
//            PreparedStatement ps = null;
//            if (employee.getId() == null) {
//                ps = conn.prepareStatement(ADD_SQL);
//                ps.setString(1, employee.);
//            } else {
//                ps = conn.prepareStatement(UPDATE_SQL);
//                ps.setString(1, department.getName());
//                ps.setInt(2, department.getId());
//            }
//            ps.executeUpdate();
//            ps.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            ConnectionsUtils.close(conn);
//        }
//    }

}
