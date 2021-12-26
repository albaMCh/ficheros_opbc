package Ej7;

import Ej2.funciones;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class main {

    private static String banner = "          _____                    _____                    _____                   _______                   _____          \n" +
            "         /\\    \\                  /\\    \\                  /\\    \\                 /::\\    \\                 /\\    \\         \n" +
            "        /::\\    \\                /::\\    \\                /::\\    \\               /::::\\    \\               /::\\    \\        \n" +
            "       /::::\\    \\              /::::\\    \\               \\:::\\    \\             /::::::\\    \\             /::::\\    \\       \n" +
            "      /::::::\\    \\            /::::::\\    \\               \\:::\\    \\           /::::::::\\    \\           /::::::\\    \\      \n" +
            "     /:::/\\:::\\    \\          /:::/\\:::\\    \\               \\:::\\    \\         /:::/~~\\:::\\    \\         /:::/\\:::\\    \\     \n" +
            "    /:::/__\\:::\\    \\        /:::/  \\:::\\    \\               \\:::\\    \\       /:::/    \\:::\\    \\       /:::/__\\:::\\    \\    \n" +
            "   /::::\\   \\:::\\    \\      /:::/    \\:::\\    \\              /::::\\    \\     /:::/    / \\:::\\    \\      \\:::\\   \\:::\\    \\   \n" +
            "  /::::::\\   \\:::\\    \\    /:::/    / \\:::\\    \\    ____    /::::::\\    \\   /:::/____/   \\:::\\____\\   ___\\:::\\   \\:::\\    \\  \n" +
            " /:::/\\:::\\   \\:::\\    \\  /:::/    /   \\:::\\ ___\\  /\\   \\  /:::/\\:::\\    \\ |:::|    |     |:::|    | /\\   \\:::\\   \\:::\\    \\ \n" +
            "/:::/  \\:::\\   \\::: \\____\\/:::/____/     \\:::|    |/::\\   \\/:::/  \\:::\\____\\|:::|____|     |:::|    |/::\\   \\:::\\   \\:::\\____\\\n" +
            "\\::/    \\:::\\  /:::/    /\\:::\\    \\     /:::|____|\\:::\\  /:::/    \\::/    / \\:::\\    \\   /:::/    / \\:::\\   \\:::\\   \\::/    /\n" +
            " \\/____/ \\:::\\/:::/    /  \\:::\\    \\   /:::/    /  \\:::\\/:::/    / \\/____/   \\:::\\    \\ /:::/    /   \\:::\\   \\:::\\   \\/____/ \n" +
            "          \\::::::/    /    \\:::\\    \\ /:::/    /    \\::::::/    /             \\:::\\    /:::/    /     \\:::\\   \\:::\\    \\     \n" +
            "           \\::::/    /      \\:::\\    /:::/    /      \\::::/____/               \\:::\\__/:::/    /       \\:::\\   \\:::\\____\\    \n" +
            "           /:::/    /        \\:::\\  /:::/    /        \\:::\\    \\                \\::::::::/    /         \\:::\\  /:::/    /    \n" +
            "          /:::/    /          \\:::\\/:::/    /          \\:::\\    \\                \\::::::/    /           \\:::\\/:::/    /     \n" +
            "         /:::/    /            \\::::::/    /            \\:::\\    \\                \\::::/    /             \\::::::/    /      \n" +
            "        /:::/    /              \\::::/    /              \\:::\\____\\                \\::/____/               \\::::/    /       \n" +
            "        \\::/    /                \\::/____/                \\::/    /                 ~~                      \\::/    /        \n" +
            "         \\/____/                  ~~                       \\/____/                                           \\/____/         \n" +
            "                                                                                                                             ";

    private static String banner2 = "               ___           ___           ___       ___     \n" +
            "              /\\__\\         /\\  \\         /\\__\\     /\\  \\    \n" +
            "             /:/  /        /::\\  \\       /:/  /    /::\\  \\   \n" +
            "            /:/__/        /:/\\:\\  \\     /:/  /    /:/\\:\\  \\  \n" +
            "           /::\\  \\ ___   /:/  \\:\\  \\   /:/  /    /::\\~\\:\\  \\ \n" +
            "          /:/\\:\\  /\\__\\ /:/__/ \\:\\__\\ /:/__/    /:/\\:\\ \\:\\__\\\n" +
            "          \\/__\\:\\/:/  / \\:\\  \\ /:/  / \\:\\  \\    \\/__\\:\\/:/  /\n" +
            "               \\::/  /   \\:\\  /:/  /   \\:\\  \\        \\::/  / \n" +
            "               /:/  /     \\:\\/:/  /     \\:\\  \\       /:/  /  \n" +
            "              /:/  /       \\::/  /       \\:\\__\\     /:/  /   \n" +
            "              \\/__/         \\/__/         \\/__/     \\/__/    ";

    public static void menu(){

        System.out.println("<<<<<<<<<<===============================================>>>>>>>>>");
        System.out.println("1 - Registrar candidato");
        System.out.println("2 - Borrar Candidato");
        System.out.println("3 - Buscar candidatos por ciudad");
        System.out.println("4 - Buscar candidatos por presencialidad");
        System.out.println("5 - Buscar candidatos por traslado");
        System.out.println("6 - Buscar candidatos por ciudad, traslado y preencialidad");
        System.out.println("7 - Buscar candidato por email");
        System.out.println("8 - Buscar candidato por teléfono");
        System.out.println("9 - Mostrar candidatos");
        System.out.println("10 - salir");
        System.out.println("<<<<<<<<<<===============================================>>>>>>>>>");
    }

    public static void mostrarCandidatos(List<Candidato> llistaCandidatos){

        for(Candidato candidato : llistaCandidatos){

            System.out.println(candidato.toString());
        }
    }

    public static void main(String[] args) {

        CandidatosListImple funciones = new CandidatosListImple();
        funciones.cargarFicheroCSV("/Users/albamolerachacon/Desktop/OpenBootCamp/ficheros_opbc/fichero_candidatos.csv");

        Scanner input = new Scanner(System.in);
        int op1 = 0, op2 = 0, op4 = 0;

        while(op1 != 10){

            menu();
            op1 = input.nextInt();

            switch (op1){

                //Registrar candidato
                case 1:

                    while (op2 != 2){

                        String  nombre ="", ciudad = "", presencialidad = "", email = "", telefono = "", pais = "";
                        boolean tipoTraslado = false;

                        System.out.flush();
                        System.out.println("Nuevo registro");
                        System.out.println("Introduce noombre: ");
                        nombre = input.next();
                        input.nextLine();
                        System.out.println("Introduce email:");
                        email = input.next();
                        input.nextLine();
                        System.out.println("Introduce teléfono:");
                        telefono = input.next();
                        input.nextLine();
                        System.out.println("Introduce país:");
                        pais = input.next();
                        input.nextLine();
                        System.out.println("Introduce ciudad:");
                        ciudad = input.next();
                        input.nextLine();
                        System.out.println("Introduce presencialidad:");
                        presencialidad = input.next();
                        input.nextLine();
                        System.out.println("Posiblidad de traslado S/N:");
                        String op3 = input.next();
                        input.nextLine();
                        op3 = op3.toLowerCase();

                        if(op3.contains("s")){

                            tipoTraslado = true;
                        }

                        if (funciones.validarCorreo(email)){

                            funciones.guardarCandidato(new Candidato(nombre.toUpperCase(),ciudad.toUpperCase(),presencialidad.toLowerCase(),
                                    tipoTraslado,email,telefono,pais));

                            System.out.println("Usuario guardado: " + email);
                        }

                        System.out.println("¿Desea introducir más alumnos? 1 = SI | 2 = NO");
                        op2 = input.nextInt();
                    }

                    break;

                //Borrar Candidato
                case 2:

                    while (op4 != 2){

                        String correo = "";

                        System.out.flush();
                        System.out.println("Borrar candidato");
                        System.out.println("Introduce correo: ");
                        correo = input.next();
                        input.nextLine();

                        if(funciones.validarCorreo(correo)){

                            System.err.println("No existe candidato con correo:  " +correo);
                            System.out.flush();
                        }

                        else{

                            funciones.borrarCandidatoPorEmail(correo);
                            op4 = 2;
                        }
                    }

                    break;

                //Filtrar por ciudad
                case 3:

                    String ciudad = "";

                    System.out.flush();
                    System.out.println("Filtrar candidato por ciudad");
                    System.out.println("Introduce ciudad: ");
                    ciudad = input.next();
                    input.nextLine();

                    mostrarCandidatos(funciones.filtrarPorCiudad(ciudad.toUpperCase()));
                    System.out.println();
                    break;

                //Filtrar por presencialidad∂
                case 4:

                    String presencialidad = "";

                    System.out.flush();
                    System.out.println("Filtrar candidato por presencialidad");
                    System.out.println("Introduce presencialidad: ");
                    presencialidad = input.next();

                    presencialidad = presencialidad.toLowerCase();

                    input.nextLine();
                    mostrarCandidatos(funciones.filtrarPorPresencialidad(presencialidad));
                    System.out.println();

                    break;

                //Filtrar por traslado
                case 5:

                    boolean tipoTraslado = false;
                    String traslado = "";

                    System.out.flush();
                    System.out.println("Filtrar camdidato por traslado");
                    System.out.println("Posibilidad de traslado S/n ");
                    traslado = input.next();
                    input.nextLine();

                    traslado = traslado.toLowerCase();

                    if(traslado.contains("s")){

                        tipoTraslado = true;
                    }

                    mostrarCandidatos(funciones.filtrarPorTipoTraslado(tipoTraslado));
                    System.out.println();

                    break;

                //Filtrar por ciudad, presencialidad y traslado
                case 6:

                    tipoTraslado = false;

                    System.out.flush();
                    System.out.println("Buscar candidato por ciudad, presencialidad y traslado");
                    System.out.println("Introduce ciudad: ");
                    ciudad = input.next();
                    input.nextLine();
                    System.out.println("Introduce presencialidad: ");
                    presencialidad = input.next();
                    input.nextLine();
                    System.out.println("Posibilidad de traslado S/n");
                    traslado = input.next();
                    input.nextLine();

                    traslado = traslado.toLowerCase();

                    if(traslado.contains("s")){

                        tipoTraslado = true;
                    }

                    mostrarCandidatos(funciones.filtrar(ciudad, presencialidad, tipoTraslado));
                    System.out.println();
                    break;

                //Buscar por correo
                case 7:

                    String correo = "";

                    System.out.flush();
                    System.out.println("Filtrar candidato por email");
                    System.out.println("Introduce email: ");
                    correo = input.next();
                    input.nextLine();

                    if(!funciones.validarCorreo(correo)) {

                        System.out.println(funciones.buscarEmail(correo).toString());
                    }
                    else{

                        System.err.println("No existe candidato con correo:  " + correo);
                    }

                    System.out.println();

                    break;

                //Buscar por teléefono
                case 8:

                    String telefono = "";

                    System.out.flush();
                    System.out.println("Filtrar candidato por telefono");
                    System.out.println("Introduce telefono: ");
                    telefono = input.next();
                    input.nextLine();

                    System.out.println(funciones.buscarTelefono(telefono).toString());

                    System.out.println();

                    break;

                //Mostrar candidatos
                case 9:

                    System.out.flush();
                    funciones.mostrarCandidatos();
                    System.out.println();

                    break;
                //Salir
                case 10:

                    banner = banner.replace(':','X');
                    System.out.println(banner);

                    break;
                default:

                    System.out.flush();
                    break;
            }
        }

        input.close();
    }
}
