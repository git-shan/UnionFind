public class UF3 implements UF {
    // add size of each tree, to make a balanced tree
    private int[] parent;
    private int[] pSize; // the size of the tree with root i

    public UF3(int size) {
        parent = new int[size];
        pSize = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            pSize[i] = 1;  //initial size of root i is 1, one element
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
        while (q != parent[q])
            q = parent[q];
        return q;
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
        if(pSize[pRoot] < pSize[qRoot]) {
            parent[pRoot] = qRoot;
            pSize[qRoot] += pSize[pRoot];
        }else{
            parent[qRoot] = pRoot;
            pSize[pRoot] += pSize[qRoot];
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
