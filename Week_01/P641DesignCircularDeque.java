//设计实现双端队列。 
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列

package leetcode.editor.cn;
//Java：设计循环双端队列
public class P641DesignCircularDeque{
    public static void main(String[] args) {
//        Solution solution = new P641DesignCircularDeque().new Solution();
        // TO TEST
//        MyCircularDeque obj = new MyCircularDeque(3);
//        boolean param_1 = obj.insertFront(value);
//        boolean param_2 = obj.insertLast(value);
//        boolean param_3 = obj.deleteFront();
//        boolean param_4 = obj.deleteLast();
//        int param_5 = obj.getFront();
//        int param_6 = obj.getRear();
//        boolean param_7 = obj.isEmpty();
//        boolean param_8 = obj.isFull();
//        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
//        System.out.println(circularDeque.insertLast(1));			        // 返回 true
//        System.out.println(circularDeque.insertLast(2));			        // 返回 true
//        System.out.println(circularDeque.insertFront(3));			        // 返回 true
//        System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
//        System.out.println(circularDeque.getRear());  				// 返回 2
//        System.out.println(circularDeque.isFull());				        // 返回 true
//        System.out.println(circularDeque.deleteLast());			        // 返回 true
//        System.out.println(circularDeque.insertFront(4));			        // 返回 true
//        System.out.println(circularDeque.getFront());				// 返回 4

//        ["MyCircularDeque","insertFront","insertLast","getFront","insertLast","getFront",
//                "insertFront","getRear","getFront","getFront","deleteLast","getRear"]
//        ["MyCircularDeque","insertFront","insertLast","getFront","insertLast","getFront","insertFront","getRear","getFront","getFront","deleteLast","getRear"]
//        [[5],[7],[0],[],[3],[],[9],[],[],[],[],[]]
        MyCircularDeque circularDeque = new MyCircularDeque(5);
        System.out.println(circularDeque.insertFront(7)); //7,true
        System.out.println(circularDeque.insertLast(0));  //70,true
        System.out.println(circularDeque.getFront());            //70,7
        System.out.println(circularDeque.insertLast(3));   //703,true
        System.out.println(circularDeque.getFront());             //703,true
        System.out.println(circularDeque.insertFront(9));   //9703,true
        System.out.println(circularDeque.getRear());               //9703,3
        System.out.println(circularDeque.getFront());              //9703,9
        System.out.println(circularDeque.getFront());               //9703,9
        System.out.println(circularDeque.deleteLast());             //970,true
        System.out.println(circularDeque.getRear());                //970,3

    }

private static class MyCircularDeque {

    private int[] arr;
    private int front = 0; //添加往前走，注意取模
    private int rear = 0; //添加往后走，注意取模
    private int capacity = 0; //添加往后走，注意取模

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.arr = new int[k +1];
        this.capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()){
            return false;
        }
        front = (front - 1 + capacity) % capacity; //防止front为0
        arr[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()){
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }
        rear = (rear - 1 + capacity) % capacity; //防止rear为0
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()){
            return -1;
        }
        return arr[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()){
            return -1;
        }
        return arr[(rear - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

}

private static class MyCircularDequeE {

    private ListNode head = new ListNode(-1);
    private ListNode last = null;
    private int maxSize;
    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDequeE(int k) {
        this.maxSize = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()){
            return false;
        }
        ListNode node = new ListNode(value);
        node.next = head.next;
        head.next = node;
        if (size++ == 0){
            last = node;
        }
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()){
            return false;
        }
        ListNode node = new ListNode(value);
        if (isEmpty()){
            head.next = node;
        }else {
            last.next = node;
        }
        last = node;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }
        head.next = head.next.next;
        if (--size == 0){
            last = null;
        }
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }
        for (ListNode node = head.next; node != null; node = node.next){
            if (node.next == last){
                last = node;
            }
        }

        if (--size == 0){
            head.next = null;
        }
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()){
            return -1;
        }
        return head.next.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()){
            return -1;
        }
        return last.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == maxSize;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}



/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}