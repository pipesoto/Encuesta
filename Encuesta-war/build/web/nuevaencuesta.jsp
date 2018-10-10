<%-- 
    Document   : index
    Created on : 12-07-2018, 19:55:08
    Author     : joseg
--%>

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
    List<Estado> estados = service.getEstados();
%>
<c:set var="estados" value="<%=estados%>" scope="application" />
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
                    <h4 class=""><b>Registro de Encuesta</b></h4>
                </div>
                <c:if test="${empty requestScope.title}">
                    <form class="card col-12" action="nuevaencuesta1" method="get">
                        <div class="clearfix"></div>
                        <div class="col-2"><br></div>
                        <div class="form-row">
                            <label for="title" class="col-2 col-form-label">Título: </label>
                            <div class="col-8">
                                <input type="text" class="form-control" id="title" name="title" placeholder="Escriba un título para la encuesta..." required>
                                <br>
                            </div>
                        </div>
                        <div class="form-row">
                            <label for="numPreguntas" class="col-2 col-form-label">Número de Preguntas: </label>
                            <div class="col-2">
                                <input type="number" class="form-control" id="numPreguntas" name="numPreguntas" min="1" max="10" required>
                            </div>
                            <div class="col-1"></div>
                            <label for="estado" class="col-1 col-form-label">Estado: </label>
                            <div class="col-2">
                                <select class="form-control" id="estado" name="estado" required >
                                    <option value="0" disabled selected>Seleccione un estado...</option>
                                    <c:forEach items="${estados}" var="e">
                                        <option value="${e.estCod}">${e.estDesc}</option>
                                    </c:forEach>
                                </select>

                            </div>
                            <div class="col-1"></div>
                            <button type="submit" class="btn btn-primary">Siguiente</button>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-2"><br></div>
                    </form>

                </c:if>
                
                
                
                
                <c:if test="${not empty requestScope.title}">
                    <form class="card col-12" action="nuevaencuesta2" method="get">
                        <div class="form-row">
                            <label for="title" class="col-2 col-form-label">Título: </label>
                            <div class="col-8">
                                <input type="text" class="form-control" id="title"  name="title" value="${requestScope.title}"readonly>
                                <br>
                            </div>
                        </div>
                        <div class="form-row">
                            <label for="numPreguntas" class="col-2 col-form-label">Número de Preguntas: </label>
                            <div class="col-2">
                                <input type="number" class="form-control" id="numPreguntas" name="cantPreguntas" value="${requestScope.numPreguntas}" readonly>
                            </div>
                            <div class="col-1"></div>
                            <div class="col-1"></div>
                            <label for="estado" class="col-1 col-form-label">Estado: </label>
                            <div class="col-2">
                                <c:forEach items="${estados}" var="e">
                                    <c:if test="${e.estCod==requestScope.estado}">
                                        <input type="text" class="form-control" id="estado" name="estado" value="${e.estDesc}" readonly>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-2"><br></div>
                            <c:forEach items="${requestScope.preguntas}" var="p">
                            <div class="clearfix"></div>
                            <div class="col-12"><br><hr><br></div>
                            <div class="form-row">
                                <label for="pregunta${p}" class="col-2 col-form-label"><b>Pregunta <span>${p}</span>:</b> </label>
                                <div class="col-8">
                                    <input type="text" class="form-control" id="pregunta${p}" name="pregunta${p}" placeholder="Inserte pregunta..." required>
                                </div>
                                <div class="col-1"></div>

                            </div>
                            <div class="clearfix"></div>
                            <div class="col-2"><br></div>
                            <div class="col-10 mx-auto">
                                <div class="form-row">
                                    <label for="pregunta${p}opc1" class="col-2 col-form-label">Opcion 1: </label>
                                    <div class="col-8">
                                        <input type="text" class="form-control" id="pregunta${p}opc1" name="pregunta${p}opc1" placeholder="Inserte opcion de respuesta..." required>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                                <div class="col-2"><br></div>
                                <div class="form-row">
                                    <label for="pregunta${p}opc2" class="col-2 col-form-label">Opcion 2: </label>
                                    <div class="col-8">
                                        <input type="text" class="form-control" id="pregunta${p}opc2" name="pregunta${p}opc2" placeholder="Inserte opcion de respuesta..." required>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                                <div class="col-2"><br></div>
                                <div class="form-row">
                                    <label for="pregunta${p}opc3" class="col-2 col-form-label">Opcion 3: </label>
                                    <div class="col-8">
                                        <input type="text" class="form-control" id="pregunta${p}opc3" name="pregunta${p}opc3" placeholder="Inserte opcion de respuesta..." required>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                                <div class="col-2"><br></div>
                                <div class="form-row">
                                    <label for="pregunta${p}opc4" class="col-2 col-form-label">Opcion 4: </label>
                                    <div class="col-8">
                                        <input type="text" class="form-control" id="pregunta${p}opc4" name="pregunta${p}opc4" placeholder="Inserte opcion de respuesta..." required>
                                    </div>
                                </div>
                            </div>
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
