package mx.edu.um.miembros.model;

import java.util.Date;

import mx.edu.um.model.BaseObject;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @hibernate.class table="miembro"
 * struts.form include-all="true" extends="baseForm"
 * @author blackdeath
 *
 */

public class Miembro extends BaseObject{
	private Integer id;
	private Integer version;
	private String nombre;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String sexo;
	private String estadoCivil;
	private String nombreConyuge;
	private String telefonoFijo;
	private String telefonoCelular;
	private String correoElectronico;
	private String observaciones;
	private String lugarBautismo;
	private String ministroOficiante;
	private String religionAnterior;
	private String modoIngreso;
	private String cursoBiblico;
	private String comoConocioIglesia;
	private String status;
	private String estudioVeintiochoCreencias;
	private String diezmando;
	private Date fechaBautismo;
	private Date fechaJuntaAdministrativa;
	private Date fechaJuntaDirectiva;
	private Integer numeroVotosJuntaAdministrativa;
	private Integer numeroVotosJuntaDirectiva;
	
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
	 * @hibernate.property length="30" not-null="true"
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @hibernate.property column="ap_materno" length="30" not-null="true"
	 * @return
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	/**
	 * @hibernate.property column="ap_paterno" length="30" not-null="true"
	 * @return
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	/**
	 * @hibernate.property length="1" not-null="true"
	 * @return
	 */
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	/**
	 * @hibernate.property column="estado_civil" length="2" not-null="true"
	 * @return
	 */
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	/**
	 * @hibernate.property column="conyuge" length="200"
	 * @return
	 */
	public String getNombreConyuge() {
		return nombreConyuge;
	}
	
	public void setNombreConyuge(String nombreConyuge) {
		this.nombreConyuge = nombreConyuge;
	}
	
	/**
	 * @hibernate.property column="tel_fijo" length="12"
	 * @return
	 */
	public String getTelefonoFijo() {
		return telefonoFijo;
	}
	
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	
	/**
	 * @hibernate.property column="tel_cel" length="13"
	 * @return
	 */
	public String getTelefonoCelular() {
		return telefonoCelular;
	}
	
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	
	/**
	 * @hibernate.property column="email" length="150"
	 * @return
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	/**
	 * @hibernate.property length="200"
	 * @return
	 */
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	/**
	 * @hibernate.property column="lugar_bautismo" length="200"
	 * @return
	 */
	public String getLugarBautismo() {
		return lugarBautismo;
	}
	
	public void setLugarBautismo(String lugarBautismo) {
		this.lugarBautismo = lugarBautismo;
	}
	
	/**
	 * @hibernate.property column="ministro_oficiante "length="200"
	 * @return
	 */
	public String getMinistroOficiante() {
		return ministroOficiante;
	}
	
	public void setMinistroOficiante(String ministroOficiante) {
		this.ministroOficiante = ministroOficiante;
	}
	
	/**
	 * @hibernate.property column="religion_anterior" length="250"
	 * @return
	 */
	public String getReligionAnterior() {
		return religionAnterior;
	}
	
	public void setReligionAnterior(String religionAnterior) {
		this.religionAnterior = religionAnterior;
	}
	
	/**
	 * @hibernate.property column="modo_ingreso" length="2" not-null="true"
	 * @return
	 */
	public String getModoIngreso() {
		return modoIngreso;
	}
	
	public void setModoIngreso(String modoIngreso) {
		this.modoIngreso = modoIngreso;
	}
	
	/**
	 * @hibernate.property column="curso_biblico" length="100"
	 * @return
	 */
	public String getCursoBiblico() {
		return cursoBiblico;
	}
	
	public void setCursoBiblico(String cursoBiblico) {
		this.cursoBiblico = cursoBiblico;
	}
	
	/**
	 * @hibernate.property column="como_conocio" length="250"
	 * @return
	 */
	public String getComoConocioIglesia() {
		return comoConocioIglesia;
	}
	
	public void setComoConocioIglesia(String comoConocioIglesia) {
		this.comoConocioIglesia = comoConocioIglesia;
	}
	
	/**
	 * @hibernate.property length="2" not-null="true"
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @hibernate.property column="estudio_creencias" length="1" not-null="true"
	 * @return
	 */
	public String getEstudioVeintiochoCreencias() {
		return estudioVeintiochoCreencias;
	}
	
	public void setEstudioVeintiochoCreencias(String estudioVeintiochoCreencias) {
		this.estudioVeintiochoCreencias = estudioVeintiochoCreencias;
	}
	
	/**
	 * @hibernate.property column="diezmando" length="1"
	 * @return
	 */
	public String getDiezmando() {
		return diezmando;
	}
	
	public void setDiezmando(String diezmando) {
		this.diezmando = diezmando;
	}
	
	/**
	 * @hibernate.property column="fecha_bautismo" not-null="true"
	 * @return
	 */
	public Date getFechaBautismo() {
		return fechaBautismo;
	}
	
	public void setFechaBautismo(Date fechaBautismo) {
		this.fechaBautismo = fechaBautismo;
	}
	
	/**
	 * @hibernate.property column="fecha_juntaAdm" not-null="true"
	 * @return
	 */
	public Date getFechaJuntaAdministrativa() {
		return fechaJuntaAdministrativa;
	}
	
	public void setFechaJuntaAdministrativa(Date fechaJuntaAdministrativa) {
		this.fechaJuntaAdministrativa = fechaJuntaAdministrativa;
	}
	
	/**
	 * @hibernate.property column="fecha_juntaDir" not-null="true"
	 * @return
	 */
	public Date getFechaJuntaDirectiva() {
		return fechaJuntaDirectiva;
	}

	public void setFechaJuntaDirectiva(Date fechaJuntaDirectiva) {
		this.fechaJuntaDirectiva = fechaJuntaDirectiva;
	}

	/**
	 * @hibernate.property column="votos_juntaAdm" not-null="true"
	 * @return
	 */
	public Integer getNumeroVotosJuntaAdministrativa() {
		return numeroVotosJuntaAdministrativa;
	}
	
	public void setNumeroVotosJuntaAdministrativa(
			Integer numeroVotosJuntaAdministrativa) {
		this.numeroVotosJuntaAdministrativa = numeroVotosJuntaAdministrativa;
	}
	
	/**
	 * @hibernate.property column="votos_juntaDir" not-null="true"
	 * @return
	 */
	public Integer getNumeroVotosJuntaDirectiva() {
		return numeroVotosJuntaDirectiva;
	}
	
	public void setNumeroVotosJuntaDirectiva(Integer numeroVotosJuntaDirectiva) {
		this.numeroVotosJuntaDirectiva = numeroVotosJuntaDirectiva;
	}
	
	public String getNombreCompleto(){
		return this.nombre + " " + this.apellidoPaterno + " " + this.apellidoMaterno;
	}
	
	public String toString(){
		return new ToStringBuilder(this)
		.append("id", this.id)
		.append("nombre", this.nombre)
		.append("apellidoPaterno", " " + this.apellidoPaterno)
		.append("apellidoMaterno" + " " + this.apellidoMaterno)
		.append("sexo", this.sexo)
		.append("status", this.status).toString();
			
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Miembro)){
			return false;
		}
		Miembro m = (Miembro)obj;
		
		return new EqualsBuilder()
			.append(this.id, m.getId())
			.append(this.nombre, m.getNombre())
			.append(this.apellidoPaterno, m.getApellidoPaterno())
			.append(this.apellidoMaterno, m.getApellidoMaterno())
			.append(this.sexo, m.getSexo())
			.append(this.status, m.getStatus())
			.isEquals();
	}
	
	public int hashCode() {
		return new HashCodeBuilder(-1915515825, -2044325231)
        .append(this.id)
        .append(this.nombre)
        .append(this.apellidoPaterno)
        .append(this.apellidoMaterno)
        .toHashCode();
	}
}