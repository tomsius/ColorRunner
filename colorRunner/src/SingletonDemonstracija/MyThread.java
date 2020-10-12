package SingletonDemonstracija;

import dev.runnergame.SingletonController;

public class MyThread implements Runnable {

    @Override
    public void run() {
        SingletonController singleton  = SingletonController.getInstance("ColorRunner", 640, 360);
        System.out.println(Thread.currentThread().getName() + " " + singleton.hashCode());
    }

}
