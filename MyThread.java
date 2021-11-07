import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {
    private static int messageCountThreads = 0;
    private final int messageCountThread = 3;

    @Override
    public Integer call() throws Exception {
        int a = 0;
        try {
            while (a < messageCountThread) {
                Thread.sleep(2500);
                System.out.printf("Я %s. Всем привет!\n", Thread.currentThread().getName());
                a++;
                messageCountThreads++;
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }
        return messageCountThreads;
    }
}
