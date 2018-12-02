package Model;

import Model.Cliente;
import Model.Tecnico;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-01T14:35:38")
@StaticMetamodel(Solicitud.class)
public class Solicitud_ { 

    public static volatile SingularAttribute<Solicitud, Cliente> cliente;
    public static volatile SingularAttribute<Solicitud, String> caracteristicas;
    public static volatile SingularAttribute<Solicitud, String> estado;
    public static volatile SingularAttribute<Solicitud, Integer> id;
    public static volatile SingularAttribute<Solicitud, Tecnico> tecnico;

}