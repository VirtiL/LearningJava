package demo;

import java.util.Stack;

/**
 * @Description: 括号匹配(有效括号问题)
 *
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

 * @author: zhangcq
 * @Time: 2019-7-19 23:15
 * @Version 1.0
 */
public class Demo2 {


    public static void main(String[] args) {
//        String str = "(){[}]";
        String str = "(){}[]";
        System.out.println(isTrue(str));


    }

    private static boolean isTrue(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(')');

            } else if (c == '[') {
                stack.push(']');

            } else if (c == '{') {
                stack.push('}');

            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}