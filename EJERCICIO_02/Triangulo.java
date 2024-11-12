package LABORATORIO_06.EJERCICIO_02;

public class Triangulo{
    // ATRIBUTOS
    // CONSTA DE LOS LADOS Y EL SEMIPERIMETRO
    private double a;
    private double b;
    private double c;
    private double s;

    //CONSTRUCTOR
    public Triangulo(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
        // UTILIZAMOS ESTE METODO PARA ASIGNAR EL VALOR 
        // AL SEMIPERIMETRO
        calcularSemiperimetro();
    }

    //MÉTODO PARA HALLAR EL SEMIPERIMETRO DEL TRIANGULO    
    private void calcularSemiperimetro(){
        s = (a + b + c) / 2;
    }

    // METODO PARA DAR UN FORMATO DE SALIDA
    public String toString(){
        return "lados: " + a + " , " + b + " , " + c;
    }

    //MÉTODO PARA HALLAR EL ÁREA DEL TRIANGULO
    public double calcularArea() throws FormacionTrianguloException{
        // SI CUMPLE CON LA DESIGUALDAD TRIANGULAR ENTONCES EL TRIANGULO EXISTE
        // Y RETORNAMOS EL AREA
        if ((a + b > c) && (a + c > b) && (b + c > a)){
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            return area;
        }
        // SI NO SE CUMPLE ENTONCES NO EXISTE EL TRIANGULO
        // LANZAMOS UNA EXCEPCION Y UN MENSAJE 
        else{
            throw new FormacionTrianguloException("El triangulo de "+toString()+" NO EXISTE");
        }
    }
}