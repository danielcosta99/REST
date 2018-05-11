package br.com.ef.rest;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ef.modelo.Usuario;
import br.com.ef.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository repository;

	@GetMapping("/usuario")
	public Usuario buscar(@RequestParam(value = "name", defaultValue = "World") String name) {
		Usuario usuario = new Usuario("Daniel", "QMSW4");
		usuario.setNome(name);
		usuario.setEndereco("QMSW 4");
		usuario.setDataNascimento(new GregorianCalendar().getTime());

		return usuario;
	}

	@GetMapping("/usuario/list")
	public List<Usuario> listar() {
		return (List<Usuario>) repository.findAll();
	}

	@GetMapping("/usuario/findByEndereco")
	public List<Usuario> buscarPorEndereco(@RequestParam(value = "endereco") String endereco) {
		return repository.findByEndereco(endereco);
	}
	
	@PostMapping("/usuario/salvar")
	public void salvar(@RequestBody Usuario usuario ) {
		repository.save(usuario);
	}
	
}
