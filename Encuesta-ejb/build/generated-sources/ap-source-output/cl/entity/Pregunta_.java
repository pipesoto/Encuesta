package cl.entity;

import cl.entity.Encuesta;
import cl.entity.Opcion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-25T11:19:42")
@StaticMetamodel(Pregunta.class)
public class Pregunta_ { 

    public static volatile SingularAttribute<Pregunta, Long> preCod;
    public static volatile ListAttribute<Pregunta, Opcion> opcionList;
    public static volatile SingularAttribute<Pregunta, String> preDesc;
    public static volatile SingularAttribute<Pregunta, Encuesta> encCod;

}