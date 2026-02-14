class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(k==0){
            for(int i=0; i<nums.length-1; i++){
                if(nums[i]==0 && nums[i+1]==0){
                    return true;
                }
            }
            return false;
        }

        HashMap<Integer, Integer> prefixMap=new HashMap<>();
        prefixMap.put(0,-1);
        int prefixSum=0;
        for(int i=0; i<nums.length; i++){
            prefixSum+=nums[i];

            int mod=prefixSum % k;

            if(mod<0){
                mod+=k;
            }

            if(prefixMap.containsKey(mod)){

                if(i-prefixMap.get(mod)>1){
                    return true;
                }
            }
            else{
                    prefixMap.put(mod,i);
                }
        }
        return false;
    }
}