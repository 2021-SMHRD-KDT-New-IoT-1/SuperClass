<%@page import="java.util.ArrayList"%>
<%@page import="com.model.ProductDAO"%>
<%@page import="com.model.ProductVO"%>
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
    	.btnsa{
    	border : 0;
		outline : 0;
		background-color:transparent;
		color : white;
    	}
    </style>
</head>
<body>
<%
MemberVO vo = (MemberVO)session.getAttribute("member");
String m_id = vo.getId();
ProductDAO pdao = new ProductDAO();
ArrayList<ProductVO> pal = pdao.getAnzzi(m_id);
	
	%>
<div class="tm-container">        
        <div>
            <div class="tm-row pt-4">
                <div class="tm-col-left">
                    <div class="tm-site-header media">
                        <i class="fas fa-umbrella-beach fa-3x mt-1 tm-logo"></i>
                        <div class="media-body">
                            <div class="media-body">
                                <h1 class="tm-sitename text-uppercase"><a href="Main.jsp"><i>An zzi</i></a></h1>
                                <p class="tm-slogon">smart무드등</p>
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
                    <%for(ProductVO pvo : pal){ %>
						<div class="media my-3 mb-5 tm-service-media tm-service-media-img-l">
							<a href="SelectAnzziDetail.jsp"><button class="btnsa">
									<img src="img/3-1.jpg" alt="Image" class="tm-service-img".btnsa>
								</button></a>
							<div class="media-body tm-service-text">
								<br>
								<h2 class="mb-4 tm-content-title"><%=pvo.getP_serialnum() %></h2>
								<p><%=pvo.getDetail_location() %></p>
								<p><%=pdao.getWeather("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=" + pvo.getP_location()) %></p>
								<br><br><br>
							</div>
							<% }%> 
							  
							</div>
								<div class="media-body tm-service-text">			
									<div class="media my-3 mb-5 tm-service-media tm-service-media-img-l">
										<input style = "float : right" id="input_submit"type="submit" onclick="input()" value="확인">
										<input style = "float : right" id="input_date" type="date">
									</div>
									<canvas style="color:white"  id='cvs'></canvas>
								</div>
							          
                          
                    </section>
                </main>
                <div>
                	
                </div>
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
	<script>
	function input(){
	    const dday = document.querySelector("#input_date").value;
	    console.log(dday);
	}
	
	
	// data
	data = [0, 1, 1, 0, 1, 0, 1, 1, 1, 0];

	const cvs = document.getElementById("cvs");
	const ctx = cvs.getContext("2d");

	cvs.height = window.innerHeight/3;
	cvs.width = window.innerWidth/3;

	// mouse position
	mx = 0;
	my = 0;

	function draw() {
	  const pad = 50;
	  const chartInnerWidth = cvs.width - 2 * pad;
	  const chartInnerHeight = cvs.height - 2 * pad;

	  ctx.moveTo(pad, pad);
	  ctx.lineTo(pad, pad + chartInnerHeight);
	  ctx.stroke();

	  ctx.moveTo(pad, pad + chartInnerHeight);
	  ctx.lineTo(pad + chartInnerWidth, pad + chartInnerHeight);
	  ctx.stroke();
	
	  
	  max = Math.max(...data);
	  min = 0
	  nX = data.length;
	  nY = max + 1;

	  blockWidth = chartInnerWidth / (nX + 1);
	  blockHeight = chartInnerHeight / (nY + 1);

	  // drawing ticks
	  const ticklenhalf = 5;
	  for (i = 1; i < nX + 1; ++i) {
		  
	    ctx.moveTo(pad + i * blockWidth, pad + chartInnerHeight - ticklenhalf);
	    ctx.lineTo(pad + i * blockWidth, pad + chartInnerHeight + ticklenhalf);
	    ctx.stroke();
	  }

	  for (i = 1; i < nY + 1; ++i) {
	    ctx.moveTo(pad - ticklenhalf, pad + chartInnerHeight - i * blockHeight);
	    ctx.lineTo(pad + ticklenhalf, pad + chartInnerHeight - i * blockHeight);
	    ctx.stroke();
	    ctx.font = "15px Arial";
	    ctx.textAlign = "right";
	    ctx.textBaseline = "middle";
	    ctx.fillText(
	      (min + i - 1).toString(),
	      pad - 20,
	      pad + chartInnerHeight - i * blockHeight
	    );
	  }

	  xOnCvs = [];
	  yOnCvs = [];

	  // where to draw
	  x = pad + blockWidth;
	  y = pad + chartInnerHeight - blockHeight * (data[0] - min + 1);

	  xOnCvs.push(x);
	  yOnCvs.push(y);

	  for (i = 1; i < nX; ++i) {
	    xOnCvs.push(pad + (i + 1) * blockWidth);
	    yOnCvs.push(pad + chartInnerHeight - blockHeight * (data[i] - min + 1));
	  }

	  function drawlines() {
	    ctx.fillStyle = "white";
	    ctx.strokeStyle = "white";
	    x = xOnCvs[0];
	    y = yOnCvs[0];

	    ctx.beginPath();
	    ctx.arc(x, y, 5, 0, 2 * Math.PI);
	    ctx.fill();

	    for (i = 1; i < nX; ++i) {
	      nextx = xOnCvs[i];
	      nexty = yOnCvs[i];

	      ctx.moveTo(x, y);
	      ctx.lineTo(nextx, nexty);
	      ctx.stroke();

	      ctx.beginPath();
	      ctx.arc(nextx, nexty, 5, 0, 2 * Math.PI);
	      ctx.fill();

	      x = nextx;
	      y = nexty;
	    }
	  }

	  for (i = 0; i < nX; ++i) {
	    dx = xOnCvs[i] - mx;
	    dy = yOnCvs[i] - my;
	    ctx.font = "30px Arial";
	    if (dx * dx + dy * dy < 100) {
	      ctx.fillStyle = "white";
	      ctx.fillRect(xOnCvs[i], yOnCvs[i] - 40, 40, 40);
	      ctx.textAlign = "center";
	      ctx.textBaseline = "middle";
	      ctx.fillStyle = "white";
	      ctx.fillText(data[i].toString(), xOnCvs[i] + 20, yOnCvs[i] + 20 - 40);
	    }
	  }
	  drawlines();
	}

	window.addEventListener("resize", function () {
	  cvs.width = window.innerWidth/3;
	  cvs.height = window.innerHeight/3;

	  draw();
	});

	cvs.addEventListener(
	  "mousemove",
	  function (event) {
	    cvsrect = this.getBoundingClientRect();
	    ctx.clearRect(0, 0, cvsrect.width, cvsrect.height);
	    mx = event.offsetX;
	    my = event.offsetY;
	    draw();
	  },
	  false
	);

	draw();
	</script>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.backstretch.min.js"></script>
    <script src="js/templatemo-script.js"></script>
</body>

</html>