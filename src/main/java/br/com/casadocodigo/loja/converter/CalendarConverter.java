package br.com.casadocodigo.loja.converter;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Calendar.class)
public class CalendarConverter implements Converter {

	DateTimeConverter converter = new DateTimeConverter();

	public CalendarConverter() {
		this.converter.setPattern("dd/MM/yyyy");
		this.converter.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
	}

	@Override
	public Object getAsObject(FacesContext contexto, UIComponent component, String dataTexto) {

		Calendar calendar = Calendar.getInstance();
		Date date = (Date) converter.getAsObject(contexto, component, dataTexto);

		calendar.setTime(date);

		return calendar;
	}

	@Override
	public String getAsString(FacesContext contexto, UIComponent component, Object dataObject) {

		if (Objects.isNull(dataObject))
			return null;

		Calendar calendar = (Calendar) dataObject;

		return converter.getAsString(contexto, component, calendar.getTime());

	}

}
