package kr.or.jaspersoft.android.talkplaza.common.ref.tree;

import java.util.ArrayList;
import java.util.List;

public final class Node {
	/** 현재 노드 아이디 */
	public long id = 0l;
	/** 상위 노드 아이디 */
	public long parent = 0l;
	/** 하위 노드 아이디 집함 */
	public List<Long> child = new ArrayList<Long>();
	/** 하위 노드 로딩 완료 여부 */
	public boolean completed = false;
	
	public Node(long id, long parent) {
		this.id = id;
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", parent=" + parent + ", completed="
				+ completed + "]";
	}
}
