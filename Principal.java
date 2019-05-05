package trabalho1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal {
    public static void main (String[] args){
        JOptionPane.showMessageDialog(null,"Seja bem-vindo(a)");
        
        Contas c;
        c = new Contas(); //instnciando uma conta comum
        JOptionPane.showMessageDialog(null,"Digite as informações referente à conta-comum");
        String nome1 = JOptionPane.showInputDialog("Informe o nome do titular:");
        c.setNome(nome1); //recebendo o nome do titular da conta-comum
        int numComum = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
        c.setNumero(numComum); //recebendo o número da conta-comum
        String aux1 = JOptionPane.showInputDialog("Informe o valor do saldo inicial:"); //declarando um auxiliar para receber o valor do saldo como uma string
        double saldo1 = Double.parseDouble(aux1); //convertendo o valor do saldo de string para double
        c.depositar(saldo1);//depositando o valor do saldo inicial na conta-comum
        
        ContaPoupanca cp;
        cp = new ContaPoupanca();
        JOptionPane.showMessageDialog(null,"Digite as informações referente à conta-poupança");
        String nome2 = JOptionPane.showInputDialog("Informe o nome do titular:");
        cp.setNome(nome2); //recebendo o nome do titular da conta-poupança
        int numPoupanca = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
        cp.setNumero(numPoupanca); //recebendo o número da conta-poupança
        String aux2 = JOptionPane.showInputDialog("Informe o valor do saldo inicial:"); //declarando um auxiliar para receber o saldo como uma string
        double saldo2 = Double.parseDouble(aux2); //convertendo o valor do saldo de string para double
        cp.depositar(saldo2);//depositando o valor do saldo inicial na conta-poupança
        String aux3 = JOptionPane.showInputDialog("Informe o valor da taxa de reajuste:"); //declarando um auxiliar para receber o valor da taxa como uma string
            if(!"".equals(aux3)){
                double taxa = Double.parseDouble(aux3); //convertendo o valor da taxa de string para double
            }
        
        ContaEspecial ce;
        ce = new ContaEspecial();
        JOptionPane.showMessageDialog(null,"Digite as informações referente à conta-especial");
        String nome3 = JOptionPane.showInputDialog("Informe o nome do titular:");
        ce.setNome(nome3); //recebendo o nome do titular da conta-especial
        int numEspecial = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
        ce.setNumero(numEspecial); //recebendo o número da conta-especial
        String aux4 = JOptionPane.showInputDialog("Informe o valor do saldo inicial:"); //declarando um auxiliar para receber o saldo como uma string
        double saldo3 = Double.parseDouble(aux4); //convertendo o valor do saldo de string para double
        ce.depositar(saldo3);//depositando o valor do saldo inicial na conta-especial
        int numLimite = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor do limite: "));
        String aux5 = JOptionPane.showInputDialog("Informe o valor da multa:"); //declarando um auxiliar para receber o valor da multa como uma string
        double multa = Double.parseDouble(aux5); //convertendo o valor da multa de string para double
        
        
        JFrame inicio = new JFrame("Contas"); //inicializando a janela inicial
        JLabel texto = new JLabel("Selecione a operação desejada: ");
        
        //inicializando botões da janela principal
        JButton bt1 = new JButton("Saque");
        //eventos do botão "Saque"
        bt1.addActionListener((ActionEvent e) -> {
            int numSaque = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
            String auxSaque = JOptionPane.showInputDialog("Informe o valor a ser sacado: "); //declarando um auxiliar para receber o valor do saque como uma string
            double sq = Double.parseDouble(auxSaque); //convertendo o valor do saque de string para double
            
            if (numSaque == numComum){
                if (sq <= saldo1){
                    Object[] options = { "Confirmar", "Cancelar" };
                    JOptionPane.showOptionDialog(null, "Titular: "+c.getNome()+"\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    c.sacar(sq);
                    JOptionPane.showMessageDialog(null,"Saque efetuado com sucesso");
                }
                else{
                    if(sq <= (saldo1+numLimite)){
                        Object[] options = { "Confirmar", "Cancelar" };
                        JOptionPane.showOptionDialog(null, "Titular: "+c.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                        c.depositar(sq-saldo1);
                        c.sacar(sq);
                        c.depositar(((saldo1 - sq)+(((saldo1 - sq)/100)*multa)));
                        JOptionPane.showMessageDialog(null,"Saque efetuado usando cheque especial");
                    }
                }
                if (sq > (saldo1 + numLimite)){
                        JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                }
            }
                if (numSaque == numPoupanca){
                    if (sq <= saldo2){
                        Object[] options = { "Confirmar", "Cancelar" };
                        JOptionPane.showOptionDialog(null, "Titular: "+cp.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                        cp.sacar(sq);
                        JOptionPane.showMessageDialog(null,"Saque efetuado com sucesso");
                    }
                    else{
                        if(sq <= (saldo2+numLimite)){
                            Object[] options = { "Confirmar", "Cancelar" };
                            JOptionPane.showOptionDialog(null, "Titular: "+cp.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                            cp.depositar(sq-saldo2);
                            cp.sacar(sq);
                            cp.depositar((saldo2 - sq)+(((saldo2 - sq)/100)*multa));
                            JOptionPane.showMessageDialog(null,"Saque efetuado usando cheque especial");
                        }
                    }
                    if (sq > (saldo2 + numLimite)){
                        JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                    }
                }
            if (numSaque == numEspecial){
                if (sq <= saldo3){
                    Object[] options = { "Confirmar", "Cancelar" };
                    JOptionPane.showOptionDialog(null, "Titular: "+ce.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    ce.sacar(sq);
                    JOptionPane.showMessageDialog(null,"Saque efetuado com sucesso");
                }
                else{
                    if(sq <= (saldo3+numLimite)){
                        Object[] options = { "Confirmar", "Cancelar" };
                        JOptionPane.showOptionDialog(null, "Titular: "+ce.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                        ce.depositar(sq-saldo3);
                        ce.sacar(sq);
                        double auxTeste;
                        auxTeste = ce.descontar(sq, multa,saldo3);
                        ce.depositar(auxTeste);
                        JOptionPane.showMessageDialog(null,"Saque efetuado usando cheque especial");
                    }
                }
                if (sq>(saldo3 + numLimite)){
                    JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                }
            }
        });
        
        
        JButton bt2 = new JButton("Depósito");
        //eventos do botão "Depósito"
        bt2.addActionListener((ActionEvent e) -> {
            int numDep = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
            String auxDep = JOptionPane.showInputDialog("Informe o valor a ser depositado: "); //declarando um auxiliar para receber o valor do depósito como uma string
            double dp = Double.parseDouble(auxDep); //convertendo o valor do depósito de string para double
            
            if(numDep == numComum){
                Object[] options = { "Confirmar", "Cancelar" };
                JOptionPane.showOptionDialog(null, "Titular: "+c.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                c.depositar(dp);
                JOptionPane.showMessageDialog(null,"Depósito efetuado com sucesso");
            }
            if(numDep == numPoupanca){
                Object[] options = { "Confirmar", "Cancelar" };
                JOptionPane.showOptionDialog(null, "Titular: "+cp.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                cp.depositar(dp);
                JOptionPane.showMessageDialog(null,"Depósito efetuado com sucesso");
            }
            if(numDep == numEspecial){
                Object[] options = { "Confirmar", "Cancelar" };
                JOptionPane.showOptionDialog(null, "Titular: "+ce.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                ce.depositar(dp);
                JOptionPane.showMessageDialog(null,"Depósito efetuado com sucesso");
            }
        });
        

        JButton bt3 = new JButton("Transferência");
        //eventos do botão "Transferência"
        bt3.addActionListener((ActionEvent e) -> {
            int numTrans1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));//número da conta a ser descontado o valor
            int numTrans2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));//número da conta a ser depositado o valor
            String auxTrans = JOptionPane.showInputDialog("Informe o valor a ser transferido: "); //declarando um auxiliar para receber o valor da transferência como uma string
            double tr = Double.parseDouble(auxTrans); //convertendo o valor da transferência de string para double
            
            if(numTrans1 == numComum && numTrans2 == numPoupanca){
                if(c.getSaldo()<tr){
                    JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                }
                else{
                    Object[] options = { "Confirmar", "Cancelar" };
                    JOptionPane.showOptionDialog(null, "Titular (conta 1): "+c.getNome()+"\nTitular (conta 2): "+cp.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    c.transferir(numTrans1, numTrans2, tr);
                    cp.depositar(tr);
                    JOptionPane.showMessageDialog(null,"Transferência efetuada com sucesso");
                }
            }
            
            if(numTrans1 == numComum && numTrans2 == numEspecial){
                if(c.getSaldo()<tr){
                    JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                }
                else{
                    Object[] options = { "Confirmar", "Cancelar" };
                    JOptionPane.showOptionDialog(null, "Titular (conta 1): "+c.getNome()+"\nTitular (conta 2): "+ce.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    c.transferir(numTrans1, numTrans2, tr);
                    ce.depositar(tr);
                    JOptionPane.showMessageDialog(null,"Transferência efetuada com sucesso");
                }
            }
            
            if(numTrans1 == numPoupanca && numTrans2 == numComum){
                if(cp.getSaldo()<tr){
                    JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                }
                else{
                    Object[] options = { "Confirmar", "Cancelar" };
                    JOptionPane.showOptionDialog(null, "Titular (conta 1): "+cp.getNome()+"\nTitular (conta 2): "+c.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    cp.transferir(numTrans1, numTrans2, tr);
                    c.depositar(tr);
                    JOptionPane.showMessageDialog(null,"Transferência efetuada com sucesso");
                }
            }
            
            if(numTrans1 == numPoupanca && numTrans2 == numEspecial){
                if(cp.getSaldo()<tr){
                    JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                }
                else{
                    Object[] options = { "Confirmar", "Cancelar" };
                    JOptionPane.showOptionDialog(null, "Titular (conta 1): "+cp.getNome()+"\nTitular (conta 2): "+ce.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    cp.transferir(numTrans1, numTrans2, tr);
                    ce.depositar(tr);
                    JOptionPane.showMessageDialog(null,"Transferência efetuada com sucesso");
                }
            }
            
            if(numTrans1 == numEspecial && numTrans2 == numComum){
                if(ce.getSaldo()<tr){
                    JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                }
                else{
                    Object[] options = { "Confirmar", "Cancelar" };
                    JOptionPane.showOptionDialog(null, "Titular (conta 1): "+ce.getNome()+"\nTitular (conta 2): "+c.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    ce.transferir(numTrans1, numTrans2, tr);
                    c.depositar(tr);
                    JOptionPane.showMessageDialog(null,"Transferência efetuada com sucesso");
                }
            }
            
            if(numTrans1 == numEspecial && numTrans2 == numPoupanca){
                if(ce.getSaldo()<tr){
                    JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                }
                else{
                    Object[] options = { "Confirmar", "Cancelar" };
                    JOptionPane.showOptionDialog(null, "Titular (conta 1): "+ce.getNome()+"\nTitular (conta 2): "+cp.getNome()+"\n\nClique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    ce.transferir(numTrans1, numTrans2, tr);
                    cp.depositar(tr);
                    JOptionPane.showMessageDialog(null,"Transferência efetuada com sucesso");
                }
            }
        });
        

        JButton bt4 = new JButton("Reajustar");
        //eventos do botão "Reajuste"
        bt4.addActionListener((ActionEvent e) -> {
            String aux03 = JOptionPane.showInputDialog("Informe o valor da taxa de reajuste:"); //declarando um auxiliar para receber o valor da taxa como uma string
            if(!"".equals(aux03)){
                double taxa = Double.parseDouble(aux03); //convertendo o valor da taxa de string para double
                int numReajuste = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta-poupança: "));
                if (numReajuste == numPoupanca){
                    cp.reajustar(taxa);
                    JOptionPane.showMessageDialog(null,"Reajuste efetuado com sucesso");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Número da conta não compatível");
                }
            }
            else{
                int numReajuste = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta-poupança: "));
                cp.reajustar();
                JOptionPane.showMessageDialog(null,"Reajuste efetuado com sucesso");
            }
        });
        
        
        JButton bt5 = new JButton("Ver saldos");
        //eventos do botão "Ver saldos"
        bt5.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null,"Tipo: Conta-comum\nTitular: "+c.getNome()+"\nNúmero da conta: "+c.getNumero()+"\nSaldo: "+c.getSaldo()+"\n\nTipo: Conta-poupança\nTitular: "+cp.getNome()+"\nNúmero da conta: "+cp.getNumero()+"\nSaldo: "+cp.getSaldo()+"\n\nTipo: Conta-especial\nTitular: "+ce.getNome()+"\nNúmero da conta: "+ce.getNumero()+"\nSaldo: "+ce.getSaldo());
        });
        

        JButton bt6 = new JButton("Sair");
        //eventos do botão "Sair"
        bt6.addActionListener((ActionEvent e) -> {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
               System.exit(1);
            }
        });
        
        
        inicio.setSize(250,200); //tamanho da janela

        inicio.setLocation(600,200); //localização da janela
        
        inicio.getContentPane().setLayout(new FlowLayout()); //layout da janela
        
        inicio.getContentPane().add(texto);
        
        inicio.getContentPane().add(bt1);

        inicio.getContentPane().add(bt2);

        inicio.getContentPane().add(bt3);

        inicio.getContentPane().add(bt4);

        inicio.getContentPane().add(bt5);

        inicio.getContentPane().add(bt6);

        inicio.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        inicio.setVisible(true); //tornando a janela visível para o usuário
    }
}