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
        <title>Aministrador - Encuestando</title>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

    <body>
        <nav>
            <jsp:include page="navindex.jsp" />
        </nav>
        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <a href="admin.do?msg=Encuesta">
                        <div class="card">
                            <div class="card-body mx-auto">
                                <img src="img/checklist.png" class="img-fluid" alt="Encuestas">
                            </div>
                            <div class="card-body mx-auto">
                                <span><b>Encuesta</b></span>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-sm-6">
                    <a href="admin.do?msg=Sede">
                        <div class="card">
                            <div class="card-body mx-auto">
                                <img src="img/school.png" class="img-fluid" alt="Sedes">
                            </div>
                            <div class="card-body mx-auto">
                                <span><b>Sede</b></span>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
            <br>
            <br>

            <c:if test="${requestScope.msg eq 'Encuesta'}">
                <div class="row">
                    <div class="col-6 mx-auto">
                        <ul class="list-group">
                            <li class="list-group-item list-group-item-secondary"><h3><b>Encuesta</b></h3></li>
                            <a href="nuevaencuesta.jsp">
                                <li class="list-group-item">
                                    <div class="row">
                                        <div class="col-2 my-auto" >
                                            <img src="img/plus.png" alt="Nueva Encuesta"/>
                                        </div>
                                        <div class="col-10 my-auto">
                                            <span> Nueva Encuesta</span>
                                        </div>
                                    </div>
                                </li>
                            </a>
                            <a href="modificaencuesta.jsp">
                                <li class="list-group-item">
                                    <div class="row">
                                        <div class="col-2 my-auto" >
                                            <img src="img/tools.png" alt="Modificar Encuesta"/>
                                        </div>
                                        <div class="col-10 my-auto">
                                            <span> Modificar Encuesta</span>
                                        </div>
                                    </div>
                                </li>
                            </a>
                            <a href="estado.jsp">
                                <li class="list-group-item">
                                    <div class="row">
                                        <div class="col-2 my-auto" >
                                            <img src="img/tools.png" alt="Modificar Encuesta"/>
                                        </div>
                                        <div class="col-10 my-auto">
                                            <span> Estados de encuestas</span>
                                        </div>
                                    </div>
                                </li>
                            </a>
                        </ul>
                    </div>
                </div>
            </c:if>
            <c:if test="${requestScope.msg eq 'Sede'}">
                <div class="row">
                    <div class="col-12 col-md-6  mx-auto">
                        <ul class="list-group">
                            <li class="list-group-item list-group-item-secondary"><h3><b>Sede</b></h3></li>
                            <a href="sede.jsp">
                                <li class="list-group-item">
                                    <div class="row">
                                        <div class="col-2 my-auto" >
                                            <img src="img/plus.png" alt="Nueva Sede"/>
                                        </div>
                                        <div class="col-10 my-auto">
                                            <span> Nueva Sede</span>
                                        </div>
                                    </div>
                                </li>
                            </a>
                            <a href="sede.jsp">
                                <li class="list-group-item">
                                    <div class="row">
                                        <div class="col-2 my-auto" >
                                            <img src="img/tools.png" alt="Modificar Sede"/>
                                        </div>
                                        <div class="col-10 my-auto">
                                            <span> Modificar Sede</span>
                                        </div>
                                    </div>
                                </li>
                            </a>
                        </ul>
                    </div>
                </div>
            </c:if>
        </div>

        <footer>
            <jsp:include page="footer.jsp" />
        </footer>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
        <script src="js/vendor/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
