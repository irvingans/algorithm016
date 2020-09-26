class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numlist = new ArrayList<>();
        for(int num: nums){
            numlist.add(num);
        }

        int first = 0;
        int last = nums.length;
        arrange(res,numlist,first,last);

        return res;
    }

    public List<List<Integer>> arrange(List<List<Integer>> res,List<Integer> nums,int first, int last) {
        if(first==last){
            res.add(new ArrayList<Integer>(nums));
        }
    
        for(int i=first;i< last;i++){
           
            Collections.swap(nums,first,i);

            arrange(res,nums,first+1,last);
            Collections.swap(nums,first,i);
        }

        return res;

}
}
    
