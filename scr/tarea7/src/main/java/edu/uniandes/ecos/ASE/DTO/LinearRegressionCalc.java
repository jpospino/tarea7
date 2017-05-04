/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.DTO;

 /**
    * <h1>LinearRegressionCalc</h1>
    * Clase contiene valores calculado de la regresión lineal
    *
    * @author Juan Pablo Ospino Solano
    * @version 1.0
    * @since   2017-04-25
    */
    public class LinearRegressionCalc
    {

        /**
         * @return the B0
         */
        public double getB0() {
            return B0;
        }

        /**
         * @return the B1
         */
        public double getB1() {
            return B1;
        }

        /**
         * @return the r_xy
         */
        public double getR_xy() {
            return r_xy;
        }

        /**
         * @return the r_pow_2
         */
        public double getR_pow_2() {
            return r_pow_2;
        }

        /**
         * @return the y_k
         */
        public double getY_k() {
            return y_k;
        }
        
        private double B0;
        private double B1;
        private double r_xy;
        private double r_pow_2;
        private double y_k;
        
        
        public LinearRegressionCalc(double b0, double b1, double r_xy, double r_pow_2, double y_k)
        {
            this.B0 = b0;
            this.B1 = b1;
            this.r_xy = r_xy;
            this.r_pow_2 = r_pow_2;
            this.y_k = y_k;
        }
    }
