
package Classes;

import ClassesAux.Data;
import java.util.List;

public class Estagiario extends Funcionario implements Pagamento {

    private int duracaoEstagio;
    private int departamento;
    private double salario = 700.00;
    private final double salarioBase = salario;
    private String funcao = "dar baixa na saida de produtos.";

    //Construtor que tem apenas o contato do telefone
    public Estagiario(String nome,String senha, String telefone, int idade, String cpf, Data dataN, Data dataAdmissao, String cargo, int duracaoEstagio, int departamento) {
        super(nome, senha,idade,telefone, cpf, dataN, dataAdmissao, cargo);
        this.duracaoEstagio = duracaoEstagio;
        this.departamento = departamento;
    }

    //Construtor que tem todos os dados de pessoa, funcionario e o adicionais da classe
    public Estagiario(String nome, String senha, int idade,String email, String telefone, String cpf, Data dataN, Data dataAdmissao, String cargo, int duracaoEstagio, int departamento) {
        super(nome, senha, idade, telefone,email, cpf, dataN, dataAdmissao, cargo);
        this.duracaoEstagio = duracaoEstagio;
        this.departamento = departamento;
    }
    
    //Construtor que utiliza outro objeto
    public Estagiario(Estagiario estagiario){
        super(estagiario.getNome(), estagiario.getSenha(), estagiario.getIdade(),estagiario.getEmail(),estagiario.getTelefone(),estagiario.getCPF(),estagiario.getDataNascimento(),estagiario.getDataAdmissao(), estagiario.getCargo());
        this.departamento = estagiario.getDepartamento();
        this.duracaoEstagio = estagiario.getDuracaoEstagio();
    }
    
    //função estática que retorna um objeto a partir da busca do nome, usado em funções da tela para busca
    public static Estagiario buscarPorCodigo(List<Estagiario> listaEstagiarios, int codigoBusca) {
        for (Estagiario estagiario : listaEstagiarios) {
            if (estagiario.getCodigo() == codigoBusca) {
                return estagiario; // Retorna o estagiario encontrado
            }
        }
    return null;
    }
    
    //função estática que retorna um objeto a partir da busca do nome, usado para o login
    public static Estagiario buscarNome(List<Estagiario> listaEstagiarios, String nome) {
        for (Estagiario estagiario : listaEstagiarios) {
            if (estagiario.getNome().equals(nome)) {
                return estagiario; // Retorna o estagiario encontrado
            }
        }
    return null;
    }
    
    @Override
    public boolean Aumento(double valor){
        if(valor > (salarioBase + salarioBase*0.3)){
            return false;
        }else if(valor > salarioBase){
            this.salario = valor;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean Desconto(double valor){
        if(valor > salarioBase){
            return false;
        }else if(valor > (salarioBase - salarioBase*0.3)){
            this.salario = valor;
            return true;
        } 
        return false;
    }
    
    public double getSalario(){
        return salario;
    }

    public String getFuncao(){
        return funcao;
    }
    
    public void setFuncao(String nFuncao){
        this.funcao = nFuncao;
    }
    
    public int getDuracaoEstagio() {
        return duracaoEstagio;
    }
    
    public String getDuracaoEstagioStr(){
        return Integer.toString(duracaoEstagio);
    }

    public void setDuracaoEstagio(int duracaoEstagio) {
        this.duracaoEstagio = duracaoEstagio;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }
     
    public String getdatas(){
        return super.getData();
    }

    @Override
    public String toString() {
        return super.toString() + "\nDuração do Estágio: " + duracaoEstagio + " meses" + "\nDepartamento: " + departamento
                + "\nFuncao: " + funcao + "\nSalario: " + salario;
    }

     public Data getDataNascimento() {
        return dataNascimento;
    }
     
     public String getDataNascimentoExtenso(){
         return dataNascimento.imprimirDataExtenso();
     }  
}
