package com.baidu.reverseLianbiao;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月26日 下午5:17:33 类说明
 */
public class NodeTest {

	public static void main(String[] args) {
		Node head = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);

		// 反转链表
		head = reverse(head);

		while (head != null) {
			System.out.println(head.getData());
			head = head.getNext();
		}
	}

	public static Node reverse(Node head) {
		Node pre = head;
		Node cur = head.getNext();
		Node tmp;
		while (cur != null) {
			tmp = cur.getNext();
			cur.setNext(pre);

			pre = cur;
			cur = tmp;
		}
		head.setNext(null);
		return pre;
	}
}
