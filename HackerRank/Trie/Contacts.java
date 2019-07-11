import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;

public class Contacts {
    /*
     * Complete the contacts function below.
     */

    public static void main(String[] args) {
        Contacts c = new Contacts();
        String[][] queries = new String[][]{
            {"add", "s"},
            {"add", "ss"},
            {"add", "sss"},
            {"add", "ssss"},
            {"add", "sssss"},
            {"find", "s"},
            {"find", "ss"},
            {"find", "sss"},
            {"find", "ssss"},
            {"find", "sssss"},
            {"find", "ssssss"}
        };
        System.out.println(Arrays.toString(c.contacts(queries)));
    }
    public static int[] contacts(String[][] queries) {
        Trie trie = new Trie();
        ArrayList<Integer> res = new ArrayList<>();
        for(String[] query : queries){
            if(query[0].equals("add")){
                trie.insert(query[1]);
            }else{
                res.add(trie.query(query[1]));
            }
        }
        trie.print();
        return res.stream().mapToInt(i -> i).toArray();
    }
}


class TrieNode{
    char data;
    Hashtable<Character, TrieNode> children;
    boolean isEndNode;
    public TrieNode(char data){
        this.children = new Hashtable<>();
        this.data = data;
    }
    public void print(){
        String s = "";
        TrieNode current = this;
        for(char c: current.children.keySet()){
            current.children.get(c).print();
            s+=""+c;
        }
        System.out.println(s);

    }
}



class Trie{
    TrieNode root;
    public Trie(){
        this.root = new TrieNode('#');
    }
    public void print(){
        this.root.print();

    }
    public void insert(String data){
        TrieNode current = this.root;
        for( char c : data.toCharArray()){
            if (current.children.containsKey(c)){
                current  = current.children.get(c);
            }else{
                TrieNode newNode = new TrieNode(c);
                current.children.put(c, newNode);
                current.isEndNode = false;
                current = newNode;
            }
        }
        if(current.children.size() == 0){
            current.isEndNode = true;
        }

    }
    public int query(String data){
        TrieNode current = this.root;
        for(char c: data.toCharArray()){
            if(current.children.containsKey(c)){
                current = current.children.get(c);
            }else{
                return 0;
            }
        }
        return current.children.size() + 1;
    }
}