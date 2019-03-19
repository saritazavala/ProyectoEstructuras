import org.junit.jupiter.api.Test;

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

    






}