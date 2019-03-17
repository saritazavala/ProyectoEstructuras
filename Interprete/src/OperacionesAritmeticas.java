import java.util.LinkedList;
import java.util.Stack;

//Referencia de la idea: http://norvig.com/lispy.html

public class OperacionesAritmeticas {
    LinkedList<String> operaciones = new LinkedList<>();
    LinkedList<Integer> tokens = new LinkedList<>();
    LinkedList<String> operadores = new LinkedList<>();
    char[] parser;

    public void hacerOperacionesAritmeticas(String operacion) {
        String operacionInterna = "";
        int tokensInternos = 0;
        int contadorParentesisInterno = 0;
        operacion = "(+ 5 (+ 1 2 3) (+ (+ 1 2 3) 1) (+ 4 5 6) (+ 7 8 9) 5)".replaceAll("\\s", "");
        parser = operacion.toCharArray();

        for (int i = 1; i < parser.length; i++) {
            if (parser[i] == '(') {
                if(operacionInterna != "" && operacionInterna != "+"){
                    operaciones.add(operacionInterna);
                }
                operacionInterna = Character.toString(parser[i]);


                tokensInternos++;
                tokens.push(tokensInternos);

            } else if (Character.isDigit(parser[i])) {
                operacionInterna += parser[i];

            } else if (parser[i] == '+') {
                if (parser[i + 1] == '(') {
                    tokensInternos = 0;
                    operadores.add(Character.toString(parser[i]));

                } else {

                    operacionInterna += parser[i];
                }

            } else if (parser[i] == '-') {
                operacionInterna += parser[i];
            } else if (parser[i] == '*') {
                operacionInterna += parser[i];
            } else if (parser[i] == '/') {
                operacionInterna += parser[i];
            }
            if (parser[i] == ')') {
                operacionInterna += parser[i];
                if (!operacionInterna.equals(")")) {
                    operaciones.add(operacionInterna);
                    operacionInterna = "";
                }
            }
        }
    }
    int resultadoSuma = 0;
    public void obtenerResultado() {

        String operacion = operaciones.removeFirst();
        String operador = "";
        int numero1 = 0;
        Stack<Integer> numeros = new Stack<>();

        for (int i = operacion.length() - 1; i >= 0; i--) {
            if(Character.isDigit(operacion.charAt(i))){
                numeros.push(Integer.parseInt(Character.toString(operacion.charAt(i))));
            }else if(operacion.charAt(i) == '+'){
                operador = Character.toString(operacion.charAt(i));
            }
        }

        for (int i = 0; numeros.size() > 0 ; i++) {
            int b = numeros.pop();
            int a = 0;
            if(numeros.size() > 0){
                a = numeros.pop();
            }

            resultadoSuma += sumar(a,b);
        }
        System.out.println(resultadoSuma);
        if(operaciones.size() > 0){
            obtenerResultado();

        }
    }

    public int sumar(int a, int b){
        return  a + b;
    }
}
