package springboor.email.commont.queue;

import springboor.email.commont.model.Email;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MailQueue {
	static final int QUEUE_MAX_SIZE = 1000;
	static BlockingQueue<Email> blockingQueue = new LinkedBlockingQueue<>(QUEUE_MAX_SIZE);
	private MailQueue(){}
	private static class SingletonHolder{
		private static MailQueue queue = new MailQueue();
	}
	public static MailQueue getMailQueue(){
		return SingletonHolder.queue;
	}
	public void product(Email email) throws InterruptedException {
		blockingQueue.put(email);
	}
	//消费出队
	public  Email consume() throws InterruptedException {
		return blockingQueue.take();
	}
	// 获取队列大小
	public int size() {
		return blockingQueue.size();
	}
}
