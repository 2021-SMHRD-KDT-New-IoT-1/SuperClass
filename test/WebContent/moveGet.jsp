<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

	<%		
		String moveSensor = request.getParameter("moveSensor");		
		System.out.println(moveSensor);		
	%>	
	

	<p id="result"></p>
	
	<script type="text/javascript">
	
	$(function(){		
		$.ajax({
			url : "InputSensor",
			type : "get",
			data : {"moveSensor": moveSensor},
			dataType : "json",
			success : function(data){
				$('#result').html("현재 감지센서 상태 : " + data.moveSensor);
			},
			error : function(){
				alert('error');
			}
		});
	});
</script>

</body>
</html>