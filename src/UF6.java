public class UF6 implements UF {
    // add rank(height) of each tree, to make a balanced tree
    private int[] parent;
    private int[] pRank; // the Rank of the tree with root i

    public UF6(int size) {
        parent = new int[size];
        pRank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            pRank[i] = 1;  //initial Rank of root i is 1, one element
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //   use tree to find,  O(h). find q element's group id
    private int find(int q) {
        if (q < 0 || q >= parent.length)
            throw new IllegalArgumentException("q is out of range, find failed");
        if (q != parent[q]) {
            parent[q] = find(parent[q]); // find root and update every node's parent in the path to root;
        }
        return parent[q];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //    quick union , O(h)
    @Override
    public void unionEle(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if(pRank[pRoot] < pRank[qRoot]) {
            parent[pRoot] = qRoot;
        }else if(pRank[pRoot] > pRank[qRoot]) {
            parent[qRoot] = pRoot;
        }
        else{ // height of p is equal height of q, let q -> p, rank of p increase 1.
            parent[qRoot] = pRoot;
            pRank[pRoot] += 1;
            }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("[");
        for(int i:parent){
            res.append(i+",");
        }
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
    }
}
