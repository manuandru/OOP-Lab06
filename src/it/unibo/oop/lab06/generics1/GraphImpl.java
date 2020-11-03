package it.unibo.oop.lab06.generics1;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {
	
	private final Map<N, Set<N>> map = new HashMap<>();


	public void addNode(N node) {
		if (node != null && !map.containsKey(node)) {
			map.put(node, new HashSet<>());
		}
	}


	public void addEdge(N source, N target) {
		if (source != null && target != null) {
			if (map.containsKey(source) && map.containsKey(target)) {
				Set<N> s1 = map.get(source);
				s1.add(target);
				map.put(source, s1);
			}
		}
		
	}


	public Set<N> nodeSet() {
		return new HashSet<>(map.keySet());
	}


	public Set<N> linkedNodes(N node) {
		return new HashSet<>(map.get(node));
	}

	
	public List<N> getPath(N source, N target) {
		return path(source, target, new HashSet<N>());
	}
	
	private List<N> path(N source, N target, Set<N> visited) {
		if (source == null || target == null ) {
			return new LinkedList<>();
		}
		
		if (map.get(source).contains(target)) {
			return new LinkedList<>(List.of(source, target));
		}
		
		Set<N> adj = map.get(source);
		List<N> returnValue = new LinkedList<>();
		for (N node : adj) {
			if (!visited.contains(node)) {
				visited.add(node);
				returnValue = this.path(node, target, visited);
			}
			if (!returnValue.isEmpty()) {
				returnValue.add(0, source);
				return returnValue;
			}
		}
		
		return new LinkedList<>();
	}

}
