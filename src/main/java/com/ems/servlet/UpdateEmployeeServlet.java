package com.ems.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;
import java.io.*;
import java.time.LocalDate;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            EmployeeDAO dao = new EmployeeDAO();
            Employee emp = dao.getEmployeeById(employeeId);
            request.setAttribute("employee", emp);
            request.getRequestDispatcher("/WEB-INF/views/updateEmployee.jsp")
                   .forward(request, response);
        } catch (Exception e) {
            response.setContentType("text/plain");
            response.getWriter().println("ERROR in doGet: " + e.getMessage());
            e.printStackTrace(response.getWriter());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String department = request.getParameter("department");
            String jobTitle = request.getParameter("jobTitle");
            LocalDate dateOfJoining = LocalDate.parse(request.getParameter("dateOfJoining"));
            Double salary = Double.parseDouble(request.getParameter("salary"));
            String status = request.getParameter("status");

            Employee emp = new Employee();
            emp.setEmployeeId(employeeId);
            emp.setFirstName(firstName);
            emp.setLastName(lastName);
            emp.setDateOfBirth(dateOfBirth);
            emp.setEmail(email);
            emp.setPhoneNumber(phoneNumber);
            emp.setDepartment(department);
            emp.setJobTitle(jobTitle);
            emp.setDateOfJoining(dateOfJoining);
            emp.setSalary(salary);
            emp.setStatus(status);

            EmployeeDAO dao = new EmployeeDAO();
            dao.updateEmployee(emp);

            response.sendRedirect("/ems/listEmployees");

        } catch (Exception e) {
            response.setContentType("text/plain");
            response.getWriter().println("ERROR in doPost: " + e.getMessage());
            e.printStackTrace(response.getWriter());
        }
    }
}