package cl.entity;

import cl.entity.Estado;
import cl.entity.Pregunta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-25T11:19:42")
@StaticMetamodel(Encuesta.class)
public class Encuesta_ { 

    public static volatile SingularAttribute<Encuesta, Estado> estCod;
    public static volatile SingularAttribute<Encuesta, Long> encCod;
    public static volatile SingularAttribute<Encuesta, String> encTitle;
    public static volatile ListAttribute<Encuesta, Pregunta> preguntaList;

}