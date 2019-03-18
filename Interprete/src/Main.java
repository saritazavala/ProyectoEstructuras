/*
Sara Zavala 18893
Proyecto Estructuras de Datos
Interprete Lisp
Marzo de 2019
* */

public class Main {
    public static void main(String[] args) {

/*
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una operacion");
        String operacion = leer.nextLine();

        Interprete interprete = new Interprete();
        interprete.operacionesAritmeticas(operacion);

    */

        //OperacionesAritmeticas o = new OperacionesAritmeticas("(+ 2 (* (+ 3 4 5)4) (- 6 4 1))");
        Analizador a = new Analizador();
        a.definirFunciones("(Defun Suma (a,b) (+ (+ a b) b )))");
        a.realizarFunciones("(Suma 3 4)");
        //  o.obtenerResultado();
        /**
         Stack<String> operaciones = new Stack<>();
         Queue<Character> digitos = new LinkedList<>();

         Scanner leer = new Scanner(System.in);
         String aritmetica = leer.nextLine();
         String operacion;
         char[] chars = aritmetica.toCharArray();
         int size = chars.length;
         int i = 1;
         while (i <  size){
         operacion = "";
         while (chars[i] != '(' && chars[i] != ')'){
         operacion += chars[i];
         i++;
         }
         if(!operacion.equals(" ") && !(operacion.equals("")) ){
         operaciones.push(operacion);
         }


         i++;
         }

         operaciones.forEach(s -> {
         System.out.println(s);
         });
         **/



    }
}