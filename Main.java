/**
 * Created by barne on 10/26/2017.
 */
public class Main {

    static  int testsFailed = 0;
    static int testNumber = 1;
    static StringBuilder sb = new StringBuilder();

    public static void test(String expected, String result){
        if(expected.equals(result)){
            testNumber++;
        }
        else{
            sb.append(("test number " + testNumber++ + " failed\n"));
            testsFailed++;
        }
    }

    public static void main(String[] args){
        Rational r1 = new Rational(1,2);
        Rational r2 = new Rational(2,4);
        Rational r3 = new Rational(2,5);
        Rational r4 = new Rational(10,49);



        //test constructor & to string
        test( "1/2", r1.toString() );
        test( "2/4", r2.toString() );
        test( "2/5", r3.toString() );
        test( "10/49", r4.toString() );

        //test reduce
        test( "1/2", r2.reduce().toString());
        test( "1/2", r1.reduce().toString());
        test( "2/5", r3.reduce().toString());
        test( "10/49", r4.reduce().toString());


        //test plus

        test("1/1", r2.plus(r1).reduce().toString());
        test("9/10", r2.plus(r3).reduce().toString());
        test("9/10", r3.plus(r2).reduce().toString());
        test("69/98", r4.plus(r1).reduce().toString());

        //test minus
        test("0/1", r1.minus(r1).reduce().toString());
        test("0/1", r1.minus(r2).reduce().toString());
        test("-1/10", r3.minus(r2).reduce().toString());
        test("-48/245", r4.minus(r3).reduce().toString());

        test("1/4", r1.multiply(r1).reduce().toString());
        test("1/4", r1.multiply(r2).reduce().toString());
        test("1/5", r3.multiply(r2).reduce().toString());
        test("1/5", r2.multiply(r3).reduce().toString());
        test("4/49", r4.multiply(r3).reduce().toString());

        //test equals
        test("true", String.valueOf(r1.equals(r1)));
        test("true", String.valueOf(r1.equals(r2)));
        test("false", String.valueOf(r1.equals(r4)));
        test("false", String.valueOf(r1.equals(r3)));

        //test greaterThan
        test("false", String.valueOf(r1.greaterThan(r1)));
        test("false", String.valueOf(r1.greaterThan(r2)));
        test("true", String.valueOf(r1.greaterThan(r3)));
        test("true", String.valueOf(r1.greaterThan(r4)));



        sb.insert(0, "total number of tests failed: " + testsFailed  + "\n" );
        sb.insert(0, "total number of tests passed: " + (testNumber - 1 - testsFailed) + "\n");
        sb.insert(0, "total number of tests: " + (testNumber -1) + "\n");
        System.out.println(sb);
    }




}
