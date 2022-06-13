package Trie;

import java.util.HashMap;
import java.util.Map;

/*
How will you implement auto-complete ?
- use tries
- Your data structure should be tries.
- if the scale of the trie data is big like 10 TB you can shard the trie based on first 2 (or 1) characters and have a hash function which will calculate a hostname based on first 2 (or 1) characters of a word. This should be the starting point for discussions
 */
public class AutoComplete {


}

class TrieComplete {
    NodeComplete root;
    public TrieComplete(){
        this.root = new NodeComplete();
    }

    public String autoComplete(String sequence) {
        NodeComplete node = this.root;
        String response = "";
        for(String ch : sequence.split("")) {
            if(node.keys.get(ch)==null) return response;
            node = node.keys.get(ch);
            response.concat(ch);
            if (node.isEnd()) {
                return response;
            }
        }
        while(!node.isEnd()){
            var entry = node.keys.entrySet().iterator().next();
            response.concat(entry.getKey());
            node = entry.getValue();
        }
        return response;

    }
}

class NodeComplete{
    boolean end;
    Map<String, NodeComplete> keys;

    public NodeComplete(){
        this.keys = new HashMap<>();
        this.end = false;
    }

    public void setEnd(){
        this.end = true;
    }

    public boolean isEnd(){
        return this.end;
    }
}
