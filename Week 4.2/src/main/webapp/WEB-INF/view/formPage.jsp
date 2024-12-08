<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Date Input Form</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-lg">
                <div class="card-header bg-primary text-white text-center">
                    <h3>Date Input Form</h3>
                </div>
                <div class="card-body">
                    <form action="processForm" >
                        <div class="form-group">
                            <label for="year">Year:</label>
                            <input type="number" class="form-control" id="year" name="year" placeholder="Enter year" required>
                        </div>
                        <div class="form-group">
                            <label for="month">Month:</label>
                            <input type="number" class="form-control" id="month" name="month" placeholder="Enter month (1-12)" required>
                        </div>
                        <div class="form-group">
                            <label for="day">Day:</label>
                            <input type="number" class="form-control" id="day" name="day" placeholder="Enter day" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Submit</button>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
