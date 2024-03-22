<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, scale-initial=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container">
<div class="row">
<div class="col-md-6 offset-md-3">
<h2 class="text-center mt-4">Update Form</h2>
<form action = "update">
<input type="hidden" name="action" value="update" >
  <div class="form-group">
    <label for="uid">Enter Id:</label>
    <input type="number" id="uid" class="form-control" name="uid" required>
     </div>
     
  <div class="form-group">
    <label >Employee Name:</label>
    <input type="text" class="form-control" name = "uname">
  </div>
<div class="form-group">
                    <label for="gender">Gender</label><br>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="ugender" id="male" value="male">
                        <label class="form-check-label" for="male">Male</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="ugender" id="female" value="female">
                        <label class="form-check-label" for="female">Female</label>
                    </div>
                    </div>
 <button type="submit" class="btn btn-primary btn-black" >Submit</button>
</form>
</div>
</div>
</div>
</body>
<footer>
<jsp:include page="footer.jsp" />
</footer>
</html>