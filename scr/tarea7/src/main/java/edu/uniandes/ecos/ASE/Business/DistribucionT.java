/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.Business;

/**
 * <h1>DsitribucionT</h1>
 * Clase DsitribucionT
 * Clase encargada del cálculo de la distribución T student
 *
 * @author Juan Pablo Ospino Solano
 * @version 1.0
 * @since   2017-03-04
 */
public class DistribucionT {
    private int numeroSegmentos;
    private double intervalo;
    private int DOF;
    private ResultData[] resultado;
    
    /**
     * Contructor de la clase
     * @param numeroSegmentos numero de segmentos en los que se va dividir el intervalo
     * @param intervalo hasta desde 0 del rango de la función
     * @param DOF  número de grados de libertad
     */
    public DistribucionT(int numeroSegmentos, double intervalo, int DOF )
    {
        this.numeroSegmentos = numeroSegmentos;
        this.intervalo = intervalo;
        this.DOF = DOF;
        
        this.resultado = new ResultData[numeroSegmentos +1];
    }
    
    /***
     * Calculo final de toda la distribución
     * @return valor calculado
     */
    public float calculoDistribucion()
    {
        float resultado = 0;
        int multiplicador = 0;
        float tmpValor = 0;
        
        for(int i = 0; i < this.resultado.length - 1 ; i++)
        {
            multiplicador = 0;
            
            if(i == 0)
                multiplicador = 1;
            else 
                if((i%2) == 0)
                    multiplicador = 2;
                else 
                    if((i%2) != 0 && (i + 1) != this.resultado.length)
                        multiplicador = 4;
                        
            this.resultado[i] = new ResultData(i, (this.intervalo/ this.numeroSegmentos), multiplicador , this.DOF , this.calculaFuncionDistribucionSimpson() );
            tmpValor = this.resultado[i].valorCalculado();
            resultado += tmpValor;
        }
        
        
        multiplicador =   1;
        this.resultado[this.resultado.length -1] = new ResultData(this.resultado.length -1, (this.intervalo/ this.numeroSegmentos)  , multiplicador , this.DOF , this.calculaFuncionDistribucionSimpson() );
        tmpValor = this.resultado[this.resultado.length -1].valorCalculado();
        
        return resultado + tmpValor;
    }
    
    /***
     * Calcula el valor de la columna 5 del ejemplo
     * @return valor calculado
     */
    private float calculaFuncionDistribucionSimpson()
    {
        float divisor = this.calcularGama((this.DOF + 1));
        float cosiente = (float)Math.sqrt((float)this.DOF * (float)Math.PI) * (float)this.calcularGama(this.DOF);
        return divisor / cosiente;
    }
    
    /***
     * Calcula el gama dado el valor de grados de libertad
     * @param DOF número de grados de libertad
     * @return valor calculado
     */
    private float calcularGama(int DOFCalculate)
    {
        float DOFCalculateTmp = (float)DOFCalculate;
        float valorResultado = ((DOFCalculateTmp/2 ) - 1);
        DOFCalculateTmp = ((DOFCalculateTmp/2 ) - 1);
        
        while(DOFCalculateTmp != 1 && DOFCalculateTmp != 0.5)
        {
            valorResultado = valorResultado * (DOFCalculateTmp - 1) ;
            DOFCalculateTmp = (DOFCalculateTmp - 1);
        }
        
        if(DOFCalculateTmp == 0.5)
            valorResultado = valorResultado * (float)Math.sqrt(Math.PI);
        
        return valorResultado;
    }
    
    /***
     * Método para el cálculo final de la distribución T Student
     * @param intervalo valor de x a calcular
     * @param DOF número de grados de libertad
     * @param error valor error admisible
     * @return resultado del cálculo
     */
    public static float calculoDistribucionResultado(double intervalo, int DOF, float error)
    {
        int numeroSegmentos = 10;
        DistribucionT distribucionT = new DistribucionT(numeroSegmentos, intervalo, DOF);
        float valorAnterior = (float)distribucionT.calculoDistribucion();
        numeroSegmentos = 20;
        distribucionT = new DistribucionT(numeroSegmentos, intervalo, DOF);;
        float valorNuevo = (float)distribucionT.calculoDistribucion();
        
        while((float)Math.abs(valorNuevo - valorAnterior) >  error)
        {
            numeroSegmentos += 10;
            valorAnterior = valorNuevo;
            distribucionT = new DistribucionT(numeroSegmentos, intervalo, DOF);
            valorNuevo = (float)distribucionT.calculoDistribucion();
        }
        
        return valorNuevo;
    }
     
    /***
     * Método para el cálculo de X a parti de un p dado de la distribución TStudent
     * @param valorIntegral valor p
     * @param DOFValue número de grados de libertad
     * @return valor x calculado
     */
    public static float calculoX(float valorIntegral, int DOFValue)
    {
        float d = (float)1.0;
        float x = (float)1.0;
        int numeroSegmentos = 50;
        
        
        DistribucionT  distribucionT = new DistribucionT(numeroSegmentos, x, DOFValue);
        float valorCalculadoIntegral = distribucionT.calculoDistribucion();
        float errorAnterior = (float)0.0;
        
        while((float)Math.abs(valorIntegral - valorCalculadoIntegral) > (float)0.001)
        {
            if(errorAnterior == 0)
                d = ((valorIntegral - valorCalculadoIntegral) > 0) ? 1 : -1;
            else
                d = (((valorIntegral - valorCalculadoIntegral) > 0 && errorAnterior > 0) || ((valorIntegral - valorCalculadoIntegral) < 0 && errorAnterior < 0))? d : (-1) * d /2;   
            
            if(Math.abs(valorIntegral - valorCalculadoIntegral) > 0.00001)
            {
                x += d;
                distribucionT = new DistribucionT(numeroSegmentos, x, DOFValue);
                errorAnterior = valorIntegral - valorCalculadoIntegral;
                valorCalculadoIntegral = distribucionT.calculoDistribucion();
            }            
        }
        
        return x;
    }
}
