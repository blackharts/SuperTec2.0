package Model;

import Model.Tecnico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-06T23:10:36")
@StaticMetamodel(TipoTecnico.class)
public class TipoTecnico_ { 

    public static volatile CollectionAttribute<TipoTecnico, Tecnico> tecnicoCollection;
    public static volatile SingularAttribute<TipoTecnico, Integer> id;
    public static volatile SingularAttribute<TipoTecnico, String> especialidad;

}