package google;

/*step 1: 我想有个element，里面存着一个名字，和下一个指向的element，建个类！（类似链表）
step 2: 如果name 和next是private，我从main函数想访问怎么办？（写getName() getNext() 函数）
step 3: 给出element e，找到他后面name为“one"的element 个数！  （while循环到null，string.equals, cnt++）
step 4: 如果next不是一个节点，而是很多节点，怎么办？   (Element[] next)
step 5: 同step 3, 怎么找个数？ （DFS or BFS）
step 6: 如果里面有cycle, 怎么办？（adjacency matrix, topology search）
*/
public class Element {

	private String name;
	private Element next;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Element getNext() {
		return next;
	}

	public void setNext(Element next) {
		this.next = next;
	}

	public static void main(String[] args) {
		Element e = new Element();
		String str = "one";
		int count = 0;
		while (e.next != null) {
			if (e.name.equals(str))
				count++;
		}
	}
}
