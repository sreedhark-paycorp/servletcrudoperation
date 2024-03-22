<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
  <div class="container">
  <div class="row">
  <div class="col-md-6 offset-md-3">
  <h2 class="text-center mt-4">Delete Form</h2>
  <form action="delete">
  <input type="hidden" name="action" value="delete" >
  <div class="form-group">
    <label for="did" >Enter Id:</label>
    <input type="number" id="did" class="form-control" name = "did" >
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