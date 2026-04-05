package com.ems.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.ems.dao.EmployeeDAO;
import com.ems.model.Employee;
import java.io.*;
import java.util.List;

@WebServlet("/listEmployees")
public class ListEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employees = employeeDAO.getAllEmployees();

        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/web/html/listEmployees.html");
        dispatcher.forward(request, response);
    }
    
}