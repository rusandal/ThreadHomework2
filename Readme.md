# Межпоточный диалог со счетчиком
## Описание
Программа создает несколько потоков и печатает сообщение в консоль. По завершению выводится количество напечатанных сообщений.
Потоки создаются на основе Callable задачи.  
```
public class MyThread implements Callable<Integer> {...}
```
Все потоки помещаются List
```
List<Callable<Integer>> myTreads = new LinkedList<>();
Callable<Integer> myCallable = new MyThread();
Callable<Integer> myCallable2 = new MyThread();
...
myTreads.add(myCallable);
myTreads.add(myCallable2);
...
```
Для выполнения используется ExecutorService с фиксированным количеством потоков. Для передаи на выполнение используется метод invokeAny()
```
final ExecutorService threadPool = Executors.newFixedThreadPool(4);
result = threadPool.invokeAny(myTreads);
```


Вывод в консоль:
```
...
Я pool-1-thread-1. Всем привет!
pool-1-thread-1 завершен
Я pool-1-thread-3. Всем привет!
pool-1-thread-3 завершен
Я pool-1-thread-4. Всем привет!
pool-1-thread-4 завершен
pool-1-thread-2 завершен
Количество сообщений 10
```