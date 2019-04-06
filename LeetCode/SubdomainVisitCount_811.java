class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < cpdomains.length; i++) {
            String[] sa = cpdomains[i].split(" ");
            
            map.put(sa[1], map.getOrDefault(sa[1], 0) + Integer.parseInt(sa[0]));
            
            int index = sa[1].indexOf(".");
            while (index >= 0) {
                String domain = sa[1].substring(index + 1);
                map.put(domain, map.getOrDefault(domain, 0) + Integer.parseInt(sa[0]));
                index = domain.indexOf(".");
                sa[1] = domain;
            }
        }
        
        for (String key: map.keySet()) {
            res.add(map.get(key) + " " + key);
        }
        
        return res;
    }
}