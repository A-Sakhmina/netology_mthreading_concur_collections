import call_center.CallGenerator;
import call_center.Specialist;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        final int CALL_INTERVAL = 1000;
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        CallGenerator atc = new CallGenerator(queue);
        Specialist operator1 = new Specialist(queue);
        Specialist operator2 = new Specialist(queue);
        Specialist operator3 = new Specialist(queue);

        //Запуск потока-АТС
        new Thread(atc::generateCalls).start();
        try {
            Thread.sleep(CALL_INTERVAL);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //запуск потоков специалистов, которые разбирают сгенерированные звонки
        new Thread(operator1::takeCall, "Оператор 1").start();
        new Thread(operator2::takeCall, "Оператор 2").start();
        new Thread(operator3::takeCall, "Оператор 3").start();
    }
}
