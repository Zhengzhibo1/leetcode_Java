import java.util.Stack;

public class CQueue {
	// 栈
	Stack<Integer> stack1;
	Stack<Integer> stack2;
    public CQueue() {

    	stack1 = new Stack<Integer>();
    	stack2 = new Stack<Integer>();
    }
    
    public void appendTail(int value) {

    	while(!stack1.isEmpty()) {
    		stack2.add(stack1.pop());
    	}
    	
    	stack2.add(value);
    	
    	while(!stack2.isEmpty()) {
    		stack1.add(stack2.pop());
    	}
    }
    
    public int deleteHead() {

    	if(stack1.isEmpty()) {
    		return -1;
    	}
    	
    	return stack1.pop();
    }
}
