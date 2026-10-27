/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifc.ibirama.hibernatesalaaula.gregori.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.JoinTable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
//import java.util.HashSet;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "Bombeiro")
public class Bombeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bom_id")
    private Integer id;
    @Column(name = "bom_cpf", length = 11, unique = true, nullable = false)
    private String cpf;
    @Column(name = "bom_data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "bom_nome_completo", nullable = false)
    private String nome;
    @Column(name = "bom_nome_guerra", nullable = false, unique = true, length = 45)
    private String nomeGuerra;

    /*@OneToOne(mappedBy = "bombeiro")
    private Usuario usuario;
    @OneToMany(mappedBy = "bombeiro")
    private Set<TelefoneContato> telefone = new HashSet<TelefoneContato>();
    @ManyToMany
    @JoinTable(name = "Bombeiro_has_Patente", joinColumns = @JoinColumn(name = "bom_id"),inverseJoinColumns = @JoinColumn(name = "pat_id"))
    private Set<Patente> patente = new HashSet<Patente>();*/

    public Bombeiro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }

    /*public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<TelefoneContato> getTelefone() {
        return telefone;
    }

    public void setTelefone(Set<TelefoneContato> telefone) {
        this.telefone = telefone;
    }

    public Set<Patente> getPatente() {
        return patente;
    }

    public void setPatente(Set<Patente> patente) {
        this.patente = patente;
    }
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bombeiro) {
            Bombeiro aux = (Bombeiro) obj;
            if ((aux.getId() != null) || (aux.getCpf() != null)) {
                return (aux.getId().equals(this.id) && (aux.getCpf().equals(this.cpf)));
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
