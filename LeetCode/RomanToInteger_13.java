class Solution {
    public int romanToInt(String s) {
       
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int result = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++){
            if (map.containsKey(chars[i])){
                int value = map.get(chars[i]);
                if ((i == chars.length - 1) || map.get(chars[i+1]) <= map.get(chars[i])) {
                    result += value;
                } else {
                    result -= value;
                }
            }
        }
        
        return result;
    }
}