/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabanco;

/**
 *
 * @author Débora Alessandra
 */
public class Conta {

    private int numero, saques = 0;
    private String nomeTitular;
    private double saldo;
    private TipoDeConta TipoConta;
    private Cliente titular;
    private double limite;
    private Conta destino;
    private Boolean isblock;
    private int pin,opcao ;
    private String iban ;

    public Conta(int numero, String nomeTitular, double saldo) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
        saques = 0;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depositado: " + valor);
        System.out.println("Novo saldo: " + saldo + "\n");
    }

    public void sacar(double valor) throws Exception {
        if (valor < this.saldo + this.limite) {
            saldo -= valor;
        saques++;
            System.out.println("Sacado: " + valor);
            System.out.println("Novo saldo: " + saldo + "\n");
        } else {
            System.out.println("Saldo insuficiente. Faça um depósito\n");
        }
    }

    public void transfer_para(double valor, Conta destino) throws Exception {
        if (this.saldo > valor) {

            this.sacar(valor);
            destino.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void alterarPin(int userPin) {
        if (validaPin(userPin)) {
            System.out.println("Digite o Novo Pin: ");
            int pinNovo = 0; //Sistema.teclado().getEntrada();
            System.out.println("Digite o Novamente o Pin: ");
            if (pinNovo == 0/*Sistema.teclado().getEntrada()*/) {
                pin = pinNovo;
                System.out.println("Pin alterado com sucesso");
            } else {
                System.out.println("Pin nao alterado. ");
            }
        }
    }

    public double consultaSaldo() {
        return saldo;
    }

    String consultaIban() {
        return iban;
    }

    public boolean validaPin(int userPin) {
        if (pin != userPin) {
            System.out.println("Pin Invalido");
            return false;
        }
        return true;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getTitular() {
        return titular.getNome();
    }

    public void iniciar() throws Exception {
        int opcao;
        do {
            exibirMenu();
            opcao = 0;//Sistema.teclado().getEntrada();
            escolheOpcao(opcao);
        } while (opcao != 5);
    }

    public void exibirMenu() {
        System.out.println("\t Escolha a opção desejada: ");
        System.out.println("1 - Consultar Extrato");
        System.out.println("2 - Levantamento");
        System.out.println("3 - Transferencia");
        System.out.println("4 - Movimento da Conta");
        System.out.println("5 - Sair\n");
        System.out.println("Opção: " + this.opcao);
    }

    public void escolheOpcao(int opcao) throws Exception {

        int i = 0;
        double valor;
        String msg;
        switch (opcao) {
            case 1:
                extrato();
                break;
            case 2:
                if (i++ <= 3) {
                    msg = ("Quanto deseja Levantar: ");
                    valor = 0;//Sistema.teclado().getEntrada();
                    this.sacar(valor);
                } else {
                    msg = ("Limite do levantamento diários atingidos.\n");
                }
                break;
            case 3:
                msg = ("Quanto deseja Transferir: ");
                valor = 0; // trabalhar nisso
                this.sacar(valor);
                break;
            case 5:
                msg = ("Sistema encerrado.");
                break;

            default:
                throw new Exception("Opção inválida");
        }
    }

    public boolean equals(Conta contas) {
        return (this.numero == contas.numero);
    }

    public void extrato() {
        System.out.println("\n\n\tExtrato");
        System.out.println("Numero da conta:" + this.numero);
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Iban da conta: " + this.iban);
        System.out.println("Saldo atual: " + this.saldo);
        System.out.println("O pin atual é: " + this.pin);
        System.out.println("O teu número é: " + this.numero);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TipoDeConta getTipoConta() {
        return TipoConta;
    }

    public void setTipoConta(TipoDeConta TipoConta) {
        this.TipoConta = TipoConta;
    }
}
