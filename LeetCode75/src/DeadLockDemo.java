public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1){
                System.out.println(Thread.currentThread().getName() + "获取资源1");
                try{
                    // 模拟线程运行
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +"等待获取资源2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread().getName() + "获取资源2");
                }
            }
        }, "thread1").start();
        new Thread(() -> {
            synchronized (resource2){
                System.out.println(Thread.currentThread().getName() + "获取资源2");
                try{
                    // 模拟线程运行
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +"等待获取资源1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread().getName() + "获取资源1");
                }
            }
        }, "thread2").start();
    }
}
