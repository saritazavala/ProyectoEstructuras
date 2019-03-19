/*
Sara Zavala 18893
Alexa Bravo  18831
Andres Quinto 18288
Renato Estrada  181099
Proyecto Estructuras de Datos
Interprete Lisp
Marzo de 2019
* */


import java.util.*;

/**
 *@author user
 */
//Referencia de la idea: http://norvig.com/lispy.html
public class OperacionesAritmeticas {

    private LinkedList<String> definiciones = new LinkedList<>(); //LinkedList creada
    private Stack<String> subDefiniciones = new Stack<>(); // Stack Strings
    private char[] parser; //Parser, lista de chars
    private int contador; // Contador
    private String numeroDosDigitos = ""; //Para revisar si es un numero de dos digitos
    private int resultado = 0; // Resultado de las operaciones

    /**
     * @param procedimiento
     */
    public OperacionesAritmeticas(String procedimiento){ //Operaciones Aritmeticas
        parser = procedimiento.toCharArray(); //Parser va a ser un char array que va a separar caracter por caracter
        contador = 0;
        hacerOperacionesAritmeticas();
    }

    /**
     *
     */
    private void hacerOperacionesAritmeticas() { //Metodo que realiza una operacion aritmetica dentro de un parentesis
        switch (parser[contador]){//va  a ir cambiando el contador y se va a ir con el switch viendo que tipo de operacion es
            case '+': definiciones.addFirst("+"); break;
            case '-': definiciones.addFirst("-"); break;
            case '*': definiciones.addFirst("*"); break;
            case '/': definiciones.addFirst("/"); break;
            case ')': try{ resultadoRecursivo();}catch (Exception e){}break;
            default: if(Character.isDigit(parser[contador])){
                if(Character.isDigit(parser[contador + 1])){// Si es un digito lo va a separar y se le va agregando a la posicion contador +1
                    numeroDosDigitos = Character.toString(parser[contador]) + Character.toString(parser[contador + 1]);// Verifica si es un numero de 2 digitos
                    contador++; //contador++

                    definiciones.addFirst(numeroDosDigitos); //Se va agregando el numero a nuestra LinkedList
                    break;
                }else{
                    definiciones.addFirst(Character.toString(parser[contador])); //Se convierte de caracter a String y se apregar al parser en la poscion contador
                }

                break; //Break
            }
        }
        contador++;

        if(contador == parser.length){
            System.out.println(resultado);
            return; //Cuando el contador sea = al larfgo de nuestro parser, que es un array se va a printear
        }else{
            hacerOperacionesAritmeticas(); // si no se cumple, se va a operar la operacion
        }
    }

    /**
     * Recursividad en operar y encontrar el resultado de las operaciones
     */
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

    /**
     * Metodo para obtener el resultado de las subOperaciones
     */
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
