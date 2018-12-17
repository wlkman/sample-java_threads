package threads.threadObject.atomicvariables;

import threads.threadObject.hello.HelloRunnable;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariablesExample  {

    public static int c = 0;
    static Counter counter = new Counter();
    static SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
    static AtomicCounter atomicCounter = new AtomicCounter();

    public static class TestLocal implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<20;i++){
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {

                }
                c++;
            }

            System.out.println("TestLocal:              "+c);

        }
    }

    public static class TestCounter implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<20;i++){
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {

                }
                counter.increment();
            }

            System.out.println("TestCounter:            "+counter.value());

        }
    }


    public static class TestSynchronizedCounter implements Runnable{
        @Override
        public void run() {

            for (int i=0;i<20;i++){
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {

                }
                synchronizedCounter.increment();
            }

            System.out.println("TestSynchronizedCounter:"+synchronizedCounter.value());
        }
    }

    public static class TestAtomicCounter implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<20;i++){
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {

                }
                atomicCounter.increment();
            }
            System.out.println("TestAtomicCounter:      "+atomicCounter.value());
        }
    }

    /**
     * 启动多个线程操作一个变量/类，如果线程不安全会出现加不到最终值的情况
     * @param args
     */
    public static void main(String args[]) {

            //线程不安全，有时加不到120
//            (new Thread(new TestLocal())).start();
//            (new Thread(new TestLocal())).start();
//            (new Thread(new TestLocal())).start();
//            (new Thread(new TestLocal())).start();
//            (new Thread(new TestLocal())).start();
//            (new Thread(new TestLocal())).start();

            //线程不安全，有时加不到120
//            (new Thread(new TestCounter())).start();
//            (new Thread(new TestCounter())).start();
//            (new Thread(new TestCounter())).start();
//            (new Thread(new TestCounter())).start();
//            (new Thread(new TestCounter())).start();
//            (new Thread(new TestCounter())).start();
//
            //线程安全，始终加到120
            (new Thread(new TestSynchronizedCounter())).start();
            (new Thread(new TestSynchronizedCounter())).start();
            (new Thread(new TestSynchronizedCounter())).start();
            (new Thread(new TestSynchronizedCounter())).start();
            (new Thread(new TestSynchronizedCounter())).start();
            (new Thread(new TestSynchronizedCounter())).start();

            //线程安全，始终加到120
//            (new Thread(new TestAtomicCounter())).start();
//            (new Thread(new TestAtomicCounter())).start();
//            (new Thread(new TestAtomicCounter())).start();
//            (new Thread(new TestAtomicCounter())).start();
//            (new Thread(new TestAtomicCounter())).start();
//            (new Thread(new TestAtomicCounter())).start();


    }
}
