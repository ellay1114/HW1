
public class Assignment01Q05 {

    public static int findShortestPath(int[][] m, int i, int j) {
        int n = m.length;
        int[] dist = new int[n];
        boolean[] alreadyChecked = new boolean[n];
        boolean[] toCheck = new boolean[n];
        int next = i;

        // Init the distances array
        for (int k = 0; k < n; k++) {
            dist[k] = Integer.MAX_VALUE;
        }
        dist[i] = 0;

        toCheck[i] = true;

        while (next != -1) {
            if (next == j) {
                // We found a path from i to j
                return dist[next];
            }

            alreadyChecked[next] = true;
            toCheck[next] = false;

            for (int step : getNextSteps(m, next)) {
                if (step != -1 && !alreadyChecked[step]) {
                    toCheck[step] = true;
                    if (dist[next] + 1 < dist[step]) {
                        dist[step] = dist[next] + 1;
                    }
                }
            }

            next = getNextToCheck(toCheck, alreadyChecked, dist);
        }

        // Failed to find a path
        return -1;
    }

    /**
     * Return the next node to check (with the shortest path from the start)
     *
     * @return an array of the nodes that are connected to curr, -1 for empty
     * elements.
     */
    private static int[] getNextSteps(int[][] m, int curr) {
        int[] steps = new int[m.length];
        int index = 0;
        for (int k = 0; k < m.length; k++) {
            if (m[curr][k] == 1) {
                steps[index++] = k;
            }
        }

        for (int i = index; i < m.length; i++) {
            steps[index++] = -1;
        }

        return steps;
    }

    /**
     * Return the next node to check (with the shortest path from the start)
     */
    private static int getNextToCheck(boolean[] toCheck, boolean[] alreadyChecked, int[] dist) {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int k = 0; k < toCheck.length; k++) {
            if (toCheck[k] && !alreadyChecked[k] && dist[k] < minDist) {
                minDist = dist[k];
                minIndex = k;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        System.out.println(
                findShortestPath(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 0, 1)); // -1
        System.out.println(
                findShortestPath(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 1, 1)); // 0
        System.out.println(
                findShortestPath(new int[][]{{0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {1, 0, 0, 0}}, 0, 2)); // 2
        System.out.println(
                findShortestPath(new int[][]{{0, 1, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 1, 0}}, 0, 2)); // 2
    }
}
