package trabalho1;

public class Contas {
    private String nome;
    private int numero;
    private double saldo;
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String novoNome){
        nome = novoNome;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public void setNumero(int novoNumero){
        numero = novoNumero;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public void depositar (double valor){
        this.saldo += valor;
    }
    
    public void sacar (double valor){
            double novoSaldo = saldo - valor;
            this.saldo = novoSaldo;
    }
    
    public void transferir (int conta1, int conta2, double valor){
        double novoSaldo = saldo - valor;
        this.saldo = novoSaldo;
    }
    
    public void tipoConta(){
        System.out.println("Conta-comum");
    }
    
}
