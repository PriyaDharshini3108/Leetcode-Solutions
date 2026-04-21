class Solution {

    class DSU{
        int []parent;
        DSU(int n){
            parent =new int [n];
            for(int i=0;i<n;i++) parent[i]=i;
        }
        int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
                
            }
            return parent[x];
        }
        void union (int x , int y){
            int px= find(x);
            int py=find(y);
            if(px!=py){
                parent[px]=py;
            }
        }
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        
        //intuition : if we swap any values, that can only be possible if they are from same components.
        DSU dsu = new DSU(n);
        for(int []swap:allowedSwaps){
            dsu.union(swap[0],swap[1]);//graph ban jayega isse component wise
        }

        //grouping indexes by parents
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i<n;i++){
            int par= dsu.find(i);
            map.computeIfAbsent(par,k-> new ArrayList()).add(i);
        }

        int d=0;//taking cnt of different elements

        ///...now go to each group and match with target elem...
        //first iterate over each index marked along with their parents & put source ele corresponding to these idx in a map and store its freq
        //then compare with target ele @idx , incement d when diff ele found
        for(List<Integer> l:map.values()){
            //we will put source values in this frq map
            Map<Integer,Integer> freq= new HashMap<>();
            for (int idx : l){
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
            }

            //comparing with target
            for(int idx:l){
                int v=target[idx];
                if(freq.getOrDefault(v,0)>0){
                    freq.put(v,freq.get(v)-1);
                }else{
                    d++;
                }
            }
        }
        return d;
    }
}