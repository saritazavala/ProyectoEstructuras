/*
Sara Zavala 18893
Proyecto Estructuras de Datos
Interprete Lisp
Marzo de 2019
* */


import java.util.*;

//Referencia de la idea: http://norvig.com/lispy.html
public class OperacionesAritmeticas {

    private LinkedList<String> definiciones = new LinkedList<>();
    private Stack<String> subDefiniciones = new Stack<>();
    private char[] parser;
    private int contador;
    private String numeroDosDigitos = "";
    private int resultado = 0;

    public OperacionesAritmeticas(String procedimiento){
        parser = procedimiento.toCharArray();
        contador = 0;
        hacerOperacionesAritmeticas();
    }
    private void hacerOperacionesAritmeticas() {
        switch (parser[contador]){
            case '+': definiciones.addFirst("+"); break;
            case '-': definiciones.addFirst("-"); break;
            case '*': definiciones.addFirst("*"); break;
            case '/': definiciones.addFirst("/"); break;
            case ')': try{ resultadoRecursivo();}catch (Exception e){}break;
            default: if(Character.isDigit(parser[contador])){
                if(Character.isDigit(parser[contador + 1])){
                    numeroDosDigitos = Character.toString(parser[contador]) + Character.toString(parser[contador + 1]);
                    contador++;

                    definiciones.addFirst(numeroDosDigitos);
                    break;
                }else{
                    definiciones.addFirst(Character.toString(parser[contador]));
                }

                break;
            }
        }
        contador++;
        //definiciones.forEach(s -> System.out.println(s));
        if(contador == parser.length){
            System.out.println(resultado);
            return;
        }else{
            hacerOperacionesAritmeticas();
        }
    }

    private void resultadoRecursivo(){
        if(!definiciones.peekFirst().equals("+") && !definiciones.peekFirst().equals("-") && !definiciones.peekFirst().equals("*")
                && !definiciones.peekFirst().equals("/")){
            subDefiniciones.push(definiciones.removeFirst());
            resultadoRecursivo();
        }else{
            resultado = Integer.parseInt(subDefiniciones.pop());
            subResultado();

            definiciones.remove(0);
            definiciones.addFirst(String.valueOf(resultado)); //6

            return;
        }

    }

    private void subResultado(){
        if(subDefiniciones.size() > 0){
            if(definiciones.get(0).equals("+")){
                resultado += Integer.parseInt(subDefiniciones.pop());
            }else if(definiciones.get(0).equals("-")){
                resultado -= Integer.parseInt(subDefiniciones.pop());
            }else if(definiciones.get(0).equals("*")){
                resultado *= Integer.parseInt(subDefiniciones.pop());
            }else if(definiciones.get(0).equals("/")){
                resultado /= Integer.parseInt(subDefiniciones.pop());
            }
            subResultado();
        }else{
            return;
        }



    }
}
