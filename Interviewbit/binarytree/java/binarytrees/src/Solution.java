
import java.util.ArrayList;


public class Solution {
    public String countAndSay(int index) {
        ArrayList<Character> next = new ArrayList<Character>();
        ArrayList<Character> current = new ArrayList<Character>();
        current.add('1');
        if(index == 1){
            return "1";
        }
        for (int i = 0; i < index-1; i++) {
            next = parse(current);
            current = next;
        }
        StringBuffer res = new StringBuffer();
        res.append("");
        next.forEach(c -> res.append(c));
        return res.toString();
    }

    public ArrayList<Character> parse(ArrayList<Character> sequence){
        if(sequence.size() == 0){
            return new ArrayList<Character>();
        }
        sequence.add('|');
        char currentChar = sequence.get(0);
        ArrayList<Character> res = new ArrayList<Character>();
        int currentCounter = 1;
        for (int i = 1; i < sequence.size(); i++) {
            if(sequence.get(i)==sequence.get(i-1)){
                currentCounter++;
            }else{
                res.add((char)(currentCounter + '0'));
                res.add(currentChar);
                currentCounter = 1;
                currentChar  = sequence.get(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(6));
    }
}