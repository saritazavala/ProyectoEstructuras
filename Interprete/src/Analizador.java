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
    private Stack<Funciones> funciones = new Stack<>();
    private Stack<String> operaciones = new Stack<>();
    private Stack<Integer> valorParametros = new Stack<>();
    private boolean existeOperacion = false;
    private String nombreFuncion;
    private String parametros;
    private int cantidadParametros;
    private String[] separarParametros;
    private String funcionesARealizar;
    private String definicionFuncion;
    private int cantidadOperaciones;
    private String[] separarOperaciones;

    public void definirFunciones(String funciones){
        ParserDefinirFunciones(funciones);
        this.funciones.push(new Funciones(definicionFuncion, nombreFuncion, parametros, funcionesARealizar, cantidadOperaciones, cantidadParametros));
    }

    public void realizarFunciones(String funcion){
        for (int i = 0; i < funcion.length() ; i++) {
            if(Character.isDigit(funcion.charAt(i))){
                valorParametros.push(Integer.parseInt(Character.toString(funcion.charAt(i))));
            }
        }
        funciones.pop().realizarFuncion(valorParametros);
    }


    //Referencia: Idea de substring obtenido aqui https://www.javatpoint.com/java-string-substring
    public void ParserDefinirFunciones(String funcion){
        int limite = funcion.indexOf(" ") + 1;

        //Obtiene los caracteres de mi string funcion desde la posicion cero hasta la posicion donde se encuentre un espacio vacio
        definicionFuncion = funcion.substring(0, limite);

        limite = funcion.indexOf(" ") + 1;
        //Reasigna la palabra desde el punto de inicio indicado, en este caso es desde el primer espacio vacio
        funcion = funcion.substring(limite);

        limite = funcion.indexOf(" ") + 1;
        //Toma el nombre de la funcion desde el inicio del String hasta donde encuentre un espacio vacio
        nombreFuncion = funcion.substring(0, limite);

        limite = funcion.indexOf(" ") + 1;
        //Reasigna la palabra desde el punto donde hay un espacio vacio
        funcion = funcion.substring(limite);

        limite = funcion.indexOf(")") + 1;
        //Toma los parametros de la funcion, indicandole que va desde  cero hasta donde encuentre un parentesis cerrado
        parametros = funcion.substring(0, limite);

        limite = funcion.indexOf(")") + 1;
        //Reasigna la palabra desde el punto donde hay un parentesis cerrado, adelante del mismo.
        funcion = funcion.substring(limite);

        limite = funcion.indexOf(" ") + 1;
        //Obtiene todas las funciones que se emplearan en la funcion
        funcionesARealizar = funcion.substring(limite);

        separarParametros = parametros.split(",");
        cantidadParametros = separarParametros.length;

        separarOperaciones = funcionesARealizar.split("\\)");
        cantidadOperaciones = separarOperaciones.length;
    }
}
