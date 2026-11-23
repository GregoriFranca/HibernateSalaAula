/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifc.ibirama.hibernatesalaaula.gregori;

import com.ifc.ibirama.hibernatesalaaula.gregori.entidades.Bombeiro;
import com.ifc.ibirama.hibernatesalaaula.gregori.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author aluno
 */
public class ConsultarBombeiro {
    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        String meuHql = "from bombeiro";
        
        List<Bombeiro> bombeiros = sessao.createQuery(meuHql, Bombeiro.class).getResultList();
        
        for(Bombeiro b : bombeiros){
          
            System.out.println(b.getCpf());
            
        }
        
        HibernateUtil.shutdown();
    }
}
