class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer , HashSet<Integer>> map = new HashMap<> ();
        for(int s : stones){
            map.put(s,new HashSet<>());
        }

        map.get(0).add(0);
        for(int i=0;i<stones.length;i++){
            for(int k:map.get(stones[i])){
                for(int size = k-1; size<=k+1;size++){
                    if(size>0&&map.containsKey(stones[i]+size)){
                        map.get(stones[i]+size).add(size);
                    }
                }
            }
        }

        if(map.get(stones[stones.length-1]).isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
}
