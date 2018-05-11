package br.com.ef.rest;

import java.util.GregorianCalendar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ef.modelo.Usuario;

@RestController
public class UsuarioController {
	
    @RequestMapping("/usuario")
    public Usuario buscar(@RequestParam(value="name", defaultValue="World") String name) {
        Usuario usuario = new Usuario();
        usuario.setNome(name);
        usuario.setEndereco("QMSW 4");
        usuario.setDataNascimento(new GregorianCalendar().getTime());
    	
    	return usuario;
    }
}
