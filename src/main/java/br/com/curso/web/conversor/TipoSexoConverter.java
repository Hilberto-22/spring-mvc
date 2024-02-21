package br.com.curso.web.conversor;

import org.springframework.core.convert.converter.Converter;

import br.com.curso.domain.TipoSexo;

public class TipoSexoConverter implements Converter<String , TipoSexo> {

	@Override
	public TipoSexo convert(String source) {
		char tipo = source.charAt(0);
		return tipo == TipoSexo.FEMININO.getDescricao() ? TipoSexo.FEMININO : TipoSexo.MASCULINO;
	}

}
