package Student.DataStructure;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 栈是Vector的一个子类，它实现了一个标准的后进先出的栈。
 *
 * 堆栈只定义了默认构造函数，用来创建一个空栈。 堆栈除了包括由Vector定义的所有方法，也定义了自己的一些方法。
 */
public class StackStudent {
    public static void pushStack(Stack<Integer> st, int num){
        st.push(new Integer(num));
        System.out.println("putsh(" + num + ")");
        System.out.println("stack：" + st);
    }

    public static void popStack(Stack<Integer> st){
        Integer i = st.pop();
        System.out.println("pop value：" + i);
        System.out.println("new stack：" + st);
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        pushStack(stack,40);
        pushStack(stack, 50);
        pushStack(stack, 60);
        System.out.println(stack.search(40));
        System.out.println(stack.search(60));
        popStack(stack);
        popStack(stack);
        popStack(stack);
        try{
            popStack(stack);
        }catch(EmptyStackException e){
            e.printStackTrace();
        }
    }
}
