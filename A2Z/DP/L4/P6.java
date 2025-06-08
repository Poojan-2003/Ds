import java.util.Arrays;
import java.util.Collections;

public class P6 {
    // O(g.length log g.length + s.length logs.length + O(g.length,+s.length)) => O(N logn + M logM) => N = g.length M = s.length
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        s = Arrays.stream(s).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        // [4,7,9], trainers = [8,8,5,2]
        // [10,9,8,7] [5,6,7,8]
        // [7 8 9 10] [8 7 6 5]
        int i = 0;
        int j = s.length-1;

        int cnt = 0;
        while (i < g.length && j >= 0) {
            if (g[i] <= s[j]) {
                cnt++;
                i++;
                j--;
            } else {
                j--;
            }
        }
        return cnt;

    }

}
