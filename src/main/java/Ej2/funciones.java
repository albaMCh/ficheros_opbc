package Ej2;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

public class funciones {

    private List<usuario> listaUsuarios;

    public funciones() {

        listaUsuarios = new ArrayList<>();
    }

    public boolean register(String email, String password){

        /*Si el correo no esta repetido, guardamos el usuario*/
        if(validarCorreo(email)){

            listaUsuarios.add(newUserWithHashPass(email, password));
            return true;
        }

        System.err.println("Correo repetido: " + email);
        return false;
    }

    private boolean validarPass (String newPass, String oldPass){

        try {

            return passwordSecure.validatePassword(newPass, oldPass);
        }

        catch (NoSuchAlgorithmException | InvalidKeySpecException e) {

            e.printStackTrace();
            return false;
        }
    }

    private usuario newUserWithHashPass (String email, String password){

        try {

            return new usuario(email, passwordSecure.generatePasswordHash(password));
        }

        catch (NoSuchAlgorithmException | InvalidKeySpecException exception){

            exception.printStackTrace();
            return null;
        }
    }

    public int login (String email, String password){

        if(validarCorreo(email)){

            // email no existe
            return -1;
        }

        else if (!validarCorreo(email)){

            usuario usuario = getUsuarioByEmail(email);

            if(validarPass(password, usuario.getPassword())){

                // login correcto
                return 1;
            }

            else{

                // usuario con contraseña incorrecta
                return -2;
            }
        }

        // caso no controlado
        return 0;
    }

    private usuario getUsuarioByEmail(String email){

        for(usuario usuario : listaUsuarios){

            if(usuario.getEmail().equals(email)){

                return usuario;
            }
        }

        return null;
    }

    private boolean validarCorreo (String correo) {

        for(usuario usuario : listaUsuarios){

            if(usuario.getEmail().equals(correo)){

                return false;
            }
        }

        return true;
    }

    public void mostrarUsuarios (){

        for(usuario usuario : listaUsuarios){

            System.out.println(usuario.toString());
        }
    }
}
