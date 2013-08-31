/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package z808;

import java.io.BufferedReader;
import java.io.FileReader;

public class maquinaVirtual {
    registradores registradores = new registradores();
    
    /*
     * --------- CÓDIGOS DAS FUNÇÕES -----------
     * 
     * ARITMÉTICAS:
     * ADD - 00
     * SUB - 01
     * MUL - 02
     * DIV - 03
     * 
     * LÓGICAS:
     * OR - 04
     * AND - 05
     * XOR - 06
     * NOT - 07
     * 
     * DESVIO:
     * JMP = JUMP INCONDICIONAL - 08
     * JE  = JUMP EQUAL (ZF = TRUE) - 09
     * JNZ = JUMP NOT ZERO (ZF = FALSE)- 10
     * JZ  = JUMP ON ZERO (ZF = TRUE) - 11
     * JP  = SE SF TRUE (SF = FALSE) - 12
     * 
     * MOVIMENTAÇÃO:
     * MOV (PARAMETROS) - 13
     * 
     * FIM DE EXECUÇÃO - 99
     * 
     */
    
    //Dados de uso
    private short memoria[] = new short[256];
    private boolean flag = false;
    int contadorMemoria = 0;
    
    
    public void rotinaDeExecucao(){

    maquinaVirtual instanciaTeste = new maquinaVirtual();
    instanciaTeste.montarCodigoObjeto("arq_objeto.txt");
    instanciaTeste.imprimeCodigoObjeto();
    //instanciaTeste.executaCodigoObjeto();
    }
    

    private short[] montarCodigoObjeto(String nomeDoArquivo){
           //MONTAGEM DO CODIGO OBJETO EM UM VETOR UNIDIMENSIONAL
        
        
    try {
        
            BufferedReader in = new BufferedReader(new FileReader(nomeDoArquivo)); //Lê na raiz do projeto
            String str;
            
            while (in.ready()) {
            str = in.readLine();

            String delims = " ";
            String[] tokens = str.split(delims);
            
            
            for(int i=0; i< tokens.length; i++){
               
                switch(Integer.parseInt(tokens[i])){
                   case 0:
                       if (!flag){
                            memoria[contadorMemoria] = 0;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                       }else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                            i++;
                       }
                      // System.out.println("ADD");
                       break;
                   
                   case 1:
                       if (!flag){
                            memoria[contadorMemoria] = 1;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                          //  System.out.println("SUB");
                       }else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                            i++;
                       }
                       break;
                    case 2:
                       if (!flag){ 
                            memoria[contadorMemoria] = 2;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;                       
                          //  System.out.println("MUL");
                       }else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                            i++;
                       }
                       break;
                    case 3:
                        if (!flag){
                            memoria[contadorMemoria] = 3;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                          //  System.out.println("DIV");
                        }else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                            i++;
                       }
                       break;
                    case 4:
                        if (!flag){
                            memoria[contadorMemoria] = 4;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                          //  System.out.println("OR");
                        }
                        else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                            i++;
                       }
                       break;
                    case 5:
                        if (!flag){
                            memoria[contadorMemoria] = 5;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;                  
                         //   System.out.println("AND");
                        }
                        else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                            i++;
                       }
                       break;
                    case 6:
                        if (!flag){
                            memoria[contadorMemoria] = 6;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;        
                        //    System.out.println("XOR");
                        }
                        else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                            i++;
                       }
                       break;
                    case 7:
                        if (!flag){
                            memoria[contadorMemoria] = 7;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                        //    System.out.println("NOT");
                        }
                        else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                            i++;
                       }
                       break;
                    case 8:
                        if (!flag){
                            memoria[contadorMemoria] = 8;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                       //     System.out.println("JMP");
                             }else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                            i++;
                       }
                       break;
                    case 9:
                        if (!flag){
                            memoria[contadorMemoria] = 9;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                       //     System.out.println("JE");
                        }else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                            i++;
                       }
                       break;
                    case 10:
                        if (!flag){
                            memoria[contadorMemoria] = 10;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                            //System.out.println("JNZ");
                        }else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                            i++;
                       }
                       break;
                    case 11:
                        if (!flag){
                            memoria[contadorMemoria] = 11;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                       //     System.out.println("JZ");
                        }else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                            i++;
                       }
                       break;
                    case 12:
                        if (!flag){
                            memoria[contadorMemoria] = 12;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                        //    System.out.println("JP");
                             }else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                            i++;
                       }
                       break;
                    case 13:
                        if (!flag){
                            memoria[contadorMemoria] = 13;
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                            i++;

                            memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                            contadorMemoria++;
                        //    System.out.println("MOV");
                        }else{
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                            i++;
                       }
                       break;
                    case 99:
                            flag = true;
                            memoria[contadorMemoria] = 99;
                            contadorMemoria++;
                            i++;


                          //  System.out.println("FIM DE EXECUÇÃO")
                       break;
                    default:
                           memoria[contadorMemoria] = Short.parseShort(tokens[i]);
                           contadorMemoria++;
                           i++;
                           break;
               }//Fim switch
                
            }//Fim for

        }//Fim while leitura do arquivo   
        in.close();        
        }catch (Exception e) {
        e.printStackTrace();
        }
    
        return memoria;   
    }
    
    private void imprimeCodigoObjeto(){
        for(short item : memoria){
            System.out.println(item);
        }
        
    }
    
    private void executaCodigoObjeto(){
        int i=0;
        
                    registradores.setAx((short)8);
                    registradores.setDx((short)5);
                    registradores.setSi((short)5);
        
        //Enquanto a instrução lida for direferente de 99 (STOP)
        while(memoria[i] != 99){
            System.out.println("Valor de AX: "+ registradores.getAx());
            System.out.println("Valor de DX: "+ registradores.getDx());
            System.out.println("Valor de SI: "+ registradores.getSi());
            
            short valorAX = registradores.getAx();
            short valorDX = registradores.getDx();
            
        
            
            switch(memoria[i]){
                case 0://ADD

                    switch(memoria[i+2]){
                        case -1: //AX AX
                            //System.out.println("testeeeeeeeeee");
                            registradores.setAx( (short)(registradores.getAx() + registradores.getAx()) );
                            System.out.println("Resultado da soma usando AX: "+ registradores.getAx() );
                            setaFlagZero(registradores.getAx());
                            setaFlagNegativo(registradores.getAx());
                            i+=3;
                            break;
                        case -2: //AX DX
                            registradores.setAx( (short)(registradores.getDx() + registradores.getAx()) );
                            System.out.println("Resultado da soma usando DX: "+ registradores.getAx() );
                            setaFlagZero(registradores.getAx());
                            setaFlagNegativo(registradores.getAx());
                            i+=3;
                            break;
                        default: //AX Constante
                             registradores.setAx( (short)(registradores.getAx() + memoria[memoria[i+2]]));
                            System.out.println("Resultado da soma usando posição de memória: "+ registradores.getAx() );
                            setaFlagZero(registradores.getAx());
                            i+=3;
                            break;
                    }
                    
                  break;  
                case 1://SUB
                    
                    switch(memoria[i+2]){
                        case -1: //AX AX
                            //System.out.println("testeeeeeeeeee");
                            registradores.setAx( (short)(registradores.getAx() - registradores.getAx()) );
                            System.out.println("Resultado da subtração usando AX: "+ registradores.getAx() );
                            setaFlagZero(registradores.getAx());
                            setaFlagNegativo(registradores.getAx());
                            i+=3;
                            break;
                        case -2: //AX DX
                            registradores.setAx( (short)( registradores.getDx() - registradores.getAx()) );
                            System.out.println("Resultado da subtração usando DX: "+ registradores.getAx() );
                            setaFlagZero(registradores.getAx());
                            setaFlagNegativo(registradores.getAx());
                            i+=3;
                            break;
                        default: //AX Constante
                            registradores.setAx( (short)( memoria[memoria[i+2]] - registradores.getAx()));
                            System.out.println("Resultado da subtração usando posição de memória: "+ registradores.getAx() );
                            setaFlagZero(registradores.getAx());
                            i+=3;
                            break;
                    }
                    
                  break;
                case 2://MUL
                    switch(memoria[i+1]){
                        case -3:
                            registradores.setAx((short)(registradores.getAx() * registradores.getSi()));
                            setaFlagZero(registradores.getAx());
                            setaFlagNegativo(registradores.getAx());
                            i+=2;
                            break;
                        case -1:
                            registradores.setAx((short)(registradores.getAx() * registradores.getAx()));
                            setaFlagZero(registradores.getAx());
                            i+=2;
                            break;
                    }
                    break;
                case 3://DIV
                    switch(memoria[i+1]){
                        case -3:
                            if(registradores.getSi() != 0){
                                short resto = (short)(registradores.getAx() % registradores.getSi());
                                registradores.setAx((short)(registradores.getAx() / registradores.getSi()));
                                registradores.setDx(resto);
                                setaFlagZero(registradores.getAx());
                                setaFlagNegativo(registradores.getAx());
                                i+=2;
                            }
                            else
                                System.exit(1);
                            
                            
                            break;
                        case -1:
                            if(registradores.getAx() != 0){
                                registradores.setAx((short)1);
                                i+=2;
                            }
                            else
                                System.exit(1);
                            
                          
                            break;
                    }
                    
                    break;
                case 4://OR
                    switch(memoria[i+2]){
                        case -1: //AX AX
                            //System.out.println("testeeeeeeeeee");
                            
                            int or = valorAX|valorAX;
                            registradores.setAx( (short)or );
                            setaFlagNegativo((short)or);
                            setaFlagZero((short)or);
                            i+=3;
                            break;
                        case -2: //AX DX
                            registradores.setAx( (short)( registradores.getAx() | registradores.getDx()) );
                            setaFlagZero(registradores.getAx());
                            setaFlagNegativo(registradores.getAx());
                            i+=3;
                            break;
                        default: //AX Constante
                            registradores.setAx( (short)(registradores.getAx() | memoria[memoria[i+2]]));
                            setaFlagNegativo(registradores.getAx());
                            setaFlagZero(registradores.getAx());
                            i+=3;
                            break;
                    }
                    break;
                case 5://AND
                    switch(memoria[i+2]){
                        case -1: //AX AX
                            //System.out.println("testeeeeeeeeee");
                            short and = (short)(valorAX & valorAX);
                            registradores.setAx( (short)and );
                            setaFlagNegativo(registradores.getAx());
                            setaFlagZero(registradores.getAx());
                            i+=3;
                            break;
                        case -2: //AX DX
                            registradores.setAx( (short)(valorAX&valorDX) );
                            setaFlagZero(registradores.getAx());
                            setaFlagNegativo(registradores.getAx());
                            i+=3;
                            break;
                        default: //AX Endereço
                            registradores.setAx( (short)(registradores.getAx() & memoria[memoria[i+2]]));
                            setaFlagNegativo(registradores.getAx());
                            setaFlagZero(registradores.getAx());
                            i+=3;
                            break;
                    }
                    break;
                case 6://XOR
                    switch(memoria[i+2]){
                        case -1: //AX AX
                            //System.out.println("testeeeeeeeeee");
                            registradores.setAx( (short)(registradores.getAx() ^ registradores.getAx()) );
                            setaFlagNegativo(registradores.getAx());
                            setaFlagZero(registradores.getAx());
                            i+=3;
                            break;
                        case -2: //AX DX
                            registradores.setAx( (short)(registradores.getDx() ^ registradores.getAx()) );
                            setaFlagZero(registradores.getAx());
                            setaFlagNegativo(registradores.getAx());
                            i+=3;
                            break;
                        default: //AX Endereço
                            registradores.setAx( (short)(registradores.getAx() ^ memoria[memoria[i+2]]));
                            setaFlagNegativo(registradores.getAx());
                            setaFlagZero(registradores.getAx());
                            i+=3;
                            break;
                    }
                    break;
                case 7://NOT
                            registradores.setAx( (short)(~registradores.getAx()) );
                            setaFlagNegativo(registradores.getAx());
                            setaFlagZero(registradores.getAx());
                            i+=2;
                            break;
                case 8://JMP
                            i = memoria[i+1];
                            break;
                            
                case 9://JE
                            if( memoria[i+1] == registradores.getAx()){
                                i= registradores.getAx();
                            }
                            else{
                                i+=2;    
                            }
                            break;
                case 10://JNZ
                            if(registradores.getZf() == true){
                                i = memoria[i+1];
                            }
                            else{
                                i+=2;
                            }
                            
                    break;
                case 11://JZ
                            if(registradores.getZf() == false)
                                i = memoria[i+1];
                            else{
                                i+=2;
                            }
                            break;
                case 12://JP
                            
                            if(registradores.getSf() == false){
                                i = memoria[i+1];
                            }
                            else{
                                i+=2;
                            }
                            break;
                case 13://MOV
                        trataInstrucaoMov(memoria[i+1], memoria[i+2]);
                        i+=3;
                        break;
                
                default: //Se cair aqui = INSTRUÇÃO MAL FORMADA
                        System.out.println("Instrução MAL FORMADA: " + memoria[i]);
                        break;
                
            }//Fim switch
            
            System.out.println("Instruction ponter: " + i); //Printando instruction pointer
            System.out.println("Valor de AX: "+ registradores.getAx());
            System.out.println("Valor de DX: "+ registradores.getDx());
            System.out.println("Valor de SI: "+ registradores.getSi());
            
        }//Fim while (leitura do vetor)
        
        
    }//Fim método executaCodigoObjeto
    
    private void setaFlagZero(short num){
        if(num == 0)
            registradores.setZf(true);
    }
    
    private void setaFlagNegativo(short num){
        if(num < 0)
            registradores.setSf(true);
    }
    
    private void trataInstrucaoMov(short op1, short op2){
        
        switch(op1){
            case -1: //OP1 AX
                switch(op2){
                    case -2: //OP2 = DX
                        registradores.setAx(registradores.getDx());
                        break;
                    case -3: //OP2 = SI
                        registradores.setAx(registradores.getSi());
                        break;
                    default: //Caso constante ou endereço
                        registradores.setAx(op2);
                        break;
                }
                break;
            case -2: //OP1 DX
                    registradores.setDx(registradores.getAx());
                    break;
                
            case -3: //OP1 SI
                    registradores.setSi(registradores.getAx());
                    break;
            default: //Op1 é um endereço de memória
                    memoria[op1] = registradores.getAx();
                    break;
                
        }
        
    }
   
    
}//fim classe