<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Customers</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid px-5">
    <div class="row py-4">
        <div class="col-sm">
            <div class="alert alert-success text-center" role="alert">
                <h4>CRM - Customer Relationship Manager</h4>
            </div>
        </div>
    </div>
    <div class="row mb-2">
        <div class="col-sm">
            <a role="button"
               class="btn btn-primary"
               href="${pageContext.request.contextPath}/customers/form">Add Customer
            </a>
        </div>
    </div>
    <div class="row">
        <div class="col-sm">
            <table class="table table-hover text-left">
                <thead>
                <tr class="table-primary">
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="customer" items="${customers}">
                    <c:url var="updateLink"
                           value="/customers/form">
                        <c:param name="id" value="${customer.id}"/>
                    </c:url>
                    <tr class="table-secondary">
                        <td class="align-middle">${customer.firstName}</td>
                        <td class="align-middle">${customer.lastName}</td>
                        <td class="align-middle">${customer.email}</td>
                        <td>
                            <a role="button"
                               class="btn btn-light"
                               href="${updateLink}">Update
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
