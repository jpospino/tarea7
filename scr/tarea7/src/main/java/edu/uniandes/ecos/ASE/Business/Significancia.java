/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.Business;


/**
 * <h1>Significancia</h1>
 * Clase Significancia
 * Clase encargada del cálculo de la significancia
 *
 * @author Juan Pablo Ospino Solano
 * @version 1.0
 * @since   2017-05-01
 */
public class Significancia {
    private double r_x_y;
    private int dataPoints;
    
    /**
     * Constructor de la clase Significancia
     * @param r_x_Y valor de r sub x y
     * @param dataPoints cantidad de muestras de los programas
     */
    public Significancia(double r_x_Y, int dataPoints)
    {
        this.r_x_y = r_x_Y;
        this.dataPoints = dataPoints;
    }
    
    /***
     * Método para el calculo de X
     * @return valor calculado de X
     */
    public double CalcularX()
    {
        return (Math.abs(this.r_x_y) * Math.sqrt(this.dataPoints - 2)) / Math.sqrt(1 - (Math.pow(r_x_y, 2.0)));
    }
}
