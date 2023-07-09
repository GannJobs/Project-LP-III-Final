package Classes;


import ClassesAux.Data;
import java.util.List;

public class Gerente extends Funcionario{

    private int departamento;
    private double salario = 2500.00;
    private final double salarioBase = salario;

    //construtor padrão que usa os dados das classes ancestrais
    public Gerente(String nome, String senha, int i, String telefone, String email, String cpf, Data dataAdmissao, Data data, String cargo, int departamento) {
        super(nome, senha, i, telefone,email, cpf, dataAdmissao, data, cargo);
        this.departamento = departamento;
    }
    
    //construtor que usa um objeto gerente e outro objeto departamento
    public Gerente(Gerente gerente, Departamento dep){
        super(gerente.getNome(), gerente.getSenha(), gerente.getIdade(), gerente.getTelefone(),gerente.getEmail(), gerente.getCPF(), Data.getDataAtual(), gerente.getDataN(), gerente.getCargo());
        this.departamento = dep.getCodigo();
    }
    
    //construtor que usa um objeto gerente como parâmetro
    public Gerente(Gerente gerente){
        super(gerente.getNome(), gerente.getSenha(), gerente.getIdade(), gerente.getTelefone(),gerente.getEmail(), gerente.getCPF(), gerente.getDataAdmissao(), gerente.getDataN(), gerente.getCargo());
        this.departamento =  gerente.getDepartamento();
    }
    
    //função estática que retorna um objeto a partir da busca do nome, usado para o login
    public static  Gerente buscarNome(List<Gerente> listaGerentes, String nome) {
        for (Gerente gerente : listaGerentes) {
            if (gerente.getNome().equals(nome)) {
                return gerente; // Retorna o gerente encontrado
            }
        }
    return null;
    }
    //função estática que retorna um objeto a partir da busca do nome, usado em funções da tela para busca
    public static  Gerente buscarCod(List<Gerente> listaGerentes, int cod) {
        for (Gerente gerente : listaGerentes) {
            if (gerente.getCodigo()== cod) {
                return gerente; // Retorna o gerente encontrado
            }
        }
    return null;
    }
    
    public int getDepartamento(){
        return departamento;
    }
    
    public void setDepartamento(int nDep){
        this.departamento = nDep;
    }
    
    public double getSalario(){
        return salario;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartamento: " + departamento + "\nSalário Gerente: " + salario;
    }
}
