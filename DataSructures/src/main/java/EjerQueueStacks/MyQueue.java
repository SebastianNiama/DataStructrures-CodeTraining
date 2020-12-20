/*
Ex:
 Implement a MyQueue class which implements a queue using two stacks. 
 */
package EjerQueueStacks;

import Stacks.Stack1;

public class MyQueue<T> {

    private Stack1<T> stackNewest, stackOldest;

    public MyQueue() {
        stackNewest = new Stack1<T>();
        stackOldest = new Stack1<T>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        /*Push onto stackNewest, which always has the newest elements on top */
        stackNewest.push(value);
      
        
    }

    /* Move elements from stackNewest into stackOldest. This is usually done
   so that we can do operations on stackOldest.*/
    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }              
    }

    public T peek() {
        shiftStacks();//Ensure stackOldest has the current elements
        return stackOldest.peek();//retrieve the oldest item
    }

    public T remove() {
        shiftStacks();//Ensure stackOldest has the current elements
        return stackOldest.pop();//pop the oldest item. 
    }

    public void show(){
        shiftStacks();
        stackOldest.show();
        
    }
}
