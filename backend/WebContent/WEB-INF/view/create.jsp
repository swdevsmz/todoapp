<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TodoApp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
    <form action="/todoapp/Create" method="post" class="form-horizontal">
      <div class="form-group">
        <label class="col-sm-2 control-label">Title</label>
        <div class="col-sm-10">
          <input type="text" name="title" class="form-control">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">重要度</label>
        <div class="col-sm-10">
          <input type="number" name="importance" min="1" max="5" value="3" class="form-control">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-primary">登録</button>
        </div>
      </div>
    </form>
  </div>
</body>
</html>