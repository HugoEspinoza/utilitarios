package com.carloncho.code.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType( propOrder = { "codigo", "descripcion", "fecha", "identificadorSolicitud" } )
@XmlRootElement( name = "MensajeInformativo" )
public class MensajeInformativo {

    private String codigo;
    private String descripcion;
    private String fecha;
    private String identificadorSolicitud;

    public String getCodigo() {
        return codigo;
    }

    @XmlElement( name = "Codigo" )
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    @XmlElement( name = "Descripcion" )
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getFecha() {
        return fecha;
    }

    @XmlElement( name = "Fecha" )
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdentificadorSolicitud() {
        return identificadorSolicitud;
    }

    @XmlElement( name = "IdentificadorSolicitud" )
    public void setIdentificadorSolicitud(String identificadorSolicitud) {
        this.identificadorSolicitud = identificadorSolicitud;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MensajeInformativo [codigo=").append(codigo).append(", descripcion=").append(descripcion)
				.append(", fecha=").append(fecha).append(", identificadorSolicitud=").append(identificadorSolicitud)
				.append("]");
		return builder.toString();
	}

}
