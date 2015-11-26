package mecury;

import java.util.ArrayList;
import java.util.Stack;

public class Solution2 {
	public static double evaluteExpression(String expsString) {
		char[] chars = expsString.toCharArray();
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < chars.length; i++) {
			if (!isOperator(chars[i]))
				sb.append(chars[i]);
			else {
				if (i == 0) {
					sb.append(chars[i]);
				} else {
					list.add(sb.toString());
					list.add(String.valueOf(chars[i]));
					sb.delete(0, sb.length());
				}
			}
		}
		list.add(sb.toString());
		Stack<String> opStack = new Stack<String>();
		Stack<String> expStack = new Stack<String>();
		for (int i = 0; i < list.size(); i++) {
			String item = list.get(i);
			if (!isOperator(item)) {
				expStack.add(item);
			} else {
				switch (item) {
				case "+":
				case "-":
					if (opStack.isEmpty()) {
						opStack.add(item);
					} else {
						String op = opStack.pop();
						double a = Float.parseFloat(expStack.pop());
						double b = Float.parseFloat(expStack.pop());
						double res = cal(a, b, op);
						expStack.add(String.valueOf(res));
						opStack.add(item);
					}
					break;
				case "*":
				case "/":
					if (opStack.isEmpty()) {
						opStack.add(item);
					} else {
						String op = opStack.pop();
						if (op.equals("+") || op.equals("-")) {
							opStack.add(op);
							opStack.add(item);
						} else {
							double a = Float.parseFloat(expStack.pop());
							double b = Float.parseFloat(expStack.pop());
							double res = cal(a, b, op);
							expStack.add(String.valueOf(res));
							opStack.add(item);
						}
					}
					break;
				}
			}
		}
		while (!opStack.isEmpty()) {
			String op = opStack.pop();
			double a = Float.parseFloat(expStack.pop());
			double b = Float.parseFloat(expStack.pop());
			double res = cal(a, b, op);
			expStack.add(String.valueOf(res));
		}
		return Double.parseDouble(expStack.pop());
	}

	private static double cal(double a, double b, String op) {
		//System.out.println(b + op + a);
		double res = 0;
		switch (op) {
		case "+":
			res = b + a;
			break;
		case "-":
			res = b - a;
			break;
		case "*":
			res = b * a;
			break;
		case "/":
			res = b / a;
			break;
		}
		return res;
	}

	private static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/')
			return true;
		return false;
	}

	private static boolean isOperator(String c) {
		if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/"))
			return true;
		return false;
	}

	public static void main(String[] args) {
		String exp = "5.6/0.7*2-3.5";
		System.out.println(evaluteExpression(exp));
		String exp2 = "-1.3+5.1/3-0.8";
		System.out.println(String.format("%.2f", evaluteExpression(exp2)));
	}
}
