/*
1154. Day of the Year
Easy

Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.

 

Example 1:

Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.
Example 2:

Input: date = "2019-02-10"
Output: 41
 

Constraints:

date.length == 10
date[4] == date[7] == '-', and all other date[i]'s are digits
date represents a calendar date between Jan 1st, 1900 and Dec 31th, 2019.
*/

class Solution {
    public int dayOfYear(String date) {
        
        String[] ds = date.split("-");
        
        int year = Integer.parseInt(ds[0]);
        int month = Integer.parseInt(ds[1]);
        int day = Integer.parseInt(ds[2]);
        
        boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        
        int days = 0;
        
        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8
                    || i == 10 || i == 12) {
                days += 31;
            } else if (i == 2) {
                if (leap) {
                    days += 29;
                } else {
                    days += 28;
                }
            } else {
                days += 30;
            }
        }
        
        return days + day;
    }
}