package NonLinearDataStructure;
import java.util.*;

public class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses == 0 || prerequisites.length == 0)
            return true;

        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int prerequisite = queue.remove();
            topo.add(prerequisite);
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return topo.size() == numCourses;
    }
}

// 1. Use topo sort to detect if the graph contains any cycle