package microsoft;

public class MyHashmap {
	private static final int SIZE = 16;
	private Entry table[] = new Entry[SIZE];

	/**
	 * User defined simple Map data structure with key and value. This is also
	 * used as linked list in case multiple key-value pairs lead to the same
	 * bucket with same hashcodes and different keys (collisions) using pointer
	 * 'next'.
	 */
	class Entry {
		final String key;
		String value;
		Entry next;

		Entry(String k, String v) {
			key = k;
			value = v;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getKey() {
			return key;
		}
	}

	/**
	 * Returns the entry associated with the specified key in the HashMap.
	 * Returns null if the HashMap contains no mapping for the key.
	 */
	public Entry get(String k) {
		int hash = k.hashCode() % SIZE;
		Entry e = table[hash];

		// if bucket is found then traverse through the linked list and
		// see if element is present
		while (e != null) {
			if (e.key.equals(k)) {
				return e;
			}
			e = e.next;
		}
		return null;
	}

	/**
	 * Associates the specified value with the specified key in this map. If the
	 * map previously contained a mapping for the key, the old value is
	 * replaced.
	 */
	public void put(String k, String v) {
		int hash = k.hashCode() % SIZE;
		Entry e = table[hash];
		if (e != null) {
			// it means we are trying to insert duplicate
			// key-value pair, hence overwrite the current
			// pair with the old pair
			if (e.key.equals(k)) {
				e.value = v;
			} else {
				// traverse to the end of the list and insert new element
				// in the same bucket
				while (e.next != null) {
					e = e.next;
				}
				Entry entryInOldBucket = new Entry(k, v);
				e.next = entryInOldBucket;
			}
		} else {
			// new element in the map, hence creating new bucket
			Entry entryInNewBucket = new Entry(k, v);
			table[hash] = entryInNewBucket;
		}
	}

	public static void main(String[] args) {
		MyHashmap hm = new MyHashmap();

		hm.put("Niranjan", "SMTS");
		hm.put("Ananth", "SSE");
		hm.put("Niranjan", "SMTS1");
		hm.put("Chandu", "SSE");

		Entry e = hm.get("Niranjan");
		System.out.println("" + e.getValue());
	}
}
