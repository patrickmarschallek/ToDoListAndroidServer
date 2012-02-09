<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Welcome to ToDoListPlus</h1>
	
	<div>
		<h2>REST - Api-References</h2>
		<div id="restCommand">
			<div class="restUri">
			Methode: GET
				http://localhost:8080/ToDoListAndroidServer/api/rest/getAll
			</div>
			<div class="restUriDocumantation">
				Gibt alle Todo-Eiträge vom Server als Json-Array zurück.
			</div>
			<div class="restUri">
				Methode: POST
				http://localhost:8080/ToDoListAndroidServer/api/rest/autheticate
			</div>
			<div class="restUriDocumantation">
				Mit dem aufruf kann man sich Authentifizieren am Server
				
				zB.:
				http://localhost:8080/ToDoListAndroidServer/api/rest/autheticate?username={username}&password={password}
			</div>
		</div>
	</div>
</body>
</html>