import java.util.Random;

public class Main {

    private static double testUF(UF uf, int opCount, boolean debug){
        long startTime = System.nanoTime();
        int size = uf.getSize();
        int a, b;

        Random random = new Random();
        if (debug) System.out.println("test start ->" + startTime / 1000000000.0);
        for (int i = 0; i < opCount; i++) {
            if (debug && i % opCount / 30 == 0) System.out.print(".");
            a = random.nextInt(size);
            b = random.nextInt(size);
            uf.unionEle(a,b);
            if(debug)System.out.println(a+","+b+" is united");
            if(debug)System.out.println("uf ID is "+uf);
        }
        System.out.println("union done");

        for (int i = 0; i < opCount; i++) {
            if (debug && i % opCount / 30 == 0) System.out.print(".");
            a = random.nextInt(size);
            b = random.nextInt(size);
            boolean res=uf.isConnected(a,b);
            if(debug)System.out.println(a+","+b+" isConnected: "+res);
        }
        System.out.println("check connected done");
        long endTime =System.nanoTime();
        if(debug) System.out.println("\ntest ended ->" +endTime/1000000000.0);
        return (endTime - startTime) /1000000000.0;
    }
    public static void main(String[] args) {
	// write your code here
        int size = 100000000;
        int opCount = 100000000;
        boolean debug = false;
//        UF1 uf1 = new UF1(size);
//        UF2 uf2 = new UF2(size);
        UF3 uf3 = new UF3(size);
        UF4 uf4 = new UF4(size);
        UF5 uf5 = new UF5(size);
        UF6 uf6 = new UF6(size);
        double time;

        /*
        time = testUF(uf1, opCount, true);
        System.out.println(time+"s");
         */
//        opCount = 10000;
//        time = testUF(uf1, opCount, debug);
//        System.out.println(time+"s");
//        time = testUF(uf2, opCount, debug);
//        System.out.println(time+"s");
        time = testUF(uf3, opCount, debug);
        System.out.println(time+"s");
        time = testUF(uf4, opCount, debug);
        System.out.println(time+"s");
        time = testUF(uf5, opCount, debug);
        System.out.println(time+"s");
        time = testUF(uf6, opCount, debug);
        System.out.println(time+"s");
    }
}
