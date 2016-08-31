public class ThreadDemo1 {

	public static void main(String[] args) {
		MyThread t1=new MyThread();
		Thread thread=new Thread(t1,"线程1");
		System.out.println(thread.getState());
		thread.start();
		
		try {
			
			thread.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(thread.getState());
		System.out.println(thread.getName());
		System.out.println(thread.getId());
		System.out.println(thread.getPriority());
		System.out.println(thread.getState());
		for (int i=1;i<=10;i++){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("hello");
		}
		thread.interrupt();
		System.out.println(thread.isInterrupted());
		System.out.println(Thread.interrupted());
		
	}

}

class MyThread implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i=1;i<=100;i++){
			try {
				System.out.println(i);
				//Thread.sleep(1000);
				System.out.println(i);
			} catch (Exception e) {
				System.out.println(Thread.currentThread().getName()+"中断了");
			}
			
		}
		
	}
	
}
