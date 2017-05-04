/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.Business;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>PredictionInterval</h1>
 * Clase PredictionInterval
 * Clase encargada del cálculo  de la desviación standar y verificación de la relación
 * entre proxy y los resultados
 *
 * @author Juan Pablo Ospino Solano
 * @version 1.0
 * @since   2017-05-01
 */
public class PredictionInterval {
    private int DOF;
    private float b_1;
    private float b_0;
    private List<Statistic> statistic = new ArrayList();
    private Operation operation;
    private int tamanhoProxy;
    
    /***
     * Constructor de la clase PredictionInterval
     * @param DOF número de grados de libertar
     * @param b_0 valor calculado de beta 0
     * @param b_1 valor calculado de beta 1
     * @param statistic arreglo con las estadisticas de los programas ya realizados
     * @param tamanhoProxy tamaño del proxy
     * @param operation operación a realizar
     */
    public PredictionInterval(int DOF,float b_0, float b_1, List<Statistic> statistic, int tamanhoProxy,Operation operation)
    {
        this.DOF = DOF;
        this.b_1 = b_1;
        this.b_0 = b_0;
        this.statistic  = statistic;
        this.tamanhoProxy = tamanhoProxy;
        this.operation = operation;
    }
    
    /***
     * Método que calcula el valor de la desviación standart
     * @return desviación standar calculada
     */
    private float standarDeviation()
    {
        float acumulador = 0;
        
        for(Statistic item : this.statistic)
        {
            switch(this.operation)
            {
                case EPSAAM:
                    acumulador += (float)Math.pow((item.getActualAddedModifiedSize() - this.b_0 - (this.b_1 * item.getEstimatedProxySize())),2.0);
                    break;
                case EPSADT:
                    acumulador += (float)Math.pow((item.getActualDevelopmentTime() - this.b_0 - (this.b_1 * item.getEstimatedProxySize())),2.0);
                    break;
            }
        }
        
        return (float)Math.sqrt((1.0/(this.statistic.size() - 2.0)) * acumulador);
    }
    
    /***
     * Calcula el valor del RANGE del ejercicio
     * @param tDistribution valor de la distribución para el ejercicio
     * @return rango calculado
     */
    public float CalcularRango(float tDistribution)
    {
        float promedio = (float)this.statistic.stream().mapToDouble(x -> x.getEstimatedProxySize()).sum() / this.statistic.size();
        float acumulado = 0;
        
        for(Statistic item : this.statistic)
        {
            acumulado += (float)Math.pow(item.getEstimatedProxySize() - promedio, 2.0);
        }
            
        float temp = (float)Math.sqrt(1.0 + (float)(1.0 / this.statistic.size()) + ((float)Math.pow(this.tamanhoProxy - promedio, 2.0)/acumulado));
        return (float)tDistribution * (float)standarDeviation() * temp;          
    }
}
