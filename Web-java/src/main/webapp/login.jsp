<%@ page contentType="text/html ; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>$Tit1e$</title>
    </head>
    <body>
    		<form action="ConterServlet" method="post">
    			name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name" /><br>
    			password:<input type="password" name="password" /><br>
    			password:<input type="password" name="password2" /><br>
    			email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email"><br>
    			<input type="submit" value="提交"/>
    			<input type="reset" value="重置" />
    		</form>
    	</body>
</html>