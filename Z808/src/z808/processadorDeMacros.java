/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package z808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lucas
 */
public class processadorDeMacros {
            
            private File arqObjeto, arqFonteComMacrosExpandidas;
            private FileWriter escritor, escritor2;
            private BufferedWriter bw, bw2;
            private BufferedReader bufferLeituraArquivoFonteComMacros, bufferLeituraArquivoDefinicoesDeMacros;
            private ArrayList nomesMacros;
            private boolean flagNomeDeMacro = false;
            
    public void rotinaDeProcessamentoDeMacros(){
        
        /*
         * 
        EXEMPLO DE USO DE HASHMAP!
        HashMap<String, Integer> lista = new HashMap<String, Integer>();  
        lista.put("lucas", 10);
        int i = lista.get("lucas");
        System.out.println(i);
        FIM
        * 
        */
        
        
        
        try {
        
        //Entrada do arquivo fonte com definições de MACROS
        arqObjeto = new File("definicoes_de_macros.txt");
        arqObjeto.createNewFile();
        escritor = new FileWriter(arqObjeto);
        bw = new BufferedWriter(escritor); //variavel para escrever no arquivo
        bufferLeituraArquivoFonteComMacros = new BufferedReader(new FileReader("arq_fonte_com_macros.txt")); //Lê na raiz do projeto
        //Criação do arquivo para gravar código objeto
            
        String str;
        str = bufferLeituraArquivoFonteComMacros.readLine().toUpperCase();
        String delims = " ";
        String[] tokens = str.split(delims); //contem todo programa
        
        if(!tokens[0].equals("INICIO")){
        
            nomesMacros = new ArrayList();
            nomesMacros.add(tokens[0]); //adiciona o primeiro nome de macro
                
            
            //While que le o arquivo fonte com expansões de macro e gera um novo arquivo 
            //apenas com expansões                  
            while (!tokens[0].equals("INICIO")) { //arquivo

              if(tokens[0].equals("ENDM")){
                 flagNomeDeMacro = true;
              }
              
              for(int i=0; i< tokens.length; i++){ //linha
                   bw.write((tokens[i]) +" "); //escreve na definição de macros
                   
                   if(flagNomeDeMacro && !tokens[0].equals("ENDM")){
                       nomesMacros.add(tokens[0]);
                       flagNomeDeMacro = false;
                   }
                   
               }
                bw.newLine();   

                str = bufferLeituraArquivoFonteComMacros.readLine().toUpperCase();
                tokens = str.split(delims);
            }//Fim da geração do arquivo de definições de macros         

            bw.close();
            
            
            
            
            
            
            
            
            
            
            
            

            //Re-leitura do arquivo fonte contendo definiçẽs de macros e criação de um novo
            //arquivo fonte com macros expandidas
            arqFonteComMacrosExpandidas = new File("arquivo_fonte_com_macros_expandidas.txt");
            arqFonteComMacrosExpandidas.createNewFile();
            escritor2 = new FileWriter(arqFonteComMacrosExpandidas);
            bw2 = new BufferedWriter(escritor2);
            ArrayList<String> listaParametros, listaValores;
            
            
            

            while (!tokens[0].equals("FIM")) { //vai lendo e 

                //Achei um token[o] que esta na lista de macros
                if(nomesMacros.contains(tokens[0])){
                    //expansão de macro                                         
                    
                    //Variávels para LEITURA do arquivo com DEFINIÇÕES de macros
                    bufferLeituraArquivoDefinicoesDeMacros = new BufferedReader(new FileReader("definicoes_de_macros.txt"));
                    String linhaDefDeMacros = bufferLeituraArquivoDefinicoesDeMacros.readLine().toUpperCase();
                    String[] tokensMacros = linhaDefDeMacros.split(delims);
                    listaValores = new ArrayList<String>();
                    listaParametros = new ArrayList<String>();

                    while(!tokensMacros[0].equals(tokens[0])){ //varre até achar o nome da macro desejada
                        linhaDefDeMacros = bufferLeituraArquivoDefinicoesDeMacros.readLine().toUpperCase();
                        tokensMacros = linhaDefDeMacros.split(delims);
                        
                    }
                    
                    boolean primeiraLinha = true;
                    while(!tokensMacros[0].equals("ENDM")){
                            
                            if(!primeiraLinha){
                                for(int i=0; i< tokensMacros.length; i++){ //linha
                                    
                                
                                        if(listaParametros.contains(tokensMacros[i])){
                                            int indice = listaParametros.indexOf(tokensMacros[i]);
                                            bw2.write(listaValores.get(indice) + " ");
                                        }else
                                        {
                                            bw2.write(tokensMacros[i] + " ");
                                        }
                             

                                }
                                bw2.newLine();

                            }else{
                                primeiraLinha = false;
                                
                                //Compondo a lista de parametros
                                
                                
                                int j = 2;
                                for(int i= 0; i < tokensMacros.length; i++){
                                    if(i == 0 || i == 1){
                                        //Pass
                                    }else{
                                        listaParametros.add(tokensMacros[j]);
                                        j++;
                                    }

                                }
                                
                                for(String item : listaParametros){
                                    System.out.println("Parametro: " + item);
                                }
                                
                                //Compondo lista de valores
                                j = 1;
                                for(int i= 0; i < tokens.length; i++){
                                    if(i == 0){
                                        //Pass
                                    }else{
                                        listaValores.add(tokens[j]);
                                        j++;
                                    }

                                }
                                
                                for(String item : listaValores){
                                    System.out.println("Valores: " + item);
                                }
                                
                                

                            }
                            
                            linhaDefDeMacros = bufferLeituraArquivoDefinicoesDeMacros.readLine().toUpperCase();
                            tokensMacros = linhaDefDeMacros.split(delims);
                        }
                    
                        
                        bufferLeituraArquivoDefinicoesDeMacros.close();

                }else{
                    for(int i=0; i< tokens.length; i++){ //linha
                        bw2.write((tokens[i]) +" "); 
                    }//Fim for
                    bw2.newLine();
                }
              
                
            
                  

               str = bufferLeituraArquivoFonteComMacros.readLine().toUpperCase();
               tokens = str.split(delims);
            }   

                
                
         
            
        
        }//Fim do if de coleta da palavra INICIO
        
        }catch (Exception e) {
            e.printStackTrace();
        }
        try{
        bufferLeituraArquivoFonteComMacros.close();
        bufferLeituraArquivoDefinicoesDeMacros.close();
        bw2.close();
        bw.close();
        }catch(Exception e){}
    
    }//fim metodo
    
    
}
