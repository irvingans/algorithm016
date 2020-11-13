class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] interval1, int[] interval2){
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> merged = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(merged.size()<1||merged.get(merged.size()-1)[1] < L){
                merged.add(new int[]{L,R});
            }
            else if(merged.get(merged.size()-1)[1] >= L){
                merged.get(merged.size()-1)[1] = Math.max(R,merged.get(merged.size()-1)[1]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }
}
