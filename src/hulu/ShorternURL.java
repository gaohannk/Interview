package hulu;
/*On Single Machine
Suppose we have a database which contains three columns: id (auto increment), actual url, and shorten url.

Intuitively, we can design a hash function that maps the actual url to shorten url. But string to string mapping is not easy to compute.

Notice that in the database, each record has a unique id associated with it. What if we convert the id to a shorten url?
Basically, we need a Bijective function f(x) = y such that
Each x must be associated with one and only one y;
Each y must be associated with one and only one x.
n our case, the set of x's are integers while the set of y's are 6-letter-long strings. Actually, each 6-letter-long string can be considered as a number too, a 62-base numeric, if we map each distinct character to a number,
e.g. 0-0, ..., 9-9, 10-a, 11-b, ..., 35-z, 36-A, ..., 61-Z.
For each input long url, the corresponding id is auto generated (in O(1) time). 
The base conversion algorithm runs in O(k) time where k is the number of digits (i.e. k=6).
*/
/* On multiple machine
The basic process can be:
Insert
Hash an input long url into a single integer;
Locate a server on the ring and store the key--longUrl on the server;
Compute the shorten url using base conversion (from 10-base to 62-base) and return it to the user.
Retrieve
Convert the shorten url back to the key using base conversion (from 62-base to 10-base);
Locate the server containing that key and return the longUrl.
*/
/* A URL character can be one of the following
 * 1) A lower case alphabet [‘a’ to ‘z’], total 26 characters
 * 2) An upper case alphabet [‘A’ to ‘Z’], total 26 characters
 * 3) A digit [‘0′ to ‘9’], total 10 characters
 * There are total 26 + 26 + 10 = 62 possible characters.
 */
public class ShorternURL {

	public static final String ALPHABET = "23456789bcdfghjkmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ-_";
	public static final int BASE = ALPHABET.length();

	public static String encode(int num) {
		StringBuilder str = new StringBuilder();
		while (num > 0) {
			str.insert(0, ALPHABET.charAt(num % BASE));
			num = num / BASE;
		}
		return str.toString();
	}

	public static long decode(String str) {
		long id = 0;
		for (int i = 0; i < str.length(); i++) {
			id = id * BASE + ALPHABET.indexOf(str.charAt(i));
		}
		return id;
	}
}
