<%-- 
    Document   : index
    Created on : 12-07-2018, 19:55:08
    Author     : joseg
--%>


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
    List<Estado> estados = service.getEstados();
%>
<c:set var="listaestados" value="<%=estados%>" scope="application" />
<!DOCTYPE html>
<html>
    <head>
    <head>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap-theme.css">
        <title>Nueva Encuesta - Encuestando</title>
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
                    <h4 class=""><b>Registro de Estado</b></h4>
                </div>
                <form class="card col-12" action="nuevoestado" method="get">
                    <div class="clearfix"></div>
                    <div class="col-2"><br></div>
                    <div class="form-row">
                        <label for="estado" class="col-2 col-form-label">Estado: </label>
                        <div class="col-8">
                            <input type="text" class="form-control" id="estado" name="estado" placeholder="Escriba un estado...">
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
                            <th scope="col">#</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Last</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaestados}" var="e">
                        <tr>
                            <th scope="row">${e.estCod}</th>
                            <td>${e.estDesc}</td>
                            <td><a href="eliminaestado.do?cod=${e.estCod}"><span>Eliminar</span></a></td>
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
