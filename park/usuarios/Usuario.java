/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package park.usuarios;

/**
 *
 * @author corun
 */
public abstract class Usuario {
    private final TipoUsuario tipoUsuario;
    private final int altura;
    private final int idUsuario;
    private static int ultimoIdUsuario;
    

    protected Usuario(TipoUsuario tipoUsuario, int altura) {
        this.tipoUsuario = tipoUsuario;
        this.altura = altura;
        
        this.idUsuario = ultimoIdUsuario++;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public int getAltura() {
        return altura;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    
}
