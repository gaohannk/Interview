package microsoft;

import java.util.Stack;

public class ShortenURL {
	 public String shortenURL(String path) {
			Stack<String> s = new Stack<String>();
			String[] split = path.split("/");
			for (String a : split) {
				if (a.equals(".") ||a.isEmpty()) {
				    continue;
				}else{
					if (a.equals("..")) {
						if (!s.isEmpty())
							s.pop();
					} else {
						s.push(a);
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			while (!s.isEmpty()) {
				sb.insert(0, s.pop());
				sb.insert(0, "/");
			}
			return sb.length() == 0 ? "/" : sb.toString();
		}
}
