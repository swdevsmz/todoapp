<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="todoapp.model.todo.Todo"%>
<%
Todo todo=(Todo)request.getAttribute("todo");
%>
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
  <form action="/todoapp/Update" method="post" class="form-horizontal">
    <div class="form-group">
      <label class="col-sm-2 control-label">Title</label>
      <div class="col-sm-10">
        <input type="text" name="title" value="<%=todo.getTitle() %>" class="form-control">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">重要度</label>
      <div class="col-sm-10">
        <input type="number" name="importance" value="<%=todo.getImportance() %>" class="form-control">
        <input type="hidden" name="id" value="<%=todo.getId() %>">
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary">更新</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>