package br.com.curso.dao;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Repository;

import br.com.curso.domain.TipoSexo;
import br.com.curso.domain.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private static List<Usuario> usuarios; 
	
	public UsuarioDaoImpl() {
		createUserList();
	}

	private List<Usuario> createUserList() {
		if (usuarios == null) {
			usuarios = new LinkedList<>();
			usuarios.add(new Usuario(System.currentTimeMillis() +1L, "Ana Maria", " da Silva", LocalDate.of(1992, 5, 10), TipoSexo.FEMININO));
			usuarios.add(new Usuario(System.currentTimeMillis() +2L, "Luiz Roberto", " da Silva", LocalDate.of(1992, 5, 10), TipoSexo.MASCULINO ));
			usuarios.add(new Usuario(System.currentTimeMillis() +3L, "José Antonio", " da Silva", LocalDate.of(1992, 5, 10), TipoSexo.MASCULINO));
			usuarios.add(new Usuario(System.currentTimeMillis() +4L, "Mariana", " da Silva",LocalDate.of(1992, 5, 10), TipoSexo.FEMININO));
			usuarios.add(new Usuario(System.currentTimeMillis() +5L, "Josefa", " da Silva", LocalDate.of(1992, 5, 10), TipoSexo.FEMININO));
			usuarios.add(new Usuario(System.currentTimeMillis() +6L, "Norberto", " da Silva", LocalDate.of(1992, 5, 10), TipoSexo.MASCULINO));
		}
		return usuarios;
	}

	@Override
	public void salvar(Usuario usuario) {
		usuario.setId(System.currentTimeMillis());
		usuarios.add(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
		usuarios.stream().filter((user) -> user.getId().equals(usuario.getId()))
		.forEach((us) -> {
			us.setNome(usuario.getNome());
			us.setSobrenome(usuario.getSobrenome());
			us.setDtNascimento(usuario.getDtNascimento());
			us.setTipoSexo(usuario.getTipoSexo());
		});
	}

	@Override
	public void excluir(Long id) {
		usuarios.removeIf((usuario) -> usuario.getId().equals(id));
	}

	@Override
	public Usuario getId(Long id) {
	    return usuarios.stream()
	            .filter(u -> u.getId().equals(id))
	            .findFirst()
	            .orElseThrow(() -> new NoSuchElementException("Nenhum usuário com o ID fornecido encontrado: " + id));
	}

	@Override
	public List<Usuario> getTodos() {
		return usuarios;
	}
}
