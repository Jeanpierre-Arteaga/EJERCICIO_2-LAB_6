package LABORATORIO_06.EJERCICIO_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaTriangulo {
    // CREAMOS E INICIALIZAMOS EL SCANNER PARA USARLO EN EL PROGRAMA
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // LEEMOS CADA UNO DE LOS LADOS DEL TRIANGULO
        double a = leerLado("Introduzca el lado a: ");
        double b = leerLado("Introduzca el lado b: ");
        double c = leerLado("Introduzca el lado c: ");

        // INSTANCIAMOS UN OBJETO DE LA CLASE TRIANGULO
        Triangulo t1 = new Triangulo(a, b, c);

        // INTENTAMOS UTILIZAR EL METODO PARA CALCULAR EL AREA DEL TRIANGULO
        // CONTROLANDO LA EXCEPCION QUE HEMOS CREADO
        try{
            System.out.println("El area del triangulo es: "+t1.calcularArea());
        
            // SI SE LANZA LA EXCEPCION, ENTONCES SE CAPTURA Y SE IMPRIME UN MENSAJE
        } catch(FormacionTrianguloException e){
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    // METODO PARA LEER UNO DE LOS LADOS DEL TRIANGULO
    public static double leerLado(String m) {
        double lado;

        // INICIAMOS CON UN BUCLE INFINITO
        while(true) {
            
            // INTENTAMOS LEER UN LADO DEL TRIANGULO
            // CONTROLANDO LA EXCEPCION INPUT MISMATCH EXCEPTION
            try {
                System.out.print(m);
                lado = scanner.nextDouble();
                // EVALUAMOS SI EL VALOR INGRESADO ES POSITIVO
                if(lado>0) {
                    // EN ESTE CASO LEE EL VALOR SATISFACTORIAMENTE
                    // Y ROMPE EL BUCLE WHILE
                    break;  
                } else {
                    // CASO CONTRARIO IMPRIME UN MENSAJE DE ERROR
                    System.out.println("Error: El valor debe ser mayor que cero.");
                }

            // SI SE LANZA UNA EXCEPCION, ENTONCES SE CAPTURA Y SE IMPRIME UN MENSAJE
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un valor numérico válido.");
                scanner.nextLine();
            }
        }
        return lado;
    }
}