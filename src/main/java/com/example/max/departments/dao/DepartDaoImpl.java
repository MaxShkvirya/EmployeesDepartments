package com.example.max.departments.dao;

import com.example.max.departments.model.Department;
import com.example.max.utils.ConnectionsUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartDaoImpl implements DepartDao {

    private static final String ADD_SQL = "INSERT INTO departments (name) VALUES(?)";

    private static final String GET_ONE_SQL = "SELECT * FROM departments WHERE id=?";

    private static final String GET_ALL_SQL = "SELECT * FROM departments";

    private static final String DELETE_SQL = "DELETE FROM departments WHERE id=?";

    private static final String UPDATE_SQL = "UPDATE departments SET name=? WHERE id=?;";

    private static final String COUNT_SQL = "SELECT COUNT(*) AS countName FROM departments WHERE name=?";


    @Override
    public void addUpdateDepartment(Department department) {
        Connection conn = ConnectionsUtils.getConnection();
        try {
            PreparedStatement ps = null;
            if (department.getId() == null) {
                ps = conn.prepareStatement(ADD_SQL);
                ps.setString(1, department.getName());
            } else {
                ps = conn.prepareStatement(UPDATE_SQL);
                ps.setString(1, department.getName());
                ps.setInt(2, department.getId());
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
    public Department getDepartmentById(Integer id) {
        Connection conn = ConnectionsUtils.getConnection();
        Department department = new Department();
        try {
            PreparedStatement ps = conn.prepareStatement(GET_ONE_SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionsUtils.close(conn);
        }
        return department;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<Department>();
        Connection conn = ConnectionsUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(GET_ALL_SQL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionsUtils.close(conn);
        }
        return departments;
    }

    @Override
    public void deleteDepartment(Integer id) {
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
    public int getDepartmentNameCount(String name) {
        Connection conn = ConnectionsUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(COUNT_SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("countName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionsUtils.close(conn);
        }
        return -1;
    }


}

