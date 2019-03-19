import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public  class Test1Test {

    @Test
    public void test(){
        String num = "(+ 1 2)";
        Test1Test prueba = new Test1Test();
        OperacionesAritmeticas nuevo = new OperacionesAritmeticas(num);
        nuevo.getClass();

    }
    @Test
    public void test1(){
        String num = "(* 1 2 3 4 6)";
        Test1Test prueba = new Test1Test();
        num.toCharArray();
        OperacionesAritmeticas nuevo = new OperacionesAritmeticas(num);

    }

    @Test
    public void test2(){
        String num = "(+ (- 10 2) 3)";
        Test1Test prueba = new Test1Test();
        OperacionesAritmeticas nuevo = new OperacionesAritmeticas(num);

    }
    @Test
    public void test3(){
        String num = "(+ (- 10 2) (+ 1 2) (* 3 4) (/ 10 5)(+ 7 1) (- 9 8) 3)";
        Test1Test prueba = new Test1Test();
        OperacionesAritmeticas nuevo = new OperacionesAritmeticas(num);

    }

    @Test

    public void test4(){
        Test1Test prueba = new Test1Test();
        Predicados P = new Predicados();
        System.out.println(P.mayorMenor(1,2));
    }

    @Test

    public void test5(){
        Test1Test prueba = new Test1Test();
        Predicados P = new Predicados();
        System.out.println(P.equals(1,1));
    }

    @Test

    public void test6(){
        Test1Test prueba = new Test1Test();
        Predicados P = new Predicados();
        System.out.println(P.atom("(Atom (< 1 2))"));
    }

    @Test

    public void test7(){
        Test1Test prueba = new Test1Test();
        Predicados P = new Predicados();
        System.out.println(P.lista("(list (1 2 3)"));
    }

    @Test

    public void test8(){
        Test1Test prueba = new Test1Test();
        Predicados P = new Predicados();
        P.listas = new LinkedList();
        P.listas.add(1);
        System.out.println(P.listas);
        P.listas.add(2);
        System.out.println(P.listas);
        P.listas.add(3);
        System.out.println(P.listas);
        System.out.println(P.listas.size());
        P.listas.addFirst(0);
        System.out.println(P.listas);
    }

    @Test

    public void test9(){
        Test1Test prueba = new Test1Test();
        Predicados P = new Predicados();
        P.listas = new LinkedList();
        P.listas.add(1);
        System.out.println(P.listas);
        P.listas.add(2);
        System.out.println(P.listas);
        P.listas.clear();
        System.out.println(P.listas);
        System.out.println(P.listas.size());
        P.listas.add(5);
        System.out.println(P.listas);
        P.listas.addFirst(6);
        System.out.println(P.listas);
        P.listas.addLast(2);
        System.out.println(P.listas);
        System.out.println(P.listas.contains(2));
        P.listas.addLast(19);
        System.out.println(P.listas);
        P.listas.descendingIterator();
    }






}