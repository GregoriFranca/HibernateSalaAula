/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifc.ibirama.hibernatesalaaula.gregori;

import com.ifc.ibirama.hibernatesalaaula.gregori.entidades.Bombeiro;
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
        Transaction transacao = null;
        
        Bombeiro bombeiro = new Bombeiro();
        bombeiro.setCpf("12345678");
        bombeiro.setDataNascimento(LocalDate.of(1990, 2, 2));
        bombeiro.setNome("Fulano da Silva");
        bombeiro.setNomeGuerra("Silva");
        
        try{
            transacao = sessao.beginTransaction();
            
            sessao.persist(bombeiro);
            
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
