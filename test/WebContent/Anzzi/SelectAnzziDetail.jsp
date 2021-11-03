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
    <title>ANZZI</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet" /> <!-- https://fonts.google.com/ -->
    <link href="css/bootstrap.min.css" rel="stylesheet" /> <!-- https://getbootstrap.com/ -->
    <link href="fontawesome/css/all.min.css" rel="stylesheet" /> <!-- https://fontawesome.com/ -->
    <link href="css/templatemo-diagoona.css" rel="stylesheet" />
 <style>
	.btnsa {
	border : 0;
	outline : 0;
	background-color: transparent;
	color: white;
}
    	
.toggleBG {
	background: #CCCCCC;
	width: 70px;
	height: 35px;
	border: 1px solid #A9A9A9;
	border-radius: 15px;
}

.toggleFG {
	background: #FFFFFF;
	width: 35px;
	height: 35px;
	border: none;
	border-radius: 15px;
	position: relative;
	left: 0px;
	}
	#logo{
          width:250px;
          height:250px;
          position: absolute;
          background-color:transparent;
            border : 0;
		outline : 0;
</style>
</head>
<body>
<%
MemberVO vo = (MemberVO)session.getAttribute("member");
String m_id = vo.getId();
ProductDAO pdao = new ProductDAO();
ArrayList<ProductVO> pal = pdao.getAnzzi(m_id);
ProductVO detail = (ProductVO)session.getAttribute("PVO");
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
                                    <a class="nav-link tm-nav-link" href="Time.jsp">�ð�����</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="Calendar.jsp">�����ټ���</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="ServiceCenter.jsp">�Խ��� </a>
                                </li>        
                               <li class="nav-item">
                                    <a class="nav-link tm-nav-link" href="SelectAnzzi.jsp">SELECT ANZZI</a>
                                </li>                                
                                 <li class="nav-item">
                                <%if(vo == null){ %>
                                    <a class="nav-link tm-nav-link" href="Login.html">�α���/ȸ������</a>
                                    <%}else{ %>
                                    <a class="nav-link tm-nav-link" href="../Logout"><%=vo.getName()+"��\t" %>�α׾ƿ�</a>
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
                    <%if(detail != null){ %>
						<div class="media my-3 mb-5 tm-service-media tm-service-media-img-l">
							<a href="SelectAnzziDetail.jsp"><button class="btnsa">
									<img src="img/3-1.jpg" alt="Image" class="tm-service-img".btnsa>
								</button></a>
							<div class="media-body tm-service-text">
								<br>
								<h2 class="mb-4 tm-content-title"><%=detail.getP_serialnum() %></h2>
								<p><%=detail.getDetail_location() %></p>
								<p><%=pdao.getWeather("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=" + detail.getP_location()) %></p>
								<a href = "./UpdateProduct.jsp" ><button class="btn btn-primary">�����ϱ�</button></a>
								
									<label for="buttonID"><div class='toggleBG'>
                           <button id="buttonID" type="submit" class='toggleFG off' >OFF</button>
                         </div></label>
					
							</div>
							<% }%> 
							  
							</div>
								<div class="media-body tm-service-text">			
									<div class="media my-3 mb-5 tm-service-media tm-service-media-img-l">
									<form action="../SelectPattern" method="get">
										<input  type="date" name="p_date">
										<input  type="submit" value="Ȯ��">
									</form>
									</div>
									<div style="width: 600px; height: 400px;">
	<!--��Ʈ�� �׷��� �κ�-->
										<canvas id="myChart"></canvas>
									</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
									
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
	<script>
	function input(){
	    const dday = document.querySelector("#input_date").value;
	    console.log(dday);
	}
	
	<%int i = 1;%>
	// data
	data = [<%=i%>, 1, 1, 0, 1, 0, 1, 1, 1, 0,0,0,1];

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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
     <script>
     $(document).ready(function () {
    	 
    		 $.ajax({
    		     	url : "../SelectLED", //�����͸� �����ϴ� (��û�ϴ�) ����������
    				type : "get", //������ ����(��û) ���
    				dataType : "text", //���䵥������ ����
    				success : function(data) { //��ż���
    					console.log(data)			
    				},
    				error : function() { //��Ž���
    					alert("��Ž���!!")
    				}
    				});		
	}
     );
     
     
     
    $(document).on('click', '.toggleBG', function () {
        var toggleBG = $(this);
        var toggleFG = $(this).find('.toggleFG');
        if($("#buttonID").hasClass("off")){
        	$("#buttonID").addClass("on");
        	$("#buttonID").removeClass("off");
        	$("#buttonID").html("ON");
        }else{
        	$("#buttonID").addClass("off");
        	$("#buttonID").removeClass("on");
        	$("#buttonID").html("OFF");
        }
        
        	
        
        	
        
        var left = toggleFG.css('left');
        if(left == '40px') {
            toggleBG.css('background', '#CCCCCC');
            toggleActionStart(toggleFG, 'TO_LEFT');
        }else if(left == '0px') {
            toggleBG.css('background', '#53FF4C');
            toggleActionStart(toggleFG, 'TO_RIGHT');
        }
    });
     
    // ��� ��ư �̵� ��� �Լ�
    
    function toggleActionStart(toggleBtn, LR) {
        // 0.01�� ������ ����
        var intervalID = setInterval(
            function() {
                // ��ư �̵�
                var left = parseInt(toggleBtn.css('left'));
                left += (LR == 'TO_RIGHT') ? 5 : -5;
                if(left >= 0 && left <= 40) {
                    left += 'px';
                    toggleBtn.css('left', left);
                }
            }, 10);
        setTimeout(function(){
            clearInterval(intervalID);
        }, 201);
        
    }
    
   	$("#buttonID").on('click',function(){
   	 $.ajax({
     	url : "../onOffLED", //�����͸� �����ϴ� (��û�ϴ�) ����������
		type : "get", //������ ����(��û) ���
		dataType : "text", //���䵥������ ����
		success : function(data) { //��ż���
			console.log(data)			
		},
		error : function() { //��Ž���
			alert("��Ž���!!")
		}
		});	
   		
   	
   	})
   	
    
    
    function getToggleBtnState(toggleBtnId){
        const left_px = parseInt( $('#'+toggleBtnId).css('left') );
        
        $.ajax({
        	url : "../onOffLED", //�����͸� �����ϴ� (��û�ϴ�) ����������
        
			type : "get", //������ ����(��û) ���
			data : {
				"m_id" : email.value
			}, //�����ϴ� ������
			dataType : "text", //���䵥������ ����
			success : function(data) { //��ż���
				let sp_result = document.getElementById("sp_result");
				//alert(data)
				if (data == "true") {
					sp_result.innerText = "���Ұ����� ���̵�";
				} else {
					$("#sp_result").text("��밡���� ���̵�");
				}
			},
			error : function() { //��Ž���
				alert("��Ž���!!")
			}
		});
    }
    
    
   
    </script>
    <script>
    var min = 1500;
	new Chart(document.getElementById("line-chart"), {
  
		type: 'line',
  data: {
    labels: [min,min+109,1700,1750,1800,1850,1900,1950,1999,2050],
    datasets: [{ 
        data: [86,114,106,106,107,111,133,221,783,2478],
        label: "ANZZI",
        borderColor: "white",
        fill: false
      }
    ]
  },
  options: {
    title: {
      display: true,
      text: '��������'
    }
  }
});
	</script>
	<script type="text/javascript">
            var context = document
                .getElementById('myChart')
                .getContext('2d');
            var myChart = new Chart(context, {
                type: 'line', // ��Ʈ�� ����
                data: { // ��Ʈ�� �� ������
                    labels: [
                        //x ��
                        
                        '1','2','3','4','5','6','7','8'
                    ],
                    datasets: [
                        { //������
                            label: '<%=detail.getP_serialnum()%>', //��Ʈ ����
                            fill: false, // line ������ ��, �� ������ ä����� ��ä�����
                            data: [
                                1,0,1,1,0,1,1,1 //x�� label�� �����Ǵ� ������ ��
                            ],
                            backgroundColor: [
                                //����
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                //��輱 ����
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1 //��輱 ����
                        }/* ,
                        {
                            label: 'test2',
                            fill: false,
                            data: [
                                8, 34, 12, 24
                            ],
                            backgroundColor: 'rgb(157, 109, 12)',
                            borderColor: 'rgb(157, 109, 12)'
                        } */
                    ]
                },
                options: {
                    scales: {
                        yAxes: [
                            {
                                ticks: {
                                    beginAtZero: true
                                }
                            }
                        ]
                    }
                }
            });
        </script>
</body>

</html>