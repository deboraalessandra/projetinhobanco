/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabanco;

import java.util.Date;

/**
 *
 * @author Débora Alessandra
 */
public class Pessoa {
    private int codigo;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    
    public Pessoa(){
        this.codigo =0;
        this.nome ="";
        this.cpf = "";
        this.dataNascimento = new Date();   
    }
    
    public Pessoa(int codigo){
        this.codigo = codigo;
        this.nome ="";
        this.cpf = "";
        this.dataNascimento = new Date();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
