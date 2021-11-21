package gal.usc.etse.soap.analizadorTextos;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface AnalizadorTextos {

    @WebMethod(operationName = "contarPalabras")
    @WebResult(name = "resultado")
    int contarPalabras(@WebParam(name = "contarPalabrasText") String txt);

    @WebMethod(operationName = "contarCaracteres")
    @WebResult(name = "resultado")
    int contarCaracteres(@WebParam(name = "contarCaracteresText") String txt);

    @WebMethod(operationName = "contarFrases")
    @WebResult(name = "resultado")
    int contarFrases(@WebParam(name = "contarFrasesText") String txt);

    @WebMethod(operationName = "contarNumVecesPalabra")
    @WebResult(name = "resultado")
    int contarNumVecesPalabra(@WebParam(name = "contarNumVecesPalabraText") String txt, @WebParam(name = "contarNumVecesPalabraPalabra") String palabra);

    @WebMethod(operationName = "palabraMasUsada")
    @WebResult(name = "resultado")
    List<String> palabraMasUsada(@WebParam(name = "palabraMasUsadaText") String txt);

    @WebMethod(operationName = "palabraMenosUsada")
    @WebResult(name = "resultado")
    List<String> palabraMenosUsada(@WebParam(name = "palabraMenosUsadaText") String txt);

    @WebMethod(operationName = "reemplazarPalabra")
    @WebResult(name = "resultado")
    String reemplazarPalabra(@WebParam(name = "reemplazarPalabraText") String txt, @WebParam(name = "reeemplazarPalabraA") String palabraA, @WebParam(name = "reeemplazarPalabraB") String palabraB);

}