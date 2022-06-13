package Trie;

import java.util.*;

/*
Given a set of reviews provided by the customers for different hotels and a string containing Good Words, you need to sort the reviews in descending order according to their Goodness Value (Higher goodness value first).
We define the Goodness Value of a string as the number of Good Words in that string.

NOTE: Sorting should be stable. If review i and review j have the same Goodness Value then their original order would be preserved.
 */

public class Trie {
    public static ArrayList<Integer> solve(String A, ArrayList<String> B) {
        TrieNode trie = new TrieNode();
        for (String value : A.split("_")) {
            trie.add(value, null);
        }
        Map<Integer, Integer> mapCount = new LinkedHashMap<>();
        for(int i = 0; i<B.size();i++) {
            int count = 0;
            for(String word : B.get(i).split("_")) {
                if(trie.isWord(word)) count++;
            }
            mapCount.put(i,count);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(mapCount.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        ArrayList<Integer> response = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : list) {
            response.add(entry.getKey());
        }

        return response;
    }

    public static void main(String[] args){
        ArrayList<String> arr = new ArrayList<>();
        arr.add("water_is_cool");
        arr.add("cold_ice_drink");
        arr.add("cool_wifi_speed");
        solve("cool_ice_wifi", arr);
    }
}

class TrieNode{
    private Node root;
    public TrieNode(){
        this.root = new Node();
    }

    public void add(String input, Node node){
        if (node==null) { node = this.root;}
        if(input.length()==0){
            node.setEnd();
            return;
        } else if(node.getKeys().get(input.substring(0,1))==null) {
            node.getKeys().put(input.substring(0,1), new Node());
        }
        this.add(input.substring(1), node.getKeys().get(input.substring(0, 1)));
    }

    public boolean isWord(String word){
        Node node = this.root;
        while(word.length()>1){
            if(node.getKeys().get(word.substring(0,1))==null) return false;
            node =  node.getKeys().get(word.substring(0,1));
            word = word.substring(1);
        }
        return (node.getKeys().get(word)!= null && node.getKeys().get(word).isEnd());
    }
}

class Node{
    private Map<String, Node> keys;
    private boolean end;
    public Node(){
        this.keys = new HashMap<>();
        this.end = false;
    }
    public void setEnd(){
        this.end = true;
    }
    public boolean isEnd(){
        return this.end;
    }
    public Map<String, Node> getKeys(){
        return this.keys;
    }
}