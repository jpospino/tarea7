/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.Business;

/**
 * <h1>Statistic</h1>
 * Statistic
 *
 * @author Juan Pablo Ospino Solano
 * @version 1.0
 * @since   2017-03-04
 */
public class Statistic {
    private int programID;
    private double estimatedProxySize;
    private double planAddedModifiedSize;
    private double actualAddedModifiedSize;
    private double actualDevelopmentTime;
    
    // <editor-fold defaultstate="collapsed" desc=" Constructores de la clase ">
    /**
     * 
     * @param pgrID identificador del programa
     * @param ePS valor de la propiedad Estimated Proxy Size
     * @param pAMS valor de la propiedad Plan Added and Modified size
     * @param aAMS valor de la propiedad Actual Added and Modified Size
     * @param aDT valor de la propiedad Actual Development Times
     */
    public Statistic(int pgrID, double ePS, double pAMS, double aAMS, double aDT) 
    {
        this.programID = pgrID;
        this.estimatedProxySize = ePS;
        this.planAddedModifiedSize = pAMS;
        this.actualAddedModifiedSize = aAMS;
        this.actualDevelopmentTime = aDT;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Get de las propiedades de la clase ">
    /**
     * Método  get para obtener la proíedad Estimated Proxy Size
     * @return valor de la variable Estimated Proxy Size
     */
    public double getEstimatedProxySize() 
    {
        return this.estimatedProxySize;
    }
    
    /**
     * Método get para obtener la propiedad Plan Added and Modified size
     * @return valor de la variable Plan Added and Modified size
     */
    public double getPlanAddedModifiedSize()
    {  
        return this.planAddedModifiedSize; 
    }
    
    /**
     * Método get para obtener la propiedad Actual Added and Modified Size
     * @return valor de la variable Actual Added and Modified Size
     */
    public double getActualAddedModifiedSize()
    {  
        return this.actualAddedModifiedSize; 
    }
    
    /**
     * Método para obtener la propiedad Actual Development Times
     * @return valor de la variable Actual Development Times
     */
    public double getActualDevelopmentTime()
    {  
        return this.actualDevelopmentTime; 
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" valores cuadrados de las propiedades ">
    /**
     * Calcula el cuadrado de Estimated Proxy Size
     * @return Calcula el cuadrado de Plan Added and Modified size
     */
    public double estimatedProxySizeSquared()
    {  
        return this.estimatedProxySize * this.estimatedProxySize;
    }
    
    /**
     * Calcula el cuadrado de Actual Added and Modified Size
     * @return Valor cuadrado de Plan Added and Modified size
     */
    public double planAddedModifiedSizeSquared()
    {  
        return this.planAddedModifiedSize * this.planAddedModifiedSize; 
    }
    
    /**
     * Calcula el cuadrado de Actual Added and Modified Size
     * @return Valor cuadrado de Actual Added and Modified Size
     */
    public double actualAddedModifiedSizeSquared()
    {  
        return this.actualAddedModifiedSize * this.actualAddedModifiedSize; 
    }
    
    /**
     * Calcula el cuadrado de Actual Development Time
     * @return Valor cuadrado de Actual Development Time
     */
    public double actualDevelopmentTimeSquared()
    {  
        return this.actualDevelopmentTime * this.actualDevelopmentTime; 
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Procuto de las propiedades ">
    /**
     * cálculo del producto de Estimated Proxy Size y Actual Added and Modified Size
     * @return valor del producto Estimated Proxy Size y Actual Added and Modified Size
     */
    public double estimatedProxySizeActualAddedModifiedSize()
    {  
        return this.estimatedProxySize * this.actualAddedModifiedSize; 
    }
    
    /**
     * cálculo del producto de Estimated Proxy Size y Actual Development Time
     * @return valor del producto de Estimated Proxy Size y Actual Development Time
     */
    public double estimatedProxySizeActualDevelopmentTime()
    {  
        return this.estimatedProxySize * this.actualDevelopmentTime; 
    }
    
    /**
     * 
     * @return 
     */
    public double planAddedModifiedSizeActualAddedModifiedSize()
    {  
        return this.planAddedModifiedSize * this.actualAddedModifiedSize; 
    }
    
    /**
     * cálculo del producto de Plan Added and Modified size y Actual Added and Modified Size
     * @return valor del producto de Plan Added and Modified size y Actual Development Time
     */
    public double planAddedModifiedSizeActualDevelopmentTime()
    {  
        return this.planAddedModifiedSize * this.actualDevelopmentTime; 
    }
    // </editor-fold>
}
