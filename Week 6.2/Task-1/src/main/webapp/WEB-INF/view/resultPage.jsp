<html>
<head>

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body class="bg-light">
<div class="container text-center mt-5">
    <div class="card shadow-lg p-3 mb-5 bg-white rounded">
        <div class="card-body">
            <h1 class="display-4 text-primary">Welcome to Employee App</h1>
            <h3 class="mt-4">Hello, <span class="text-success">${empModel.firstName} ${empModel.lastName}</span> !</h3>
            <p class="lead">We're excited to have you on board!</p>

        </div>
    </div>
</div>
</body>
</html>


