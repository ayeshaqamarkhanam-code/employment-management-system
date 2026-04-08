<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ems.model.Employee" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List — EMS</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

    <div class="container">
        <h1>All Employees</h1>
        <a href="/addEmployee.html" class="btn btn-primary">+ Add Employee</a>

        <%
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
        %>

        <% if (employees == null || employees.isEmpty()) { %>
            <p class="empty-msg">No employees found. Add one above!</p>
        <% } else { %>
            <table class="employee-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Department</th>
                        <th>Job Title</th>
                        <th>Salary</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Employee emp : employees) { %>
                    <tr>
                        <td><%= emp.getEmployeeId() %></td>
                        <td><%= emp.getFirstName() %></td>
                        <td><%= emp.getLastName() %></td>
                        <td><%= emp.getEmail() %></td>
                        <td><%= emp.getPhoneNumber() %></td>
                        <td><%= emp.getDepartment() %></td>
                        <td><%= emp.getJobTitle() %></td>
                        <td><%= emp.getSalary() %></td>
                        <td><%= emp.getStatus() %></td>
                        <td>
                            <a href="/updateEmployee?id=<%= emp.getEmployeeId() %>" class="btn btn-edit">Edit</a>
                            <a href="/deleteEmployee?id=<%= emp.getEmployeeId() %>"
                               class="btn btn-delete"
                               onclick="return confirm('Delete this employee?')">Delete</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>

        <br>
        <a href="/index.html" class="btn btn-secondary">← Back to Home</a>
    </div>

</body>
</html>