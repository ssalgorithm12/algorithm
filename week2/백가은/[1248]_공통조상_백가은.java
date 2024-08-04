package test;

import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T;
    static int V, E, input1, input2;

    static int size;
    static Node[] nodes;
    static boolean[] visited;

    static class Node {
        int element;
        Node parent, leftChild, rightChild;

        Node(int element, Node parent, Node leftChild, Node rightChild) {
            this.element = element;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            sb.append("#").append(tc).append(" ");

            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            input1 = Integer.parseInt(st.nextToken());
            input2 = Integer.parseInt(st.nextToken());

            nodes = new Node[V + 1];
            visited = new boolean[V + 1];

            //트리 만들기
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                if(nodes[parent] == null) {
                    nodes[parent] = new Node(parent, null, null, null);
                }
                if(nodes[child] == null) {
                    nodes[child] = new Node(child, nodes[parent], null, null);
                } else {
                    nodes[child].parent = nodes[parent];
                }

                if(nodes[parent].leftChild == null) {
                    nodes[parent].leftChild = nodes[child];
                } else {
                    nodes[parent].rightChild = nodes[child];
                }
            }

            //첫 번째 타겟 노드 부모 다 방문처리 하기
            getParent(nodes[input1]);
            //두 번째 타겟 노드 부모 중 처음으로 방문처리된 부모 만나면 그게 공통 조상임
            Node nearParent = findNearParent(nodes[input2]);

            //노드를 부모와 자손 관계로 정의했으므로, 자손 속성만 count 해주면 됨
            int cnt = findChildrenCnt(nearParent);

            sb.append(nearParent.element).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void getParent(Node target) {
        for(Node x = target; x != null; x = x.parent) {
            visited[x.element] = true;
        }
    }

    static Node findNearParent(Node target) {
        Node parent = nodes[1];
        for(Node x = target; x != null; x = x.parent) {
            if(visited[x.element]) {
                parent = x;
                break;
            }
        }
        return parent;
    }

    static int findChildrenCnt(Node nearParent) {
        int cnt = 1;
        if(nearParent.leftChild != null) {
            cnt += findChildrenCnt(nearParent.leftChild);
        }

        if(nearParent.rightChild != null) {
            cnt += findChildrenCnt(nearParent.rightChild);
        }

        return cnt;
    }
}