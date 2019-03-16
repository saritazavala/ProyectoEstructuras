public class Condicionales {

    char[] operaciones;
    Predicados p = new Predicados();
    String operador = "";
    public void realizarCondicional(String o) {
        operaciones = o.toCharArray();

        String operacion = "";
        String a = "";
        String b = "";
        String operando = "";
       /* for (int i = 0; i < condicionales[0].length(); i++) {
            if(condicionales[0].charAt(i) == '>'){
               operacion = p.mayorMenor(a,b).toString();
            }
        }*/
        //System.out.println(operacion);

        for (int i = 0; i <  operaciones.length; i++) {
            if(Character.isDigit(operaciones[i])){ //gotta work on this
                if(a.equals("")){
                    a = Character.toString(operaciones[i]);
                }else{
                    b = Character.toString(operaciones[i]);
                }
            }
        }
        for (int i = 0; i < operaciones.length; i++) {


            if(operaciones[i] == '>'){
                System.out.println(p.mayorMenor((Integer.parseInt(a)),Integer.parseInt(b)));
            }

            if(operaciones[i] == '<'){
                System.out.println(p.menorMayor((Integer.parseInt(a)),Integer.parseInt(b)));
            }

            if(operaciones[i] == '='){
                System.out.println(p.equals((Integer.parseInt(a)),Integer.parseInt(b)));
            }

            if(operaciones[i] == 'a'){

            }

            if(operaciones[i] == 'l'){

            }

        }
    }
}
