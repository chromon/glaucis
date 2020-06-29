/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    
    int sum = 0;
    
    public int getImportance(List<Employee> employees, int id) {
    
        if (id == 0) {
            return 0;
        }
        
        for (Employee ee: employees) {
            if (ee.id == id) {
                sum += ee.importance;
                for (int i: ee.subordinates) {
                    getImportance(employees, i);
                }
            }
        }
        
        return sum;
    }
}