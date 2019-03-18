/*
Sara Zavala 18893
Proyecto Estructuras de Datos
Interprete Lisp
Marzo de 2019
* */
//(* 2 5)
//(Cond (< 3 2))
//(< 2 3)
//(Defun multi (a,b) (* a b))
//(multi 3 2)

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Analizador analizador = new Analizador();
        Condicionales condicionales;
        OperacionesAritmeticas operacionesAritmeticas;
        while (true) {
            System.out.print("Lisp> ");
            String operacion = leer.nextLine();
            if(operacion.contains("Defun")){
                analizador.definirFunciones(operacion);
            }else if(operacion.contains("Cond")){
                condicionales = new Condicionales(operacion);
            }else if (operacion.contains("+") || operacion.contains("-") || operacion.contains("*") || operacion.contains("/")){
                operacionesAritmeticas = new OperacionesAritmeticas(operacion);
            }else if(operacion.contains("<") || operacion.contains(">") || operacion.contains("Atom") || operacion.contains("List") || operacion.contains("Equal")){
                condicionales = new Condicionales("(Cond " + operacion + ")");
            }else{
                analizador.realizarFunciones(operacion);
            }
        }
    }
}