/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Clase de la entidad Row el xml
 */
@XmlRootElement(name = "Row")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sacrificio implements Serializable {

    public Sacrificio(){}
    
    public Sacrificio(String codRegaMatadero, int codProvincia, String provincia, int codMunicipio, String municipio, String fechaSacrificio, String fechaMovimientoAMatadero, String idMovimiento, String ueln, int codEspecie, String especie, String codSexo, String sexo, String codRaza, String raza, String fechaNacimiento, int codPaisNacimiento, String paisNacimiento, String fechaMuerte, String codAptitudConsumo, String aptitudConsumo, String idElectronica, String fechaIdentifiacion, String nombreNacimiento, String codCapa, String capa, String codOrientacion, String orientacion) {
        this.codRegaMatadero = codRegaMatadero;
        this.codProvincia = codProvincia;
        this.provincia = provincia;
        this.codMunicipio = codMunicipio;
        this.municipio = municipio;
        this.fechaSacrificio = fechaSacrificio;
        this.fechaMovimientoAMatadero = fechaMovimientoAMatadero;
        this.idMovimiento = idMovimiento;
        this.ueln = ueln;
        this.codEspecie = codEspecie;
        this.especie = especie;
        this.codSexo = codSexo;
        this.sexo = sexo;
        this.codRaza = codRaza;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.codPaisNacimiento = codPaisNacimiento;
        this.paisNacimiento = paisNacimiento;
        this.fechaMuerte = fechaMuerte;
        this.codAptitudConsumo = codAptitudConsumo;
        this.aptitudConsumo = aptitudConsumo;
        this.idElectronica = idElectronica;
        this.fechaIdentifiacion = fechaIdentifiacion;
        this.nombreNacimiento = nombreNacimiento;
        this.codCapa = codCapa;
        this.capa = capa;
        this.codOrientacion = codOrientacion;
        this.orientacion = orientacion;
    }

    public String getCodRegaMatadero() {
        return codRegaMatadero;
    }

    public void setCodRegaMatadero(String codRegaMatadero) {
        this.codRegaMatadero = codRegaMatadero;
    }

    public int getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(int codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(int codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getFechaSacrificio() {
        return fechaSacrificio;
    }

    public void setFechaSacrificio(String fechaSacrificio) {
        this.fechaSacrificio = fechaSacrificio;
    }

    public String getFechaMovimientoAMatadero() {
        return fechaMovimientoAMatadero;
    }

    public void setFechaMovimientoAMatadero(String fechaMovimientoAMatadero) {
        this.fechaMovimientoAMatadero = fechaMovimientoAMatadero;
    }

    public String getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(String idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getUeln() {
        return ueln;
    }

    public void setUeln(String ueln) {
        this.ueln = ueln;
    }

    public int getCodEspecie() {
        return codEspecie;
    }

    public void setCodEspecie(int codEspecie) {
        this.codEspecie = codEspecie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCodSexo() {
        return codSexo;
    }

    public void setCodSexo(String codSexo) {
        this.codSexo = codSexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCodRaza() {
        return codRaza;
    }

    public void setCodRaza(String codRaza) {
        this.codRaza = codRaza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCodPaisNacimiento() {
        return codPaisNacimiento;
    }

    public void setCodPaisNacimiento(int codPaisNacimiento) {
        this.codPaisNacimiento = codPaisNacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(String fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public String getCodAptitudConsumo() {
        return codAptitudConsumo;
    }

    public void setCodAptitudConsumo(String codAptitudConsumo) {
        this.codAptitudConsumo = codAptitudConsumo;
    }

    public String getAptitudConsumo() {
        return aptitudConsumo;
    }

    public void setAptitudConsumo(String aptitudConsumo) {
        this.aptitudConsumo = aptitudConsumo;
    }

    public String getIdElectronica() {
        return idElectronica;
    }

    public void setIdElectronica(String idElectronica) {
        this.idElectronica = idElectronica;
    }

    public String getFechaIdentifiacion() {
        return fechaIdentifiacion;
    }

    public void setFechaIdentifiacion(String fechaIdentifiacion) {
        this.fechaIdentifiacion = fechaIdentifiacion;
    }

    public String getNombreNacimiento() {
        return nombreNacimiento;
    }

    public void setNombreNacimiento(String nombreNacimiento) {
        this.nombreNacimiento = nombreNacimiento;
    }

    public String getCodCapa() {
        return codCapa;
    }

    public void setCodCapa(String codCapa) {
        this.codCapa = codCapa;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getCodOrientacion() {
        return codOrientacion;
    }

    public void setCodOrientacion(String codOrientacion) {
        this.codOrientacion = codOrientacion;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    @XmlElement(name = "COD_REGA_MATADERO")
    private String codRegaMatadero;

    @XmlElement(name = "COD_PROVINCIA")
    private int codProvincia;

    @XmlElement(name = "PROVINCIA")
    private String provincia;

    @XmlElement(name = "COD_MUNICIPIO")
    private int codMunicipio;

    @XmlElement(name = "MUNICIPIO")
    private String municipio;

    @XmlElement(name = "FECHA_SACRIFICIO")
    private String fechaSacrificio;

    @XmlElement(name = "FECHA_MOVIMIENTO_A_MATADERO")
    private String fechaMovimientoAMatadero;

    @XmlElement(name = "ID_MOVIMIENTO")
    private String idMovimiento;

    @XmlElement(name = "UELN")
    private String ueln;

    @XmlElement(name = "COD_ESPECIE")
    private int codEspecie;

    @XmlElement(name = "ESPECIE")
    private String especie;

    @XmlElement(name = "COD_SEXO")
    private String codSexo;

    @XmlElement(name = "SEXO")
    private String sexo;

    @XmlElement(name = "COD_RAZA")
    private String codRaza;

    @XmlElement(name = "RAZA")
    private String raza;

    @XmlElement(name = "FECHA_NACIMIENTO")
    private String fechaNacimiento;

    @XmlElement(name = "COD_PAIS_NACIMIENTO")
    private int codPaisNacimiento;

    @XmlElement(name = "PAIS_NACIMIENTO")
    private String paisNacimiento;

    @XmlElement(name = "FECHA_MUERTE")
    private String fechaMuerte;

    @XmlElement(name = "COD_APTITUD_CONSUMO")
    private String codAptitudConsumo;

    @XmlElement(name = "APTITUD_CONSUMO")
    private String aptitudConsumo;
    
    @XmlElement(name = "ID_ELECTRONICA")
    private String idElectronica;
    
    @XmlElement(name = "FECHA_IDENTIFICACION")
    private String fechaIdentifiacion;
    
    @XmlElement(name = "NOMBRE_NACIMIENTO")
    private String nombreNacimiento;
    
    @XmlElement(name = "COD_CAPA")
    private String codCapa;
    
    @XmlElement(name = "CAPA")
    private String capa;
    
    @XmlElement(name = "COD_ORIENTACION")
    private String codOrientacion;
    
    @XmlElement(name = "ORIENTACION")
    private String orientacion;
}
