package java;

public class Driver {
	public static void main(String[] args) {
		/*
		 * Flexible_Priority_Queue pQueue = new Flexible_Priority_Queue("max");
		 * System.out.println("START:"); pQueue.insert("18", "1st"); pQueue.insert("45",
		 * "2nd"); pQueue.insert("9", "3rd"); pQueue.insert("2", "4th");
		 * pQueue.insert("21", "5th"); pQueue.insert("64", "6th"); pQueue.insert("4",
		 * "7th"); pQueue.insert("7", "8th"); pQueue.insert("1", "9th");
		 * pQueue.insert("6", "10th");
		 */

		Node array[] = new Node[10];
		array[0] = new Node("18", "1st");
		array[1] = new Node("45", "2nd");
		array[2] = new Node("9", "3rd");
		array[3] = new Node("2", "4th");
		array[4] = new Node("21", "5th");
		array[5] = new Node("64", "6th");
		array[6] = new Node("4", "7th");
		array[7] = new Node("7", "8th");
		array[8] = new Node("1", "9th");
		array[9] = new Node("6", "10th");
		Flexible_Priority_Queue pQueue = new Flexible_Priority_Queue(array, "max");
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
	}
}