import java.util.*;

class Solution {

    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Interval[] arr;
    Result[][] dp;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();

        arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by left endpoint
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l)
                return Integer.compare(a.l, b.l);

            if (a.r != b.r)
                return Integer.compare(a.r, b.r);

            return Integer.compare(a.idx, b.idx);
        });

        dp = new Result[n + 1][5];

        Result ans = solve(0, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        Arrays.sort(result);

        return result;
    }

    Result solve(int pos, int remaining) {

        if (pos >= n || remaining == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[pos][remaining] != null) {
            return dp[pos][remaining];
        }

        // Option 1: Skip current interval
        Result skip = solve(pos + 1, remaining);

        // Option 2: Take current interval
        int next = findNext(pos);

        Result takeNext = solve(next, remaining - 1);

        List<Integer> takeIndices = new ArrayList<>();

        takeIndices.add(arr[pos].idx);
        takeIndices.addAll(takeNext.indices);

        Result take = new Result(
            (long) arr[pos].w + takeNext.score,
            takeIndices
        );

        dp[pos][remaining] = better(take, skip);

        return dp[pos][remaining];
    }

    // First interval whose left endpoint > current right endpoint
    int findNext(int pos) {

        int target = arr[pos].r;

        int lo = pos + 1;
        int hi = n;

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if (arr[mid].l > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

   Result better(Result a, Result b) {

    if (a.score != b.score) {
        return a.score > b.score ? a : b;
    }

    List<Integer> x = new ArrayList<>(a.indices);
    List<Integer> y = new ArrayList<>(b.indices);

    Collections.sort(x);
    Collections.sort(y);

    if (lexicographicallySmaller(x, y)) {
        return new Result(a.score, x);
    }

    return new Result(b.score, y);
}
    boolean lexicographicallySmaller(List<Integer> a, List<Integer> b) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        // If one is prefix of another, shorter one is smaller
        return a.size() < b.size();
    }
}