<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Save Customer</title>

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
    <div class="row pt-1">
        <div class="col-sm text-primary">
            <h3>Customer Details</h3>
        </div>
    </div>
    <hr>
    <form:form action="${pageContext.request.contextPath}/customers"
               modelAttribute="customer"
               method="post">
        <div class="form-group">
            <label for="firstName">First Name</label>
            <form:input type="text"
                        class="form-control"
                        id="firstName"
                        path="firstName"
                        placeholder="First Name"/>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name</label>
            <form:input type="text"
                        class="form-control"
                        id="lastName"
                        path="lastName"
                        placeholder="Last Name"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <form:input type="email"
                        class="form-control"
                        id="email"
                        path="email"
                        placeholder="Email"/>
        </div>
        <div class="row">
            <div class="col-sm">
                <button type="submit"
                        class="btn btn-primary float-right mt-1">Save
                </button>
            </div>
        </div>
    </form:form>
    <hr class="mt-5">
    <div class="row mb-2">
        <div class="col-sm">
            <a role="button"
               class="btn btn-light"
               href="${pageContext.request.contextPath}/customers">Back to List
            </a>
        </div>
    </div>
</div>
</body>
</html>
