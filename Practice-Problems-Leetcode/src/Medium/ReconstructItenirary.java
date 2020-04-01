package Medium;

import java.util.*;

public class ReconstructItenirary {
		   
	 HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
	    LinkedList<String> result = null;
	    
	    public List<String> findItinerary(List<List<String>> tickets) {
	    
	        for (List<String> ticket : tickets) {
	            String origin = ticket.get(0);
	            String dest = ticket.get(1);
	            if (this.flightMap.containsKey(origin)) {
	                LinkedList<String> destList = this.flightMap.get(origin);
	                destList.add(dest);
	            } else {
	                LinkedList<String> destList = new LinkedList<String>();
	                destList.add(dest);
	                this.flightMap.put(origin,destList);
	            }
	            
	        }
	        
	        // Lets sort lexographically based on value
	        this.flightMap.forEach((key,value) -> Collections.sort(value));
	        this.result = new LinkedList<String>();
	        //Lets call the visit method which does post order DFS
	        this.Visit("JFK");
	        return this.result;        
	    }
	    
	    protected void Visit(String origin) {
	        // Visit all the outgoing edges first;
	        if (this.flightMap.containsKey(origin)) {
	            LinkedList<String> destList = this.flightMap.get(origin);
	            while(!destList.isEmpty()) {
	                // remove each edge after visiting it
	                String dest = destList.pollFirst();
	                Visit(dest);
	            }
	        }
	    
	        // add the airport to the head of the itenirary
	        this.result.offerFirst(origin);
	    } 

	    // [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
       public static void main(String[] args) {
    	   
    	   List<List<String>> tickets = new ArrayList<>();
    	   List<String> tick1 = new ArrayList<>();
    	   List<String> tick2 = new ArrayList<>();
    	   List<String> tick3 = new ArrayList<>();
    	   List<String> tick4 = new ArrayList<>();
    	   tick1.add("MUC");
    	   tick1.add("LHR");
    	   tickets.add(tick1);
    	   
    	   tick2.add("JFK");
    	   tick2.add("MUC");
    	   tickets.add(tick2);
    	   
    	   tick3.add("SFO");
    	   tick3.add("SJC");
    	   tickets.add(tick3);
    	   
    	   tick4.add("LHR");
    	   tick4.add("SFO");
    	   tickets.add(tick4);
    	   System.out.println(tickets.size());
    	   for (List<String> rx : tickets) {
    		   System.out.println(rx.get(0));
    		   System.out.println(rx.get(1));
    		   System.out.println("---");
    	   }
    	   List<String> rex = new ReconstructItenirary().findItinerary(tickets);
    	   System.out.println("printing the result");
    	   System.out.println(rex.toString());
    	   
       }     	          
}
