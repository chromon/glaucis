public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        List<String> local = new ArrayList<>();
        
        dfs(s, 0, local, res);
        
        return res;
 
    }
    
    private void dfs(String s, int index,
                    List<String> local,
                    List<List<String>> res){
            			// 这里 >= 是为了处理空字符串这种特殊情况, 不然res里面什么都没有, 其实
        				// 应该return一个含有空集的集合
                        if(index >= s.length()){
                            res.add(new ArrayList<String>(local));
                            return;
                        }
                        
        				// 切一个字符
                        if(index + 1 <= s.length()){
                            local.add(s.substring(index, index + 1));
                            dfs(s, index + 1, local, res);
                            local.remove(local.size() - 1);
                        }
                        
        				// 切两个字符
                        if(index + 2 <= s.length()){
                            local.add(s.substring(index, index + 2));
                            dfs(s, index + 2, local, res);
                            local.remove(local.size() - 1);
                        }
                        
                        return;
                    }
}