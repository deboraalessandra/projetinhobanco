/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.ArrayList;
/**
 *
 * @author 
 * @param <Tipo> 
 */
public interface IDAO<Tipo> {
    
    public void inserir(Tipo Objeto) throws Exception;
    
    public void alterar(Tipo Objeto) throws Exception;
    
    public void excluir(Tipo Objeto) throws Exception;
    
    public ArrayList<Tipo> listarTodos() throws Exception;
    
    public Tipo recuperar(int codigo) throws Exception;
}
