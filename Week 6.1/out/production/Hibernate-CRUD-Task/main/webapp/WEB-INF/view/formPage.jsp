<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Styled Form</title>

    <!-- Link to custom stylesheet -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="text-center mb-4">Employee Registration Form</h2>
            <form:form action="processForm" modelAttribute="empModel" class="p-4 border rounded bg-white shadow-sm">
                <!-- FirstName Input -->
                <div class="form-group mb-3">
                    <form:input type="text" placeholder="First Name" path="firstName" class="form-control" />
                    <form:errors path="firstName" cssClass="alert-danger"/>
                </div>
                <!-- LastName Input -->
                <div class="form-group mb-3">
                    <form:input type="text" placeholder="Last Name" path="lastName" class="form-control" />
                    <form:errors path="lastName" cssClass="alert-danger"/>
                </div>
                <!-- Email Input -->
                <div class="form-group mb-3">
                    <form:input type="text" placeholder="Email" path="email" class="form-control" />
                    <form:errors path="email" cssClass="alert-danger"/>
                </div>
                <!-- Username Input -->
                <div class="form-group mb-3">
                <form:input type="text" placeholder="Username" path="username" class="form-control" />
                    <form:errors path="username" cssClass="alert-danger"/>
                </div>
                <!-- Password Input -->
                <div class="form-group mb-3">
                    <form:input type="password" placeholder="Password" path="password" class="form-control" />
                    <form:errors path="password" cssClass="alert-danger"/>
                </div>
                <!-- Password Input -->
                <div class="form-group mb-3">
                    <form:input type="password" placeholder="Confirm Password" path="confirmationPassword" class="form-control" />
                    <form:errors path="confirmationPassword" cssClass="alert-danger"/>
                </div>
                <!-- PhoneNumber Input -->
                <div class="form-group mb-3">
                    <form:input type="text" placeholder="Phone Number" path="phoneNumber" class="form-control" />
                    <form:errors path="phoneNumber" cssClass="alert-danger"/>
                </div>

                <!-- Submit Button -->
                <div class="form-group">
                    <input type="submit" class="btn btn-danger btn-block" />
                </div>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
