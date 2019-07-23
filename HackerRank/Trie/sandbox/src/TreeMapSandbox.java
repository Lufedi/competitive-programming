import java.util.*;

class TreeMapSandbox{
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(50, "d");
        map.put(60, "e");
        map.put(70, "f");
        map.put(80, "g");
        map.put(90, "h");
        map.put(10, "a");
        map.put(30, "b");
        map.put(40, "c");
       

        print(map);
        System.out.println(map.firstKey()+"fk"+map.firstEntry().getValue());
        System.out.println("ceiling 71 " + map.ceilingKey(71));
        System.out.println("Floor 75 " + map.floorKey(71));
        System.out.println("Head 75");
        print(map.headMap(75));
        System.out.println("Higher key 80 " + map.higherKey(80));
        System.out.println("Last " + map.lastKey());
        System.out.println("Lower key " + map.lowerKey(80));
        System.out.println("Tail 75");
        print(map.tailMap(75));
    }

    public static void print(SortedMap<Integer, String> map){
        map.entrySet().forEach( obj-> System.out.println( obj.getKey() +"," + obj.getValue()));
        System.out.println("keys");
        map.keySet().forEach(key -> System.out.println(key));
        
    }

}