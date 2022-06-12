package call_center;

import java.util.Queue;
import java.util.Random;
import java.util.stream.Collectors;

public class CallGenerator {
    private static final long WAIT_FOR_NEW_CALL = 200;
    private final Queue<String> queue;
    private Random random = new Random();

    public CallGenerator(Queue<String> queue) {
        this.queue = queue;
    }

    public void generateCalls() {
        try {
            for (int i = 0; i < 100; i++) {
                //генерируем номер телефона абонента
                String number = "+7" + random.ints(10, 0, 9)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining());
                //добавление номера в очередь
                queue.add(number);
                //генерируем новый звонок через определённое время
                Thread.sleep(WAIT_FOR_NEW_CALL);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
