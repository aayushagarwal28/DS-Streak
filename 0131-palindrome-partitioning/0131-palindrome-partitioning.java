class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> sol = new ArrayList<>();
        solve(s,0,new ArrayList<String>(),sol);
        return sol;
    }
    
    public boolean isPalindrome(String str){
        
        int start = 0;
        int end = str.length() -1;
        
        while(start < end){
            
            
            if(str.charAt(start) != str.charAt(end))
                return false;
            
            start++;
            end--;
        }
        return true;
    }
    public void solve(String str,int start,List<String> al,List<List<String>> sol){
        
        if(start == str.length()){
            sol.add(new ArrayList(al));
            return;
        }
        
        for(int i= start; i < str.length() ; i++){
            
            String test= str.substring(start, i+1);
            
            if(isPalindrome(test)){
                al.add(test);
            
            solve(str, i + 1, al, sol);
            
            if(al.size() > 0)
            al.remove(al.size() - 1);
            }
        }
    }
}