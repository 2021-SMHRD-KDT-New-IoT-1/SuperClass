<%@page import="java.util.ArrayList"%>
<%@page import="com.model.ServiceCenterDAO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.model.ServiceCenterVO"%>
<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>ANZZI</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet" /> <!-- https://fonts.google.com/ -->
    <link href="css/bootstrap.min.css" rel="stylesheet" /> <!-- https://getbootstrap.com/ -->
    <link href="fontawesome/css/all.min.css" rel="stylesheet" /> <!-- https://fontawesome.com/ -->
    <link href="css/templatemo-diagoona.css" rel="stylesheet" />
    <STYLE>
		#logo{
          width:250px;
          height:250px;
          position: absolute;
          background-color:transparent;
            border : 0;
		outline : 0;
       }
   
        </style>
</head>
<body>
<%
	MemberVO vo = (MemberVO)session.getAttribute("member");
	ServiceCenterDAO dao = new ServiceCenterDAO();
	int board_num = Integer.parseInt(request.getParameter("board_num"));
	ServiceCenterVO svo = dao.getContents(board_num);
	System.out.print(board_num);
	%>
<div class="tm-container">        
        <div>
            <div class="tm-row pt-4">
                <div class="tm-col-left">
                    <div class="tm-site-header media">
                        <i class="fas fa-umbrella-beach fa-3x mt-1 tm-logo"></i>
                        <div class="media-body">
                            <div class="media-body">
                               <button href="Main.jsp" id="logo">
                           <img src="img/an3.png">
                        </button>  
                            </div>        
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
                                <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="Time.jsp">시간설정</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="Calendar.jsp">스케줄설정</a>
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
                            </ul>                            
                        </div>                        
                    </nav>
                </div>
            </div>
            
            <div class="tm-row">
                <div class="tm-col-left"></div>
                <main class="tm-col-right">
                    <section class="tm-content">
                        		<h1 style="text-align:center">게시판</h1>
                        		<hr class="mb-5">
                        		<form action="../DeleteServiceCenter" method="post">
                               <table border="1">
                                  <tr>
                                     <th width="200" height="50" style="text-align:center">제목</th>
                                     <th width="500" height="50" style="text-align:center"><%=svo.getBoardTitle() %></th>
                                  </tr>
                                  <input type="hidden" name="board_num" value="<%=board_num%>">
                                  <tr>
                                     <th width="200" height="50"style="text-align:center">회원아이디</th>
                                     <th width="500" height="50" style="text-align:center"><%=svo.getMid()%></th>
                                  </tr>   
                                 
                                  <tr>
                                     <th width="200" height="50"style="text-align:center">날짜</th>
                                     <th width="500" height="50" style="text-align:center" name="board_date"><%=svo.getBoardDate() %></th>
                               </tr>
                                  <tr>
                                     <th colspan="2" width="200" height="50"style="text-align:center">내용</th>
                                     
                               </tr>
                                <tr>
                               <td colspan="2" width="500" height="50" style="text-align:center"><%=svo.getBoardContents() %></td>
                               </tr>
                               </table>
                               <%if(vo.getId().equals(svo.getMid())) {%>
                               <table>
                               <tr>
                                     <th width="200" height="10"style="text-align:center"></th>
                                     <th width="500" height="10" style="text-align:center"></th>
                               </tr>
                               <tr>
                               <td colspan="2" width="500" height="50" style="text-align:center"><input type="submit" class="btn btn-primary" value="글삭제"></td>
                               </tr>
                               </table>
                               <%} %>
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