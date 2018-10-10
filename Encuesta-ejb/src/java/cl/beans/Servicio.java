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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author joseg
 */
@Stateless
public class Servicio implements ServicioLocal {

    @PersistenceContext(unitName = "Encuesta-ejbPU")
    private EntityManager em;

    
    public void insert(Object object) {
        em.persist(object);
    }
    
    @Override
    public Object insert2(Object obj) {
        em.persist(obj);
        em.flush();
        return obj;
    }

    @Override
    public void sincronizar(Object object) {
        em.merge(object);
        em.flush();
    }

    @Override
    public Encuesta getEncuesta(long CodEncuesta) {
        return em.find(Encuesta.class, CodEncuesta);
    }

    @Override
    public Encuesta getEncuesta(String descEncuesta) {
        return (Encuesta) em.createNamedQuery("Encuesta.findByEncTitle").setParameter("encTitle", descEncuesta).getResultList().get(0);
    }

    @Override
    public List<Encuesta> getEncuestas() {
        return em.createNamedQuery("Encuesta.findAll").getResultList();
    }

    @Override
    public void editarEncuesta(long codEncuesta, String titulo, long codEstado) {
        Encuesta enc = getEncuesta(codEncuesta);
        enc.setEncTitle(titulo);
        Estado est = em.find(Estado.class, codEstado);
        enc.setEstCod(est);
        em.merge(enc);
        em.flush();
        em.refresh(enc);
    }

    @Override
    public Pregunta getPregunta(long codPregunta) {
        return em.find(Pregunta.class, codPregunta);
    }

    @Override
    public Pregunta getPregunta(String descPregunta) {
        return (Pregunta) em.createNamedQuery("Pregunta.findByEncCod").setParameter("encCod", descPregunta).getResultList();
    }

    @Override
    public List<Pregunta> getPreguntas(long codEncuest) {
        return em.createNamedQuery("Pregunta.findByEncCod").setParameter("encCod", codEncuest).getResultList();
    }

    @Override
    public void editarPregunta(long codPregunta, String descPregunta, long codEncuesta) {
        Pregunta preg = getPregunta(codPregunta);
        preg.setPreDesc(descPregunta);
        em.merge(preg);
        em.flush();
        em.refresh(preg);
    }

    @Override
    public Opcion getOpcion(long codOpcion) {
        return em.find(Opcion.class, codOpcion);
    }

    @Override
    public List<Opcion> getOpciones(long codPregunta) {
        return em.createNamedQuery("Opcion.findByPreCod").setParameter("preCod", codPregunta).getResultList();
    }

    @Override
    public void editarOpcion(long codOpcion, String descOpcion, long codPregunta) {
        Opcion opc = getOpcion(codOpcion);
        opc.setOpcDesc(descOpcion);
        em.merge(opc);
        em.flush();
        em.refresh(opc);
    }

    @Override
    public Sede getSede(long codSede) {
        return em.find(Sede.class, codSede);
    }

    @Override
    public List<Sede> getSedes() {
        return em.createNamedQuery("Sede.findAll").getResultList();
    }

    @Override
    public void editarSede(long codSede, String nombreSede, String ciudadSede) {
        Sede sed = getSede(codSede);
        sed.setSedNombre(nombreSede);
        sed.setSedCiudad(ciudadSede);
        em.merge(sed);
        em.flush();
        em.refresh(sed);
    }

    @Override
    public Estado getEstado(long codEstado) {
        return em.find(Estado.class, codEstado);
    }

    @Override
    public List<Estado> getEstado(String descEstado) {
        return em.createNamedQuery("Estado.findByEstDesc").setParameter("estDesc", descEstado).getResultList();
    }

    @Override
    public List<Estado> getEstados() {
        return em.createNamedQuery("Estado.findAll").getResultList();
    }

    @Override
    public void deleteEstado(long codEstado) {
//        Query query = em.createQuery(
//                "DELETE FROM ESTADO e WHERE e.EST_COD = :cod");
//        int deletedCount = query.setParameter("cod", codEstado).executeUpdate();

        em.getTransaction().begin();
        em.remove(getEstado(codEstado));
        em.getTransaction().commit();
    }

}
