package findingPath;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Depth_First_Search {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Node: ");
        int node = input.nextInt();
        System.out.print("Enter Edge: ");
        int edge = input.nextInt();
        Depth_First_Search Node = new Depth_First_Search(node);
        System.out.println("Enter " + edge + " Edges ");
        for (int i = 0; i < edge; i++) {
            int source = input.nextInt();
            int des = input.nextInt();
            Node.Edge(source, des);
        }
        System.out.print("Enter The Source: ");
        int source = input.nextInt();
        Node.DFS(source);
    }


    public LinkedList<Integer> adjacency[];

    Depth_First_Search(int node) {
        adjacency = new LinkedList[node];
        for (int i = 0; i < node; i++) {
            adjacency[i] = new LinkedList<>();
        }
    }
    public void Edge(int source, int des) {
        adjacency[source].add(des);
        adjacency[des].add(source);
    }
    public void DFS(int source) {
        boolean visited[] = new boolean[adjacency.length];
        int parent[] = new int[adjacency.length];
        Stack<Integer> s = new Stack<>();
        s.add(source);
        visited[source] = true;
        parent[source] = -1;
        while (!s.isEmpty()) {
            int current = s.pop();
            System.out.print(current);
            for (int i : adjacency[current]) {
                if (visited[i] != true) {
                    visited[i] = true;
                    s.add(i);
                    parent[i] = current;  }
            } }
    }
}
