import java.util.stream.*;
class Solution {

    public String[] arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv",
    "wxyz"};

    public List<String> letterCombinations(String digits) {

        String temp= "";
        List<String> sol = new ArrayList<>();

        if(digits.length() == 0)
        return sol;
        solve(digits,0,new ArrayList<Character>(),sol);
        return sol;
    }

    public void solve(String digits,int start,List<Character> temp,List<String> sol ){

          if(start == digits.length()){
              String str= temp.stream().map(c -> c.toString()).collect(Collectors.joining(""));
              sol.add(str);
              return;
          }

         
        String str= arr[Integer.parseInt(""+digits.charAt(start))];

        for(int i=0; i< str.length(); i++){
            temp.add(str.charAt(i));
            solve(digits,start+1,temp,sol);
             temp.remove(temp.size() -1);
        }
    }
}