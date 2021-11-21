package gal.usc.etse.soap.calculadora;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface Calculadora {
    @WebMethod(operationName = "suma")
    @WebResult(name = "resultadoSuma")
    int suma(@WebParam(name = "sumaNum1") int a, @WebParam(name = "sumaNum2") int b);

    @WebMethod(operationName = "resta")
    @WebResult(name = "resultadoResta")
    int resta(@WebParam(name = "restaNum1") int a, @WebParam(name = "restaNum2") int b);

    @WebMethod(operationName = "multiplicacion")
    @WebResult(name = "resultadoMultiplicacion")
    int multiplicacion(@WebParam(name = "multiNum1") int a, @WebParam(name = "multiNum2") int b);

    @WebMethod(operationName = "division")
    @WebResult(name = "resultadoDivision")
    float division(@WebParam(name = "divNum1") int a, @WebParam(name = "divNum2") int b);

    @WebMethod(operationName = "potencia")
    @WebResult(name = "resultadoPotencia")
    double potencia(@WebParam(name = "potNum1") int a, @WebParam(name = "potNum2") int b);

    @WebMethod(operationName = "raiz")
    @WebResult(name = "resultadoRaiz")
    double raiz(@WebParam(name = "raizNum") int a);

    @WebMethod(operationName = "logNeperiano")
    @WebResult(name = "resultadoLogNeperiano")
    double logNeperiano(@WebParam(name = "lnNum") int a);

    @WebMethod(operationName = "maximo")
    @WebResult(name = "resultadoMaximo")
    int maximo(int[] nums);

    @WebMethod(operationName = "minimo")
    @WebResult(name = "resultadoMinimo")
    int minimo(int[] nums);

    @WebMethod(operationName = "media")
    @WebResult(name = "resultadoMedia")
    double media(int[] nums);

    @WebMethod(operationName = "mediana")
    @WebResult(name = "resultadoMediana")
    double mediana(int[] nums);

    @WebMethod(operationName = "moda")
    @WebResult(name = "resultadoModa")
    List<Integer> moda(int[] nums);

    @WebMethod(operationName = "desviacionTipica")
    @WebResult(name = "resultadoDesviacionTipica")
    double desviacionTipica(int[] nums);

}
