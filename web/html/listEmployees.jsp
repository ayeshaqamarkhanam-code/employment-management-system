<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <link rel="stylesheet" href="../css/style.css">
</html>
<body>
    <h1>Employee List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Department</th>
            <th>Job Title</th>
            <th>Date of Joining</th>
            <th>Salary</th>
            <th>Status</th>
        </tr>
        <%-- Loop through employees and display them --%>
        <%-- Example: --%>
        <%-- 
        for(Employee emp : employees) { 
        %>
        <%-- 
        <tr>
            <td><%= emp.getId() %></td>
            <td><%= emp.getFirstName() %></td>
            <td><%= emp.getLastName() %></td>
            <td><%= emp.getDateOfBirth() %></td>
            <td><%= emp.getEmail() %></td>
            <td><%= emp.getPhoneNumber() %></td>
            <td><%= emp.getDepartment() %></td>
            <td><%= emp.getJobTitle() %></td>
            <td><%= emp.getDateOfJoining() %></td>
            <td><%= emp.getSalary() %></td>
            <td><%= emp.getStatus() %></td>
        </tr> 
        <%-- 
        } 
        --%>
    </table>
</html>