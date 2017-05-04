package edu.uniandes.ecos.ASE.app;
import com.google.gson.reflect.TypeToken;
import edu.uniandes.ecos.ASE.Business.DistribucionT;
import edu.uniandes.ecos.ASE.Business.LinealRegressionCalculator;
import edu.uniandes.ecos.ASE.Business.Operation;
import edu.uniandes.ecos.ASE.Business.PredictionInterval;
import edu.uniandes.ecos.ASE.Business.Significancia;
import edu.uniandes.ecos.ASE.Business.Statistic;
import edu.uniandes.ecos.ASE.DTO.Resultado;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

 /**
* <h1>App</h1>
* Clase orquesta los llamados desde el servicio
*
* @author Juan Pablo Ospino Solano
* @version 1.0
* @since   2017-05-01
*/
public class App 
{
    /***
     * Método principal del programa
     * @param args valores del llamado
     */
    public static void main( String[] args )
    {
        if(args.length > 1)
        {
            String jSON = args[0];
            Operation operation = Operation.valueOf(args[1]) ;
            int tamanhoProxy = Integer.parseInt(args[2]) ;
            
            System.out.println(Calculo(jSON, operation, tamanhoProxy));
            return ;
        }        
        
        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
        
        get("/calculoCorrelacionSignificancia",  "application/json", (req, res) -> {
//            "[{programID:1,estimatedProxySize:1.0,planAddedModifiedSize:1.0,actualAddedModifiedSize:1.0,actualDevelopmentTime:1.0},"
//            + "{programID:2,estimatedProxySize:3.0,planAddedModifiedSize:1.2,actualAddedModifiedSize:1.0,actualDevelopmentTime:1.0}]";
//                  
//            String jSON = "[{ \"programID\": 1, \"estimatedProxySize\": 130, \"planAddedModifiedSize\": 163, \"actualAddedModifiedSize\": 186, \"actualDevelopmentTime\": 15.000000 },{ \"programID\": 2, \"estimatedProxySize\": 650, \"planAddedModifiedSize\": 765, \"actualAddedModifiedSize\": 699, \"actualDevelopmentTime\": 69.900000 },{ \"programID\": 3, \"estimatedProxySize\": 99, \"planAddedModifiedSize\": 141, \"actualAddedModifiedSize\": 132, \"actualDevelopmentTime\": 6.500000 },{ \"programID\": 4, \"estimatedProxySize\": 150, \"planAddedModifiedSize\": 166, \"actualAddedModifiedSize\": 272, \"actualDevelopmentTime\": 22.400000 },{ \"programID\": 5, \"estimatedProxySize\": 128, \"planAddedModifiedSize\": 137, \"actualAddedModifiedSize\": 291, \"actualDevelopmentTime\": 28.400000 }," 
//                          + "{ \"programID\": 6, \"estimatedProxySize\": 302, \"planAddedModifiedSize\": 35, \"actualAddedModifiedSize\": 331, \"actualDevelopmentTime\": 65.900000 },{ \"programID\": 7, \"estimatedProxySize\": 95, \"planAddedModifiedSize\": 136, \"actualAddedModifiedSize\": 199, \"actualDevelopmentTime\": 19.400000 },{ \"programID\": 8, \"estimatedProxySize\": 945, \"planAddedModifiedSize\": 1206, \"actualAddedModifiedSize\": 1890, \"actualDevelopmentTime\": 198.700000 },{ \"programID\": 9, \"estimatedProxySize\": 368, \"planAddedModifiedSize\": 433, \"actualAddedModifiedSize\": 788, \"actualDevelopmentTime\": 38.800000 },{ \"programID\": 10, \"estimatedProxySize\": 961, \"planAddedModifiedSize\": 1130, \"actualAddedModifiedSize\": 1601, \"actualDevelopmentTime\": 138.200000 }]";
//            //Operation operation = Operation.EPSAAM;
//            Operation operation = Operation.EPSAAM;
//            int tamanhoProxy = 386;
//            
            return Calculo(req.queryParams("tablaValor").toString() , 
                                Operation.valueOf(req.queryParams("tipoCalculo").toString()), 
                                Integer.parseInt(req.queryParams("tamanhoProxy").toString()));
        });
    }
    
    public static String Calculo(String jSON, Operation operation, int tamanhoProxy)
    {
            com.google.gson.Gson gson = new com.google.gson.Gson();
            Type listType = new TypeToken<ArrayList<Statistic>>(){}.getType();
            List<Statistic> statistics = gson.fromJson(jSON, listType);
            
            LinealRegressionCalculator linealRegressionCalculator = new LinealRegressionCalculator();
            for(Statistic statistic : statistics)
            {
                linealRegressionCalculator.addStatictics(statistic);
            }
          
            edu.uniandes.ecos.ASE.DTO.LinearRegressionCalc valCalc = null; 
            switch(operation)
            {
                // Proxy size and actuañ added and midified size
                case EPSADT:
                    valCalc = linealRegressionCalculator.EPSADT(tamanhoProxy);
                    break;
                case EPSAAM:
                    valCalc = linealRegressionCalculator.EPSAAM(tamanhoProxy);
                    break;
                default:
                    return "Error en la selección de la operación";
            }         
            
            double x = new Significancia(valCalc.getR_xy(), statistics.size()).CalcularX();
                float significancia = ((float)0.5 - DistribucionT.calculoDistribucionResultado(x, statistics.size() - 2 , (float)0.00000001)) * 2;
            float t = DistribucionT.calculoX((float)0.35, statistics.size() - 2 );
            PredictionInterval predictionInterval = new PredictionInterval(statistics.size() - 2, (float)valCalc.getB0(), (float)valCalc.getB1(), statistics, tamanhoProxy,operation);
            
            float range = predictionInterval.CalcularRango(t);
            
            Resultado resultado = new Resultado();
            resultado.B0 = (float)valCalc.getB0() ;
            resultado.B1 = (float)valCalc.getB1() ;
            resultado.UPI = (float)valCalc.getY_k() - (float)range;
            resultado.LPI = (float)valCalc.getY_k() + (float)range;
            resultado.RANGE = range;
            resultado.r_2 = (float)valCalc.getR_pow_2();
            resultado.r_xy = (float)valCalc.getR_xy();
            resultado.significance = significancia;
            resultado.yk = (float)valCalc.getY_k();
            
            return gson.toJson(resultado);      
    }
}
