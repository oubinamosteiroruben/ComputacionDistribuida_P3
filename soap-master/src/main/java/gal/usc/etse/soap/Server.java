package gal.usc.etse.soap;

import gal.usc.etse.soap.analizadorTextos.AnalizadorTextos;
import gal.usc.etse.soap.analizadorTextos.AnalizadorTextosImpl;
import gal.usc.etse.soap.calculadora.Calculadora;
import gal.usc.etse.soap.calculadora.CalculadoraImpl;
import javax.xml.ws.Endpoint;

public class Server {
    public static void main(String[] args) {
        Calculadora c = new CalculadoraImpl();
        Endpoint.publish("http://localhost:8080/calculadora", c);
        AnalizadorTextos at = new AnalizadorTextosImpl();
        Endpoint.publish("http://localhost:8080/analizadorTextos",at);
    }
}
