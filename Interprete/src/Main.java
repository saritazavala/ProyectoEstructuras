import java.util.*;

public class Main {
    public static void main(String[] args) {


        Scanner leer = new Scanner(System.in);
        String operacion = leer.nextLine();

        Interprete interprete = new Interprete();
        interprete.operacionesAritmeticas(operacion);



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