package Model;

import Model.Local;
import Model.Solicitud;
import Model.TipoTecnico;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-01T14:35:38")
@StaticMetamodel(Tecnico.class)
public class Tecnico_ { 

    public static volatile SingularAttribute<Tecnico, String> rut;
    public static volatile CollectionAttribute<Tecnico, Local> localCollection;
    public static volatile SingularAttribute<Tecnico, Date> fechaNacimiento;
    public static volatile CollectionAttribute<Tecnico, Solicitud> solicitudCollection;
    public static volatile SingularAttribute<Tecnico, String> correo;
    public static volatile SingularAttribute<Tecnico, String> usuario;
    public static volatile SingularAttribute<Tecnico, String> contrasenia;
    public static volatile SingularAttribute<Tecnico, Integer> id;
    public static volatile SingularAttribute<Tecnico, String> telefono;
    public static volatile SingularAttribute<Tecnico, String> nombre;
    public static volatile SingularAttribute<Tecnico, TipoTecnico> especialidad;

}