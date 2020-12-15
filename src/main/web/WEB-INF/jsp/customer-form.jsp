<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Save Customer</title>

    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}../resources/css/style.css">

    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}../resources/css/add-customer-style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Customer</h3>

    <form:form action="saveCustomer" modelAttribute="customer" method="post">
        <!-- from the model it will pre-populate each field below behind the scenes -->
        <!-- by submitting the data, Spring will call set methods on those objects -->

        <!-- need to associate this data with customer id -->
        <form:hidden path="id" />

        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName"/></td>
            </tr>

            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName"/></td>
            </tr>

            <tr>
                <td><label>E-mail:</label></td>
                <td><form:input path="email"/></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="save" class="save"/></td>
            </tr>

            </tbody>
        </table>

        <!--
        <div style="both"> </div>
        -->
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>

    </form:form>
</div>
</body>
</html>