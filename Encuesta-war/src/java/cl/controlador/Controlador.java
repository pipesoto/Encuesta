/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controlador;

import cl.beans.ServicioLocal;
import cl.entity.Encuesta;
import cl.entity.Estado;
import cl.entity.Opcion;
import cl.entity.Pregunta;
import cl.entity.Sede;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joseg
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador", "/admin.do", "/nuevaencuesta1", "/eliminaestado.do", "/nuevoestado", "/nuevaencuesta2", "/modificaencuesta", "/modificaencuesta2", "/sede", "/modificasede","/respondeencuesta"})
public class Controlador extends HttpServlet {

    @EJB
    private ServicioLocal servicio;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getServletPath().equals("/admin.do")) {
            String msg = request.getParameter("msg").toString();
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("admin.jsp").forward(request, response);

        } else if (request.getServletPath().equals("/nuevaencuesta1")) {
            String titulo = request.getParameter("title");
            int numpreguntas = Integer.parseInt(request.getParameter("numPreguntas"));
            ArrayList<String> preguntas = new ArrayList();
            for (int i = 0; i < numpreguntas; i++) {
                preguntas.add((i + 1) + "");
            }

            request.setAttribute("estado", request.getParameter("estado"));
            request.setAttribute("title", titulo);
            request.setAttribute("numPreguntas", numpreguntas);
            request.setAttribute("preguntas", preguntas);
            request.getRequestDispatcher("nuevaencuesta.jsp").forward(request, response);

        } else if (request.getServletPath().equals("/nuevaencuesta2")) {
            String titulo = request.getParameter("title");
            int numpreguntas = Integer.parseInt(request.getParameter("cantPreguntas"));
            ArrayList<String> preguntas = new ArrayList();
            Encuesta enc = new Encuesta();
            enc.setEncTitle(titulo);
            Estado est = servicio.getEstado(request.getParameter("estado")).get(0);
            enc.setEstCod(est);
            enc = (Encuesta) servicio.insert2(enc);

            for (int i = 0; i < numpreguntas; i++) {
                Pregunta preg = new Pregunta();
                preg.setPreDesc(request.getParameter("pregunta" + (i + 1)));
                preg.setEncCod(enc);
                preg = (Pregunta) servicio.insert2(preg);
                enc.getPreguntaList().add(preg);
                servicio.sincronizar(enc);

                Opcion opcion1 = new Opcion();
                opcion1.setOpcDesc(request.getParameter("pregunta" + (i + 1) + "opc1"));
                opcion1.setPreCod(preg);
                servicio.insert(opcion1);
                preg.getOpcionList().add(opcion1);
                Opcion opcion2 = new Opcion();
                opcion2.setOpcDesc(request.getParameter("pregunta" + (i + 1) + "opc2"));
                opcion2.setPreCod(preg);
                servicio.insert(opcion2);
                preg.getOpcionList().add(opcion2);
                Opcion opcion3 = new Opcion();
                opcion3.setOpcDesc(request.getParameter("pregunta" + (i + 1) + "opc3"));
                opcion3.setPreCod(preg);
                servicio.insert(opcion3);
                preg.getOpcionList().add(opcion3);
                Opcion opcion4 = new Opcion();
                opcion4.setOpcDesc(request.getParameter("pregunta" + (i + 1) + "opc4"));
                opcion4.setPreCod(preg);
                servicio.insert(opcion4);
                preg.getOpcionList().add(opcion4);

                servicio.sincronizar(preg);

            }
            response.sendRedirect("index.jsp");

        } else if (request.getServletPath().equals("/eliminaestado.do")) {
            servicio.deleteEstado(Long.parseLong(request.getParameter("cod")));
            response.sendRedirect("estado.jsp");

        } else if (request.getServletPath().equals("/nuevoestado")) {
            Estado est = new Estado();
            est.setEstDesc(request.getParameter("estado"));
            Long pk = ((Estado) servicio.insert2(est)).getEstCod();
            System.out.println(pk);
            response.sendRedirect("index.jsp");

        } else if (request.getServletPath().equals("/modificaencuesta")) {

            Encuesta enc = servicio.getEncuesta(Long.parseLong(request.getParameter("encuesta")));
            int numPreguntas = enc.getPreguntaList().size();
            request.setAttribute("encuesta", enc);
            request.setAttribute("numPreguntas", numPreguntas);
            request.getRequestDispatcher("modificaencuesta.jsp").forward(request, response);

        } else if (request.getServletPath().equals("/modificaencuesta2")) {
            Long codEncuesta = Long.parseLong(request.getParameter("codEncuesta"));
            System.out.println(codEncuesta);
            String titulo = request.getParameter("title");
            Long codEstado = Long.parseLong(request.getParameter("estado"));
            System.out.println(codEstado);
            servicio.editarEncuesta(codEncuesta, titulo, codEstado);
            Encuesta enc = servicio.getEncuesta(codEncuesta);

            List<Pregunta> preguntas = enc.getPreguntaList();
            for (Pregunta p : preguntas) {
                p.setPreDesc(request.getParameter("preg" + p.getPreCod()));
                p.setEncCod(enc);
                servicio.editarPregunta(p.getPreCod(), p.getPreDesc(), enc.getEncCod());

                List<Opcion> opciones = p.getOpcionList();
                for (Opcion o : opciones) {
                    o.setOpcDesc(request.getParameter("opc" + o.getOpcCod()));
                    o.setPreCod(p);
                    servicio.editarOpcion(o.getOpcCod(), o.getOpcDesc(), p.getPreCod());
                }
                servicio.sincronizar(p);
            }

            response.sendRedirect("index.jsp");

        } else if (request.getServletPath().equals("/sede")) {
            if (request.getParameter("codAccion").equals("1")) {
                Sede sede = new Sede();
                sede.setSedNombre(request.getParameter("sede"));
                sede.setSedCiudad("x");
                servicio.insert2(sede);
                
            }else if (request.getParameter("codAccion").equals("2")) {
                Sede sede= servicio.getSede(Long.parseLong(request.getParameter("codSede")));
                sede.setSedNombre(request.getParameter("sede"));
                sede.setSedCiudad("x");
                servicio.editarSede(sede.getSedCod(), sede.getSedNombre(), sede.getSedCiudad());
            }
            response.sendRedirect("sede.jsp");

        } else if (request.getServletPath().equals("/modificasede")) {
            Sede sede= servicio.getSede(Long.parseLong(request.getParameter("sedCod")));
            request.setAttribute("sede", sede);
            request.getRequestDispatcher("sede.jsp").forward(request, response);
            
        }else if (request.getServletPath().equals("/respondeencuesta")) {
            Encuesta enc= servicio.getEncuesta(Long.parseLong(request.getParameter("encuesta")));
            request.setAttribute("encuesta", enc);
            request.getRequestDispatcher("usuario.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().equals("/nuevoestado.do")) {
            Estado est = new Estado();
            est.setEstDesc(request.getParameter("estado"));
            servicio.insert(est);
            response.sendRedirect("index.jsp");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
