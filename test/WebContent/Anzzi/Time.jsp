<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>anzzi</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet" /> <!-- https://fonts.google.com/ -->
    <link href="css/bootstrap.min.css" rel="stylesheet" /> <!-- https://getbootstrap.com/ -->
    <link href="fontawesome/css/all.min.css" rel="stylesheet" /> <!-- https://fontawesome.com/ -->
    <link href="css/templatemo-diagoona.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
    
	    $(document).ready(function(){
	    var dayof = "";
	     $('#send').click(function(){
	      $('input[name="dayof"]:checked').each(function(idx){
	       if(idx != 0){
	        dayof = dayof + ","
	       }
	       dayof = dayof + $(this).val();
	      });
	      $('#dayofs').val(dayof);
	     });
	    });
	    $(document).ready(function(){
	        var on_off = "";
	         $('#send').click(function(){
	          $('input[name="on_off"]:checked').each(function(idx){
	           if(idx != 0){
	            on_off = on_off + ","
	           }
	           on_off = on_off + $(this).val();
	          });
	          $('#on_offs').val(on_off);
	         });
	        });
   </script>
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
                            <h1 class="tm-sitename text-uppercase"><a href="Main.jsp"><i>An zzi</i></a></h1>
                            <p class="tm-slogon">smart무드등</p>
                        </div>        
                    </div>
                </div>
                <div class="tm-col-right">
                    <nav class="navbar navbar-expand-lg" id="tm-main-nav">
                        <button class="navbar-toggler toggler-example mr-0 ml-auto" type="button" 
                            data-toggle="collapse" data-target="#navbar-nav" 
                            aria-controls="navbar-nav" aria-expanded="false" aria-label="Toggle navigation">
                            <span><i class="fas fa-bars"></i></span>
                        </button>
                        <div class="collapse navbar-collapse tm-nav" id="navbar-nav">
                            <ul class="navbar-nav text-uppercase">
                                <li class="nav-item active">
                                    <a class="nav-link tm-nav-link" href="Time.jsp">시간설정 <span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="Calender.jsp">스케줄설정</a>
                                </li>
                               
                                <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="ServiceCenter.jsp">게시판 </a>
                                </li>                     
                                <li class="nav-item">
                                <%if(vo == null){ %>
                                    <a class="nav-link tm-nav-link" href="Login.html">로그인/회원가입</a>
                                    <%}else{ %>
                                    <a class="nav-link tm-nav-link" href="../Logout"><%=vo.getName()+"\t" %>로그아웃</a>
                                    <%} %>
                                </li>
                            </ul>                            
                        </div>                        
                    </nav>
                </div>
            </div>
            
            <div class="tm-row">
                <div class="tm-col-left"></div>
                <main class="tm-col-right">
                    <section class="tm-content">
                        <form action = "../SetTime" method="post">
                        <h3><i>wake time</i></h3>
                        <br>
                        <input type="time" min="0" max="24" value="hour" placeholder="시간" name="wake_time">
                        <button type="button" class="btn btn-primary"></button>
                        <br>
                        <br>
                            <label class="btn btn-default">
                       <input type="checkbox" name="dayof" value="Mon" autocomplete="off"><span style="color:white">월요일</span>
                   </label>
                   <label class="btn btn-default">
                       <input type="checkbox" name="dayof" value="Tue" autocomplete="off"><span style="color:white">화요일</span>
                   </label>
                   <label class="btn btn-default">
                       <input type="checkbox" name="dayof" value="Wed" autocomplete="off"><span style="color:white">수요일</span>
                   </label>
                   <label class="btn btn-default">
                       <input type="checkbox" name="dayof" value="Thu" autocomplete="off"><span style="color:white">목요일</span>
                   </label>
                   <label class="btn btn-default">
                       <input type="checkbox" name="dayof" value="Fri" autocomplete="off"><span style="color:white">금요일</span>
                   </label>
                   <label class="btn btn-default">
                       <input type="checkbox" name="dayof" value="Sat" autocomplete="off"><span style="color:white">토요일</span>
                   </label>
                   <label class="btn btn-default">
                       <input type="checkbox" name="dayof" value="Sun" autocomplete="off"><span style="color:white">일요일</span>
                   </label>
                        <br>
                        <br>
                        <br>
                        <h3><i>fade in</i></h3>
                        <br>

                        <label><input type="radio" value="10" class="btn btn-primary" name="fade_in">&nbsp;&nbsp;10분&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>                         
                        <label><input type="radio" value="20" class="btn btn-primary" name="fade_in">&nbsp;&nbsp;20분 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <label><input type="radio" value="30" class="btn btn-primary" name="fade_in">&nbsp;&nbsp;30분 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                 
                        <hr class="mb-5">
                        <table style="border-collapse: separate;border-spacing: 0 20px;">
                             <tr><td><label><input type="checkbox" name="sound" value="on">&nbsp;소리알림으로 아침을 알려드릴까요?</label></td></tr>
                             <tr><td><label><input type="checkbox" name="weather_sound" value="on"> &nbsp;날씨소리로 아침을 알려드릴까요?</label></td></tr>
                             <tr><td><label><input type="checkbox" name="schedule" value="on"> &nbsp;스케줄알림으로 아침을 알려드릴까요?</label></td></tr>
                             <tr><td><label><input type="checkbox" name="pattern" value="on">&nbsp;수면패턴기능을 이용하시겠습니까? </label></td></tr>
                         </table>   
                        
                        <input type="hidden" id="dayofs" name="dayofs">
                        <input type="hidden" id="on_offs" name="on_offs">
                    <input type="submit" id="send" class="btn btn-primary value="클릭">
                        </form>
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