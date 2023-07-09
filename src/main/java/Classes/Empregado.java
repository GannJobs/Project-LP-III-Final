package Classes;

import ClassesAux.Data;
import java.util.List;

public class Empregado extends Funcionario implements Pagamento{
    private String funcao = "Dar entrada nos produtos.";
    private double salario = 2000.00;
    private final double salarioBase = salario;
    private int departamento;

    //construtor padrao
    public Empregado(String nome, String senha, int i, String telefone, String email, String cpf, Data dataAdmissao, Data dataN, String cargo, int departamento) {
        super( nome, senha, i, telefone,email, cpf, dataAdmissao, dataN, cargo);
        this.departamento = departamento;
    }
    
    //construtor que utiliza outro objeto
    public Empregado(Empregado empregado){
        super(empregado.getNome(), empregado.getSenha(), empregado.getIdade(),empregado.getTelefone(),empregado.getEmail(),empregado.getCPF(),empregado.getDataAdmissao(),empregado.getDataNascimento(), empregado.getCargo());
        this.departamento = empregado.getDepartamento();
    }
    
    //função estática que retorna um objeto a partir da busca do nome, usado em funções da tela para busca
    public static Empregado buscarPorCodigo(List<Empregado> listaEmpregados, int codigoBusca) {
        for (Empregado empregado : listaEmpregados) {
            if (empregado.getCodigo() == codigoBusca) {
                return empregado; // Retorna o Empregado encontrado
            }
        }
    return null;
    }
    
    //função estática que retorna um objeto a partir da busca do nome, usado para o login
    public static Empregado buscarNome(List<Empregado> listaEmpregados, String nome) {
        for (Empregado empregado : listaEmpregados) {
            if (empregado.getNome().equals(nome)) {
                return empregado; // Retorna o empregado encontrado
            }
        }
    return null;
    }
    
    //imlpementação da interface de Pagamento
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
    
    public String getFuncao(){
        return funcao;
    }
    
    public void setFuncao(String nFuncao){
        this.funcao = nFuncao;
    }

    public int getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(int nDep){
        this.departamento = nDep;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFunção: " + funcao + "\nDepartamento: " + departamento + "\nSalario: " + salario;
    }
    
    public double getSalario(){
        return salario;
    }

    public Data getDataNascimento() {
        return super.dataNascimento;
    }
    @Override
    public String getCargo() {
        return super.getCargo();
    }
    //data nascimento
    public String getData() {
        return super.getdata();
    }
}
