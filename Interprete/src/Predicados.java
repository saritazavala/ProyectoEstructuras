/*
Sara Zavala 18893
Proyecto Estructuras de Datos
Interprete Lisp
Marzo de 2019
* */
import java.util.LinkedList;

public class Predicados<E extends Comparable<Integer> > {

    LinkedList<String> listas = new LinkedList<>();


    public Predicados(){
        listas.add("(list");
        listas.add("(cons");
        listas.add("'(");
    }

    public boolean equals(E valorA, E valorB){
        return  valorA.equals(valorB);
    }

    public Boolean mayorMenor(int valorA, int valorB ){
        if(valorA > valorB){
            return true;
        }else{
            return false;
        }
    }

    public Boolean menorMayor(int valorA, int valorB ){
        if(valorA < valorB){
            return true;
        }else{
            return false;
        }
    }


    public boolean atom(String valor){
        boolean esAtom = true;
        for (int i = 0; i <listas.size() ; i++) {
            if(valor.startsWith("(list") || valor.startsWith("(cons") || valor.startsWith("'(")) {
                return esAtom = false;
            }
        }

        return esAtom;
    }

    public  boolean lista(String valor){
        boolean esLista = false;
        for (int i = 0; i <listas.size() ; i++) {
            if(valor.startsWith("(list") || valor.startsWith("(cons") || valor.startsWith("'(")) {
                return esLista = true;
            }
        }

        return esLista;
    }


}
