/*
Sara Zavala 18893
Proyecto Estructuras de Datos
Interprete Lisp
Marzo de 2019
* */
public class Condicionales {

    String operaciones;
    Predicados p = new Predicados();
    String operador = "";

    public Condicionales(String o){
        evaluarCondicionales(o);
    }
    public void evaluarCondicionales(String o) {
        operaciones  = o.substring(1, o.indexOf(" "));
        o = o.substring( o.indexOf(" ") + 1);
        operaciones = o.substring(1, o.indexOf(")"));
        String a = "";
        String b = "";
        String operacion = "";
        String[] operandos =operaciones.split(" ");
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
        for (int i = 0; i < operaciones.length(); i++) {


            if(operaciones.contains(">")){
                System.out.println(p.mayorMenor((Integer.parseInt(a)),Integer.parseInt(b)));
                break;
            }

            if(operaciones.contains("<")){
                System.out.println(p.menorMayor((Integer.parseInt(a)),Integer.parseInt(b)));
                break;
            }

            if(operaciones.contains("=")){
                System.out.println(p.equals((Integer.parseInt(a)),Integer.parseInt(b)));
                break;
            }

            if(operaciones.contains("Equal")){
                System.out.println(p.equals((Integer.parseInt(a)),Integer.parseInt(b)));
                break;
            }

            if(operaciones.contains("Atom")){
                System.out.println(p.atom(o));
                break;
            }

            if(operaciones.contains("List")){
                System.out.println(p.lista(o));
                break;
            }

        }
    }
}
