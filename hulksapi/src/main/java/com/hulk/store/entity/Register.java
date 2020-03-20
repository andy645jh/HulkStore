package com.hulk.store.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "register")
public class Register {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "date")
    private Date date;
    
    @Column(name = "description")
    private String description;
    
    @Column(name="unit_val")
    private int unitVal;
    
    @Column(name="cant_entrada")
    private int cantEntrada;
    
    @Column(name="val_entrada")
    private int valEntrada;
    
    @Column(name="cant_salida")
    private int cantSalida;
    
    @Column(name="val_salida")
    private int valSalida;
    
    @Column(name="cant_saldo")
    private int cantSaldo;
    
    @Column(name="val_saldo")
    private int valSaldo;    
      
    @Column(name="operation")
    private int operation;  
    
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name="darkex_id", referencedColumnName = "id")    
    private Darkex darkex;

	public Register() { }   

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", date=" + date + ", description=" + description + ", unitVal=" + unitVal
				+ ", cantEntrada=" + cantEntrada + ", valEntrada=" + valEntrada + ", cantSalida=" + cantSalida
				+ ", valSalida=" + valSalida + ", cantSaldo=" + cantSaldo + ", valSaldo=" + valSaldo + ", darkex="
				+ darkex + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Register other = (Register) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
    public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnitVal() {
		return unitVal;
	}

	public void setUnitVal(int unitVal) {
		this.unitVal = unitVal;
	}

	public int getCantEntrada() {
		return cantEntrada;
	}

	public void setCantEntrada(int cantEntrada) {
		this.cantEntrada = cantEntrada;
	}

	public int getValEntrada() {
		return valEntrada;
	}

	public void setValEntrada(int valEntrada) {
		this.valEntrada = valEntrada;
	}

	public int getCantSalida() {
		return cantSalida;
	}

	public void setCantSalida(int cantSalida) {
		this.cantSalida = cantSalida;
	}

	public int getValSalida() {
		return valSalida;
	}

	public void setValSalida(int valSalida) {
		this.valSalida = valSalida;
	}

	public int getCantSaldo() {
		return cantSaldo;
	}

	public void setCantSaldo(int cantSaldo) {
		this.cantSaldo = cantSaldo;
	}

	public int getValSaldo() {
		return valSaldo;
	}

	public void setValSaldo(int valSaldo) {
		this.valSaldo = valSaldo;
	}

	public Darkex getDarkex() {
		return darkex;
	}

	public void setDarkex(Darkex darkex) {
		this.darkex = darkex;
	}

	   
}
