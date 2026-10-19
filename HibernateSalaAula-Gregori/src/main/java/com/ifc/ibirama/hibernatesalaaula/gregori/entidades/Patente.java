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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "Patente")
public class Patente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pat_id")
    private Integer id;
    @Column(name = "pat_sigla", length = 10, nullable = false, unique = true)
    private String sigla;
    @Column(name = "pat_descricao", length = 45, nullable = true)
    private String descricao;
    @ManyToMany(mappedBy = "patente")
    private Set<Bombeiro> bombeiro = new HashSet<Bombeiro>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Bombeiro> getBombeiro() {
        return bombeiro;
    }

    public void setBombeiro(Set<Bombeiro> bombeiro) {
        this.bombeiro = bombeiro;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Patente){
            Patente aux = (Patente)obj;
            if((aux.getId()!= null) && (aux.getSigla() != null)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}