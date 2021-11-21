package gal.usc.etse.soap;

import gal.usc.etse.soap.analizadorTextos.AnalizadorTextos;
import gal.usc.etse.soap.calculadora.Calculadora;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Client {

    private static String modo = "";
    private static String opcion = "";
    private static Calculadora clientCalculadora;
    private static AnalizadorTextos clientAnalizadorTextos;
    private static Scanner scanner;

    public static void main(String[] args) throws MalformedURLException {
        URL wsdlURL = new URL("http://localhost:8080/calculadora?wsdl");
        QName SERVICE_NAME = new QName("http://calculadora.soap.etse.usc.gal/", "Calculadora");
        Service service = Service.create(wsdlURL, SERVICE_NAME);
        clientCalculadora = service.getPort(Calculadora.class);

        wsdlURL = new URL("http://localhost:8080/analizadorTextos?wsdl");
        SERVICE_NAME = new QName("http://analizadorTextos.soap.etse.usc.gal/", "AnalizadorTextos");
        service = Service.create(wsdlURL, SERVICE_NAME);
        clientAnalizadorTextos = service.getPort(AnalizadorTextos.class);

        scanner=new Scanner(System.in);

        do{
            imprimirMenu();
            System.out.print(">> ");
            modo = scanner.next().toLowerCase(Locale.ROOT);
            if(modo.equals("a") || modo.equals("b")){
                do{
                    imprimirMenu();
                    System.out.print(">> ");
                    opcion = scanner.next().toLowerCase(Locale.ROOT);
                    realizarAccion();
                }while(!opcion.equals("x"));
                modo = "";
            }
        }while(!modo.equals("x"));

    }

    private static void imprimirMenu(){
        String menuTxt = "";
        switch (modo){
            case "a": // calculadora
                menuTxt+= "------------ " + "Calculadora" + " ------------\n";
                menuTxt+= "a) Suma de dos números.\n";
                menuTxt+= "b) Resta de dos números.\n";
                menuTxt+= "c) Multiplicación de dos números.\n";
                menuTxt+= "d) División de dos números.\n";
                menuTxt+= "e) Potencia de un número\n";
                menuTxt+= "f) Raíz cuadrada de un número.\n";
                menuTxt+= "g) Logaritmo neperiano de un número.\n";
                menuTxt+= "h) Máximo de una lista de números.\n";
                menuTxt+= "i) Mínimo de una lista de números.\n";
                menuTxt+= "j) Media de una lista de números.\n";
                menuTxt+= "k) Mediana de una lista de números.\n";
                menuTxt+= "l) Moda de una lista de números.\n";
                menuTxt+= "m) Desviación típica de una lista de números.\n";
                menuTxt+= "x) Salir.\n";
                menuTxt+= "------------ " + "Calculadora" + " ------------\n";
                break;
            case "b": // analizador de textos
                menuTxt+= "------------ " + "Analizador" + " ------------\n";
                menuTxt+= "a) Contar palabras.\n";
                menuTxt+= "b) Contar caracteres.\n";
                menuTxt+= "c) Contar frases.\n";
                menuTxt+= "d) Número de veces que aparece una palabra.\n";
                menuTxt+= "e) Palabra más usada.\n";
                menuTxt+= "f) Palabra menos usada.\n";
                menuTxt+= "g) Reemplazar palabra.\n";
                menuTxt+= "\n";
                menuTxt+= "x) Salir.\n";
                menuTxt+= "------------ " + "Analizador" + " ------------\n";
                break;

            default:
                menuTxt+= "------------ " + "Menú" + " ------------\n";
                menuTxt+= "a) Calculadora.\n";
                menuTxt+= "b) Analizador de Textos.\n";
                menuTxt+= "x) Salir.\n";
                menuTxt+= "------------ " + "Menú" + " ------------\n";
                break;
        }

        System.out.println(menuTxt);
    }

    private static void realizarAccion(){
        switch (modo){
            case "a": // calculadora
                switch (opcion){
                    case "a":
                        accionSuma();
                        break;
                    case "b":
                        accionResta();
                        break;
                    case "c":
                        accionMultiplicacion();
                        break;
                    case "d":
                        accionDivision();
                        break;
                    case "e":
                        accionPotencia();
                        break;
                    case "f":
                        accionRaizCuadrada();
                        break;
                    case "g":
                        accionLogNeperiano();
                        break;
                    case "h":
                        accionMaximo();
                        break;
                    case "i":
                        accionMinimo();
                        break;
                    case "j":
                        accionMedia();
                        break;
                    case "k":
                        accionMediana();
                        break;
                    case "l":
                        accionModa();
                        break;
                    case "m":
                        accionDesviacionTipica();
                        break;
                }
                break;
            case "b": // analizador
                switch (opcion){
                    case "a":
                        accionContarPalabras();
                        break;
                    case "b":
                        accionContarCaracteres();
                        break;
                    case "c":
                        accionContarFrases();
                        break;
                    case "d":
                        accionNumVecesPalabra();
                        break;
                    case "e":
                        accionPalabraMasUsada();
                        break;
                    case "f":
                        accionPalabraMenosUsada();
                        break;
                    case "g":
                        accionReemplazarPalabra();
                        break;
                }
                break;
        }
    }

    private static void accionSuma(){
        int a,b;
        try{
            System.out.print("Introduce el primer número: ");
            a = Integer.parseInt(scanner.next());
            System.out.print("Introduce el segundo número: ");
            b = Integer.parseInt(scanner.next());
            System.out.println("\nRESULTADO: " + clientCalculadora.suma(a,b));
        }catch(Exception e){
            System.out.println("Error al introducir los números");
        }

    }

    private static void accionResta(){
        int a,b;
        try{
            System.out.print("Introduce el primer número: ");
            a = Integer.parseInt(scanner.next());
            System.out.print("Introduce el segundo número: ");
            b = Integer.parseInt(scanner.next());
            System.out.println("\nRESULTADO: " + clientCalculadora.resta(a,b));
        }catch(Exception e){
            System.out.println("Error al introducir los números");
        }
    }

    private static void accionMultiplicacion(){
        int a,b;
        try{
            System.out.print("Introduce el primer número: ");
            a = Integer.parseInt(scanner.next());
            System.out.print("Introduce el segundo número: ");
            b = Integer.parseInt(scanner.next());
            System.out.println("\nRESULTADO: " + clientCalculadora.multiplicacion(a,b));
        }catch(Exception e){
            System.out.println("Error al introducir los números");
        }
    }

    private static void accionDivision(){
        int a,b;
        try{
            System.out.print("Introduce el primer número: ");
            a = Integer.parseInt(scanner.next());
            System.out.print("Introduce el segundo número: ");
            b = Integer.parseInt(scanner.next());
            System.out.println("\nRESULTADO: " + clientCalculadora.division(a,b));
        }catch(Exception e){
            System.out.println("Error al introducir los números");
        }
    }

    private static void accionPotencia(){
        int base, exponente;
        try {
            System.out.print("Introduce el número (base): ");
            base = Integer.parseInt(scanner.next());
            System.out.print("Introduce el exponente: ");
            exponente = Integer.parseInt(scanner.next());
            System.out.println("\nRESULTADO: " + clientCalculadora.potencia(base, exponente));
        }catch(Exception e){
            System.out.println("Error al introducir los números");
        }
    }

    private static void accionRaizCuadrada(){
        int num;
        try{
            System.out.print("Introduce el número: ");
            num = Integer.parseInt(scanner.next());
            System.out.println("\nRESULTADO: " + clientCalculadora.raiz(num));
        }catch(Exception e){
            System.out.println("Error al introducir los números");
        }
    }

    private static void accionLogNeperiano(){
        int num;
        try{
            System.out.print("Introduce el número: ");
            num = Integer.parseInt(scanner.next());
            System.out.println("\nRESULTADO: " + clientCalculadora.logNeperiano(num));
        }catch(Exception e){
            System.out.println("Error al introducir los números");
        }
    }

    private static void accionMaximo(){
        try{
            System.out.print("Introduce una lista de números (seperados por espacios): ");
            scanner.nextLine();
            String [] numsTxt = scanner.nextLine().split(" ");
            int [] nums = new int[numsTxt.length];
            for(int i=0; i<numsTxt.length; i++){
                nums[i] = Integer.parseInt(numsTxt[i]);
            }
            if(nums.length>0){
                System.out.println("\nRESULTADO: " + clientCalculadora.maximo(nums));
            }else{
                System.out.println("\nNo se ha introducido ningún número");
            }
        }catch(Exception e){
            System.out.println("Error al introducir los números");
        }
    }

    private static void accionMinimo(){
        try{
            System.out.print("Introduce una lista de números (seperados por espacios): ");
            scanner.nextLine();
            String [] numsTxt = scanner.nextLine().split(" ");
            int [] nums = new int[numsTxt.length];
            for(int i=0; i<numsTxt.length; i++){
                nums[i] = Integer.parseInt(numsTxt[i]);
            }
            if(nums.length>0){
                System.out.println("\nRESULTADO: " + clientCalculadora.minimo(nums));
            }else{
                System.out.println("\nNo se ha introducido ningún número");
            }
        }catch(Exception e){
            System.out.println("Error al introducir los números");
        }
    }

    private static void accionMedia(){
        try{
            System.out.print("Introduce una lista de números (seperados por espacios): ");
            scanner.nextLine();
            String [] numsTxt = scanner.nextLine().split(" ");
            int [] nums = new int[numsTxt.length];
            for(int i=0; i<numsTxt.length; i++){
                nums[i] = Integer.parseInt(numsTxt[i]);
            }
            if(nums.length>0){
                System.out.println("\nRESULTADO: " + clientCalculadora.media(nums));
            }else{
                System.out.println("\nNo se ha introducido ningún número");
            }
        }catch(Exception e){
            System.out.println("Error al introducir los números");
        }
    }

    private static void accionMediana(){
        try{
            System.out.print("Introduce una lista de números (seperados por espacios): ");
            scanner.nextLine();
            String [] numsTxt = scanner.nextLine().split(" ");
            int [] nums = new int[numsTxt.length];
            for(int i=0; i<numsTxt.length; i++){
                nums[i] = Integer.parseInt(numsTxt[i]);
            }
            if(nums.length>0){
                System.out.println("\nRESULTADO: " + clientCalculadora.mediana(nums));
            }else{
                System.out.println("\nNo se ha introducido ningún número");
            }
        }catch(Exception e){
            System.out.println("Error al introducir los digitos");
        }
    }

    private static void accionModa(){
        try{
            System.out.print("Introduce una lista de números (seperados por espacios): ");
            scanner.nextLine();
            String [] numsTxt = scanner.nextLine().split(" ");
            int [] nums = new int[numsTxt.length];
            for(int i=0; i<numsTxt.length; i++){
                nums[i] = Integer.parseInt(numsTxt[i]);
            }
            if(nums.length>0){
                List<Integer> res = clientCalculadora.moda(nums);
                String mensaje = "\nRESULTADO: ";
                for(int i=0; i<res.size();i++){
                    mensaje+= res.get(i).toString();
                    if(i<(res.size()-1)){
                        mensaje+= ", ";
                    }
                }
                System.out.println(mensaje);
            }else{
                System.out.println("\nNo se ha introducido ningún número");
            }
        }catch(Exception e){
            System.out.println("Error al introducir los números");
        }
    }

    private static void accionDesviacionTipica(){
        try{
            System.out.print("Introduce una lista de números (seperados por espacios): ");
            scanner.nextLine();
            String [] numsTxt = scanner.nextLine().split(" ");
            int [] nums = new int[numsTxt.length];
            for(int i=0; i<numsTxt.length; i++){
                nums[i] = Integer.parseInt(numsTxt[i]);
            }
            if(nums.length>0){
                System.out.println("\nRESULTADO: " + clientCalculadora.desviacionTipica(nums));
            }else{
                System.out.println("\nNo se ha introducido ningún número");
            }
        }catch(Exception e){
            System.out.println("Error al introducir los números");
        }
    }

    private static void accionContarPalabras(){
        try{
            System.out.print("Introduce una cadena de texto: ");
            scanner.nextLine();
            String txt = scanner.nextLine();
            System.out.println("\nRESULTADO: " + clientAnalizadorTextos.contarPalabras(txt));
        }catch(Exception e){
            System.out.println("Error al introducir el texto");
        }
    }

    private static void accionContarCaracteres(){
        try{
            System.out.print("Introduce una cadena de texto: ");
            scanner.nextLine();
            String txt = scanner.nextLine();
            System.out.println("\nRESULTADO: " + clientAnalizadorTextos.contarCaracteres(txt));
        }catch(Exception e){
            System.out.println("Error al introducir el texto");
        }
    }

    private static void accionContarFrases(){
        try{
            System.out.print("Introduce una cadena de texto: ");
            scanner.nextLine();
            String txt = scanner.nextLine();
            System.out.println("\nRESULTADO: " + clientAnalizadorTextos.contarFrases(txt));
        }catch(Exception e){
            System.out.println("Error al introducir el texto");
        }
    }

    private static void accionNumVecesPalabra(){
        try{
            System.out.print("Introduce una cadena de texto: ");
            scanner.nextLine();
            String txt = scanner.nextLine();
            System.out.print("Introduce una palabra: ");
            String palabra = scanner.next();
            System.out.println("\nRESULTADO: " + clientAnalizadorTextos.contarNumVecesPalabra(txt,palabra));
        }catch(Exception e){
            System.out.println("Error al introducir el texto");
        }
    }

    private static void accionPalabraMasUsada(){
        try{
            System.out.print("Introduce una cadena de texto: ");
            scanner.nextLine();
            String txt = scanner.nextLine();
            String mensaje = "";
            if(txt.length()>0){
                List<String> res = clientAnalizadorTextos.palabraMasUsada(txt);
                mensaje += "\nRESULTADO: ";
                for(int i = 0; i<res.size(); i++){
                    mensaje += res.get(i);
                    if(i<(res.size()-1)) mensaje += ", ";
                }
                System.out.println(mensaje);
            }else{
                System.out.println("\nCadena vacía.\n");
            }
        }catch(Exception e){
            System.out.println("Error al introducir el texto");
        }
    }

    private static void accionPalabraMenosUsada(){
        try{
            System.out.print("Introduce una cadena de texto: ");
            scanner.nextLine();
            String txt = scanner.nextLine();
            String mensaje = "";
            if(txt.length()>0){
                List<String> res = clientAnalizadorTextos.palabraMenosUsada(txt);
                mensaje += "\nRESULTADO: ";
                for(int i = 0; i<res.size(); i++){
                    mensaje += res.get(i);
                    if(i!=(res.size()-1)) mensaje += ", ";
                }
                System.out.println(mensaje);
            }else{
                System.out.println("\nCadena vacía.\n");
            }
        }catch(Exception e){
            System.out.println("Error al introducir el texto");
        }
    }

    private static void accionReemplazarPalabra(){
        try{
            System.out.print("Introduce una cadena de texto: ");
            scanner.nextLine();
            String txt = scanner.nextLine();
            System.out.print("Introduce una palabra: ");
            String palabra = scanner.next();
            System.out.print("Introduce la nueva palabra: ");
            String nuevaPalabra = scanner.next();
            System.out.println("\nRESULTADO: " + clientAnalizadorTextos.reemplazarPalabra(txt,palabra,nuevaPalabra));
        }catch(Exception e){
            System.out.println("Error al introducir el texto");
        }
    }
}




