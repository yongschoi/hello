<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring MVC ::: Registration </title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript"> 
	// 한글입력 방지
	$(document).ready(function(){
		$("input[name=username]").keyup(function(event){ 
			if (!(event.keyCode >=37 && event.keyCode<=40)) {
				var inputVal = $(this).val();
				$(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
			}
		});
	});
</script>
</head>
<style>
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #8b0000;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
<body>
	<form action="${pageContext.request.contextPath}/user/create" method="post">
		<div class="container">			
			<label><b>Username</b> (alphabet/numeric ONLY)</label>
			<input type="text" placeholder="Enter Username" id="username" name="username" required /> 
			<label><b>Password</b></label> 
			<input type="password" placeholder="Enter Password" id="password" name="password" required />
        	
			<button type="submit">사용자등록</button>
		</div>
	</form>
	<div align=cneter><h1>${out}</h1></div>
	::: <%= request.getProtocol() %> :::
</body>
</html>