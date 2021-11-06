import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {
    private static int messageCount = 0;

    @Override
    public Integer call() throws Exception {
        int a = 0;
        try {
            while (a < 3) {
                Thread.sleep(2500);
                System.out.printf("Я %s. Всем привет!\n", Thread.currentThread().getName());
                a++;
                messageCount++;
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }
        return messageCount;
    }
}
