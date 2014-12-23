package queue;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> 
implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		size = 0;
		last = null;
	}

	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		Iterator<E> itr = this.iterator();
		return itr;
	}

	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {		
		return size;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	x the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E x) {
		QueueNode<E> n = new QueueNode<E>(x);
		if(last == null){
			last = n;
			last.next = last;
			size++;
			return true;
		}else if(last != null){
			n.next = last.next;
			last.next = n;
			size++;
			return true;
		}
		return false;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if(last == null){
			return null;
		}
		E temp = last.next.element;
		if(last.next == null){
			last = null;
		}else{
			last.next = last.next.next;
		}
		size--;
		return temp; 
	}

	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if(last == null){
			return null;
		}
		return last.next.element;
	}


	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}

	}

}
