/**
 * 
 */
package org.rash.ds.al;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author mshai9
 *
 */
public class BinarySearchTree {
	private TreeNode root;

	public BinarySearchTree() {
		this.root = null;
	}

	public BinarySearchTree(int data) {
		this.root = new TreeNode(data);
	}

	public void insert(int data) {
		this.root = insert(this.root, data);
	}

	/*

			  20
		    /    \
		   15     25
		  /  \     /
		 10  18   23 
	 */
	private TreeNode insert(TreeNode node, int data) {
		if (node == null)
			node = new TreeNode(data);
		else {
			if (data >= node.data) {
				node.rightNode = insert(node.rightNode, data);
			} else if (data < node.data) {
				node.leftNode = insert(node.leftNode, data);
			}
		}
		return node;
	}

	public void insertt(int data) {
		TreeNode newNode = new TreeNode(data);
		if (this.root == null) {
			this.root = newNode;
			return;
		}
		TreeNode currentNode = this.root;
		TreeNode parentNode = null;
		while (true) {
			parentNode = currentNode;
			if (data > currentNode.data) {
				currentNode = currentNode.rightNode;
				if (currentNode == null) {
					parentNode.rightNode = newNode;
					return;
				}
			} else {
				currentNode = currentNode.leftNode;
				if (currentNode == null) {
					parentNode.leftNode = newNode;
					return;
				}
			}
		}
	}

	public TreeNode search(int data) {
		return search(this.root, data);
	}

	private TreeNode search(TreeNode node, int data) {
		if (node == null)
			return node;
		else {
			if (data > node.data) {
				return search(node.rightNode, data);
			} else if (data < node.data) {
				return search(node.leftNode, data);
			} else {
				return node;
			}
		}
	}

	public TreeNode searchh(int data) {
		TreeNode currentNode = this.root;
		while (currentNode != null) {
			if (data > currentNode.data) {
				currentNode = currentNode.rightNode;
			} else if (data < currentNode.data) {
				currentNode = currentNode.leftNode;
			} else {
				return currentNode;
			}
		}
		return null;
	}

	public TreeNode delete(int data) {
		return delete(this.root, data);
	}

	private TreeNode delete(TreeNode node, int data) {
		if (node == null) {
			return node;
		} else {
			if (data > node.data) {
				node.rightNode = delete(node.rightNode, data);
			} else if (data < node.data) {
				node.leftNode = delete(node.leftNode, data);
			} else {
				if (node.rightNode == null) {
					return node.leftNode;
				} else if (node.leftNode == null) {
					return node.rightNode;
				}
				// node with two children: Get the inorder successor (smallest in the right subtree)
				node = minimumElement(node);
				node.rightNode = delete(node.rightNode, node.data);
			}
		}
		return node;
	}

	// Depth First Traversals: Preorder, Inorder, Postorder

	public void inOrder() {
		inOrder(this.root);
	}

	private void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.leftNode);
			System.out.print(node.data + " ");
			inOrder(node.rightNode);
		}
	}

	public void preOrder() {
		preOrder(this.root);
	}

	private void preOrder(TreeNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.leftNode);
			preOrder(node.rightNode);
		}
	}

	public void postOrder() {
		postOrder(this.root);
	}

	private void postOrder(TreeNode node) {
		if (node != null) {
			postOrder(node.leftNode);
			postOrder(node.rightNode);
			System.out.print(node.data + " ");
		}
	}

	public void decending() {
		decending(this.root);
	}

	/**
	 * @param root2
	 */
	private void decending(TreeNode node) {
		if (node != null) {
			decending(node.rightNode);
			System.out.print(node.data + " ");
			decending(node.leftNode);
		}
	}

	public TreeNode minimumElement(TreeNode node) {
		if (node.leftNode == null)
			return node;
		else
			return minimumElement(node.leftNode);

	}

	public TreeNode maxElement(TreeNode node) {
		if (node.rightNode == null)
			return node;
		else
			return maxElement(node.rightNode);
	}

	// left sub-tree highest element
	public TreeNode predecessor(int data) {
		TreeNode node = search(data);
		TreeNode parentNode = null;
		for (TreeNode currentNode = node.leftNode; currentNode != null; parentNode = currentNode, currentNode = currentNode.rightNode)
			;
		return parentNode;
	}

	// left sub-tree lowest element
	public TreeNode successor(int data) {
		TreeNode node = search(data);
		TreeNode parentNode = null;
		for (TreeNode currentNode = node.rightNode; currentNode != null; parentNode = currentNode, currentNode = currentNode.leftNode)
			;
		return parentNode;
	}

	public int height(TreeNode node) {
		if (node == null)
			return -1;
		int lheight = height(node.leftNode);
		int rheight = height(node.rightNode);
		return Math.max(lheight, rheight) + 1;
	}

	public int heightt(TreeNode node) {
		if (node == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = heightt(node.leftNode);
			int rheight = heightt(node.rightNode);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	// Breadth First Traversal (Or Level Order Traversal)
	// O(n2)
	public void levelOrderTraversalSpiral() {
		int h = height(this.root);
		boolean ltr = true;
		for (int i = 1; i <= h; i++) {
			printGivenLevel(this.root, i, ltr);
			ltr = !ltr;
		}
	}

	public void printGivenLevel(TreeNode node, int l, boolean ltr) {
		if (node == null)
			return;
		if (l == 1)
			System.out.print(node.data + " ");
		else if (l > 1) {
			if (ltr) {
				printGivenLevel(node.leftNode, l - 1, ltr);
				printGivenLevel(node.rightNode, l - 1, ltr);
			} else {
				printGivenLevel(node.rightNode, l - 1, ltr);
				printGivenLevel(node.leftNode, l - 1, ltr);
			}
		}
	}

	// O(n)
	public void printLevelOrder() {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(this.root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.data + " ");
			if (node.leftNode != null)
				queue.add(node.leftNode);
			if (node.rightNode != null)
				queue.add(node.rightNode);
		}
	}

	// O(n)
	public void printLevelOrderSpiral() {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.add(this.root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				TreeNode pop = s1.pop();
				System.out.print(pop.data + " ");
				if (pop.rightNode != null)
					s2.push(pop.rightNode);
				if (pop.leftNode != null)
					s2.push(pop.leftNode);
			}

			while (!s2.isEmpty()) {
				TreeNode pop = s2.pop();
				System.out.print(pop.data + " ");
				if (pop.leftNode != null)
					s1.push(pop.leftNode);
				if (pop.rightNode != null)
					s1.push(pop.rightNode);
			}
		}
	}

	public int sumTree(TreeNode node) {
		if (node == null)
			return 0;
		int left = sumTree(node.leftNode);// take the left tree sum
		int right = sumTree(node.rightNode);// take the right tree sum
		node.data = node.data + left + right;
		return node.data;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(15);
		bst.insert(25);
		bst.insert(10);
		bst.insert(18);
		// bst.insert(16);
		bst.inOrder();
		System.out.println();
		bst.sumTree(bst.root);
		bst.inOrder();
		/*
		 * bst.insert(12); bst.insert(28); bst.insert(18); bst.insert(16); bst.insert(19);
		 */

		// bst.inOrder();
		// System.out.println();
		// System.out.println(bst.height(bst.root));
		//
		// System.out.println(bst.predecessor(18));
		//
		// System.out.println(bst.successor(18));

		// // both null
		// bst.delete(10);
		// bst.inOrder();
		//
		// System.out.println();
		// // right Null
		// bst.delete(25);
		// bst.inOrder();
		// System.out.println();
		// // left Null
		// bst.delete(10);
		// bst.inOrder();
		//
		// System.out.println();
		// bst.delete(18);
		// bst.inOrder();
	}

}

class TreeNode {
	int data;
	TreeNode leftNode;
	TreeNode rightNode;

	public TreeNode() {
		super();
	}

	public TreeNode(int data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}

}
