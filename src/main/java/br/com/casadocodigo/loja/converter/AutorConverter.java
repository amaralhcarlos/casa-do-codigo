package br.com.casadocodigo.loja.converter;

import java.awt.datatransfer.StringSelection;
import java.util.Objects;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.casadocodigo.loja.model.Autor;

@FacesConverter("autorConverter")
public class AutorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {

		if (Objects.isNull(id) || id.isBlank())
			return null;

		Autor autor = new Autor();
		autor.setId(Integer.valueOf(id));

		return autor;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object autor) {

		if (Objects.isNull(autor))
			return null;

		return ((Autor) autor).getId().toString();
	}

}
