/*
Sara Zavala 18893
Alexa Bravo  18831
Andres Quinto 18288
Renato Estrada  181099
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

/**
 * @author user
 */
public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Analizador analizador = new Analizador();
        Condicionales condicionales;
        OperacionesAritmeticas operacionesAritmeticas;

    while (true) {
        try {
                System.out.println("Si utilizará parametros por utilice letras en orden alfabetco");
                System.out.println("en minuscula. Gracias");
                System.out.print("Lisp> ");
                String operacion = leer.nextLine();
                if (operacion.contains("Defun")) {
                    analizador.definirFunciones(operacion);
                } else if (operacion.contains("Cond")) {
                    condicionales = new Condicionales(operacion);
                } else if (operacion.contains("+") || operacion.contains("-") || operacion.contains("*") || operacion.contains("/")) {
                    operacionesAritmeticas = new OperacionesAritmeticas(operacion);
                } else if (operacion.contains("<") || operacion.contains(">") || operacion.contains("Atom") || operacion.contains("List") || operacion.contains("Equal")) {
                    condicionales = new Condicionales("(Cond " + operacion + ")");
                } else {
                    analizador.realizarFunciones(operacion);
                }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    }
}