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
    <meta name="Generator" content="EditPlus��">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>Document</title>
     <!-- ȭ�� �ػ󵵿� ���� ���� ũ�� ����(����� ����) -->
  <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <!-- jquery CDN -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <!-- fullcalendar CDN -->
  <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
  <!-- fullcalendar ��� CDN -->
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
</head>
<body>
<%
	MemberVO vo = (MemberVO)session.getAttribute("member");
	
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
                                <p class="tm-slogon" style="font-size: 17px;">smart�����</p>
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
                                    <a class="nav-link tm-nav-link" href="Time.jsp" style="font-size: 20.8px;">�ð�����</a>
                                </li>
                                <li class="nav-item active">
                                    <a class="nav-link tm-nav-link" href="Calender.jsp" style="font-size: 20.8px;">�����ټ��� <span class="sr-only">(current)</span></a>
                                </li>
                                    
                                <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="ServiceCenter.jsp">�Խ��� </a>
                                </li>                     
                                 <li class="nav-item">
                                <%if(vo == null){ %>
                                    <a class="nav-link tm-nav-link" href="Login.html">�α���/ȸ������</a>
                                    <%}else{ %>
                                    <a class="nav-link tm-nav-link" href="../Logout"><%=vo.getName()+"��\t" %>�α׾ƿ�</a>
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
                        
                      
  <!-- calendar �±� -->
  <div id='calendar-container'>
    <div id='calendar'></div>
  </div>
  
  <script>
  (function(){
    $(function(){
      // calendar element ���
      var calendarEl = $('#calendar')[0];
      // full-calendar �����ϱ�
      var calendar = new FullCalendar.Calendar(calendarEl, {
        height: '650px', // calendar ���� ����
        expandRows: true, // ȭ�鿡 �°� ���� �缳��
        slotMinTime: '08:00', // Day Ķ�������� ���� �ð�
        slotMaxTime: '20:00', // Day Ķ�������� ���� �ð�
        // �ش��� ǥ���� ����
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
        },
        initialView: 'dayGridMonth', // �ʱ� �ε� �ɶ� ���̴� Ķ���� ȭ��(�⺻ ����: ��)
        initialDate: null, // �ʱ� ��¥ ���� (�������� ������ ���� ��¥�� ���δ�.)
        navLinks: true, // ��¥�� �����ϸ� Day Ķ������ Week Ķ������ ��ũ
        editable: true, // ���� ����?
        selectable: true, // �޷� ���� �巡�� ��������
        nowIndicator: true, // ���� �ð� ��ũ
        dayMaxEvents: true, // �̺�Ʈ�� �����Ǹ� ���� ���� (+ �� �������� ǥ��)
        locale: 'ko', // �ѱ��� ����
        eventAdd: function(obj) { // �̺�Ʈ�� �߰��Ǹ� �߻��ϴ� �̺�Ʈ
          console.log(obj);
        },
        eventChange: function(obj) { // �̺�Ʈ�� �����Ǹ� �߻��ϴ� �̺�Ʈ
          console.log(obj);
        },
        eventRemove: function(obj){ // �̺�Ʈ�� �����Ǹ� �߻��ϴ� �̺�Ʈ
          console.log(obj);
        },
        select: function(arg) { // Ķ�������� �巡�׷� �̺�Ʈ�� ������ �� �ִ�.
          var title = prompt('Event Title:');
          if (title) {
            calendar.addEvent({
              title: title,
              start: arg.start,
              end: arg.end,
              allDay: arg.allDay
            })
          }
          calendar.unselect()
        }
        
      });
      // Ķ���� ������
      calendar.render();
    });
  })();
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
                    
                        | Design: <a rel="nofollow" target="_parent" href="https://templatemo.com" class="tm-text-link">�Ϳ���۹�</a></p>
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