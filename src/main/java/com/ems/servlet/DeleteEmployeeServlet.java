package com.ems.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.ems.dao.EmployeeDAO;
import java.io.*;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.deleteEmployee(employeeId);

        response.sendRedirect("listEmployees");
    }
}