package twitter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gaohan on 10/15/16.
 */
public class TweetRecommendation {
    static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges,
                                      int targetUser, int minLikeThreshold) {
        List<Integer> list = new LinkedList<>();

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < followGraph_edges.length; i++) {
            if (followGraph_edges[i][0] == targetUser) {
                if (!set.contains(followGraph_edges[i][1]))
                    set.add(followGraph_edges[i][1]);
            }
        }
        HashSet<Integer> tweet = new HashSet<>();

        HashMap<Integer, Integer> tweetIdToLike = new HashMap<>();
        for (int i = 0; i < likeGraph_edges.length; i++) {
            if(!set.contains(likeGraph_edges[i][0]))
                continue;
            else {
                tweetIdToLike.put(likeGraph_edges[i][1], tweetIdToLike.getOrDefault(likeGraph_edges[i][1], 0) + 1);
            }
        }
        for (int id : tweetIdToLike.keySet()) {
            if (tweetIdToLike.get(id) >= minLikeThreshold) {
                list.add(id);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}