package Model;

import Model.Comuna;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-01T14:35:38")
@StaticMetamodel(Region.class)
public class Region_ { 

    public static volatile SingularAttribute<Region, String> codigo;
    public static volatile CollectionAttribute<Region, Comuna> comunaCollection;
    public static volatile SingularAttribute<Region, Integer> id;
    public static volatile SingularAttribute<Region, String> nombre;

}