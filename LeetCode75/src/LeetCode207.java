import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pku-lyh
 * @Description 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * @date 2025/1/8 10:50
 */
public class LeetCode207 {
    // 边
    class Pair{
        int index;
        public Pair(int index) {
            this.index = index;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 存储numCouses个课程的边
        List<Pair>[] edges = new ArrayList[numCourses];
        int n = prerequisites.length;
        // 存储入度
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            edges[prerequisites[i][1]].add(new Pair(prerequisites[i][0]));
            indeg[prerequisites[i][0]]++;
        }
        // 入度为0的入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()){
            int index = queue.poll();
            visited++;
            for (Pair pair : edges[index]) {
                indeg[pair.index]--;
                if (indeg[pair.index] == 0) {
                    queue.offer(pair.index);
                }
            }
        }
        return visited == numCourses;
    }
}
