<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action = "Calender.jsp" method = "post">
	
	<h1>스케줄선택</h1>
	<select name = "i" >
	<option value = "병원">병원</option>
	<option value = "출근">출근</option>
	<option value = "데이트">데이트</option>
	<option value = "미팅">미팅</option>
	</select>
	<input type='button' value="test">
	

</form>
	
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
	      
		$('input[type="button"]').on('click', function(){
			let i = $('select[name="i"]').val() 
			console.log(calendar);
			console.log(arg);
			
			console.log(arg.start);
			console.log(arg.end);
			console.log(arg.allDay);
			
			$.ajax({
				url:"http://localhost:8087/test/calendarService",
				type:'post',
				contentType: 'application/x-www-form-urlencoded; charset=euc-kr',
				data:{
					'i' : i,
					'start' : arg.start,
					'end' : arg.end,
					'allday' : arg.allDay
				},
				success : function(res){
					calendar.addEvent({
		                title: res,
		                start: arg.start,
		                end: arg.end,
		                allDay: arg.allDay
		              })
					//alert(res)
					//opener.location.href="Calender.jsp?data="+res;

					window.close();
					//window.location.href="Calendar.jsp?data="+res;
				}
			})
		})
		
/*		let arr = $("input[type='checkbox']")
		
		for(let i = 0 ; i < arr.length; i++){
			console.log($(arr[i]).val());
		}		
*/		
	</script>
</body>
</html>