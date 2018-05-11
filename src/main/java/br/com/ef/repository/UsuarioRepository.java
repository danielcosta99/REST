package br.com.ef.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.ef.modelo.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	List<Usuario> findByEndereco(String endereco);
}