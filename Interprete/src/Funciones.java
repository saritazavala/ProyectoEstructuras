/*
Sara Zavala 18893
Proyecto Estructuras de Datos
Interprete Lisp
Marzo de 2019
* */
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Stack;

public class Funciones {
    private String nombre;
    private String definicion;
    private String parametros;
    private String operaciones;
    private int cantidadParametros;
    private int cantidadOperaciones;
    private Stack<Integer> valores = new Stack<>();
    private Stack<String> operacion = new Stack<>();

    public Funciones(String definicion, String nombre, String parametros, String operaciones, int cantidadOperaciones, int cantidadParametros){
        this.definicion = definicion;
        this.nombre = nombre;
        this.parametros = parametros;
        this.operaciones = operaciones;
        this.cantidadParametros = cantidadParametros;
        this.cantidadOperaciones = cantidadOperaciones;
        System.out.println(operaciones.indexOf(")"));
        System.out.println("Funcion creada: ");
        System.out.println(definicion + nombre + parametros + operaciones);


    }
    public void realizarFuncion(Stack<Integer> valores){
        if(valores.size() > cantidadParametros){
            System.out.println("Hay demasiados valores en los parametros");
        }else{
            this.valores = valores;
            realizarFuncion();
        }


    }

    public void realizarFuncion(){


        for (int j = 0; j < operaciones.length() ; j++) {
            if(operaciones.charAt(j) != ' ' && operaciones.charAt(j) != '+' && operaciones.charAt(j) != ')' && operaciones.charAt(j) != '(' && operaciones.charAt(j) != '*'
                    && operaciones.charAt(j) != '/' && operaciones.charAt(j) != '-' && !Character.isDigit(operaciones.charAt(j))){ //fix this
                operaciones = operaciones.replace(Character.toString(operaciones.charAt(j)), valores.pop().toString());
            }

        }
        operacion.push(operaciones);
        //System.out.println(operacion.pop());\
        if(operacion.peek().contains("+") || operacion.peek().contains("-") || operacion.peek().contains("*") || operacion.peek().contains("/")){
            new OperacionesAritmeticas(operacion.pop());
        }else if(operacion.peek().contains("COND")){
            new Condicionales(operacion.pop());
        }

        if(operacion.size() > 0){
            realizarFuncion();
        }else{
            return;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public int getCantidadParametros() {
        return cantidadParametros;
    }

    public void setCantidadParametros(int cantidadParametros) {
        this.cantidadParametros = cantidadParametros;
    }

    public Stack<Integer> getValores() {
        return valores;
    }

    public void setValores(Stack<Integer> valores) {
        this.valores = valores;
    }

    public Stack<String> getOperacion() {
        return operacion;
    }

    public void setOperacion(Stack<String> operacion) {
        this.operacion = operacion;
    }
}
