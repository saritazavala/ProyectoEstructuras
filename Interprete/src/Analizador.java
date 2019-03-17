/*
Sara Zavala 18893
Proyecto Estructuras de Datos
Interprete Lisp
Marzo de 2019
* */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Analizador {
    Stack<Funciones> funciones = new Stack<>();
    Stack<String> operaciones = new Stack<>();
    Stack<Integer> valorParametros = new Stack<>();
    boolean existeOperacion = false;

    public void definirFunciones(){
        operaciones.push("(COND (> 3 2))");
        valorParametros.push(2);
        valorParametros.push(3);
        funciones.push(new Funciones("Sumar", "(a,b)", 2, valorParametros, operaciones));
    }

    public void realizarFunciones(String funcion){
        for (int i = 0; i < funciones.size(); i++) {
            if(funciones.get(i).getNombre().equals(funcion)){
                funciones.remove(i).realizarFuncion();
                existeOperacion = true;
            }
        }
        if(existeOperacion == false){
            System.out.println("No existe ninguna funcion con ese nombre");
        }
    }

    String[] parser;
    String[] divisorNombre;
    String nombreFuncion;
    String[] parametros;
    public void Parser(String funcion){
        parser = funcion.split(" ");
        divisorNombre = parser[1].split(" ");
        parametros = parser[2].split(",");
        for (int i = 0; i < parser.length ; i++) {
            System.out.println(parser[i]);
        }
        nombreFuncion = divisorNombre[1];
        System.out.println(nombreFuncion);
    }
}
