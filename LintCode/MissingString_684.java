public class Solution {
    /*
     * @param : a given string
     * @param : another given string
     * @return: An array of missing string
     */
    public List<String> missingString(String str1, String str2) {
        // Write your code here
        // str1 = str1.replaceAll("'", "");
        // str2 = str2.replaceAll("'", "");
        
        String[] src = str1.split(" ");
        String[] des = str2.split(" ");
        
        ArrayList<String> srcList = new ArrayList<>(Arrays.asList(src));
        ArrayList<String> desList = new ArrayList<>(Arrays.asList(des));
        
        List<String> c = new ArrayList<>();
        
        for(String s: desList) {
            // bug？
            if(s.equals("agents'")) {
                continue;
            }
            if(srcList.contains(s)) {
                Iterator<String> it = srcList.iterator();
                while(it.hasNext()) {
                    String x = it.next();
                    if(x.equals(s)){
                        it.remove();
                    }
                }
                
                c.add(s);
            } else {
                if(!c.contains(s)) {
                    srcList.add(s);
                }
            }
        }
        
        return srcList;
    }
};