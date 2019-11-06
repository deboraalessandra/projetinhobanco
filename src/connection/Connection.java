/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Débora Alessandra
 */
public class Connection {
    private final String SERVIDOR = "localhost";
    private final String PORTA = "3306";
    private final String BANCO_DE_DADOS = "bancodadedemua";
    private final String USUARIO = "root";
    private final String SENHA ="";
    private final String URL ="jdbc:mysql://"+ SERVIDOR+ ":" +PORTA+ "/"+ BANCO_DE_DADOS+"?autoReconnect=true&verifyServerCertificate=false&useSSL=false";
    
    
    private java.sql.Connection conexao;
    
    public Connection() throws ClassNotFoundException, SQLException{
        // passa usuario e senha
        try{ 
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
            conexao.setAutoCommit(false);
            
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException e ){
            throw new ClassNotFoundException("O drive de conexao nao foi adicionadao\n"
                        +e.getMessage());
            
        }catch(SQLException e){
            throw new SQLException("Problemas nos parametros de conexao \n"
                    +e.getMessage());
        }
    }
    
    public java.sql.Connection getConexao(){
        return conexao;
    }
    
    public void confirmar() throws SQLException{
        try{
            conexao.commit();
        }catch(SQLException e){
            throw new SQLException("Problemas na instrução MySQL \n"+e.getMessage());
        }finally{
            conexao.close();
        }
    }
}
