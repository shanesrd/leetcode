package s0225;/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 *
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (51.87%)
 * Likes:    1870
 * Dislikes: 773
 * Total Accepted:    278.1K
 * Total Submissions: 536K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * Implement a last-in-first-out (LIFO) stack using only two queues. The
 * implemented stack should support all the functions of a normal stack (push,
 * top, pop, and empty).
 * 
 * Implement the MyStack class:
 * 
 * 
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * 
 * 
 * Notes:
 * 
 * 
 * You must use only standard operations of a queue, which means that only push
 * to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may
 * simulate a queue using a list or deque (double-ended queue) as long as you
 * use only a queue's standard operations.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 * 
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 * 
 * 
 * 
 * Follow-up: Can you implement the stack using only one queue?
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

import util.ResUtils;

// @lc code=start
@SuppressWarnings("ConstantConditions")
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    boolean isFirst;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        isFirst = true;
    }
    
    public void push(int x) {
        src().add(x);
    }
    
    public int pop() {
        Queue<Integer> src = src();
        Queue<Integer> target = target();

        while (src.size() > 1) {
            target.add(src.poll());
        }
        isFirst = !isFirst;

        return src.poll();
    }
    
    public int top() {
        Queue<Integer> src = src();
        Queue<Integer> target = target();

        Integer tail = null;
        while (!src.isEmpty()) {
            tail = src.poll();
            target.add(tail);
        }
        isFirst = !isFirst;

        return tail;
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    private Queue<Integer> src() {
        return isFirst ? q1 : q2;
    }

    private Queue<Integer> target() {
        return isFirst ? q2 : q1;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

class Main {

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);

        int res = s.top();
        ResUtils.print(res, 2);

        res = s.pop();
        ResUtils.print(res, 2);

        boolean bres = s.empty();
         ResUtils.print(bres, false);
    }

}
