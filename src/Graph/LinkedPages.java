package Graph;

import java.util.*;

/*
You have a function f(p) that returns an array of linked pages e.g
f(homepage) = {page1, page2, page3}. Or f(page1) = {page4, page5}.
If there is no linked pages function will return null.
And we say one site is a good site if we can get to any page of that site in a less than 6 clicks.
The task was to write a function that will check is it a good site or not using f(p).

- Use breadth first search in order to find shortest path to already visited pages # breadth first good(pages, visitedPages, depth) if depth > 5 return false if pages.empty return true newPages = List() for p in pages subPages = f(p) for sp in subPages if !visitedPages.contains(sp) visitedPages.add(sp) newPages.add(sp) return good(newPages, visitedPages, depth + 1) good(homepage, List(), 0)
- The solution mentioned by Alexey Matveev has a flaw. What if later during the traversal we found shorter path to a page. To allow this we need to keep track of distance for each node and visit the node event it is already visited e.g. by using Map. Finally we need to check the distance of each node to see if it is greater than 5.
 */
public class LinkedPages {
    public static boolean isGoodSite(Map<String, List<String>> graph) {
        Set<String> visited = new HashSet<String>();
        List<String> nodes = graph.get("homepage");
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add("homepage");
        while(!queue.isEmpty() && visited.size()<graph.size()){
            String node = queue.poll();
            visited.add(node);
            for(String neighbor : graph.get(node)){
                queue.add(neighbor);
            }
            count++;
        }

        return count < 6;

    }

}
