/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parque.usuarios;

import java.util.ArrayList;

/**
 *
 * @author corun
 */
public class ListaUsuarios extends ArrayList<Usuario> {

    private ListaUsuarios() {

    }

    private static ListaUsuarios listaUsuarios;

    public static ListaUsuarios getListaUsuarios() {
        if (listaUsuarios == null) {
            listaUsuarios = new ListaUsuarios();
        }

        return listaUsuarios;
    }

    public Usuario addUsuario(TipoUsuario tipoUsuario, int altura) {
        Usuario usuario;
        switch (tipoUsuario) {

            case INFANTIL:
                usuario = new UsuarioMenor(altura);
                break;
            case ADULTO:
                usuario = new UsuarioAdulto(altura);
                break;
            case SENIOR:
                usuario = new UsuarioSenior(altura);
                break;
            default:
                throw new RuntimeException("No se ha podido crear el usuario.");
        }
        this.add(usuario);
        return usuario;
    }

    public Usuario getUsuario(int idUsuario) {
        return listaUsuarios.stream().filter(u -> u.getIdUsuario() == idUsuario).findFirst().get();
    }
}
