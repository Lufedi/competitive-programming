import java.util.*;

class Pair {
    String node;
    int distance;

    public Pair(String node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "hit";
        String b = "cog";
        List<String> c = new ArrayList<String>();
        c.add("hot");
        c.add("dot");
        c.add("dog");
        c.add("lot");
        c.add("log");
        c.add("cog");

        s.ladderLength(a, b, c);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, List<String>> map = createGraph(wordList);
        int res = bfs(beginWord, endWord, map);
        System.out.println(res);
        return res + 1;
    }

    public int bfs(String root, String target, Map<String, List<String>> map) {
        Queue<Pair> queue = new LinkedList<Pair>();
        Set<String> visited = new HashSet<String>();

        queue.add(new Pair(root, 0));
        visited.add(root);
        while (!queue.isEmpty()) {
            Pair top = queue.poll();
            String node = top.node;
            if (node == target) {
                return top.distance;
            }
            List<String> adjacents = map.get(node);

            for (String next : adjacents) {
                if (!visited.contains(next)) {
                    queue.add(new Pair(next, top.distance + 1));
                    visited.add(next);
                }
            }
        }
        return -1;
    }

    public Map<String, List<String>> createGraph(List<String> words) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        words.forEach(word -> {
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                List<String> adj = map.getOrDefault(newWord, new ArrayList<String>());
                adj.add(word);
                map.put(newWord, adj);
            }
        });
        words.forEach(word -> {
            Set<String> adjSet = new HashSet<String>();
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                List<String> adj = map.getOrDefault(newWord, new ArrayList<String>());
                adj.forEach(n -> adjSet.add(n));
            }
            map.put(word, new ArrayList<String>(adjSet));
        });
        return map;
    }
}