public class Solution {
    private List<String> res;
 
	public List<String> restoreIpAddresses(String s) {
		res = new ArrayList<>();
		if(s.length() == 0) {
			return res;
		}
		generateIpAddresses("", s);
		return res;
	}
 
	/*
	 * 在ipAddress中已经存了n - 1个数字和n - 1个点，寻找第n个数字，获得存放了n个数字的ipAddress
	 */
	private void generateIpAddresses(String ipAddress, String s) {
		int n = 0;
		for (int i = 0; i < ipAddress.length(); i++) {
			if(ipAddress.charAt(i) == '.') {
				n++;
			}
		}
		if(n == 3) {
			if(ipAddress.length() - 3 < s.length()) {
				String lastString = s.substring(ipAddress.length() - 3);
				if(lastString.length() >= 4) {
					return;
				}
				if(lastString.length() != 1 && lastString.charAt(0) == '0') {
					return;
				}
				if(Integer.valueOf(lastString) >= 0 && Integer.valueOf(lastString) <= 255) {
					res.add(ipAddress + lastString);
					return;
				}else {
					return;
				}
			}else {
				return;
			}
		}
		String[] nextString = new String[3];
		for (int i = 0; i < 3; i++) {
			if(ipAddress.length() - n + i + 1 <= s.length()) {
				nextString[i] = s.substring(ipAddress.length() - n, ipAddress.length() - n + i + 1);
				if(nextString[i].length() != 1 && nextString[i].charAt(0) == '0') {
					continue;
				}
				if(Integer.valueOf(nextString[i]) >= 0 && Integer.valueOf(nextString[i]) <= 255) {
					generateIpAddresses(ipAddress + nextString[i] + ".", s);
				}
			}
		}
		return;
	}
}