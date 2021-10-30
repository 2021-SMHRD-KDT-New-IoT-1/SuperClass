<%@page import="com.model.CalendarVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.CalendarDAO"%>
<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Diagoona - About Page</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet" /> <!-- https://fonts.google.com/ -->
    <link href="css/bootstrap.min.css" rel="stylesheet" /> <!-- https://getbootstrap.com/ -->
    <link href="fontawesome/css/all.min.css" rel="stylesheet" /> <!-- https://fontawesome.com/ -->
    <link href="css/templatemo-diagoona.css" rel="stylesheet" />
    <meta name="Generator" content="EditPlus®">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>Document</title>
     <!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
  <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <!-- jquery CDN -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <!-- fullcalendar CDN -->
  <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
  <!-- fullcalendar 언어 CDN -->
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
</head>
<body>

<%
	MemberVO vo = (MemberVO)session.getAttribute("member");
	CalendarDAO Cdao = new CalendarDAO();
	ArrayList<CalendarVO> al = null;
	
	if(vo != null){
	String m_id = vo.getId();
	al = Cdao.getSchedule(m_id);
	}
	%>	
	
	
	 <%
          request.setCharacterEncoding("euc-kr");
          
          // 세션으로 변동
          
          //String op = request.getParameter("data");
         // String op = (String)session.getAttribute("i");
         // System.out.println("문제의 op: " +op);
         // 이 페이지로 와지기는 한거네요?? 쌤 다시 입력해주세요 안녕이라구요!
         // 이 페이지로 돌아와지는것만 확인하면 괜찮습니당
          %>

<div class="tm-container">        
        <div>
            <div class="tm-row pt-4">
                <div class="tm-col-left">
                    <div class="tm-site-header media">
                        <i class="fas fa-umbrella-beach fa-3x mt-1 tm-logo"></i>
                        <div class="media-body">
                            <div class="media-body">
                                <h1 class="tm-sitename text-uppercase" style="font-size: 40px;"><a href="Main.jsp" style="color:#5F9EA0;"><i>An zzi</i></a></h1>
                                <p class="tm-slogon" style="font-size: 17px;">smart무드등</p>
                            </div>        
                        </div>        
                    </div>
                </div>
               
                  </style>
                <div class="tm-col-right">
                    <nav class="navbar navbar-expand-lg" id="tm-main-nav">
                        <button class="navbar-toggler toggler-example mr-0 ml-auto" type="button" 
                            data-toggle="collapse" data-target="#navbar-nav" 
                            aria-controls="navbar-nav" aria-expanded="false" aria-label="Toggle navigation">
                            <span><i class="fas fa-bars"></i></span>
                        </button>
                        <div class="collapse navbar-collapse tm-nav" id="navbar-nav">
                            <ul class="navbar-nav text-uppercase">
                                <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="Time.jsp" style="font-size: 20.8px;">시간설정</a>
                                </li>
                                <li class="nav-item active">
                                    <a class="nav-link tm-nav-link" href="Calender.jsp" style="font-size: 20.8px;">스케줄설정 <span class="sr-only">(current)</span></a>
                                </li>
                                    
                                <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="ServiceCenter.jsp">게시판 </a>
                                </li>                     
                                <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="SelectAnzzi.jsp">SELECT ANZZI</a>
                                </li>          
                                 <li class="nav-item">
                                <%if(vo == null){ %>
                                    <a class="nav-link tm-nav-link" href="Login.html">로그인/회원가입</a>
                                    <%}else{ %>
                                    <a class="nav-link tm-nav-link" href="../Logout"><%=vo.getName()+"님\t" %>로그아웃</a>
                                    <%} %>
                                </li>
                                </li>
                            </ul>                            
                        </div>                        
                    </nav>
                </div>
            </div>
            <div class="tm-row">
                <div class="tm-col-left"></div>
                <main class="tm-col-right">
                    <section class="tm-content tm-about">
                        <h2 style=font-size:1cm;><div style=text-align:center ><i>
                            calender</i></div></h2>
                        <hr class="mb-4">
                        
                      
  <!-- calendar 태그 -->
  <div id='calendar-container'>
    <div id='calendar'></div>
   
  </div>
  
  
  <script>

      // calendar element 취득
      var calendarEl = $('#calendar')[0];
      // full-calendar 생성하기
      var calendar = new FullCalendar.Calendar(calendarEl, {
    	  
        height: '650px', // calendar 높이 설정
        expandRows: true, // 화면에 맞게 높이 재설정
        slotMinTime: '08:00', // Day 캘린더에서 시작 시간
        slotMaxTime: '20:00', // Day 캘린더에서 종료 시간
        // 해더에 표시할 툴바
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: ''    //'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
        },
        initialView: 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
        initialDate: null, // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
        navLinks: null, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
        editable: true, // 수정 가능?
        selectable: true, // 달력 일자 드래그 설정가능
        nowIndicator: true, // 현재 시간 마크
        dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
        locale: 'ko', // 한국어 설정
        
 
        eventChange: function(obj) { // 이벤트가 수정되면 발생하는 이벤트
          console.log(obj);
        },
        eventRemove: function(obj){ // 이벤트가 삭제되면 발생하는 이벤트
          console.log(obj);
        },
        select: function(arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.
        	console.log("1");
          var title = confirm("스케줄을 입력하시겠습니까?");
          
          var url = "CalenderPopup.jsp";
          console.log("3");
          var name = "CalenderPopup test";

          var option = "width = 500, height = 500, top = 100, left = 200, location = no"
          windowObj = window.open(url, name, option);
          windowObj.calendar = calendar;
          windowObj.arg = arg;
          
          calendar.unselect()
        }             

        })//끝
        
        <%if(vo != null){%>
        <%for(int i = 0; i<al.size();i++){%>
         calendar.addEvent({
        	title : "<%=al.get(i).getCalendar_op()%>",
         	start: "<%=al.get(i).getStart()%>",
         	end: "<%=al.get(i).getEnd()%>",
         	allDay: true
         })
         <%}%>
         <%}%>
        
    
      
      // 캘린더 랜더링
      calendar.render();
      
      $('.fc-event-title-container').on('click', function(){
    	  let td = $(this).parents().parents().parents().parents().parents().parents().parents()
    	  console.log(td.attr('data-date'))
    	  //삭제시켜주는 함수만들기.
      })
</script>
                
                      
                    </section>
                </main>
            </div>
        </div>        

        <div class="tm-row">
            <div class="tm-col-left text-center">            
                <ul class="tm-bg-controls-wrapper">
                    <li class="tm-bg-control active" data-id="0"></li>
                    <li class="tm-bg-control" data-id="1"></li>
                    <li class="tm-bg-control" data-id="2"></li>
                </ul>            
            </div>        
            <div class="tm-col-right tm-col-footer">
                <footer class="tm-site-footer text-right">
                    <p class="mb-0">Copyright 2021 SuperClass Co. 
                    
                        | Design: <a rel="nofollow" target="_parent" href="https://templatemo.com" class="tm-text-link">귀여운송미</a></p>
                </footer>
            </div>   
        </div>        

        <!-- Diagonal background design -->
        <div class="tm-bg">
            <div class="tm-bg-left"></div>
            <div class="tm-bg-right"></div>
        </div>
    </div>

    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.backstretch.min.js"></script>
    <script src="js/templatemo-script.js"></script>
</body>
</html>