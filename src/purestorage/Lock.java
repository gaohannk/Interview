package purestorage;
/*
Lock Use Analyzer
Suppose we want to monitor how locks are used in our system. As the first step, we log moments of acquire and release for each lock in the following format:
¥	ACQUIRE X
¥	RELEASE X
where X is some integer ID (1 <=X<=1,000,000) of the lock.

All locks must be released in the reverse order of acquiring them; for example, this is a correct event sequence:
1.	ACQUIRE 364
2.	ACQUIRE 84
3.	RELEASE 84
4.	ACQUIRE 1337
5.	RELEASE 1337
6.	RELEASE 364
However, the following sequence violates this rule, because lock 84 is still acquired while releasing lock 364:
1.	ACQUIRE 364
2.	ACQUIRE 84
3.	RELEASE 364
4.	RELEASE 84

It's also dangerous to leave locks acquired after application termination, as other processes in the system may be blocked while waiting on
them, so such sequence is incorrect, too:
1. ACQUIRE 364
2. ACQUIRE 84
3. RELEASE 84
since lock 364 is never released
Third type of problem is lock misuse: it's never good to release a lock that has never been acquired, e.g.:
1. ACQUIRE 364
2. RELEASE 84
3. RELEASE 364
and it is as bad to acquire an already acquired lock (usually resulting in a deadlock):
1. ACQUIRE 364
2. ACQUIRE 84
3. ACQUIRE 364
4. RELEASE 364
Write a program that, given a list of N (0<=N<=1,000,000) lock acquire and release events (counting from 1), checks if there were any
problems (acquire-release order violation, dangling acquired lock, acquiring a lock twice or releasing a free lock), and if so, tells the earliest
time that could be detected. Note that there's no limit on how many nested locks may be acquired at any given moment.
More formally, you are given an array of strings where each string is either "ACQUIRE X" or "RELEASE X", where all Xs are integers in the
range [1..1000000]

*/
import java.util.HashSet;
import java.util.Stack;

public class Lock {

	static int check_log_history(String[] events) {
		HashSet<Integer> set = new HashSet<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < events.length; i++) {
			String[] split = events[i].split(" ");
			int num = Integer.parseInt(split[1]);
			if (split[0].equals("ACQUIRE")) {
				if (set.contains(num))
					return i + 1;
				else {
					set.add(num);
					stack.push(num);
				}
			} else {
				if (stack.peek() == num) {
					stack.pop();
					set.remove(num);
					continue;
				} else {
					return i + 1;
				}
			}
		}
		if (set.isEmpty())
			return 0;
		else
			return events.length;
	}
}
