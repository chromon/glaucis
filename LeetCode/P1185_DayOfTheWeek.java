/*
1185. Day of the Week
Easy

Given a date, return the corresponding day of the week for that date.

The input is given as three integers representing the day, month and year respectively.

Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.

 

Example 1:

Input: day = 31, month = 8, year = 2019
Output: "Saturday"
Example 2:

Input: day = 18, month = 7, year = 1999
Output: "Sunday"
Example 3:

Input: day = 15, month = 8, year = 1993
Output: "Sunday"
 

Constraints:

The given dates are valid dates between the years 1971 and 2100.
*/

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
                
        int days = 0;
        
        for (int i = 1971; i < year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                days += 366;
            } else {
                days += 365;
            }
        
        }
                
        boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        
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
        
        days += day;
        
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", 
                         "Thursday", "Friday", "Saturday"};
        
        // 1971-01-01 Firiday
        return week[(days + 4) % 7];
    }
}