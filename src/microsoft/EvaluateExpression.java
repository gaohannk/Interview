package microsoft;

import java.util.Stack;

/* (1)首先，需要分配2个栈，栈s1用于临时存储运算符（含一个结束符号），此运算符在栈内遵循越往栈顶优先级越高的原则；
 栈s2用于输入逆波兰式，为方便起见，栈s1需先放入一个优先级最低的运算符，在这里假定为'#'；
 (2)从中缀式的左端开始逐个读取字符x，逐序进行如下步骤：
 1.若x是操作数，则分析出完整的运算数（在这里为方便，用字母代替数字），将x直接压入栈s2；
 2.若x是运算符，则分情况讨论：
 2.1若x是'('，则直接压入栈s1；
 2.2若x是')'，则将距离栈s1栈顶的最近的'('之间的运算符，逐个出栈，依次压入栈s2，此时抛弃'('；
 2.3若x是除'('和')'外的运算符，则再分如下情况讨论：
 2.3.1若当前栈s1的栈顶元素为'('，则将x直接压入栈s1；
 2.3.2若当前栈s1的栈顶元素不为'('，则将x与栈s1的栈顶元素比较，若x的优先级大于栈s1栈顶运算符优先级，则将x直接压入栈s1。
 否者，将栈s1的栈顶运算符弹出，压入栈s2中，直到栈s1的栈顶运算符优先级别低于（不包括等于）x的优先级，或栈s2的栈顶运
 算符为'('，此时再则将x压入栈s1;
 (3)在进行完(2)后，检查栈s1是否为空，若不为空，则将栈中元素依次弹出并压入栈s2中（不包括'#'）；　　　　　　 
 (4)完成上述步骤后，栈s2便为逆波兰式输出结果。但是栈s2应做一下逆序处理，因为此时表达式的首字符位于栈底；
 */
public class EvaluateExpression {
	public static int evaluteExpression(String[] exp) {
		Stack<String> opStack = new Stack<String>();
		Stack<String> expStack = new Stack<String>();
		opStack.add("#");
		for (String c : exp) {
			if (!isOperator(c)) {
				expStack.push(c);
			} else {
				switch (c) {
				case "(":
					opStack.push(c);
					break;
				case ")":
					while (opStack.peek() != "(") {
						expStack.add(opStack.peek());
						opStack.pop();
					}
					opStack.pop();
					break;
				case "+":
				case "-":
					while (opStack.peek() != "#") {
						if (opStack.peek() == "(") {
							break;
						}
						expStack.add(opStack.peek());
						opStack.pop();
					}
					opStack.add(c);
					break;
				case "*":
				case "/":
					while (opStack.peek() != "#") {
						if (opStack.peek() == "(" || opStack.peek() == "+" || opStack.peek() == "-") {
							break;
						}
						expStack.add(opStack.peek());
						opStack.pop();
					}
					opStack.add(c);
				}

			}
		}
		while (opStack.peek() != "#") {
			expStack.add(opStack.pop());
		}
        String[] str = new String[expStack.size()];
        int index=expStack.size()-1;
		while (!expStack.isEmpty()) {
			//System.out.println(expStack.peek());
			str[index]=expStack.pop();
			index--;
			
		}
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < str.length; i++) {
			if (isOperator(str[i])) {
				int x = stack.pop();
				int y = stack.pop();
				switch (str[i]) {
				case "+":
					stack.push(x + y);
					break;
				case "-":
					stack.push(y - x); // not x-y
					break;
				case "*":
					stack.push(x * y);
					break;
				case "/":
					stack.push(y/ x);
					break;
				}
			} else {
				stack.push(Integer.parseInt(str[i]));
			}
		}
		return stack.pop();
	}

	private static boolean isOperator(String c) {
		if (c == "+" || c == "-" || c == "*" || c == "/" || c == "(" || c == ")")
			return true;
		return false;
	}

	public static void main(String[] args) {
		String[] exp = { "3", "+", "2", "*", "(", "4", "+", "2", ")", "-", "1" };
		System.out.println(evaluteExpression(exp));
	}
}
