/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TelasDiretor;

import Classes.Departamento;
import Classes.Empregado;
import Classes.Estagiario;
import Classes.Gerente;
import ClassesAux.Arquivo;
import ClassesAux.Data;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Binho
 */
public class Direção extends javax.swing.JFrame {

    /**
     * Creates new form Direção
     */
    //lugar para armazenar as listas que farei uso
    List<Estagiario> listaEstagiarios = null;
    List<Empregado> listaEmpregado = null;
    List<Departamento> listaDepartamento = null;
    List<Gerente> listaGerente = null;
    
    //construtor padrao que recebe todas as listas
    public Direção(List<Departamento> listaDepartamento,List<Estagiario> listaEstagiarios, List<Empregado> listaEmpregado, List<Gerente> listaGerente) {
        initComponents();
        this.listaDepartamento = listaDepartamento;
        this.listaEstagiarios = listaEstagiarios;
        this.listaEmpregado = listaEmpregado;
        this.listaGerente = listaGerente;
        AttTable();
    }
    
    //função para atualizar a tabela com os dados da lista
    private void AttTable(){
        DefaultTableModel model = (DefaultTableModel) departamentos.getModel();
        model.setRowCount(0);
        //enquanto a lista n estiver vazia eu pecorro salvando os dados nas colunas respectivas
        if (listaDepartamento != null) {
            for (Departamento empregado : listaDepartamento) {
                Object[] row = new Object[4];
                row[0] = empregado.getCodigo();
                row[1] = empregado.getNome();
                model.addRow(row);
            }
        }
        
        DefaultTableModel model2 = (DefaultTableModel) funcs.getModel();
        model2.setRowCount(0);
        if (listaGerente != null) {
            for (Gerente gerente : listaGerente) {
                Object[] row = new Object[5];
                row[0] = gerente.getCodigo();
                row[1] = gerente.getNome();
                row[2] = gerente.getCargo();
                row[3] = gerente.getSalario();
                row[4] = gerente.getDepartamento();
                model2.addRow(row);
            }
        }
        if (listaEmpregado != null) {
            for (Empregado empregado : listaEmpregado) {
                Object[] row = new Object[5];
                row[0] = empregado.getCodigo();
                row[1] = empregado.getNome();
                row[2] = empregado.getCargo();
                row[3] = empregado.getSalario();
                row[4] = empregado.getDepartamento();
                model2.addRow(row);
            }
        }
        if (listaEstagiarios != null) {
            for (Estagiario estagiario : listaEstagiarios) {
                Object[] row = new Object[5];
                row[0] = estagiario.getCodigo();
                row[1] = estagiario.getNome();
                row[2] = estagiario.getCargo();
                row[3] = estagiario.getSalario();
                row[4] = estagiario.getDepartamento();
                model2.addRow(row);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        departamentos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        funcs = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Diretoria");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Diretoria");

        departamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Departamentos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(departamentos);

        jButton3.setText("Excluir Departamento");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Criar Departamento");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField2.setText("0");

        jLabel2.setText("Código");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("...");

        jButton2.setText("Atualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        funcs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Cargo", "Salario", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(funcs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel2))
                                .addComponent(jButton1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jButton1)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Criação de um departamento
        //primeiro pego os dados do nome e o codigo do novo funcionario que sera promovido a gerente
        String nome = JOptionPane.showInputDialog(null, "Nome do Departamento:","Novo Departamento", JOptionPane.INFORMATION_MESSAGE);
        String codG = JOptionPane.showInputDialog(null, "Código do novo Gerente:","Novo Gerente", JOptionPane.INFORMATION_MESSAGE);
        int codGerente = Integer.parseInt(codG);
        //busco esse funcionário para ver se ele existe
        Estagiario estagiario = Estagiario.buscarPorCodigo(listaEstagiarios, codGerente);
        Empregado empregado = Empregado.buscarPorCodigo(listaEmpregado, codGerente);
        if (estagiario != null) {
            //existindo eu mando nesta parte como um estagiario para ser promovido
            Gerente Ngerente = new Gerente(estagiario.getNome(), estagiario.getSenha(), estagiario.getIdade(), estagiario.getTelefone(), estagiario.getEmail(), estagiario.getCPF(), Data.getDataAtual(), estagiario.getDataN(), "Gerente", 0);
            //cria departamento
            Departamento dep = new Departamento(nome, Ngerente.getCodigo());
            Ngerente.setDepartamento(dep.getCodigo());
            //grava gerente 
            Arquivo.adicionarGerente(Ngerente, "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Gerentes.txt");
            //exclui estagiario
            Arquivo.removerEmpregado(estagiario.getNome(), "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Estagiarios.txt");
            //grava departamento
            Arquivo.adicionarDepartamento(dep, "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Departamentos.txt");
            //atualiza lista
            listaDepartamento.add(dep);
            listaGerente.add(Ngerente);
            listaEstagiarios.remove(estagiario);
            //sucesso
            JOptionPane.showMessageDialog(null, "Departament Criado!", "Novo Departamento", JOptionPane.INFORMATION_MESSAGE);
        }else if (empregado != null){
            //existindo eu mando nesta parte como um empregado para ser promovido
            Gerente Ngerente = new Gerente(empregado.getNome(), empregado.getSenha(),empregado.getIdade(), empregado.getTelefone(), empregado.getEmail(), empregado.getCPF(), Data.getDataAtual(), empregado.getDataN(), "Gerente", 0);
            //cria departamento
            Departamento dep = new Departamento(nome, Ngerente.getCodigo());
            Ngerente.setDepartamento(dep.getCodigo());
            //grava gerente 
            Arquivo.adicionarGerente(Ngerente, "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Gerentes.txt");
            //exclui estagiario
            Arquivo.removerEmpregado(empregado.getNome(), "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Empregados.txt");
            //grava departamento
            Arquivo.adicionarDepartamento(dep, "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Departamentos.txt");
            //atualiza lista
            listaDepartamento.add(dep);
            listaGerente.add(Ngerente);
            listaEmpregado.remove(empregado);
            //sucesso
            JOptionPane.showMessageDialog(null, "Departament Criado!", "Novo Departamento", JOptionPane.INFORMATION_MESSAGE);
        }else if (empregado == null && estagiario == null){
            JOptionPane.showMessageDialog(null, "Escolha um empregado ou estagiário", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        AttTable();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // vou excluir um departamento
        //primero pego o codigo e encontro o departamento
        Departamento dep = Departamento.buscarDepartamentoPorCodigo(listaDepartamento, Integer.parseInt(jTextField2.getText()));
        if(dep != null && listaDepartamento.size() > 1){ //tenho que ter ao menos um departamento e ter encontrado o departamento
            if(dep.getCodigo() == 1){
                //transfiro todos do departamento excluido para o posterior caso o departamento seja o 1° ou algum existente
                Departamento verify = Departamento.buscarDepartamentoPorCodigo(listaDepartamento,dep.getCodigo() + 1);
                int i = 0;
                while(verify == null){
                    verify = Departamento.buscarDepartamentoPorCodigo(listaDepartamento,i);
                    i++;
                }
                for (Empregado empregado : listaEmpregado) {
                    if (empregado.getDepartamento() == dep.getCodigo()) {
                        empregado.setDepartamento(verify.getCodigo());
                        Arquivo.removerEmpregado(empregado.getNome(), "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Empregados.txt");
                        Arquivo.adicionarEmpregado(empregado, "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Empregados.txt");
                    }
                }
                for (Estagiario estagiario : listaEstagiarios) {
                    if (estagiario.getDepartamento() == dep.getCodigo()) {
                        estagiario.setDepartamento(verify.getCodigo());
                        Arquivo.removerEmpregado(estagiario.getNome(), "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Estagiarios.txt");
                        Arquivo.adicionarEstagiario(estagiario, "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Estagiarios.txt");
                    }
                }
                //rebaixo o antigo gerente a empregado comum
                Empregado novo = null;
                Gerente velhoG = null;
                for (Gerente gerente : listaGerente) {
                    if (gerente.getDepartamento() == dep.getCodigo()) {
                        novo = new Empregado(gerente.getNome(), gerente.getSenha(), gerente.getIdade(), gerente.getTelefone(), gerente.getEmail(), gerente.getCPF(), Data.getDataAtual(), gerente.getDataN(), "Empregado", verify.getCodigo());
                        Arquivo.adicionarEmpregado(novo, "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Empregados.txt");
                        Arquivo.removerEmpregado(gerente.getNome(), "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Gerentes.txt");
                        velhoG = gerente;
                    }
                }
                //atualizo as listas
                listaGerente.remove(velhoG);
                listaEmpregado.add(novo);
                //exclui do arquivo
                Arquivo.removerDepartamento(dep.getNome(), "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Departamentos.txt");
                //atualizo as listas
                listaDepartamento.remove(dep);
                //mensagem de exclusão
                JOptionPane.showMessageDialog(null, "Departament Excluido!", "Exclusão de Departamento", JOptionPane.INFORMATION_MESSAGE);
            }else{
                //transfiro todos do departamento excluido para o anterior ou algum existente
                Departamento verify = Departamento.buscarDepartamentoPorCodigo(listaDepartamento,dep.getCodigo() - 1);
                int i = 0;
                while(verify == null){
                    verify = Departamento.buscarDepartamentoPorCodigo(listaDepartamento,i);
                    i++;
                }
                for (Empregado empregado : listaEmpregado) {
                    if (empregado.getDepartamento() == dep.getCodigo()) {
                        empregado.setDepartamento(verify.getCodigo());
                        Arquivo.removerEmpregado(empregado.getNome(), "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Empregados.txt");
                        Arquivo.adicionarEmpregado(empregado, "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Empregados.txt");
                    }
                }
                for (Estagiario estagiario : listaEstagiarios) {
                    if (estagiario.getDepartamento() == dep.getCodigo()) {
                        estagiario.setDepartamento(verify.getCodigo());
                        Arquivo.removerEmpregado(estagiario.getNome(), "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Estagiarios.txt");
                        Arquivo.adicionarEstagiario(estagiario, "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Estagiarios.txt");
                    }
                }
                //rebaixo o antigo gerente a empregado comum
                Empregado novo = null;
                Gerente velhoG = null;
                for (Gerente gerente : listaGerente) {
                    if (gerente.getDepartamento() == dep.getCodigo()) {
                        novo = new Empregado(gerente.getNome(), gerente.getSenha(), gerente.getIdade(), gerente.getTelefone(), gerente.getEmail(), gerente.getCPF(), Data.getDataAtual(), gerente.getDataN(), "Empregado", verify.getCodigo());
                        Arquivo.adicionarEmpregado(novo, "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Empregados.txt");
                        Arquivo.removerEmpregado(gerente.getNome(), "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Gerentes.txt");
                        velhoG = gerente;
                    }
                }
                //atualizo as listas
                listaGerente.remove(velhoG);
                listaEmpregado.add(novo); 
                //exclui do arquivo
                Arquivo.removerDepartamento(dep.getNome(), "C:\\Users\\links\\Documents\\NetBeansProjects\\ProjetoSistema\\New Folder\\Projeto-Lp-III\\src\\main\\java\\Arquivos\\Departamentos.txt");
                //atualizo as listas
                listaDepartamento.remove(dep);
                //mensagem de exclusão
                JOptionPane.showMessageDialog(null, "Departament Excluido!", "Exclusão de Departamento", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        AttTable();
        jLabel3.setText("Departamento não existe!");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AttTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Direção.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Direção.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Direção.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Direção.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable departamentos;
    private static javax.swing.JTable funcs;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
