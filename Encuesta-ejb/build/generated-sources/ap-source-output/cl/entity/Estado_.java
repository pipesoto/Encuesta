package cl.entity;

import cl.entity.Encuesta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-25T11:19:42")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, Long> estCod;
    public static volatile SingularAttribute<Estado, String> estDesc;
    public static volatile ListAttribute<Estado, Encuesta> encuestaList;

}