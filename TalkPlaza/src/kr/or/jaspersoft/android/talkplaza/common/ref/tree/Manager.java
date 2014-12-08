package kr.or.jaspersoft.android.talkplaza.common.ref.tree;

import java.util.ArrayList;
import java.util.List;

import kr.or.jaspersoft.android.talkplaza.common.obj.Talk;
import android.support.v4.util.LongSparseArray;

public final class Manager {
	/** 최상위 노드 키 */
	public long top = 0l;
	/** 노드 트리 구성 완료 여부 */
	public boolean complete = false;
	/** 노드 트리 구성 정보 컨테이너 */
	public LongSparseArray<Node> nodes = new LongSparseArray<Node>();
	/** 노드 트리 상세 정보 컨테이너 */
	public LongSparseArray<Talk> contents = new LongSparseArray<Talk>();
	
	/** 생성자 */
	public Manager(Node topNode) {
		top = topNode.id;
		nodes.put(top, topNode);
	}
	
	/** 하위 노드 로딩할 노드 아이디 정보 조회 */
	public List<Long> filledUpNodes() {
		List<Long> ns = new ArrayList<Long>();
		int count = nodes.size();
		for (int i=0; i<count; i++) {
			Node node = nodes.get(nodes.keyAt(i));
			if (!node.completed) {
				ns.add(node.parent);
			}
		}
		if (ns.size() == 0) {
			// 로딩할 노드가 없을 때 완료 표시
			complete = true;
		}
		return ns;
	}
	
	/** 로딩한 노드 정보를 컨테이너에 채우기 */
	public void setUpNodes(List<Node> ns) {
		int count = ns.size();
		for (int i=0; i<count; i++) {
			Node remoteode = ns.get(i);
			
			Node existNode = nodes.get(remoteode.id);
			existNode.child = remoteode.child;
			existNode.completed = true;
			
			int childCount = existNode.child.size();
			for (int k=0; k<childCount; k++) {
				long chilldrenId = existNode.child.get(k);
				Node children = new Node(chilldrenId, existNode.id);
				nodes.append(chilldrenId, children);
			}
		}
	}
	
	/** 컨텐츠 조회 */
	public Talk getContent(long contentId) {
		return contents.get(contentId);
	}
	
	/** 컨텐츠 추가 */
	public void addContent(Talk content) {
		contents.append(content.id, content);
	}
}
