/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package z808;

import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class menuPrincipal {
    
    public static void main(String[] args){
        //Entrada de opção do usuário:
        System.out.println("Entre com uma opção do Menu");  
        System.out.println("0 - Prcessador de Macros: ");
        System.out.println("1 - Montador: ");  
        System.out.println("2 - Maquina Virtual: ");  
        
        Scanner sc = new Scanner(System.in);  
        String entrada;
          
        entrada = sc.nextLine();
        
        switch(Integer.parseInt(entrada)){
            case 0:
                processadorDeMacros processador = new processadorDeMacros();
                processador.rotinaDeProcessamentoDeMacros();
                break;
            case 1:
                montador montador = new montador();
                montador.rotinaDeMontagem();
                break;
            case 2:
                maquinaVirtual maquinaVirtual = new maquinaVirtual();
                maquinaVirtual.rotinaDeExecucao();
                break;
        }
  
    }
    
}
