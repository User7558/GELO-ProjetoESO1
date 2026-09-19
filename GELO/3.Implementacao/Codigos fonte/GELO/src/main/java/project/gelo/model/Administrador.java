package project.gelo.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ADMIN")
public class Administrador extends Usuario {
    
}
