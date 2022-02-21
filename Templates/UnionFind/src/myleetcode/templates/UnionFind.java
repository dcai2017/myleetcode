package myleetcode.templates;

public class UnionFind {
    int [] father;
    public UnionFind(int N) {
        father = new int[N];
    }
    int findFather(int x) {
        if (father[x]!=x)
            father[x]=findFather(father[x]);
        return father[x];
    }
    void union(int x, int y) {
        int px=findFather(x);
        int py=findFather(y);
        if (px!=py)
            father[py]=px;
    }
}
