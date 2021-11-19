/*14. Longest Common Prefix
In this problem, we have to find the common prefix of the given string array list. We can solve this problem in O(n) time complexity.
At the start, take the first string in the array as a starting point.
In the for loop compare the first saved string with the next available string from the array. If the string does not match then reduce the last character of the string by 1 and compare it again. If match is found then move on to the next string in the array. By the end you will get the common longest prefix
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String prefx = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefx) != 0){
                prefx = prefx.substring(0, prefx.length() - 1);
                if(prefx.isEmpty()) return "";
            }
        }
        return prefx;
    }
}