class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> al =  new ArrayList<>();
        
        
        solve(nums,0,target,al,sol);
        
        return sol;
    }
    
    public void solve(int[] nums,int start,int target,List<Integer> al,List<List<Integer>> sol){
        
      
        //base  case 
        if(start == nums.length){
            // means you have traversed the array .
            if(target == 0)
                sol.add(new ArrayList(al));
            
            return;
        }
       
//        System.out.println(al.toString());
       
        //include
        if(nums[start] <= target){
        
        al.add(nums[start]);
        solve(nums,start,target-nums[start],al,sol);
        
        //backtrack on return
        al.remove(al.size()-1);
            
        }
        
        
        //exclude
        
        solve(nums,start+1,target,al,sol);
        
       
    }
}