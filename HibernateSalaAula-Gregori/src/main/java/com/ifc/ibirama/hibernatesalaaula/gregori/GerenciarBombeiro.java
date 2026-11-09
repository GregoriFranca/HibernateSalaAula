/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifc.ibirama.hibernatesalaaula.gregori;

import com.ifc.ibirama.hibernatesalaaula.gregori.entidades.Bombeiro;
import com.ifc.ibirama.hibernatesalaaula.gregori.entidades.Usuario;
import com.ifc.ibirama.hibernatesalaaula.gregori.util.HibernateUtil;
import java.time.LocalDate;
import java.time.Month;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author aluno
 */
public class GerenciarBombeiro {
    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        System.out.println("Sessão estabelecida");
        
        Bombeiro bombeiro01 = new Bombeiro();
        bombeiro01.setCpf("10955221919");
        bombeiro01.setDataNascimento(LocalDate.of(1990, 2, 2));
        bombeiro01.setNome("Fulano da Silva");
        bombeiro01.setNomeGuerra("Silva");
        bombeiro01.setDataNascimento(LocalDate.of(2000, Month.NOVEMBER, 12));
        
        Usuario usuario01 = new Usuario();
        usuario01.setLogin("beltrano.silva");
        usuario01.setSenha("12345");
        
        bombeiro01.setUsuario(usuario01);
        usuario01.setBombeiro(bombeiro01);
        
        Transaction transacao = null;
        
        try{
            transacao = sessao.beginTransaction();
            
            sessao.persist(bombeiro01);
            //sessao.persist(usuario01);
            
            transacao.commit();
            System.out.println("Bombeiro 'salvo'");
            sessao.close();

        }catch(Exception e){
            if(transacao != null){
                transacao.rollback();
            }
        }
        HibernateUtil.shutdown();
    }
}
