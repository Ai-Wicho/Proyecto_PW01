<jsp:include page="head.jsp">
    <jsp:param name="nameSecc" value="Register"/>
</jsp:include>
<%@include file= "navbar.jsp" %> 
<%  String messageType = (String) request.getAttribute("message_type");
    String message =(String) request.getAttribute("message");
    if(messageType != null){%>
    <jsp:include page="notification.jsp">
        <jsp:param name="messageType" value="<%= messageType %>"/>
        <jsp:param name="message" value="<%= message %>"/>
    </jsp:include>
<%}%>
<!--------------------------------------------------------- CONTENT --------------------------------------------------------->
       <link rel="stylesheet" href="assets/css/register.css">
        <div class="model-dialog text-center ">
            <div class="col-sm-4 main-section">
                <div class="modal-content model-content-main">
                    <div class="col-12">
                        <img src="https://thecinenews.com/cine-news.png" alt="">
                    </div>
                    <form action="./Register" method="POST" class="col-12">
                        <div class="form-group">
                            <input type="text" name="user_name" id="" placeholder="Enter User Name" class="form-control">
                        </div>
                        <div class="form-group">
                            <input type="email" name="user_email" id="" placeholder="Enter Email" class="form-control">
                        </div>
                        <div class="form-group">
                            <input type="password" name="user_password" id="" placeholder="Enter Password" class="form-control">
                        </div>
                        <div class="form-group">
                            <input type="password" name="user_password_conf" id="" placeholder="Confirm Password" class="form-control">
                        </div>
                        <button id="btn-register-id" type="submit" class="btn btn-primary col-6">Register</button>
                    </form>
                    <a href="Login" class="login-a">Login</a>
                </div>
            </div>
        </div>
    </body>
</html>
