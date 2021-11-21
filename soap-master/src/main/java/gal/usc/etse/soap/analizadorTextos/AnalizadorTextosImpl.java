package gal.usc.etse.soap.analizadorTextos;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(
        endpointInterface = "gal.usc.etse.soap.analizadorTextos.AnalizadorTextos",
        serviceName = "AnalizadorTextos"
)

public class AnalizadorTextosImpl implements AnalizadorTextos{

    public int contarPalabras(String txt){
        return txt.split(" ").length;
    }

    public int contarCaracteres(String txt){
        return txt.length();
    }

    public int contarFrases(String txt){
        int count = 0;
        for(String s: txt.split("\\.")){
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i) != ' '){
                    count++;
                    break;
                }
            }
        }
        return count;
        //return txt.split("\\.").length;
    }

    public int contarNumVecesPalabra(String txt, String palabra){
        String[] palabras = txt.split(" ");
        int num = 0;
        for(String p: palabras){
            if(p.equals(palabra)) num++;
        }
        return num;
    }

    public List<String> palabraMasUsada(String txt){
        String[] palabras = txt.split(" ");
        List<String> palabrasMasUsadas = new ArrayList<>();
        int maxNumVecesUsadas = 0;

        for(String p: palabras){
            int numVecesUsada = 0;
            if(!estanEn(palabrasMasUsadas,p)){
                for(String p2: palabras){
                    if(p.equals(p2)){
                        numVecesUsada++;
                    }
                }
                if(numVecesUsada > maxNumVecesUsadas){
                    palabrasMasUsadas = new ArrayList<>();
                    palabrasMasUsadas.add(p);
                    maxNumVecesUsadas = numVecesUsada;
                }else if(numVecesUsada == maxNumVecesUsadas){
                    palabrasMasUsadas.add(p);
                }
            }
        }

        return palabrasMasUsadas;
    }

    public List<String> palabraMenosUsada(String txt){
        String[] palabras = txt.split(" ");
        List<String> palabrasMenosUsadas = new ArrayList<>();
        int minNumVecesUsadas = palabras.length;

        for(String p: palabras){
            int numVecesUsada = 0;
            if(!estanEn(palabrasMenosUsadas,p)){
                for(String p2: palabras){
                    if(p.equals(p2)){
                        numVecesUsada++;
                    }
                }
                if(numVecesUsada < minNumVecesUsadas){
                    palabrasMenosUsadas = new ArrayList<>();
                    palabrasMenosUsadas.add(p);
                    minNumVecesUsadas = numVecesUsada;
                }else if(numVecesUsada == minNumVecesUsadas){
                    palabrasMenosUsadas.add(p);
                }
            }
        }

        return palabrasMenosUsadas;
    }

    public String reemplazarPalabra(String txt, String palabraA, String palabraB){
        String txtNuevo = "";

        for(String p: txt.split(" ")){
            if(p.equals(palabraA)){
                txtNuevo+= " " + palabraB;
            }else{
                txtNuevo+= " " + p;
            }
        }

        return txtNuevo;
    }

    private boolean estanEn(List<String> list, String cadena){
        for(String s: list){
            if(s.equals(cadena)) return true;
        }
        return false;
    }

}