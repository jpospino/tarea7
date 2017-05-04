/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ASE.Business;

 /**
 * <h1>ResultData</h1>
 * Clase ResultData
 * Clase que modela la tabla de calculos para la distribución T Student
 *
 * @author Juan Pablo Ospino Solano
 * @version 1.0
 * @since   2017-03-04
 */
    public class ResultData
    {
            private int numeroSegmento;
            private float anchoSegmento;
            private float anchoSegmentoIntervalo;
            private float valorFuncion;
            private int multiplicador;
            private int DOF;
            private float valorFuncionDistribucionSimpson;


            /***
             * contructor de la clase 
             * @param numeroSegmento identficador del intervalo
             * @param anchoSegmento ancho del intervalo
             * @param multiplicador número multiplicador del intervalo
             * @param DOF grados de libertad del cálculo
             * @param valorFuncionDistribucionSimpson valor de la distribución
             */
            public ResultData(int numeroSegmento, double anchoSegmento,int multiplicador, int DOF,double valorFuncionDistribucionSimpson)
            {
                this.numeroSegmento = numeroSegmento;
                this.anchoSegmento = (float)anchoSegmento;
                this.anchoSegmentoIntervalo = (float)anchoSegmento * this.numeroSegmento;
                this.valorFuncion = (float)valorFuncionDistribucionSimpson;
                this.multiplicador = multiplicador;
                this.DOF = DOF;
                this.valorFuncionDistribucionSimpson = (float)valorFuncionDistribucionSimpson;
            }

            /***
             * método para el calculo total del intervalo
             * @return valor calculado
             */
            public float valorCalculado()
            {
                return anchoSegmento * this.multiplicador * this.valorFuncionDistribucionSimpson * cosienteIntervaloGradosLibertadElevadoGradosLIbertadSobre2() / 3;
            }

            /***
             * calcula la segunda columna del ejemplo del requerimiento
             * @return valor calculado
             */
            protected float cosienteIntervaloGradosLibertad()
            {
                float valorTmp = (float)Math.pow(this.anchoSegmentoIntervalo,2.0) / (float)this.DOF;
                return (float)(1 + valorTmp);
            }

            /***
             * calcula la tercera columna del ejemplo del requerimiento
             * @return calor calculado
             */
            protected float cosienteIntervaloGradosLibertadElevadoGradosLIbertadSobre2() 
            {
                float valorTmp1 = this.cosienteIntervaloGradosLibertad();
                float valorTmp2 = ((-1)*(((float)this.DOF + 1)/ 2));
                return (float)Math.pow(valorTmp1,valorTmp2 );
            }
    }
