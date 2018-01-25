import exceptions.StackOverFlowException;
import exceptions.StackUnderFlowException;

public class MyStack<T> {

    private int maxSize;
    private Object[] stackArray;
    private int top;

    public MyStack(int s) {
        maxSize = s;
        stackArray = new Object[maxSize];
        top = -1;
    }

    public void push(T object){

        if(this.getFreeSpace() == 0) {
            try {
                throw new StackOverFlowException("stack is full");
            }catch(StackOverFlowException ex){
                ex.printStackTrace();
            }
        }else{

            stackArray[++top] = object;
        }


    }

    public Object pop() {

        if (this.getFreeSpace() == this.maxSize) {
            try {
                throw new StackUnderFlowException("stack is empty");
            } catch (StackUnderFlowException ex) {
                ex.printStackTrace();
            }
        } else {
            return stackArray[top--];
        }return stackArray[top];
    }

    public Object peek() {
        return stackArray[top];
    }

    public long getFreeSpace(){
        return (maxSize - 1) - top;
    }


}
