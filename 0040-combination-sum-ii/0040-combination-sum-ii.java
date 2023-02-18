class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        
        //Approach - generate different subsequences 
        
        //sort, so that same elements are together . like [1,1,1,2,2] and target = 4
        Arrays.sort(candidates);
        
        List<List<Integer>> sol = new ArrayList<>();
        
        List<Integer> temp = new ArrayList<>();
        
        solve(candidates,0,target,temp,sol);
        
       
        return sol;
        
    }
    
    public void solve(int[] arr,int start,int target,List<Integer> temp,List<List<Integer>> sol){
    
        
        //base case 
        if(target == 0){
            sol.add(new ArrayList(temp));
            return;
        }
        
        
        // if start =0 , we loop from 0 to n-1 . 
        // suppose we pick 1 at 0th index, there is no point in picking 1 from 
        //index 2 and 3 . It will otherwise generate duplicates combinations 
        
        for(int i= start; i< arr.length;i++){
            
            
            //don't pick if already picked .
            if(i > start && arr[i] == arr[i-1])
                continue;
            
            // we can't pick if arr[i] > target
            if(arr[i] > target)
                break;
            
            
            //pick the first unique 
            temp.add(arr[i]);
            
            
            solve(arr,i+1,target-arr[i],temp,sol);
            
            
            //backtrack 
            temp.remove(temp.size() -1);
            
        }
        
    }
}