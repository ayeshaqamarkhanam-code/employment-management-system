package com.ems.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import com.ems.model.Employee;

public class EmployeeDAO {

    public void addEmployee(Employee emp) {
        String sql="INSERT INTO employee(first_name, last_name, date_of_birth, email, phone_number, department, job_title, date_of_joining, salary, status) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, emp.getFirstName());
            stmt.setString(2, emp.getLastName());
            stmt.setObject(3, emp.getDateOfBirth());
            stmt.setString(4, emp.getEmail());
            stmt.setString(5, emp.getPhoneNumber());
            stmt.setString(6, emp.getDepartment());
            stmt.setString(7, emp.getJobTitle());
            stmt.setObject(8, emp.getDateOfJoining());
            stmt.setDouble(9, emp.getSalary());
            stmt.setString(10, emp.getStatus());

            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql="SELECT * FROM employee";

        try(Connection conn=DatabaseConnection.getConnection(); PreparedStatement stmt=conn.prepareStatement(sql); ResultSet rs= stmt.executeQuery()){
            while(rs.next()){
                Employee emp=new Employee();
                emp.setEmployeeId(rs.getInt("employee_id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setDateOfBirth(rs.getObject("date_of_birth",LocalDate.class));
                emp.setEmail(rs.getString("email"));
                emp.setPhoneNumber(rs.getString("phone_number"));
                emp.setDepartment(rs.getString("department"));
                emp.setJobTitle(rs.getString("job_title"));
                emp.setDateOfJoining(rs.getObject("date_of_joining", LocalDate.class));
                emp.setSalary(rs.getDouble("salary"));
                emp.setStatus(rs.getString("status"));

                employees.add(emp);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return employees;
    }

    public void updateEmployee(Employee emp) {
        String sql = "UPDATE employee SET first_name=?, last_name=?, date_of_birth=?, email=?, phone_number=?, department=?, job_title=?, date_of_joining=?, salary=?, status=? WHERE employee_id=?";
        try(Connection conn=DatabaseConnection.getConnection(); PreparedStatement stmt=conn.prepareStatement(sql)){
            stmt.setString(1, emp.getFirstName());
            stmt.setString(2, emp.getLastName());
            stmt.setObject(3, emp.getDateOfBirth());
            stmt.setString(4, emp.getEmail());
            stmt.setString(5, emp.getPhoneNumber());
            stmt.setString(6, emp.getDepartment());
            stmt.setString(7, emp.getJobTitle());
            stmt.setObject(8, emp.getDateOfJoining());
            stmt.setDouble(9, emp.getSalary());
            stmt.setString(10, emp.getStatus());
            stmt.setInt(11, emp.getEmployeeId());

            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void deleteEmployee(int employeeId) {
        String sql="DELETE FROM employee WHERE employee_id=?";
        try(Connection conn=DatabaseConnection.getConnection(); PreparedStatement stmt=conn.prepareStatement(sql)){
            stmt.setInt(1, employeeId);
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}