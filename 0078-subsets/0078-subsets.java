class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>>  sol = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        solve(nums,0,  new ArrayList<Integer>(),sol);
        return sol;
    }

    public void solve(int[] nums,int start, List<Integer> temp,List<List<Integer>>  sol){

    if(start == nums.length){
       
        sol.add(temp);
        return;
    }

      
     //exclude
     List<Integer> output1= new ArrayList(temp);

     //include
    List<Integer> output2= new ArrayList(temp);
    output2.add(nums[start]);

  
    
    solve(nums,start+1,output1,sol);
     solve(nums,start+1,output2,sol);



    }
}


