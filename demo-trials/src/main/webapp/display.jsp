<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Display Form</title>
</head>
<body>
<jsp:include page="header.jsp" />
  <div class="container">
  <div class="row">
  <div class="col-md-6 offset-md-3">
  <h2 class="text-center mt-4">Display Employee Details</h2>
  <form action = "disp">
  <input type="hidden" name="action" value="disp" >
  <div class="form-group">
    <label for="did">Enter Id:</label>
    <input type="number" class="form-control" name = "did" placeholder="Enter ID">
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