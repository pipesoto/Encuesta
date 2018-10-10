<%-- 
    Document   : index
    Created on : 12-07-2018, 19:55:08
    Author     : joseg
--%>

<%@page import="cl.entity.Sede"%>
<%@page import="cl.entity.Encuesta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.entity.Estado"%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="cl.beans.ServicioLocal"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! ServicioLocal service;%>
<%

    InitialContext ctx = new InitialContext();
    service = (ServicioLocal) ctx.lookup("java:global/Encuesta/Encuesta-ejb/Servicio!cl.beans.ServicioLocal");
    List<Encuesta> encuestas = service.getEncuestas();
    List<Sede> sedes = service.getSedes();
    Estado disponible= service.getEstado(1);

%>
<c:set var="encuestas" value="<%=encuestas%>" scope="application" />
<c:set var="disp" value="<%=disponible%>" scope="application" />
<c:set var="sedes" value="<%=sedes%>" scope="page" />
<!DOCTYPE html>
<html>
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
                    <h4 class=""><b>Responde una Encuesta</b></h4>
                </div>
                <c:if test="${empty requestScope.encuesta}">
                    <form class="card col-12" action="respondeencuesta" method="get">
                        <div class="clearfix"></div>
                        <div class="col-2"><br></div>
                        <div class="form-row">
                            <label for="encuesta" class="col-2 col-form-label">Título de encuesta: </label>
                            <div class="col-8">
                                <select class="form-control" id="encuesta" name="encuesta" required>
                                    <option value="0" disabled selected>Seleccione una encuesta...</option>
                                    <c:forEach items="${encuestas}" var="e">
                                        <c:if test="${e.estCod==disp}">
                                        <option value="${e.encCod}">${e.encTitle}</option>
                                        </c:if>
                                        
                                    </c:forEach>
                                </select>
                                <br>
                            </div>
                        </div>
                        <div class="form-row">
                            <label for="sede" class="col-2 col-form-label">Sede: </label>
                            <div class="col-8">
                                <select class="form-control" id="sede" name="sede" required>
                                    <option value="0" disabled selected>Seleccione una sede...</option>
                                    <c:forEach items="${sedes}" var="s">
                                        <option value="${s.sedCod}">${s.sedNombre}</option>
                                    </c:forEach>>
                                </select>
                                <br>
                            </div>
                        </div>
                        <div class="form-row mx-auto">
                            <button type="submit" class="btn btn-primary">Siguiente</button>
                        </div>

                        <div class="clearfix"></div>
                        <div class="col-2"><br></div>
                    </form>

                </c:if>




                <c:if test="${not empty requestScope.encuesta}">
                    <c:set var="encuesta" value="${requestScope.encuesta}" scope="page" />


                    <form class="card col-12" action="fin.jsp" method="get">
                        <div class="clearfix"></div>
                        <div class="col-2"><br></div>
                        <div class="form-row">
                            <label for="title" class="col-2 col-form-label">Título: </label>
                            <div class="col-8">
                                <input type="text" class="form-control" id="title"  name="title" value="${encuesta.encTitle}" readonly>
                                <input type="text" class="form-control" id="codEncuesta"  hidden name="codEncuesta" value="${encuesta.encCod}">
                                <br>
                            </div>
                        </div>
                        
                        <div class="clearfix"></div>
                        <div class="col-2"><br></div>
                            <% int j = 1;%>
                            <c:forEach items="${encuesta.preguntaList}" var="p">
                                <c:set var="j" value="<%=j%>" scope="page" />
                            <div class="clearfix"></div>
                            <div class="col-12"><br><hr><br></div>
                            <div class="form-row">
                                <label for="preg${p.preCod}" class="col-2 col-form-label"><b>Pregunta <span>${j}</span>:</b> </label>
                                <div class="col-8">
                                    <input type="text" class="form-control" id="preg${p.preCod}" name="preg${p.preCod}" value="${p.preDesc}" readonly>
                                </div>
                                <div class="col-1"></div>

                            </div>

                            <div class="clearfix"></div>
                            <div class="col-2"><br></div>
                            <div class="col-10 mx-auto">
                                <% int i = 1;%>

                                <c:forEach items="${p.opcionList}" var="o">
                                    <c:set var="i" value="<%=i%>" scope="page" />    
                                    <div class="form-row">
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" name="opc${p.preCod}" id="opc${o.opcCod}" value="${o.opcCod}">
                                            <label class="form-check-label" for="opc${o.opcCod}">${o.opcDesc}</label>
                                        </div>
                                    </div>
                                    <div class="clearfix"></div>
                                    <div class="col-2"><br></div>
                                        <% i = i + 1;%>
                                    </c:forEach>
                                    <% j = j + 1;%>
                                </c:forEach>
                            <div class="col-12"><br></div>
                            <div class="form-row mx-auto">
                                <button type="submit" class="btn btn-primary">Siguiente</button>
                            </div>
                            <div class="clearfix"></div>
                            <div class="col-12"><br></div>
                    </form>
                </c:if>
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
