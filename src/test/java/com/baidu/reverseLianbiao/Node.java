package com.baidu.reverseLianbiao;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月26日 下午5:16:52 类说明
 */
public class Node {
	private int Data;// 数据域
	private Node Next;// 指针域

	public Node(int Data) {
		// super();
		this.Data = Data;
	}
	public int getData() {
		return Data;
	}
	public void setData(int Data) {
		this.Data = Data;
	}
	public Node getNext() {
		return Next;
	}
	public void setNext(Node Next) {
		this.Next = Next;
	}
}
