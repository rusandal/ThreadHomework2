import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Callable<Integer>> myTreads = new LinkedList<>();
        Callable<Integer> myCallable = new MyThread();
        Callable<Integer> myCallable2 = new MyThread();
        Callable<Integer> myCallable3 = new MyThread();
        Callable<Integer> myCallable4 = new MyThread();
        myTreads.add(myCallable);
        myTreads.add(myCallable2);
        myTreads.add(myCallable3);
        myTreads.add(myCallable4);
        final ExecutorService threadPool = Executors.newFixedThreadPool(4);
        Integer result = threadPool.invokeAny(myTreads);
        System.out.println("Количество сообщений " + result);
        threadPool.shutdown();
    }
}
