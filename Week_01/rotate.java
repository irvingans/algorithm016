class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int count =0;
        for(int start = 0;count<nums.length;start++){
            int next = start;
            
            do{
                next = (next+k)%nums.length;
                int temp = nums[next];
                nums[next] = nums[start];
                nums[start] = temp;
                count++;
            }while(start!=next);

        }
    }
}