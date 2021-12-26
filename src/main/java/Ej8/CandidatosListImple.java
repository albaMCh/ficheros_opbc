package Ej8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CandidatosListImple implements CandidatosList {

    private List<Candidato> listaCandidatos;
    private Integer num_linea;

    public CandidatosListImple() {

        listaCandidatos = new ArrayList<>();
        num_linea = 0;
    }

    public void cargarFicheroCSV(String filePath){

        try {

            String currentLine = "";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            while((currentLine = reader.readLine()) != null){

                procesarLinea(currentLine);
                num_linea++;
            }

            mostrarCandidatos();

            System.out.println("Número de líneas procesadas: " + num_linea);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //funciones

    private void procesarLinea (String linea){

        linea = linea + ";";
        int cont_variable = 0;
        String str_temp = "", nombre = "", ciudad = "", presencialidad = "", tipoTraslado = "", email = "", telefono = "", pais = "";
        char chr = 0;

        for(int i = 0; i < linea.length(); i ++){

            chr = linea.charAt(i);

            if(chr == 59){

                if(cont_variable == 0){

                    nombre = str_temp;
                    cont_variable ++;
                    str_temp = "";
                }

                else if(cont_variable == 1){

                    ciudad = str_temp;
                    cont_variable ++;
                    str_temp = "";
                }

                else if(cont_variable == 2){

                    presencialidad = str_temp;
                    cont_variable ++;
                    str_temp = "";
                }

                else if(cont_variable == 3){

                    tipoTraslado = str_temp;
                    cont_variable ++;
                    str_temp = "";
                }

                else if(cont_variable == 4){

                    email = str_temp;
                    cont_variable ++;
                    str_temp = "";
                }

                else if(cont_variable == 5){

                    telefono = str_temp;
                    cont_variable ++;
                    str_temp = "";
                }

                else if(cont_variable == 6){

                    pais = str_temp;
                }
            }

            else{

                str_temp = str_temp + chr;
            }
        }

        email = email.toLowerCase();
        presencialidad = presencialidad.toLowerCase();

        if(validarVariable(nombre, "nombre") && validarVariable(ciudad, "ciudad") &&
                validarVariable(tipoTraslado, "Tipo traslado") && validarVariable (telefono, "telefono") &&
           validarVariable(presencialidad, "presencialidad") && validarCorreo(email) && validarVariable(pais, "pais")){

            listaCandidatos.add(new Candidato(nombre, ciudad, presencialidad, parseTipoTraslado(tipoTraslado), email, telefono, pais));
        }
    }

    private boolean parseTipoTraslado(String tipo){

        if(tipo.equals("1")){

            return true;
        }

        return false;
    }

    private boolean validarVariable(String var, String nombre_var){

        if(var.isEmpty()){

            System.err.println("Error en la línea: " + num_linea + ", " + nombre_var + " vacio");
            return false;
        }

        return true;
    }

    public boolean validarCorreo (String correo) {

        for( Candidato candidato : listaCandidatos) {

            if (candidato.getEmail().equals(correo)) {

                //si el correo esta repetido lanzamos el error
                //System.err.println("Error en linea " + num_linea + ", correo repetido:  " + correo);

                return false;
            }
        }

        return true;
    }

    public void mostrarCandidatos(){

        for(Candidato candidato : listaCandidatos){

            System.out.println(candidato.toString());
        }
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {

        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list = new LinkedList<>(hm.entrySet());

        // Sort the list using lambda expression
        Collections.sort(list, Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)));

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> aa : list) {

            temp.put(aa.getKey(), aa.getValue());
        }

        return temp;
    }

    public List<Candidato> filtrarPorPais (String pais){

        List<Candidato> listaCandidatosPorPais = new ArrayList<>();

        for(Candidato candidato : listaCandidatos){

            if(candidato.getPais().equals(pais.toUpperCase())){

                listaCandidatosPorPais.add(candidato);
            }
        }

        return listaCandidatosPorPais;
    }

    @Override
    public boolean guardarCandidato(Candidato candidato) {

        if (!candidato.getEmail().isEmpty() && validarCorreo(candidato.getEmail())) {

            listaCandidatos.add(candidato);
            return true;
        }

        return false;
    }

    @Override
    public Boolean borrarCandidatoPorEmail(String email) {

        for(Candidato candidato : listaCandidatos){

            if(candidato.getEmail().equals(email)){

                listaCandidatos.remove(candidato);
                return true;
            }
        }

        return false;
    }

    @Override
    public Boolean borrarCandidatoPorNombre(String nombre) {

        for(Candidato candidato : listaCandidatos){

            if(candidato.getNombre().equals(nombre)){

                listaCandidatos.remove(candidato);
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Candidato> filtrarPorCiudad(String ciudad) {

        List<Candidato> listaCandidatosPorCiudad = new ArrayList<>();

        for(Candidato candidato : listaCandidatos){

            if(candidato.getCiudad().equals(ciudad.toUpperCase())){

                listaCandidatosPorCiudad.add(candidato);
            }
        }

        return listaCandidatosPorCiudad;
    }

    @Override
    public List<Candidato> filtrarPorPresencialidad(String presencialidad) {

        List<Candidato> listaCandidatosPorPresencialidad = new ArrayList<>();

        for(Candidato candidato : listaCandidatos){

            if(candidato.getPresencialidad().equals(presencialidad.toLowerCase())){

                listaCandidatosPorPresencialidad.add(candidato);
            }
        }

        return listaCandidatosPorPresencialidad;
    }

    @Override
    public List<Candidato> filtrarPorTipoTraslado(boolean tipoTraslado) {

        List<Candidato> listaCandidatosPorTipoTraslado = new ArrayList<>();

        for(Candidato candidato : listaCandidatos){

            if(candidato.isTipoTraslado() == tipoTraslado){

                listaCandidatosPorTipoTraslado.add(candidato);
            }
        }

        return listaCandidatosPorTipoTraslado;
    }

    @Override
    public List<Candidato> filtrar(String ciudad, String presencialidad, boolean tipoTraslado) {

        List<Candidato> listaCandidatosPorCPT = new ArrayList<>();

        for(Candidato candidato : listaCandidatos){

            if((candidato.getCiudad().equals(ciudad.toUpperCase())) && (candidato.getPresencialidad().equals(presencialidad.toLowerCase()))
                    && (candidato.isTipoTraslado() == tipoTraslado)){

                listaCandidatosPorCPT.add(candidato);
            }
        }

        return listaCandidatosPorCPT;
    }

    @Override
    public Candidato buscarEmail(String email) {

        for(Candidato candidato : listaCandidatos){

            if(candidato.getEmail().equals(email.toLowerCase())){

                return candidato;
            }
        }

        return null;
    }

    @Override
    public Candidato buscarTelefono(String telefono) {

        for(Candidato candidato : listaCandidatos){

            if(candidato.getTelefono().equals(telefono)){

                return candidato;
            }
        }

        return null;
    }

    @Override
    public void imprimeCiudadesTOP() {

        List<String> listaCiudades = new ArrayList<>();

        for (Candidato candidato : listaCandidatos) {

            listaCiudades.add(candidato.getCiudad());
        }

        listaCiudades = new ArrayList<>(new HashSet<>(listaCiudades));

        HashMap<String, Integer> ciudadeesTop = new HashMap<>();

        for (int i = 0; i < listaCiudades.size(); i++) {

            ciudadeesTop.put(listaCiudades.get(i), filtrarPorCiudad(listaCiudades.get(i)).size());
        }

        ciudadeesTop = sortByValue(ciudadeesTop);

        for(Map.Entry<String, Integer> map : ciudadeesTop.entrySet()){

            System.out.println(map.getKey() + " --> " + map.getValue());
        }

    }

    @Override
    public void imprimePaisesTOP() {

        List<String> listaPaises = new ArrayList<>();

        for(Candidato candidato : listaCandidatos){

            listaPaises.add(candidato.getPais());
        }

        listaPaises = new ArrayList<>(new HashSet<>(listaPaises));

        HashMap<String, Integer> paisesTop = new HashMap<>();

        for (String pais : listaPaises){

            paisesTop.put(pais, filtrarPorPais(pais).size());
        }

        paisesTop = sortByValue(paisesTop);

        for(Map.Entry<String,Integer> map : paisesTop.entrySet()){

            System.out.println(map.getKey() + " --> " + map.getValue());
        }
    }

    @Override
    public int totalRemotos() {

        int cont = 0;

        for(Candidato candidato : listaCandidatos){

            if(!candidato.isTipoTraslado()){

                cont ++;
            }
        }

        return cont;
    }

    @Override
    public int totalPresencial() {

        int cont = 0;

        for (Candidato candidato : listaCandidatos){

            if(candidato.getPresencialidad().equals("si")){

                cont ++;
            }
        }

        return cont;
    }

    @Override
    public int totalNoPresencial() {

        int cont = 0;

        for (Candidato candidato : listaCandidatos){

            if(candidato.getPresencialidad().equals("no")){

                cont ++;
            }
        }

        return cont;
    }
}
