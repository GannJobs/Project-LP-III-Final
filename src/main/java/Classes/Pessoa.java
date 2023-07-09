package Classes;

import ClassesAux.Data;


public abstract class Pessoa {
    protected String nome;
    protected int idade;
    protected String telefone;
    protected String email;
    protected String cpf;  
    protected Data dataNascimento;
    //Classe mae de todos os objetos derivados de funcionários
    
    //Construtor sem o telefone
    public Pessoa(String nome, int idade, String cpf, Data dataN){
        this(nome,idade, "sem celular","sem email",cpf,dataN);
    }
    
    //Construtor sem o email 
    public Pessoa(String nome, int idade, String telefone, String cpf, Data dataN){
        this(nome,idade,telefone,"sem email",cpf,dataN);
    }
    
    //Construtor sem o telefone
    public Pessoa(String nome, String email, int idade, String cpf, Data dataN){
        this(nome,idade,"sem celular", email, cpf,dataN);
    }
    
    //Construtor padrão com todos os campos
    public Pessoa(String nome, int idade, String telefone, String email, String cpf, Data dataN){
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataN;
    }

    public Data getDataN(){
        return dataNascimento;
    }
    
    public String getNome(){
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }

     public String getEmail() {
        return email;
    }

     public String getCPF() {
        return cpf;
    }
    
    @Override
    public String toString(){
        return "nome: " + nome + "\nidade: " + idade + 
                "\nData de Nascimento: " + dataNascimento.imprimirDataExtenso() 
                + "\ntelefone: " + telefone + "\nemail: " + email + "\ncpf: " + cpf;
    }
     
    public String getData(){
        return dataNascimento.imprimirDataExtenso();
    }
}