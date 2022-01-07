/*
1496. Path Crossing
Easy

Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.

 

Example 1:


Input: path = "NES"
Output: false 
Explanation: Notice that the path doesn't cross any point more than once.
Example 2:


Input: path = "NESWW"
Output: true
Explanation: Notice that the path visits the origin twice.
 

Constraints:

1 <= path.length <= 104
path[i] is either 'N', 'S', 'E', or 'W'.
*/

class Solution {
    public boolean isPathCrossing(String path) {
        
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        
        set.add(x + "," + y);
        
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else {
                x--;
            }
            
            if (set.contains(x + "," + y)) {
                return true;
            }
            
            set.add(x + "," + y);
        }
        return false;
    }
}