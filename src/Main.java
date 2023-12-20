// This is Kacy Codes solution to the LeetCode problem: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
// from https://www.youtube.com/watch?v=H1n3GZb3i0c

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        TreeNode root = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(Solution.verticalTraversal(root));
    }

    public static class Solution {
        public static List<List<Integer>> verticalTraversal(TreeNode root) {


            List<List<Integer>> result = new ArrayList<>();
            PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) ->
            {
                int comparison = Integer.compare(p1.col, p2.col);
                if (comparison != 0)
                    return comparison;

                comparison = Integer.compare(p1.row, p2.row);
                if (comparison != 0)
                    return comparison;

                return Integer.compare(p1.val, p2.val);
            });

            dfs(root, pq, 0, 0);

            int prev_col = Integer.MIN_VALUE;

            while (!pq.isEmpty()) {
                Point point = pq.poll();

                if (point.col != prev_col)
                    result.add(new ArrayList<>());
                List<Integer> column = result.get(result.size() - 1);
                column.add(point.val);

                prev_col = point.col;
            }

            return result;
        }

        private static void dfs(TreeNode root, PriorityQueue<Point> pq, int row, int col) {
            if (root == null)
                return;

            pq.offer(new Point(row, col, root.val));
            dfs(root.left, pq, row + 1, col - 1);
            dfs(root.right, pq, row + 1, col + 1);
        }

        private static class Point {
            int row;
            int col;
            int val;

            public Point(int row, int col, int val) {
                this.row = row;
                this.col = col;
                this.val = val;
            }
        }
    }
}





