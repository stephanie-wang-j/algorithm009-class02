//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组

package leetcode.editor.cn;
//Java：加一
public class P66PlusOne{
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
        System.out.println(solution.plusOne(new int[]{1,9,9}));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public int[] plusOneE(int[] digits) {
            if (digits[digits.length - 1] < 9){
                digits[digits.length - 1] += 1;
                return digits;
            }
            int j = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] < 9){
                    break;
                }
                j++;
            }
            if (j == digits.length){
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                return newDigits;
            }else {
                for (int i = digits.length - j; i < digits.length; i++) {
                    digits[i] = 0;
                }
                digits[digits.length - j -1] += 1;
            }
            return digits;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}