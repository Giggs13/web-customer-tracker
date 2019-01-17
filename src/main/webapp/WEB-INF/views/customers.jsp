<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List of Customers</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid px-5">
    <div class="row py-4">
        <div class="col">
            <div class="alert alert-success text-center" role="alert">
                <h4>CRM - Customer Relationship Manager</h4>
            </div>
        </div>
    </div>
    <form:form action="${pageContext.request.contextPath}/customers/search"
               method="post">
        <div class="container-fluid p-0">
            <div class="row">
                <div class="col-8">
                    <a role="button"
                       class="btn btn-primary"
                       href="${pageContext.request.contextPath}/customers/form">Add Customer
                    </a>
                </div>
                <div class="col-4 d-flex flex-row">
                    <input type="text"
                           id="searchName"
                           class="form-control"
                           name="searchName"
                           placeholder="Search customer"/>
                    <button type="submit"
                            class="btn btn-light ml-2">Search
                    </button>
                </div>
            </div>
        </div>
    </form:form>
    <div class="row">
        <div class="col">
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
                    <c:url var="deleteLink"
                           value="/customers/delete">
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
                            <a role="button"
                               class="btn btn-light"
                               href="${deleteLink}"
                               onclick="return confirm('Are you sure want to delete this customer?')">Delete
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
