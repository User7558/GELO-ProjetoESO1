package project.gelo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.gelo.dto.UsuarioDTO;
import project.gelo.model.TipoUsuario;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:gelo-admin-login-test;DB_CLOSE_DELAY=-1",
    "spring.datasource.driver-class-name=org.h2.Driver",
    "spring.jpa.hibernate.ddl-auto=create-drop",
    "gelo.bootstrap-admin.enabled=true",
    "gelo.bootstrap-admin.email=admin@gelo.local",
    "gelo.bootstrap-admin.senha=Admin123!"
})
class LoginAdministradorTest {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    void deveAutenticarAdministradorInicial() {
        UsuarioDTO administrador = usuarioService.autenticar(
                "admin@gelo.local",
                "Admin123!"
        );

        assertEquals("admin@gelo.local", administrador.email());
        assertEquals(TipoUsuario.ADMINISTRADOR, administrador.tipoUsuario());
    }
}
