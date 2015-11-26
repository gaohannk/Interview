package mecury;

import java.util.Stack;

public class Solution3 {
	public static float calVal(String expString){
		char[] chars = expString.toCharArray();
		StringBuilder sb = new StringBuilder();
         String[] exp = new String[10];
         int index=0;
		for (int i = 0; i < chars.length; i++) {
			if (!isOperator(chars[i]))
				sb.append(chars[i]);
			else {
				if (i == 0) {
					sb.append(chars[i]);
				} else {
					exp[index]=sb.toString();
					index++;
					exp[index]=String.valueOf(chars[i]);
					index++;
					sb.delete(0, sb.length());
				}
			}
		}
		exp[index]=sb.toString();
		return evaluteExpression(exp);
	}
	public static float evaluteExpression(String[] exp) {
		Stack<String> opStack = new Stack<String>();
		Stack<String> expStack = new Stack<String>();
		opStack.add("#");
		for (String c : exp) {
			if(c==null)
				break;
			if (!isOperator(c)) {
				expStack.push(c);
			} else {
				switch (c) {
			
				case "+":
				case "-":
					while (opStack.peek() != "#") {
						expStack.add(opStack.peek());
						opStack.pop();
					}
					opStack.add(c);
					break;
				case "*":
				case "/":
					while (opStack.peek() != "#") {
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
		Stack<Float> stack = new Stack<Float>();
		for (int i = 0; i < str.length; i++) {
			if (isOperator(str[i])) {
				float x = stack.pop();
				float y = stack.pop();
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
				stack.push(Float.parseFloat(str[i]));
			}
		}
		return stack.pop();
	}

	private static boolean isOperator(String c) {
		if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/"))
			return true;
		return false;
	}
	private static boolean isOperator(char c) {
		if (c=='+' || c == '-' || c == '*' || c == '/')
			return true;
		return false;
	}

	public static void main(String[] args) {
		String exp = "5.6/0.7*2-3.5";
		System.out.println(calVal(exp));
		String exp2 = "-1.3+5.1/3-0.8";
		System.out.println(calVal(exp2));
		System.out.println(String.format("%.2f", calVal(exp2)));
	}
}
