/*
Sara Zavala 18893
Alexa Bravo  18831
Andres Quinto 18288
Renato Estrada  181099
Proyecto Estructuras de Datos
Interprete Lisp
Marzo de 2019
* */
import java.util.LinkedList;

public class Predicados<E extends Comparable<Integer> > {

    LinkedList<String> listas = new LinkedList<>(); //Linked List para mis predicados


    public Predicados(){
        listas.add("(list"); //Se agregan los Strings con el parentesis
        listas.add("(cons");
        listas.add("'(");
    }

    //Metodo para hacer equals. El mas facil JAJA
    public boolean equals(E valorA, E valorB){ //Tenemos 2 genericos y si son iguales regresa true, sino false
        return  valorA.equals(valorB);
    }
    //Metodo mayor que. Funciona solo con numeros (ints) devuelve true o false
    public Boolean mayorMenor(int valorA, int valorB ){
        if(valorA > valorB){
            return true;
        }else{
            return false;
        }
    }
    //Metodo menor que. Funciona con numeros (ints) devuelve true o false
    public Boolean menorMayor(int valorA, int valorB ){
        if(valorA < valorB){
            return true;
        }else{
            return false;
        }
    }

    //Booleano para decirme si es atom o no
    public boolean atom(String valor){
        boolean esAtom = true; //Boolenado true
        for (int i = 0; i <listas.size() ; i++) { //Se recorre la lista conforme a su tamaño
            if(valor.contains("list") || valor.contains("cons") || valor.contains("'(")) { //Si contiene list, cons o una '  va a devolver false
                return esAtom = false;
            }
        }

        return esAtom;//De lo contrario se regresa el booleano original
    }
    //Tiene la misma logica que el del atoms
    public  boolean lista(String valor){
        boolean esLista = false; //Bolleado esLista
        for (int i = 0; i <listas.size() ; i++) { //Se recorre la lista
            if(valor.contains("(list") || valor.contains("(cons") || valor.contains("'(")) { //Si contiene list, cons o una '  va a devolver TRUE
                return esLista = true;
            }
        }

        return esLista; //De lo contrario se regresa el booleano original
    }


}
