/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.beans;

import cl.entity.Encuesta;
import cl.entity.Estado;
import cl.entity.Opcion;
import cl.entity.Pregunta;
import cl.entity.Sede;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author joseg
 */
@Local
public interface ServicioLocal {

    //METODOS GENERALES
    void insert(Object object);
    void sincronizar(Object object);
    Object insert2(Object obj);
    
    //METODOS ENCUESTA
    Encuesta getEncuesta(long CodEncuesta);
    Encuesta getEncuesta(String descEncuesta);
    List<Encuesta> getEncuestas();
    void editarEncuesta(long codEncuesta, String titulo, long codEstado);

    
    //METODOS PREGUNTA
    Pregunta getPregunta(long codPregunta);
    Pregunta getPregunta(String pregunta);
    List<Pregunta> getPreguntas(long codEncuest);
    void editarPregunta(long codPregunta, String descPregunta, long codEncuesta);
    
    //METODOS OPCION
    Opcion getOpcion(long codOpcion);
    List<Opcion> getOpciones(long codPregunta);
    void editarOpcion(long codOpcion, String descOpcion, long codPregunta);
    
    //METODOS SEDE
    Sede getSede(long codSede);
    List<Sede> getSedes();
    void editarSede(long codSede, String nombreSede, String ciudadSede);
    
    //METODOS ESTADO
    Estado getEstado(long codEstado);
    List<Estado> getEstados();
    List<Estado> getEstado(String descEstado);
    void deleteEstado(long codEstado);
    
}
