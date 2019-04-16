class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < emails.length; i++) {
        
            StringBuffer sbf = new StringBuffer();
            String[] name = emails[i].split("@");
            String[] rname = name[0].split("\\+");
            
            sbf.append(rname[0].replace(".", "")).append("@").append(name[1]);
            set.add(sbf.toString());
        }
        
        return set.size();
    }
}