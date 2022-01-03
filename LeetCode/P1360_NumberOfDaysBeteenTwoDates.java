/*
1360. Number of Days Between Two Dates
Easy

Write a program to count the number of days between two dates.

The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.

 

Example 1:

Input: date1 = "2019-06-29", date2 = "2019-06-30"
Output: 1
Example 2:

Input: date1 = "2020-01-15", date2 = "2019-12-31"
Output: 15
 

Constraints:

The given dates are valid dates between the years 1971 and 2100.
*/

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        
        if (date1.compareTo(date2) < 0) {
            String temp  = date1;
            date1 = date2;
            date2 = temp;
        }
        
        return getDays(date1) - getDays(date2);
    }
    
    private int getDays(String date) {
        String[] ds = date.split("-");
        
        int y = Integer.parseInt(ds[0]);
        int m = Integer.parseInt(ds[1]);
        int d = Integer.parseInt(ds[2]);
        
        int days = 0;
        
        for (int i = 1970; i < y; i++) {
            if (leapYear(i)) {
                days += 366;
            } else {
                days += 365;
            }
        }
        
        for (int i = 1; i < m; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8
                    || i == 10 || i == 12) {
                days += 31;
            } else if (i == 2) {
                if (leapYear(y)) {
                    days += 29;
                } else {
                    days += 28;
                }
            } else {
                days += 30;
            }
        }
        
        days += d;
        
        return days;
    }
    
    private boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}