package Philosophers;

public class Philosopher implements Runnable {

    // The forks on either side of this Philosopher
    Object leftFork;
    Object rightFork;

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {

                // thinking
                doAction("Thinking");
                synchronized (leftFork) {
                    doAction( "Picked up left fork");
                    synchronized (rightFork) {
                        doAction("Picked up right fork - eating");

                        doAction("Put down right fork");
                    }
                    doAction("Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}