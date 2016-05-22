package yapstone;

import java.util.Scanner;

public class ElementPresentinTree {
	public static Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return node;
	}

	public static int isPresent(Node root, int value) {
		if (root == null)
			return 0;
		if (root.data == value)
			return 1;
		if (value < root.data)
			isPresent(root.left, value);
		else if (value > root.data)
			isPresent(root.right, value);
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Node _root;
		int root_i = 0, root_cnt = 0, root_num = 0;
		root_cnt = in.nextInt();
		_root = null;
		for (root_i = 0; root_i < root_cnt; root_i++) {
			root_num = in.nextInt();
			if (root_i == 0)
				_root = new Node(root_num);
			else {
				insert(_root, root_num);
			}
		}
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int _x = in.nextInt();
			System.out.println(isPresent(_root, _x));
		}
	}

}
