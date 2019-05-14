/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque.usuarios;

/**
 *
 * @author corun
 */
public class UsuarioAdulto extends Usuario {

    public UsuarioAdulto(int altura) {
        super(TipoUsuario.ADULTO, altura);
    }

    public UsuarioAdulto(TipoUsuario tipoUsuario, int altura) {
        super(tipoUsuario, altura);
    }
}
