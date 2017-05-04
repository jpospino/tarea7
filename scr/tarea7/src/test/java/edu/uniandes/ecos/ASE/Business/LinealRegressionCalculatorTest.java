/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.Business;

import edu.uniandes.ecos.ASE.DTO.LinearRegressionCalc;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JuanPablo
 */
public class LinealRegressionCalculatorTest {
    
    public LinealRegressionCalculator linealRegressionCalculator;
    
    public LinealRegressionCalculatorTest() {
        linealRegressionCalculator = new LinealRegressionCalculator(); 
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        this.linealRegressionCalculator = new LinealRegressionCalculator();
        this.linealRegressionCalculator.addStatictics(1, 130.0, 163.0, 186.0, 15.0);
        this.linealRegressionCalculator.addStatictics(2, 650.0, 765.0, 699.0, 69.9);
        this.linealRegressionCalculator.addStatictics(3, 99.0, 141.0, 132.0, 6.50);
        this.linealRegressionCalculator.addStatictics(4, 150.0, 166.0, 272.0, 22.40);
        this.linealRegressionCalculator.addStatictics(5, 128.0, 137.0, 291.0, 28.4);
        this.linealRegressionCalculator.addStatictics(6, 302.0, 355.0, 331.0, 65.9);
        this.linealRegressionCalculator.addStatictics(7, 95.0, 136.0, 199.0, 19.4);
        this.linealRegressionCalculator.addStatictics(8, 945.0, 1206.0, 1890.0, 198.7);
        this.linealRegressionCalculator.addStatictics(9, 368.0, 433.0, 788.0, 38.8);
        this.linealRegressionCalculator.addStatictics(10, 961.0, 1130.0, 1601.0, 138.2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Prueba unitarioa del metodo SumActualAddedModifiedSize
     */
    @Test
    public void testSumActualAddedModifiedSize()
    {
        assertEquals(this.linealRegressionCalculator.sumActualAddedModifiedSize(), 6389.0, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo SumActualAddedModifiedSizeSquared
     */
    @Test
    public void testSumActualAddedModifiedSizeSquared()
    {
        assertEquals(this.linealRegressionCalculator.sumActualAddedModifiedSizeSquared(), 7604693.0, 0.01);
    }

    /**
     * Prueba unitarioa del metodo SumActualDevelopmentTimeSquared
     */
    @Test
    public void testSumActualDevelopmentTimeSquared()
    {
        assertEquals(this.linealRegressionCalculator.sumActualDevelopmentTimeSquared(), 71267.12, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo sumEstimatedProxySize
     */
    @Test
    public void testSumEstimatedProxySize()
    {
        assertEquals(this.linealRegressionCalculator.sumEstimatedProxySize(), 3828.0, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo sumEstimatedProxySizeActualAddedModifiedSize
     */
    @Test
    public void testSumEstimatedProxySizeActualAddedModifiedSize()
    {
        assertEquals(this.linealRegressionCalculator.sumEstimatedProxySizeActualAddedModifiedSize(), 4303108.0, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo sumEstimatedProxySizeActualDevelopmentTime
     */
    @Test
    public void testSumEstimatedProxySizeActualDevelopmentTime()
    {
        assertEquals(this.linealRegressionCalculator.sumEstimatedProxySizeActualDevelopmentTime(), 411628.6, 0.01);  
    }
    
    /**
     * Prueba unitarioa del metodo sumEstimatedProxySizeSquared
     */
    @Test
    public void testSumEstimatedProxySizeSquared()
    {
        assertEquals(this.linealRegressionCalculator.sumEstimatedProxySizeSquared(), 2540284.0, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo sumPlanAddedModifiedSizeActualAddedModifiedSize
     */
    @Test
    public void testSumPlanAddedModifiedSizeActualAddedModifiedSize()
    {
        assertEquals(this.linealRegressionCalculator.sumPlanAddedModifiedSizeActualAddedModifiedSize(), 5242927.0, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo sumPlanAddedModifiedSizeActualDevelopmentTime
     */
    @Test
    public void testSumPlanAddedModifiedSizeActualDevelopmentTime()
    {
        assertEquals(this.linealRegressionCalculator.sumPlanAddedModifiedSizeActualDevelopmentTime(), 503075.7, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo sumPlanAddedModifiedSizeSquared
     */
    @Test
    public void testSumPlanAddedModifiedSizeSquared()
    {
        assertEquals(this.linealRegressionCalculator.sumPlanAddedModifiedSizeSquared(), 3741346.0, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo printStatistics
     */
    @Test
    public void testImprimirStatistics()
    {
        //this.linealRegressionCalculator.printStatistics();
    }
    
    /**
     * Prueba unitarioa de la impresión de los resultados
     */
    @Test 
    public void testCalcPlanAddedModifiedSizeEPSAAM()
    {
        
        System.out.println("[B0]          [B1]          [r_xy]        [r^2]         [y_k]");
        
        LinearRegressionCalc valores = this.linealRegressionCalculator.EPSAAM(386);
        
        assertEquals(valores.getB0(), -22.55253275203438);        
        assertEquals(valores.getB1(), 1.7279324262069864);        
        assertEquals(valores.getR_xy(), 0.9544965741046826);        
        assertEquals(valores.getR_pow_2(), 0.9110637099775758);        
        assertEquals(valores.getY_k(), 644.4293837638623);            
    }
}
