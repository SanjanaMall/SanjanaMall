import java.util.*;

class Solution {
    
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        
        // An IP address has exactly 4 parts
        backtrack(s, 0, 0, "", result);
        
        return result;
    }
    
    public void backtrack(String s, int index, int parts, 
                           String current, List<String> result) {
        
        // If we have used 4 parts
        if (parts == 4) {
            // All digits must also be used
            if (index == s.length()) {
                result.add(current.substring(0, current.length() - 1));
            }
            return;
        }
        
        // A part can have at most 3 digits
        for (int len = 1; len <= 3; len++) {
            
            // Don't go outside the string
            if (index + len > s.length()) {
                break;
            }
            
            String part = s.substring(index, index + len);
            
            // Leading zero is not allowed
            // Example: "01" is invalid
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }
            
            // Value must be between 0 and 255
            int value = Integer.parseInt(part);
            
            if (value > 255) {
                break;
            }
            
            // Choose this part
            backtrack(
                s,
                index + len,
                parts + 1,
                current + part + ".",
                result
            );
        }
    }
}