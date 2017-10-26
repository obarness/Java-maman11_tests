/**
 * Created by barne on 10/26/2017.
 */
public class Main {

    static  int testsFailed = 0;
    static StringBuilder sb = new StringBuilder();

    public static void test(int testNumber,String expected, String result){
        if(expected.equals(result)){
        }
        else{
            sb.append(("test number " + testNumber + " failed\n"));
            testsFailed++;
        }
    }

    public static void main(String[] args){
        Rational r1 = new Rational(1,2);
        Rational r2 = new Rational(2,4);
        Rational r3 = new Rational(2,5);
        Rational r4 = new Rational(10,49);

        int testNumber = 1;

        //test constructor & to string
        test(testNumber++, "1/2", r1.toString() );
        test(testNumber++, "2/4", r2.toString() );
        test(testNumber++, "2/5", r3.toString() );
        test(testNumber++, "10/49", r4.toString() );

        //test reduce
        test(testNumber++, "1/2", r2.reduce().toString());
        test(testNumber++, "1/2", r1.reduce().toString());
        test(testNumber++, "2/5", r3.reduce().toString());
        test(testNumber++, "10/49", r4.reduce().toString());


        //test plus

        test(testNumber++, "1/1", r2.plus(r1).reduce().toString());
        test(testNumber++, "9/10", r2.plus(r3).reduce().toString());
        test(testNumber++, "9/10", r3.plus(r2).reduce().toString());
        test(testNumber++, "69/98", r4.plus(r1).reduce().toString());

        //test minus
        test(testNumber++, "0/1", r1.minus(r1).reduce().toString());
        test(testNumber++, "0/1", r1.minus(r2).reduce().toString());
        test(testNumber++, "-1/10", r3.minus(r2).reduce().toString());
        test(testNumber++, "0/1", r4.minus(r3).reduce().toString());

        //test multiply


        //test equals

        //test greaterThan

        //test greaterThan

        //test greaterThan

        //test greaterThan



        sb.insert(0, "total number of tests failed: " + testsFailed  + "\n" );
        sb.insert(0, "total number of tests passed: " + (testNumber - 1 - testsFailed) + "\n");
        sb.insert(0, "total number of tests: " + (testNumber -1) + "\n");
        System.out.println(sb);
    }




}
