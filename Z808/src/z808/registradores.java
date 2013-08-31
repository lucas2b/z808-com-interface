/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package z808;

/**
 *
 * @author lucas
 */
public class registradores {
    
    //registradores de uso geral
    public static short ax; 
    private short dx;
    private short si; //indice usado para endereçamento indireto
    private short ip; //struction pointer - contem o apontamento da próxima instrução
    
    
    //Flags de controle
    private boolean zf; //se a operação resulta em zero
    private boolean sf; //flag de sinal para operações entre registradores (instruções lógicas ou aritméticas)
    
    
    //GETTERS E SETTERS

    /**
     * @return the ax
     */
    public short getAx() {
        return ax;
    }

    /**
     * @param ax the ax to set
     */
    public void setAx(short ax) {
        this.ax = ax;
    }

    /**
     * @return the dx
     */
    public short getDx() {
        return dx;
    }

    /**
     * @param dx the dx to set
     */
    public void setDx(short dx) {
        this.dx = dx;
    }

    /**
     * @return the si
     */
    public short getSi() {
        return si;
    }

    /**
     * @param si the si to set
     */
    public void setSi(short si) {
        this.si = si;
    }

    /**
     * @return the ip
     */
    public short getIp() {
        return ip;
    }
    
    public boolean getSf() {
        return sf;
    }
    
    public boolean getZf() {
        return zf;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(short ip) {
        this.ip = ip;
    }

    /**
     * @return the zf
     */
    public boolean isZf() {
        return zf;
    }

    /**
     * @param zf the zf to set
     */
    public void setZf(boolean zf) {
        this.zf = zf;
    }

    /**
     * @return the sf
     */
    public boolean isSf() {
        return sf;
    }

    /**
     * @param sf the sf to set
     */
    public void setSf(boolean sf) {
        this.sf = sf;
    }
   
}
