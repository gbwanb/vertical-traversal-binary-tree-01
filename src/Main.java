import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Point> pq = new PriorityQueue<>( (p1, p2) ->
        {
            int comparison = Integer.compare(p1.col, p2.col);
            if (comparison != 0) {
                return comparison;
                comparison = Integer.compare(p1.row, p2.row);
                if (comparison != 0) {
                    return comparison;
                } else {
                    return Integer.compare(p1.val, p2.val);
                });

                private void dfs (TreeNode root, PriorityQueue < Point > pq,int row, int col) {
                    if (root == null) {
                        return;
                    }
                    pq.offer(new Point(row, col, root.val));
                    dfs(root.left, row + 1, col - 1, pq);
                    dfs(root.right, row + 1, col + 1, pq);
                }

        dfs(root, pq);
        return result;


                dfs(root, pq, 0, 0);

                int prev_col = Integer.MIN_VALUE;
                while (!pq.isEmpty()) {
                    Point point = pq.poll();

                    if (point.col != prev_col) {
                        result.add(new ArrayList<>());

                        List<Integer> column = result.get(result.size() - 1);
                        column.add(point.val);

                        prev_col = point.col;
                    }
                    return result;
                }


                private class Point {
                    {
                        int row;
                        int col;
                        int val;

                    public Point( int row, int col, int val)
                        {
                            this.row = row;
                            this.col = col;
                            this.val = val;
                        }
                    }
                }
            }
        }
    }
}

