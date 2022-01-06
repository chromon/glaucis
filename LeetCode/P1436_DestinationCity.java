/*
1436. Destination City
Easy

You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.

 

Example 1:

Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo" 
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
Example 2:

Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are: 
"D" -> "B" -> "C" -> "A". 
"B" -> "C" -> "A". 
"C" -> "A". 
"A". 
Clearly the destination city is "A".
Example 3:

Input: paths = [["A","Z"]]
Output: "Z"
 

Constraints:

1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
All strings consist of lowercase and uppercase English letters and the space character.
*/

class Solution {
    /*
    public String destCity(List<List<String>> paths) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < paths.size(); i++) {
            map.put(paths.get(i).get(0), map.getOrDefault(paths.get(i).get(0), 0) + 1);
        }
        
        for (int i = 0; i < paths.size(); i++) {
            String ca = paths.get(i).get(0);
            String cb = paths.get(i).get(1);
            
            if (!map.containsKey(ca)) {
                return ca;
            } else if (!map.containsKey(cb)) {
                return cb;
            }
        }
        
        return null;
    }
    */
    
    public String destCity(List<List<String>> paths) {
        String curr = paths.get(0).get(0);
        String dest = paths.get(0).get(1);
        
        while (dest != null) {
            curr = dest;
            dest = getDest(paths, curr);
        }
        
        return curr;
    }
    
    private String getDest(List<List<String>> paths, String curr) {
        for (int i = 0; i < paths.size(); i++) {
            if (paths.get(i).get(0).equals(curr)) {
                return paths.get(i).get(1);
            }
        }
        return null;
    }
}