import com.google.gson.JsonSyntaxException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcionElegida = 0;

        ConsultaConversion consulta = new ConsultaConversion();

        Calculos calculos = new Calculos(consulta);
        GeneradorDeArchivos generador = new GeneradorDeArchivos();

        List<String> respuestas = new ArrayList<>();

        String menu = """
                \n**********************************************************
                ***        Bienvienid@ al Conversor de Monedas         ***
                ***         Seleccione su opción del listado           ***
                **********************************************************
                **                                                      **
                **   1) Peso Argentino --> Dólar Estadounidense         **
                **   2) Dólar Estadounidense --> Peso Argentino         **
                **   3) Euro --> Peso Argentino                         **
                **   4) Real Brasilero --> Peso Argentino               **
                **   5) Libra Esterlina --> Peso Argentino              **
                **   6) Peso Uruguayo --> Peso Argentino                **
                **                                                      **
                **   7) Otra opción de conversión, Elija ambas monedas  **
                **                                                      **
                **   8) Salir de la aplicación                          **
                **********************************************************
                
                Ingrese su opcion de conversion del menú a continuación:""";
        while (opcionElegida != 8) {
            try {
                System.out.println(menu);
                opcionElegida = Integer.parseInt(lectura.nextLine());

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                switch (opcionElegida) {
                    case 1:
                        calculos.almacenarValores("ARS", "USD");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 2:
                        calculos.almacenarValores("USD", "ARS");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 3:
                        calculos.almacenarValores("EUR", "ARS");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 4:
                        calculos.almacenarValores("BRL", "ARS");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 5:
                        calculos.almacenarValores("GBP", "ARS");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 6:
                        calculos.almacenarValores("UYU", "ARS");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 7:
                        calculos.almacenarValoresPersonalizados();
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Ingrese una opción de conversión válida");
                }
            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("Error. Ingrese solo códigos de moneda válidos.");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error. Ingrese un valor numérico válido.");
            }

        }
        generador.guardarJson(respuestas);

        System.out.println("Finalizando programa");
    }
}