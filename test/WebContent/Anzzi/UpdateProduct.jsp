<%@page import="com.model.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.ServiceCenterDAO"%>
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
    <title>Diagoona - Services Page</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet" /> <!-- https://fonts.google.com/ -->
    <link href="css/bootstrap.min.css" rel="stylesheet" /> <!-- https://getbootstrap.com/ -->
    <link href="fontawesome/css/all.min.css" rel="stylesheet" /> <!-- https://fontawesome.com/ -->
    <link href="css/templatemo-diagoona.css" rel="stylesheet" />
<style>
	#titleboard{
		border : 0;
		outline : 0;
		background-color:transparent;
		color : white;
	}
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
	ProductVO detail = (ProductVO)session.getAttribute("PVO");
	int cnt = 1;
	%>
<div class="tm-container">        
        <div>
            <div class="tm-row pt-4">
                <div class="tm-col-left">
                    <div class="tm-site-header media">
                        <i class="fas fa-umbrella-beach fa-3x mt-1 tm-logo"></i>
                        <div class="media-body">
                            <div class="media-body">
                                 <button id="logo">
                               <a href="Main.jsp">
                           <img src="img/an3.png">
                           </a>
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
                                    <a class="nav-link tm-nav-link" href="Calender.jsp">스케줄설정</a>
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
                        		<h1 style="text-align:center">주소수정</h1>
                        		<hr class="mb-5">
                               <table >
                               <form action="../UpdateProduct" name="form" id="form" method="post">
                               	<tr>
                               		<th width="200" height="50" style="text-align:center">제품명</th>
                               		<th width="460" height="50" style="text-align:center"><select>
                               			<option>안찌뿌등</option>
                               		</select></th>
                               	</tr>
                               	<tr>
                               		<th width="200" height="50" style="text-align:center">시리얼넘버</th>
                               		<th width="460" height="50" style="text-align:center"><p><%=detail.getP_serialnum()%></p>
                               	</tr>
                               	<tr>
                               		<th width="200" height="50" style="text-align:center">주소</th>
                               		<th width="460" height="50" style="text-align:center"><input type="button" onClick="goPopup();"  value="주소찾기"/></th>
                               	</tr>
                               	<tr>
                               	
								<div id="list"></div>
                               	<div id="callBackDiv">
                               	<input type="hidden" id="admCd" name="p_location">
                               	
                               	<input type="hidden"  style="width:500px;" id="roadAddrPart1"  name="roadAddrPart1" />
								<input type="hidden"  style="width:500px;" id="addrDetail"  name="addrDetail" />
                               	<input type="hidden"  style="width:500px;" id="roadAddrPart2"  name="roadAddrPart2" />
                               	<input type="hidden"  style="width:500px;" id="engAddr"  name="engAddr" />
								<input type="hidden"  style="width:500px;" id="jibunAddr"  name="jibunAddr" />
								<input type="hidden" style="width:500px;" id="zipNo"  name="zipNo" />
								<input type="hidden"  style="width:500px;" id="rnMgtSn"  name="rnMgtSn" />
								<input type="hidden"  style="width:500px;" id="bdMgtSn"  name="bdMgtSn" />
								<input type="hidden"  style="width:500px;" id="detBdNmList"  name="detBdNmList" />
								<input type="hidden"  style="width:500px;" id="bdNm"  name="bdNm" />
								<input type="hidden"  style="width:500px;" id="bdKdcd"  name="bdKdcd" />
								<input type="hidden"  style="width:500px;" id="siNm"  name="siNm" />
								<input type="hidden"  style="width:500px;" id="sggNm"  name="sggNm" />
								<input type="hidden"  style="width:500px;" id="emdNm"  name="emdNm" />
								<input type="hidden"  style="width:500px;" id="liNm"  name="liNm" />
								<input type="hidden"  style="width:500px;" id="rn"  name="rn" />
								<input type="hidden"  style="width:500px;" id="udrtYn"  name="udrtYn" />
								<input type="hidden"  style="width:500px;" id="buldMnnm"  name="buldMnnm" />
								<input type="hidden"  style="width:500px;" id="buldSlno"  name="buldSlno" />
								<input type="hidden"  style="width:500px;" id="mtYn"  name="mtYn" />
								<input type="hidden"  style="width:500px;" id="lnbrMnnm"  name="lnbrMnnm" />
								<input type="hidden"  style="width:500px;" id="lnbrSlno"  name="lnbrSlno" />
								<input type="hidden"  style="width:500px;" id="emdNo"  name="emdNo" />
								
                               		<th colspan="2" width="330" height="50" style="text-align:center"><input name="p_locationdetail" size="40" id="roadFullAddr" type="text"></th>
                               	</tr>
                               	
                               	</div>
                               	<tr>
                               		<th colspan="2" width="330" height="50" style="text-align:center"><button type="submit" class="btn1 btn-primary">수정하기</button></th>
                               		
                               	</tr>
                               	
                               	</form>
                               
                               </table>
                               <BR>
                               
                            
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
    
    <script>
        function jusoCallBack(roadFullAddr, admCd){
        		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
        		document.form.roadFullAddr.value = roadFullAddr;
        		document.form.admCd.value = admCd;
        		window.close();
        		
        }
        function goPopup()
        {
            // window.name = "부모창 이름"; 
            window.name = "parentForm";
            // window.open("open할 window", "자식창 이름", "팝업창 옵션");
            openWin = window.open("jusoPopup.jsp",
                    "childForm", "width=570,height=420, scrollbars=yes, resizable=yes");    
        }
        
    </script>
    
</body>

</html>