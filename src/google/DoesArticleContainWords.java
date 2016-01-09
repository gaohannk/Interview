package google;

import java.util.HashMap;
import java.util.List;

public class DoesArticleContainWords {
	public static boolean isAfreqlessthanBfreq(List<String> A, List<String> B) {
		HashMap<String, Integer> mapa = new HashMap<>();
		HashMap<String, Integer> mapb = new HashMap<>();
		for (String str : A) {
			if (mapa.containsKey(str))
				mapa.put(str, mapa.get(str) + 1);
			else {
				mapa.put(str, 1);
			}
		}
		for (String str : B) {
			if (mapb.containsKey(str))
				mapb.put(str, mapb.get(str) + 1);
			else {
				mapb.put(str, 1);
			}
		}
		for (String str : mapa.keySet()) {
			if (!mapb.containsKey(str))
				continue;
			if (mapb.get(str) >= mapa.get(str))
				return false;
		}
		return true;
	}
}
