<%-- 
    Document   : index
    Created on : 12-07-2018, 19:55:08
    Author     : joseg
--%>


<%@page import="cl.entity.Sede"%>
<%@page import="java.util.List"%>
<%@page import="cl.entity.Estado"%>
<%@page import="cl.entity.Estado"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="cl.beans.ServicioLocal"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! ServicioLocal service;%>
<%
    
    InitialContext ctx = new InitialContext();
    service = (ServicioLocal) ctx.lookup("java:global/Encuesta/Encuesta-ejb/Servicio!cl.beans.ServicioLocal");
    List<Sede> sedes = service.getSedes();
%>
<c:set var="sedes" value="<%=sedes%>" scope="application" />
<!DOCTYPE html>
<html>
    <head>
    <head>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-theme.css">
        <title>Sede - Encuestando</title>
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
                <div class="col-4 mx-auto">
                    <h4 class=""><b>Registro de Sedes</b></h4>
                </div>
                <form class="card col-12" action="sede" method="get">
                    <div class="clearfix"></div>
                    <div class="col-2"><br></div>
                    <div class="form-row">
                        <label for="estado" class="col-2 col-form-label">Sede: </label>
                        <div class="col-8">
                            <c:if test="${empty requestScope.sede}">
                                <input type="text" class="form-control" id="sede" name="sede" placeholder="Escriba nombre de sede..." required>
                                <input type="text" class="form-control" id="codAccion" name="codAccion" value="1" hidden>
                            </c:if>
                            <c:if test="${not empty requestScope.sede}">
                                <input type="text" class="form-control" id="sede" name="sede" value="${sede.sedNombre}" required>
                                <input type="text" class="form-control" id="codSede" name="codSede" value="${sede.sedCod}" hidden>
                                <input type="text" class="form-control" id="codAccion" name="codAccion" value="2" hidden>
                            </c:if>
                                
                            <br>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Siguiente</button>
                    <div class="clearfix"></div>
                    <div class="col-2"><br></div>
                </form>
            </div>
            <br>
            <div class="row clearfix">
                <table class="table col-12">
                    <thead>
                        <tr>
                            <th scope="col">Código</th>
                            <th scope="col">Sede</th>
                            <th scope="col">Modificar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sedes}" var="s">
                        <tr>
                            <th scope="row">${s.sedCod}</th>
                            <td>${s.sedNombre}</td>
                            <td><a href="modificasede?sedCod=${s.sedCod}"><span>Modificar</span></a></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

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
