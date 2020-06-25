public class UF1 implements UF {
    private int []id;
    public UF1(int size){
        id = new int[size];
        for(int i=0;i<size;i++){
            id[i]=i;
        }
    }
    @Override
    public int getSize(){
        return id.length;
    }
//  quick find, just use index, O(1). find q element's group id
    private int find(int q){
        if(q<0 || q>=id.length)
            throw new IllegalArgumentException("q is out of range, find failed");
        return id[q];
    }

    @Override
    public boolean isConnected( int p, int q){
        return find(p) == find(q);
    }
//    Union needs to check all id[], O(n)s
    @Override
    public void unionEle(int p, int q){
        int pID = find(p);
        int qID = find(q);
        if(pID == qID){
            return;
        }
        for(int i=0; i<id.length; i++){
            if(id[i] ==pID)
                id[i] = qID;
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("[");
        for(int i:id){
            res.append(i+",");
        }
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
    }
}
