import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	// 栈：后进先出 队列：先进先出
	// ===============算法实现======================
	Queue<Integer> queue1 = null;
	Queue<Integer> queue2 = null; 
    /** Initialize your data structure here. */
    public MyStack() {
    	queue1 = new LinkedList<Integer>();
    	queue2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	
    	queue2.add(x);
    	while(!queue1.isEmpty()) {
    		queue2.add(queue1.poll());
    	}
    	
    	Queue<Integer> temp = queue1;
    	queue1 = queue2;
    	queue2 = temp;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	
    	return queue1.poll();
    }
    
    /** Get the top element. */
    public int top() {
    	return queue1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	return queue1.isEmpty();
    }

}
