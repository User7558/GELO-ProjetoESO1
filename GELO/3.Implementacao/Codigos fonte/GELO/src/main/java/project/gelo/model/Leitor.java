package project.gelo.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("LEITOR")
public class Leitor extends Usuario {
    
}
