/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author alexc
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "prothincrsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Usuario loginUsuario(int id){
    Query bd=em.createNamedQuery("Usuario.findById",Usuario.class).setParameter("id", id);
    List <Usuario> listaU = bd.getResultList();
    if(!listaU.isEmpty()){
        return listaU.get(0);
        
    }
    return null;
    
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
 
 
}
