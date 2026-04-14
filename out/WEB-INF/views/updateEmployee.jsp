<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ems.model.Employee" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Employee — EMS</title>
    <link rel="stylesheet" href="/ems/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Update Employee</h1>

        <form action="/ems/updateEmployee" method="post">
            <%-- Hidden field — carries the ID so doPost knows which row to update --%>
            <input type="hidden" name="employeeId" value="<%= emp.getEmployeeId() %>">

            <label>First Name:</label>
            <input type="text" name="firstName" value="<%= emp.getFirstName() %>" required>

            <label>Last Name:</label>
            <input type="text" name="lastName" value="<%= emp.getLastName() %>" required>

            <label>Date of Birth:</label>
            <input type="date" name="dateOfBirth" value="<%= emp.getDateOfBirth() %>">

            <label>Email:</label>
            <input type="email" name="email" value="<%= emp.getEmail() %>">

            <label>Phone Number:</label>
            <input type="text" name="phoneNumber" value="<%= emp.getPhoneNumber() %>">

            <label>Department:</label>
            <input type="text" name="department" value="<%= emp.getDepartment() %>">

            <label>Job Title:</label>
            <input type="text" name="jobTitle" value="<%= emp.getJobTitle() %>">

            <label>Date of Joining:</label>
            <input type="date" name="dateOfJoining" value="<%= emp.getDateOfJoining() %>">

            <label>Salary:</label>
            <input type="number" name="salary" value="<%= emp.getSalary() %>">

            <label>Status:</label>
            <input type="text" name="status" value="<%= emp.getStatus() %>">

            <button type="submit" class="btn btn-primary">Save Changes</button>
            <a href="/ems/listEmployees" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>