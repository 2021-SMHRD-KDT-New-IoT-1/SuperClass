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
        <script src="js/jquery-3.4.1.min.js"></script>
        <style>
        .dayCheck{
        display: none;
        }
        .dayCheck + label{
           background-color: white;
          border: 1px solid #cacece;
          box-shadow: 0 1px 2px rgba(0,0,0,0.05), inset 0px -15px 10px -12px rgba(0,0,0,0.05);
          padding: 9px;
          border-radius: 3px;
          display: inline-block;
          position: relative;
          color : black;
          
        }
        
        .dayCheck:checked + label {
          background-color: #2F4F4F;
          border: 1px solid #adb8c0;
          color : white;
    
      }
        </style>
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
                            <p class="tm-slogon">smart�����</p>
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
                                    <a class="nav-link tm-nav-link" href="Time.jsp">�ð����� <span class="sr-only">(current)</span></a>
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
                                    <a class="nav-link tm-nav-link" href="../Logout"><%=vo.getName()+"\t" %>�α׾ƿ�</a>
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
                        <h3><i>wake time</i></h3>
                        <br>
                        <input type="time" min="0" max="24" value="hour" placeholder="�ð�" name="wake_time">
                        <!-- <button type="submit" class="btn btn-primary">����</button> -->
                        <br>
                        <br>
                        <form>
                        <input id = "ckbox1" type= "checkbox" name = "selectDay" value = "mon" class="dayCheck">
                        <label for="ckbox1">��</label>
                        <input id = "ckbox2"  type= "checkbox" name = "selectDay" value = "thu" class="dayCheck">
                        <label for="ckbox2">ȭ</label>
                        <input id = "ckbox3"  type= "checkbox" name = "selectDay" value = "wed" class="dayCheck">
                        <label for="ckbox3">��</label>
                        <input id = "ckbox4"  type= "checkbox" name = "selectDay" value = "thu" class="dayCheck">
                        <label for="ckbox4">��</label>
                        <input id = "ckbox5"  type= "checkbox" name = "selectDay" value = "fri" class="dayCheck">
                        <label for="ckbox5">��</label>
                        <input id = "ckbox6"  type= "checkbox" name = "selectDay" value = "sat" class="dayCheck">
                        <label for="ckbox6">��</label>
                        <input id = "ckbox7"  type= "checkbox" name = "selectDay" value = "sun" class="dayCheck">
                        <label for="ckbox7">��</label>
                        
                        
                        <!-- <div  class="btn1 btn-primary" >��</div>
                        <div  class="btn1 btn-primary">ȭ</div>
                        <div  class="btn1 btn-primary">��</div>
                        <div  class="btn1 btn-primary">��</div>
                        <div  class="btn1 btn-primary">��</div>
                        <div  class="btn1 btn-primary">��</div>
                        <div  class="btn1 btn-primary">��</div> -->
                        </form>
                        <br>
                        <br>
                        <h3><i>fade in</i></h3>
                        <br>
                        <button type="submit" class="btn btn-primary" value="10" name="fade_in">10��</button>
                        <button type="submit" class="btn btn-primary" value="20" name="fade_in">20��</button>
                        <button type="submit" class="btn btn-primary" value="30" name="fade_in">30��</button>
                        
                        <hr class="mb-5">
                                            
                      <table style="border-collapse: separate;border-spacing: 0 20px;">
                             <tr><td><label><input type="checkbox" name="sound" value="on">&nbsp;�Ҹ��˸����� ��ħ�� �˷��帱���?</label></td></tr>
                             <tr><td><label><input type="checkbox" name="weather_sound" value="on"> &nbsp;�����Ҹ��� ��ħ�� �˷��帱���?</label></td></tr>
                             <tr><td><label><input type="checkbox" name="schedule" value="on"> &nbsp;�����پ˸����� ��ħ�� �˷��帱���?</label></td></tr>
                             <tr><td><label><input type="checkbox" name="pattern" value="on">&nbsp;�������ϱ���� �̿��Ͻðڽ��ϱ�? </label></td></tr>
                         </table>   
                           <input type="hidden" id="dayofs" name="dayofs">
                    <input type="submit" id="send" class="btn btn-primary" value='��!'>
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
    <!-- <script>
    let divArr = []
    
   
    $(".btn1.btn-primary").on('click',function(){
       $(this).css("backgroundColor", "green");
       divArr.push($(this).html());
       console.log(divArr)
       
    }) 
    </script> -->


    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.backstretch.min.js"></script>
    <script src="js/templatemo-script.js"></script>
</body>
</html>