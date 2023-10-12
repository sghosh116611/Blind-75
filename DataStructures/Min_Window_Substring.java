package DataStructures;

public class Min_Window_Substring {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0)
                counter--;
            map[c1]--;
            end++;
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                final char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0)
                    counter++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}


// Note

// Template - 

// Template

// int findSubstring(string s){
//         vector<int> map(128,0);
//         int counter; // check whether the substring is valid
//         int begin=0, end=0; //two pointers, one point to tail and one  head
//         int d; //the length of substring

//         for() { /* initialize the hash map here */ }

//         while(end<s.size()){

//             if(map[s[end++]]-- ?){  /* modify counter here */ }

//             while(/* counter condition */){ 
                 
//                  /* update d here if finding minimum*/

//                 //increase begin to make it invalid/valid again
                
//                 if(map[s[begin++]]++ ?){ /*modify counter here*/ }
//             }  

//             /* update d here if finding maximum*/
//         }
//         return d;
//   }