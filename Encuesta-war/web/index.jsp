<%-- 
    Document   : index
    Created on : 12-07-2018, 19:55:08
    Author     : joseg
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-theme.css">
        <title>Home - Encuestando</title>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

    <body>
            <nav>
                <jsp:include page="navindex.jsp" />
            </nav>
            <div class="row">
                <div class="col-3"><img src="img/index2.png"/></div>
                <div class="col-3"><img src="img/index1.png"/></div>
                <div class="col-3"><img src="img/index3.png"/></div>
                <div class="col-3"><img src="img/index4.png"/></div>
            </div>
            <div class="row">
                <div class="col-3"><img src="img/index3.png"/></div>
                <div class="col-3"><img src="img/index4.png"/></div>
                <div class="col-3"><img src="img/index1.png"/></div>
                <div class="col-3"><img src="img/index2.png"/></div>
            </div>
            <div class="row">
                <div class="col-3"><img src="img/index4.png"/></div>
                <div class="col-3"><img src="img/index3.png"/></div>
                <div class="col-3"><img src="img/index2.png"/></div>
                <div class="col-3"><img src="img/index1.png"/></div>
            </div>
        
        
        <script src="/static/js/bootstrap.js"></script>
        <script>
            $(function () {
                $(".button-collapse").sideNav();
            });
            $(document).ready(function () {
                $('.parallax').parallax();
            });
        </script>
        <footer>
            <jsp:include page="footer.jsp" />
        </footer>
    </body>
</html>
