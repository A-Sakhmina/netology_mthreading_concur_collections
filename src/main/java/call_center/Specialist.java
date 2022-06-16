package call_center;

import java.util.Queue;

public class Specialist {
    private static final long PROBLEM_RESOLVING_TIME = 3000;
    private final Queue<String> queue;

    public Specialist(Queue<String> queue) {
        this.queue = queue;
    }

    public void takeCall() {
        try {
            while (!queue.isEmpty()) {
                String call = queue.poll();
                if (call != null)
                    System.out.println(call + " разговаривает с " + Thread.currentThread().getName());
                //эмулируем ответ на звонок
                Thread.sleep(PROBLEM_RESOLVING_TIME);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
