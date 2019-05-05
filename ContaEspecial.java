package trabalho1;

public class ContaEspecial extends Contas {
    int limite;
    
    public double descontar (double valor, double multa, double saldoDesc){
        double auxDesc = ((saldoDesc - valor) + (((saldoDesc - valor)/100) * multa));
        return auxDesc;
    }
    
     public void tipoConta(){
        System.out.println("Conta-especial");
    }
    
}
