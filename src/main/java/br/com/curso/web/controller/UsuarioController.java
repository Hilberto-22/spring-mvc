package br.com.curso.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.curso.dao.UsuarioDao;
import br.com.curso.domain.TipoSexo;
import br.com.curso.domain.Usuario;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioDao usuarioDao;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView findAll(ModelMap model) {
		model.addAttribute("usuarios", usuarioDao.getTodos());
		return new ModelAndView("/user/list", model);
	}

	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("usuario") Usuario usuario, ModelMap model) {
		model.addAttribute("sexos", TipoSexo.values());
		return "/user/create";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/user/create";
		}
		usuarioDao.salvar(usuario);
		attr.addFlashAttribute("message", "Usuário salvo com sucesso.");
		return "redirect:/usuario/todos";
	}

	@GetMapping("/update/{id}")
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
		Usuario usuario = usuarioDao.getId(id);
		model.addAttribute("usuario", usuario);
		return new ModelAndView("/user/create", model);
	}

	@PostMapping("/update")
	public ModelAndView update(@Validated @ModelAttribute("usuario") Usuario usuario, BindingResult result,
			RedirectAttributes attr) {
		if (result.hasErrors()) {
			return new ModelAndView("/user/create");
		}
		usuarioDao.editar(usuario);
		attr.addFlashAttribute("message", "Usuário alterado com sucesso.");
		return new ModelAndView("redirect:/usuario/todos");
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
		usuarioDao.excluir(id);
		attr.addFlashAttribute("message", "Usuário excluído com sucesso.");
		return "redirect:/usuario/todos";
	}
}
