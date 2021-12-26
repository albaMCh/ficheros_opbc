package Ej8;

import java.util.List;
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
        System.out.println("1 - Mostrar ciudades top");
        System.out.println("2 - Mostrar paises top");
        System.out.println("3 - Mostrar candidatos remotos");
        System.out.println("4 - Mostrar candidatos con posibilidad de traslado");
        System.out.println("5 - Mostrar candidatos sin posibilidad de traslado");
        System.out.println("6 - Mostrar candidatos");
        System.out.println("7 - salir");
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

        while(op1 != 7){

            menu();
            op1 = input.nextInt();

            switch (op1){

                case 1:

                    System.out.flush();
                    funciones.imprimeCiudadesTOP();
                    System.out.println();

                    break;

                case 2:

                    System.out.flush();
                    funciones.imprimePaisesTOP();
                    System.out.println();
                    break;

                case 3:

                    System.out.flush();
                    System.out.println("Número de candidatos en remoto: " + funciones.totalRemotos());
                    System.out.println();

                    break;

                case 4:

                    System.out.flush();
                    System.out.println("Número de candidatos dispuestos a trasladarse: " + funciones.totalPresencial());
                    System.out.println();

                    break;

                case 5:

                    System.out.flush();
                    System.out.println("Número de candidatos dispuestos a no trasladarse: " + funciones.totalNoPresencial());
                    System.out.println();

                    break;

                case 6:

                    System.out.flush();
                    funciones.mostrarCandidatos();
                    System.out.println();

                    break;
                //Salir
                case 7:

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
