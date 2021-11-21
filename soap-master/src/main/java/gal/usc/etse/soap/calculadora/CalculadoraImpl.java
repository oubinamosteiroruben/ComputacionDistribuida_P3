package gal.usc.etse.soap.calculadora;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebService(
        endpointInterface = "gal.usc.etse.soap.calculadora.Calculadora",
        serviceName = "Calculadora"
)
public class CalculadoraImpl implements Calculadora {
    @Override
    public int suma(int a, int b) {
        return a+b;
    }

    @Override
    public int resta(int a, int b){ return a-b; }

    @Override
    public int multiplicacion(int a, int b){ return a*b; }

    @Override
    public float division(int a, int b){ return ((float) a)/((float) b); }

    @Override
    public double potencia(int a, int b){ return Math.pow((double)a,(double)b);}

    @Override
    public double raiz(int a){
        return Math.sqrt(a);
    }

    @Override
    public double logNeperiano(int a){
        return Math.log(a);
    }

    @Override
    public int maximo(int[] nums){
        return Arrays.stream(nums).max().getAsInt();
    }

    @Override
    public int minimo(int[] nums){
        return Arrays.stream(nums).min().getAsInt();
    }

    @Override
    public double media(int[] nums){
        double sum = Arrays.stream(nums).sum();
        return sum/nums.length;
    }

    @Override
    public double mediana(int[] nums){
        Arrays.sort(nums);
        double mediana = ((double)(nums.length+1))/2;
        int a,b;
        double valor;

        if(nums.length %2 != 0){
            a = nums[((int) Math.floor(mediana))-1];
            valor = a;
        }else{
            a = nums[((int) Math.floor(mediana))-1];
            b = nums[((int) Math.ceil(mediana)-1)];
            valor = ((double)(a+b))/2;
        }

        return valor;
    }

    @Override
    public List<Integer> moda(int[] nums){
        int maximoNumRepeticiones= 0;
        List<Integer> modas= new ArrayList<>();

        for(int i=0; i<nums.length; i++)
        {
            int numRepeticiones= 0;
            if(!estanEn(modas,nums[i])){
                for(int j=0; j<nums.length; j++)
                {
                    if(nums[i]==nums[j])
                    {
                        numRepeticiones++;
                    }
                }
                if(numRepeticiones>maximoNumRepeticiones)
                {
                    modas = new ArrayList<>();
                    modas.add(nums[i]);
                    maximoNumRepeticiones= numRepeticiones;
                }else if(numRepeticiones == maximoNumRepeticiones){
                    modas.add(nums[i]);
                }
            }
        }
        return modas;
    }

    @Override
    public double desviacionTipica(int[] nums){
        double sum = Arrays.stream(nums).sum();
        double media = sum/nums.length;

        double sumatorio = 0;
        for(int i: nums){
            sumatorio+= (i-media)*(i-media);
        }
        return sumatorio/(nums.length-1);
    }

    private boolean estanEn(List<Integer> list, int num){
        for(Integer i: list){
            if(i.equals(num)) return true;
        }
        return false;
    }


}
