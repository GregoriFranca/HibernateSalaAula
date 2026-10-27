/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifc.ibirama.hibernatesalaaula.gregori.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//import java.util.Objects;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "AutoEscada")
public class AutoEscada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    private Integer id;
    @Column(name = "aut_altura_max", nullable = false)
    private Integer AlturaMaxima;
    /*@OneToOne
    @JoinColumn(name = "via_id", unique = true)
    private Viatura viatura;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlturaMaxima() {
        return AlturaMaxima;
    }

    public void setAlturaMaxima(Integer AlturaMaxima) {
        this.AlturaMaxima = AlturaMaxima;
    }

    /*public Viatura getViatura() {
        return viatura;
    }

    public void setViatura(Viatura viatura) {
        this.viatura = viatura;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AutoEscada) {
            AutoEscada aux = (AutoEscada) obj;
            if (aux.getId() != null) {
                return (aux.getId().equals(this.id));
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
