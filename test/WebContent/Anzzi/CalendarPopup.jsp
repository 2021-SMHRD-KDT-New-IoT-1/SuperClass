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
	
	<h1>�����ټ���</h1>
	<select name = "calendar_op" >
	<option value = "����">����</option>
	<option value = "���">���</option>
	<option value = "����Ʈ">����Ʈ</option>
	<option value = "����">����</option>
	</select>
	<input type='button' value="test">
	

</form>
	
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
	      
		$('input[type="button"]').on('click', function(){
			let calendar_op = $('select[name="calendar_op"]').val() 
			console.log(calendar);
			console.log(arg);
			
			console.log("��ŸƮ: "+ arg.start);
			console.log("�ص�: " +arg.end);
			console.log("�õ���: " + arg.allDay);
			
			$.ajax({
				url:"../calendarService",
				type:'post',
				contentType: 'application/x-www-form-urlencoded; charset=euc-kr',
				data:{
					'calendar_op' : calendar_op,
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
					main.location.reload();
					window.close();
					//window.location.href="Calendar.jsp";
				}
			})
			
			// ajax
	
		})
		
		
		
/*		let arr = $("input[type='checkbox']")
		
		for(let i = 0 ; i < arr.length; i++){
			console.log($(arr[i]).val());
		}		
*/		
	</script>
</body>
</html>