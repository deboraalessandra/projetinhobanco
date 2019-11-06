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
public class Funcionario extends Pessoa {

    private double salario;
    private Date dtContratacao;

    public Funcionario(int codigo, String nome, String bi, Date dtnasc, double salario, Date dtContratacao) {
        super();
        this.salario = salario;
        this.dtContratacao = dtContratacao;
    }

    public double calcularSalario() {
        return salario;
    }
}
