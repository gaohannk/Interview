package amazon;
/* example1:
requestTime: [0, 2, 4, 5]
duration: [7, 4, 1, 4]
average waiting time  4
example2:
requestTime: [0, 1, 3, 9]
duration: [2, 1, 7, 5]
average waiting time 0.5
*/
import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestJobFirst {
	public float Solution(int[] req, int[] dur) {
		if (req == null || dur == null || req.length != dur.length)
			return 0;
		int index = 0, length = req.length;
		int waitTime = 0, curTime = 0;
		PriorityQueue<process> pq = new PriorityQueue<process>(new Comparator<process>() {
			@Override
			public int compare(process p1, process p2) {
				if (p1.exeTime == p2.exeTime)
					return p1.arrTime - p2.arrTime;
				return p1.exeTime - p2.exeTime;
			}
		});
		while (!pq.isEmpty() || index < length) {
			if (!pq.isEmpty()) {
				process cur = pq.poll();
				waitTime += curTime - cur.arrTime;
				curTime += cur.exeTime;
				while (index < length && curTime >= req[index])
					pq.offer(new process(req[index], dur[index++]));
			} else {
				pq.offer(new process(req[index], dur[index]));
				curTime = req[index++];
			}
		}
		return (float) waitTime / length;
	}
}
