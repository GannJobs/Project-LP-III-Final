package ClassesAux;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Classes.Departamento;
import Classes.Diretor;
import Classes.Empregado;
import Classes.Estagiario;
import Classes.Gerente;
import javax.swing.JOptionPane;

public abstract class Arquivo {
    // FUNÇOES DE CARREGAR ARQUIVO
    private static List<Empregado> empregados;
    private static List<Estagiario> estagiarios;

//retorna uma lista de empregados usada em funções das telas
    public static List<Empregado> carregaEmpregado(String arquivo) {
        empregados = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[1].trim();
                String senha = dados[2].trim();
                int idade = Integer.parseInt(dados[3].trim());
                String telefone = dados[4].trim();
                String cpf = dados[5].trim();
                String email = dados[6].trim();
                Data dataNascimento = parseData(dados[7].trim());
                Data dataAdmissao = parseData(dados[8].trim());
                String cargo = dados[9].trim();
                int departamento = Integer.parseInt(dados[10].trim());

                Empregado empregado = new Empregado(nome, senha, idade, telefone, cpf, email, dataNascimento , dataAdmissao, cargo, departamento);
                empregados.add(empregado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return empregados;
    }
//retorna uma lista de estagiarios usada em funções das telas
     public static List<Estagiario> carregaEstagiario(String arquivo) {
        estagiarios = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[1].trim();
                String senha = dados[2].trim();
                int idade = Integer.parseInt(dados[3].trim());
                String email = dados[4].trim();
                String cpf = dados[5].trim();
                String telefone = dados[6].trim();
                Data dataNascimento = parseData(dados[7].trim());
                Data dataAdmissao = parseData(dados[8].trim());
                String cargo = dados[9].trim();
                int duracao = Integer.parseInt(dados[10].trim());
                int departamento = Integer.parseInt(dados[11].trim());

                Estagiario estagiario = new Estagiario(nome, senha, idade, email, telefone, cpf, dataNascimento, dataAdmissao, cargo, duracao, departamento);
                estagiarios.add(estagiario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return estagiarios;
    }

     private static Data parseData(String dataStr) {
        String[] partes = dataStr.split(":");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);
        return new Data(dia, mes, ano);
    }
//retorna uma lista de gerentes usada em funções das telas    
    public static List<Gerente> carregaGerente(String arquivo) {
    List<Gerente> gerentes = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(",");
            String nome = dados[1].trim();
            String senha = dados[2].trim();
            int idade = Integer.parseInt(dados[3].trim());
            String telefone = dados[4].trim();
            String cpf = dados[5].trim();
            String email = dados[6].trim();
            Data dataNascimento = parseData(dados[7].trim());
            Data dataAdmissao = parseData(dados[8].trim());
            String cargo = dados[9].trim();
            int departamento = Integer.parseInt(dados[10].trim());

            Gerente gerente = new Gerente(nome, senha, idade, telefone, cpf, email, dataAdmissao, dataNascimento, cargo, departamento);
            gerentes.add(gerente);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return gerentes;
    }
//retorna uma lista de diretores usada em funções das telas
     public static List<Diretor> carregaDiretor(String arquivo) {
        List<Diretor> diretores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[1].trim();
                String senha = dados[2].trim();
                int idade = Integer.parseInt(dados[3].trim());
                String telefone = dados[4].trim();
                String cpf = dados[5].trim();
                String email = dados[6].trim();
                Data dataNascimento = parseData(dados[7].trim());
                Data dataAdmissao = parseData(dados[8].trim());
                String cargo = dados[9].trim();

                Diretor diretor = new Diretor(nome, senha, idade, telefone, cpf, email, dataAdmissao, dataNascimento, cargo);
                diretores.add(diretor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return diretores;
    }

    // FUNÇOES DE ADICIONAR UM FUNCIONARIO NO ARQUIVO ==========================================================================
    //Adiciona um estagiário no arquivo
    public static boolean adicionarEstagiario(Estagiario estagiario, String arquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            String linha = estagiario.getCodigo()+ ","+
                           estagiario.getNome() + "," +
                           estagiario.getSenha() + "," +
                           estagiario.getIdade() + "," +
                           estagiario.getTelefone() + "," +
                           estagiario.getCPF() + "," +
                           estagiario.getEmail() + "," +
                           estagiario.getDataN().getDia() + ":" +
                           estagiario.getDataN().getMes() + ":" +
                           estagiario.getDataN().getAno() + "," +
                           estagiario.getDataAdmissao().getDia() + ":" +
                           estagiario.getDataAdmissao().getMes() + ":" +
                           estagiario.getDataAdmissao().getAno() + "," +
                           estagiario.getCargo() + "," +
                           estagiario.getDuracaoEstagio() + "," +
                           estagiario.getDepartamento();

            writer.write(linha);
            writer.newLine();
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Adiciona um empregado no arquivo
    public static boolean adicionarEmpregado(Empregado empregado, String arquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            String linha = empregado.getCodigo()+ ","+
                           empregado.getNome() + "," +
                           empregado.getSenha() + "," +
                           empregado.getIdade() + "," +
                           empregado.getTelefone() + "," +
                           empregado.getCPF() + "," +
                           empregado.getEmail() + "," +
                           empregado.getDataN().getDia() + ":" +
                           empregado.getDataN().getMes() + ":" +
                           empregado.getDataN().getAno() + "," +
                           empregado.getDataAdmissao().getDia() + ":" +
                           empregado.getDataAdmissao().getMes() + ":" +
                           empregado.getDataAdmissao().getAno() + "," +
                           empregado.getCargo() + "," +
                           empregado.getDepartamento();

            writer.write(linha);
            writer.newLine();
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Adiciona um gerente no arquivo
     public static boolean adicionarGerente(Gerente gerente, String arquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            String linha = gerente.getCodigo()+ ","+
                           gerente.getNome() + "," +
                           gerente.getSenha() + "," +
                           gerente.getIdade() + "," +
                           gerente.getTelefone() + "," +
                           gerente.getCPF() + "," +
                           gerente.getEmail() + "," +
                           gerente.getDataN().getDia() + "/" +
                           gerente.getDataN().getMes() + "/" +
                           gerente.getDataN().getAno() + "," +
                           gerente.getDataAdmissao().getDia() + "/" +
                           gerente.getDataAdmissao().getMes() + "/" +
                           gerente.getDataAdmissao().getAno() + "," +
                           gerente.getCargo() + "," +
                           gerente.getDepartamento();

            writer.write(linha);
            writer.newLine();
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Adiciona um diretor no arquivo
    public static boolean adicionarDiretor(Diretor diretor, String arquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            String linha = diretor.getCodigo()+ ","+
                           diretor.getNome() + "," +
                           diretor.getSenha() + "," +
                           diretor.getIdade() + "," +
                           diretor.getTelefone() + "," +
                           diretor.getCPF() + "," +
                           diretor.getEmail() + "," +
                           diretor.getDataN().getDia() + "/" +
                           diretor.getDataN().getMes() + "/" +
                           diretor.getDataN().getAno() + "," +
                           diretor.getDataAdmissao().getDia() + "/" +
                           diretor.getDataAdmissao().getMes() + "/" +
                           diretor.getDataAdmissao().getAno() + "," +
                           diretor.getCargo();
                           

            writer.write(linha);
            writer.newLine();
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // FUNÇAO DE REMOVER FUNCIONARIO ==============================================================================
    /*como todos os objetos tem o campo de codigo de chave primaria, e cada um tem seu respectivo arquivo,
    esta função serve para a chamdada de todos arquivos, exceto os de departamento*/
    public static boolean removerEmpregado(String str, String arquivo) {
        try {
            File inputFile = new File(arquivo);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String linha;
            boolean encontrado = false;
           //  ========  busca ==========================
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                String primeiraColuna = campos[1].trim();

                if (primeiraColuna.equals(str)) {
                    encontrado = true;
                    continue; // Ignora a linha atual
                }

                writer.write(linha);
                writer.newLine();
            }
            
            writer.close();
            reader.close();

            if (encontrado) {
                inputFile.delete();
                tempFile.renameTo(inputFile);
                return true;
            } else {
                tempFile.delete();
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    // FUNÇAO DE CARREGAR DEPARTAMENTO ===================================================================================
    //retorna uma lista de departamentos que temos no arquivo
    public static List<Departamento> carregaDepartamentos(String arquivo) {
        List<Departamento> departamentos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[1].trim();
                int gerenteResponsavel = Integer.parseInt(dados[2].trim());
            
                Departamento departamento = new Departamento(nome,gerenteResponsavel);
                
                departamentos.add(departamento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return departamentos;
    }

    // FUMÇÃO DE ADICIONAR DEPARTAMENTO AO ARQUIVO ===========================================================================
    public static boolean adicionarDepartamento(Departamento departamento, String arquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            String linha = departamento.getCodigo() + "\n," +
                           departamento.getNome() + "," +
                           departamento.getGerenteResponsavel();

            writer.write(linha);
            writer.newLine();
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // FUNÇÃO DW ROMOVER DO DEPARTAMENTO ====================================================================================
    public static boolean removerDepartamento(String codigo, String arquivo) {
        try {
            File inputFile = new File(arquivo);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String linha;
            boolean encontrado = false;

            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                String primeiraColuna = campos[1].trim();

                if (primeiraColuna.equals(codigo)) {
                    encontrado = true;
                    continue; // Ignora a linha atual
                }

                writer.write(linha);
                writer.newLine();
            }

            writer.close();
            reader.close();

            if (encontrado) {
                inputFile.delete();
                tempFile.renameTo(inputFile);
                return true;
            } else {
                tempFile.delete();
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}