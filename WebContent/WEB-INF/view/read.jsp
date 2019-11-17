<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="todoapp.model.Todo,java.util.*"%>
 <%
 List<Todo> list=(List<Todo>)request.getAttribute("list");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TodoApp</title>
<!--CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<!--JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<a href="/todoapp/Create">
	<button type="button" class="btn btn-primary">新規</button>
</a>
<% if(list !=null && list.size() >0){ %>
<div class="table-responsive">
	<table class="table table-striped table-bordered"">
		<thead>
	      <tr>
	        <th>タイトル</th>
	        <th>重要度</th>
	        <th>操作</th>
	      </tr>
	    </thead>
		<tbody>
		<%for(Todo t:list){ %>
			<tr>
				<td scope="row"><%=t.getTitle() %></td>
				<td><%=t.getStar() %></td>
				<td>
					<a href="/todoapp/Update?id=<%=t.getId()%>">
						<button type="button" class="btn btn-primary">更新</button>
					</a>
					<a href="/todoapp/Delete?id=<%=t.getId()%>" onclick="return confirm('[<%=t.getTitle()%>]を削除してよろしいですか？');">
						<button type="button" class="btn btn-primary">削除</button>
					</a>
				</td>
			</tr>
		<%} %>
		</tbody>
	</table>
</div>
<%}else{ %>
<p>Todoはまだありません</p>
<%} %>
</div>
</body>
</html>