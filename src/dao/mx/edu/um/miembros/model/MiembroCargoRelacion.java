package mx.edu.um.miembros.model;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import mx.edu.um.cargos.model.Cargo;

/**
 * @hibernate.class table="miembro_cargo_relacion"
 * struts.form include-all="true" extends="BaseForm"
 * @author blackdeath
 */
public class MiembroCargoRelacion {
	private Integer id;
	private Integer version;
	private Miembro miembro;
	private Cargo cargo;
	private Date fechaInicial;
	private Date fechaFinal;
	
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
	 * @hibernate.many-to-one column="miembro_id" not-null="true"
	 * @return
	 */
	public Miembro getMiembro() {
		return miembro;
	}
	
	public void setMiembro(Miembro miembro) {
		this.miembro = miembro;
	}
	
	/**
	 * @hibernate.many-to-one column="cargo_id" not-null="true"
	 * @return
	 */
	public Cargo getCargo() {
		return cargo;
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	/**
	 * @hibernate.property not-null="true"
	 * @return
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}
	
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	
	/**
	 * @hibernate.property not-null="true"
	 * @return
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}
	
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String toString(){
		return new ToStringBuilder(this)
		.append("id", this.id)
		.append("miembro", this.miembro.getId())
		.append("cargo", this.cargo.getId())
		.append("fechaInicial", this.fechaInicial)
		.append("fechaFinal", this.fechaFinal).toString();
		//.append("alumno", (this.alumno != null) ? this.alumno.getMatricula() : "")
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof MiembroCargoRelacion)){
			return false;
		}
		MiembroCargoRelacion mcr = (MiembroCargoRelacion)obj;
		
		return new EqualsBuilder()
		.append("id", this.id)
		.append("miembro", this.miembro.getId())
		.append("cargo", this.cargo.getId())
		.append("fechaInicial", this.fechaInicial)
		.append("fechaFinal", this.fechaFinal).isEquals();
	}
	
	public int hashCode() {
		return new HashCodeBuilder(-1915515825, -2044325231)
		.append(this.id)
		.append(this.miembro.getId())
		.append(this.cargo.getId())
		.append(this.fechaInicial)
		.append(this.fechaFinal)
        .toHashCode();
	}
}