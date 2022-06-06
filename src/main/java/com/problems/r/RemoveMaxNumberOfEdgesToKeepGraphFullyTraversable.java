package com.problems.r;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] fa = new int[n];

        int common = remove(fa, edges, 3);
        int alice = remove(fa, edges, 1);
        boolean aliceFinish = finish(fa);

        remove(fa, edges, 3);
        int bob = remove(fa, edges, 2);
        boolean bobFinish = finish(fa);
        if (!aliceFinish || !bobFinish) {
            return -1;
        }
        return common + alice + bob;
    }

    int remove(int[] fa, int[][] edges, int type) {
        if (type == 3) {
            for (int i = 0; i < fa.length; i++) {
                fa[i] = i;
            }
        }
        int res = 0;
        for (int[] e : edges) {
            if (e[0] != type) {
                continue;
            }
            int u = e[1] - 1, v = e[2] - 1;
            int fu = find(u, fa), fv = find(v, fa);
            if (fu == fv) {
                res++;
            } else {
                union(fu, fv, fa);
            }
        }
        return res;
    }

    boolean finish(int[] fa) {
        int root = find(0, fa);
        for (int i = 1; i < fa.length; i++) {
            if (find(i, fa) != root) {
                return false;
            }
        }
        return true;
    }

    int find(int x, int[] fa) {
        if (x == fa[x]) {
            return x;
        }
        fa[x] = find(fa[x], fa);
        return fa[x];
    }

    void union(int x, int y, int[] fa) {
        x = find(x, fa);
        y = find(y, fa);
        if (x == y) {
            return;
        }
        fa[x] = y;
    }
}
