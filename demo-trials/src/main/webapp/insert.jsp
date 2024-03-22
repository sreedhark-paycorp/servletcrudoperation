<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Insert Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>


<body>
<jsp:include page="header.jsp" />

    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h2 class="text-center mt-4">Insert Form</h2>
                <form action = "insert">
                <input type="hidden" name="action" value="insert" >
                    <div class="form-group">
                        <label for="id"> ENTER ID</label>
                        <input type="number" class="form-control" name="eid" placeholder="Enter ID" required>
                    </div>
                    <div class="form-group">
                        <label for="name">Enter Name</label>
                        <input type="text" class="form-control" name="ename" placeholder="Enter Name" required>
                    </div>
                    <div class="form-group">
                    <label for="gender">Gender</label><br>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" id="male" value="male" required>
                        <label class="form-check-label" for="male">Male</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" id="female" value="female" required>
                        <label class="form-check-label" for="female">Female</label>
                    </div>
                    </div>
                    
                    <button type="submit" class="btn btn-primary btn-block">Submit</button>
                </form>
            </div>
        </div>
    </div>
</body>
<footer>

<jsp:include page="footer.jsp" />

</footer>
</html>
