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
    private String parametros;
    private int cantidadParametros;
    private Stack<Integer> valores;
    private Stack<String> operacion;

    public Funciones(String nombre, String parametros, int cantidadParametros, Stack<Integer> valores, Stack<String> operacion){
        this.nombre = nombre;
        this.parametros = parametros;
        this.cantidadParametros = cantidadParametros;
        this.valores = valores;
        this.operacion = operacion;
    }

    public void realizarFuncion(){
        System.out.println(nombre);
        System.out.println(parametros);
        System.out.println("Cantidad de parametros: " + cantidadParametros);
        System.out.println("a: " + valores.pop().toString() + " - " + "b: " + valores.pop());
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
