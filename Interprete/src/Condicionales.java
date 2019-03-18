/*
Sara Zavala 18893
Proyecto Estructuras de Datos
Interprete Lisp
Marzo de 2019
* */
public class Condicionales {

    String[] operaciones;
    Predicados p = new Predicados();
    String operador = "";

    public Condicionales(String o){
        evaluarCondicionales(o);
    }
    public void evaluarCondicionales(String o) {
        operaciones  = o.split("\\(");
        String a = "";
        String b = "";
        String operacion = "";
        String[] operandos = o.split(" ");
        String operando = "";

        for (int i = 0; i <  operandos.length; i++) {
            if(!operandos[i].equals("")){
                if(Character.isDigit(operandos[i].charAt(0))){ //gotta work on this
                    if(a.equals("")){
                        a = Character.toString(operandos[i].charAt(0));
                    }else{
                        b = Character.toString(operandos[i].charAt(0));
                    }
                }
            }

        }
        for (int i = 0; i < operaciones.length; i++) {


            if(operandos[i].contains(">")){
                System.out.println(p.mayorMenor((Integer.parseInt(a)),Integer.parseInt(b)));
            }

            if(operandos[i].contains("<")){
                System.out.println(p.menorMayor((Integer.parseInt(a)),Integer.parseInt(b)));
            }

            if(operandos[i].contains("=")){
                System.out.println(p.equals((Integer.parseInt(a)),Integer.parseInt(b)));
            }

            if(operaciones[i].contains("Equal")){
                System.out.println(p.equals((Integer.parseInt(a)),Integer.parseInt(b)));
            }

        }
    }
}
