//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn;
//Java：合并两个有序链表
public class P21MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // TO TEST
        int[] listOne = new int[]{1,2,4};
        int[] listTwo = new int[]{1,3,4};
        ListNode l1 = getListNode(listOne);
        ListNode l2 = getListNode(listTwo);
        ListNode result = solution.mergeTwoLists(l1, l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static ListNode getListNode(int[] listOne) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int val : listOne) {
            ListNode item = new ListNode(val);
            temp.next = item;
            temp = item;
        }
        return head.next;
    }


    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (l1 != null && l2 != null){
            if (l2.val < l1.val){
                pre.next = l2;
                l2 = l2.next;
            }else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 != null ? l1 : l2;
        return head.next;
    }

    public ListNode mergeTwoListsE(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        ListNode first = l1;
        ListNode second = l2;
        while (first != null && second != null){
            if (second.val < first.val){
                temp.next = second;
                second = second.next;
            }else {
                temp.next = first;
                first = first.next;
            }
            temp = temp.next;
        }
        ListNode otherwise = first != null ? first : second;
        while (otherwise != null){
            temp.next = otherwise;
            temp = temp.next;
            otherwise = otherwise.next;
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

}