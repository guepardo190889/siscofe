package mx.edu.um.cargos.model;

import mx.edu.um.model.BaseObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @hibernate.class table="cargos"
 * struts.form include-all="true" extends="baseForm"
 * @author blackdeath
 *
 */

public class Cargo extends BaseObject{
	private Integer id;
	private Integer version;
	private String nombre;
	private String descripcion;
	
	/**
	 * @hibernate.id generator-class="increment"
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @hibernate.version
	 * @return
	 */
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	/**
	 * @hibernate.property length="100" not-null="true"
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @hibernate.property length="150" not-null="true"
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String toString(){
		return new ToStringBuilder(this)
		.append("id", this.id)
		.append("nombre", this.nombre)
		.append("descripcion", " " + this.descripcion).toString();
			
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Cargo)){
			return false;
		}
		Cargo c = (Cargo)obj;
		
		return new EqualsBuilder()
			.append(this.id, c.getId())
			.append(this.nombre, c.getNombre())
			.append(this.descripcion, c.getDescripcion())
			.isEquals();
	}
	
	public int hashCode() {
		return new HashCodeBuilder(-1915515825, -2044325231)
        .append(this.id)
        .append(this.nombre)
        .append(this.descripcion)
        .toHashCode();
	}
}