/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Binho
 */
//interface para mexer com o pagamento
public interface Pagamento {
    boolean Aumento(double valor);
    boolean Desconto(double valor);
}
