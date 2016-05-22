package hackerrange;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/*
1. Social network

A social network is defined as all friends within social distance 2 (direct friends' direct friends.)
The recommendation logic is based on the following logic:
1. A user should only be recommended as course that their social network have attended, but he have not yet.
2. The recommendations priority is driven by how many people have attended the same course - the more people attend the rating is higher.

Two API will be provided
  vector<string> getDirectFriendsForUser(string user)
  vector<string> getAttendedCoursesForUser(string user)
Please write a function that provides a ranked (high to low) list of courses(course IDs) for a provided user.

  */
public abstract class SocialNetwork {
	abstract LinkedList<String> getDirectFriendsForUser(String user);

	abstract LinkedList<String> getAttendedCoursesForUser(String user);

	class Pair {
		String course;
		Integer num;

		Pair(String c, Integer n) {
			this.course = c;
			this.num = n;
		}
	}

	public LinkedList<String> recommend(String user) {
		HashMap<String, Integer> count = new HashMap<>();
		HashSet<String> users = new HashSet<String>();
		LinkedList<String> res = new LinkedList<String>();
		LinkedList<Pair> res2 = new LinkedList<Pair>();

		for (String firstLevel : getDirectFriendsForUser(user)) {
			if (!users.contains(firstLevel)) {
				users.add(firstLevel);
			}
			for (String secondLevel : getDirectFriendsForUser(firstLevel)) {
				if (!users.contains(secondLevel)) {
					users.add(secondLevel);
				}
			}
		}
		for (String u : users) {
			LinkedList<String> course = getAttendedCoursesForUser(u);
			for (String c : getDirectFriendsForUser(u)) {
				count.put(c, count.getOrDefault(c, 0) + 1);
			}
		}
		int num[] = new int[count.size()];
		int index = 0;
		for (Iterator<Integer> it = count.values().iterator(); it.hasNext();) {
			num[index++] = it.next();
		}
		for (Iterator<String> it = count.keySet().iterator(); it.hasNext();) {
			String c = it.next();
			Integer n = count.get(c);
			res2.add(new Pair(c, n));
		}
		Collections.sort(res2, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p2.num - p1.num;
			}
		});
		for (int i = 0; i < res2.size(); i++) {
			res.add(res2.get(i).course);
		}
		/**
		 * Arrays.sort(num);
		 * for (int i = num.length - 1; i >= 0; i--) {
		 *	Iterator<Entry<String, Integer>> it = count.entrySet().iterator();
		 *	while (it.hasNext()) {
		 * Entry<String, Integer> e = it.next();
		 *		if (e.getValue() == num[i]) {
		 *			res.add(e.getKey());
		 *			count.remove(e);
		 *			break;
		 *		}
		 *	}
		 * }
		 **/
		return res;
	}
}
