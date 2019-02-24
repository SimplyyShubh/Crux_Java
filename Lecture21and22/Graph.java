package Lecture21and22;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;


public class Graph {
	private class Vertex {
		String name;
		HashMap<Vertex, Integer> neighbors;

		public Vertex(String name) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.neighbors = new HashMap<>();
		}

		public boolean equals(Object other) {
			Vertex ov = (Vertex) other;
			return this.name.equals(ov.name);
		}

		public int hashCode() {
			return this.name.hashCode();
		}

		public void display() {
			String rv = "";
			rv = rv + this.name + "=>";
			Set<Vertex> nbrs = this.neighbors.keySet();
			for (Vertex nbr : nbrs) {
				rv = rv + nbr.name + "(" + this.neighbors.get(nbr) + "),";
			}
			rv = rv + "END";
			System.out.println(rv);
		}

	}

	private HashMap<String, Vertex> vertices;

	public Graph() {
		// TODO Auto-generated constructor stub
		this.vertices = new HashMap<>();
	}

	public int numVertices() {
		return this.vertices.size();
	}

	public void addVertex(String name) {
		if (this.vertices.containsKey(name)) {
			return;
		}

		Vertex obj = new Vertex(name);
		this.vertices.put(name, obj);

	}

	public void removeVertex(String name) {
		if (!this.vertices.containsKey(name)) {
			return;
		}

		Vertex v1 = this.vertices.get(name);
		Set<Vertex> nbrs = v1.neighbors.keySet();
		for (Vertex nbr : nbrs) {
			nbr.neighbors.remove(v1);
		}
		this.vertices.remove(name);
	}

	public int numEdges() {
		int rv = 0;
		Set<String> vertices = this.vertices.keySet();
		for (String vtc : vertices) {
			Vertex vtx = this.vertices.get(vtc);
			rv = rv + vtx.neighbors.size();
		}
		rv = rv / 2;
		return rv;
	}

	public void addEdge(String name1, String name2, int cost) {
		Vertex v1 = this.vertices.get(name1);
		Vertex v2 = this.vertices.get(name2);

		if (v1 == null || v2 == null || v1.neighbors.containsKey(v2)) {
			return;
		}

		v1.neighbors.put(v2, cost);
		v2.neighbors.put(v1, cost);
	}

	public void removeEdge(String name1, String name2) {
		Vertex v1 = this.vertices.get(name1);
		Vertex v2 = this.vertices.get(name2);

		if (v1 == null || v2 == null || !v1.neighbors.containsKey(v2)) {
			return;
		}

		v1.neighbors.remove(v2);
		v2.neighbors.remove(v1);

	}

	public void display() {
		Set<String> vertices = this.vertices.keySet();
		for (String vtc : vertices) {
			Vertex vtx = this.vertices.get(vtc);
			vtx.display();
		}
	}

	public boolean hasPath(String v1, String v2) {
		Vertex vtx1 = this.vertices.get(v1);
		Vertex vtx2 = this.vertices.get(v2);
		if (vtx1 == null || vtx2 == null) {
			return false;
		}
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		return hasPathDFSI(vtx1, vtx2, explored);

	}

	private boolean hasPathDFS(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> explored) {
		if (!explored.containsKey(vtx1)) {
			explored.put(vtx1, true);
		} else {
			return false;
		}

		if (vtx1.neighbors.containsKey(vtx2)) {
			return true;
		}
		Set<Vertex> nbrs = vtx1.neighbors.keySet();
		for (Vertex nbr : nbrs) {
			if (hasPathDFS(nbr, vtx2, explored)) {
				return true;
			}
		}

		return false;
	}

	private boolean hasPathBFS(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> explored) {

		LinkedList<Vertex> queue = new LinkedList<>();
		queue.add(vtx1);
		while (!queue.isEmpty()) {
			Vertex rvtx = queue.remove();
			if (!explored.containsKey(rvtx)) {
				explored.put(rvtx, true);
				if (rvtx.neighbors.containsKey(vtx2)) {
					return true;
				} else {
					Set<Vertex> nbrs = rvtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							queue.add(nbr);
						}
					}

				}
			}

		}
		return false;

	}

	private boolean hasPathDFSI(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> explored) {

		LinkedList<Vertex> stack = new LinkedList<>();
		stack.addFirst(vtx1);
		while (!stack.isEmpty()) {
			Vertex rvtx = stack.removeFirst();
			if (!explored.containsKey(rvtx)) {
				explored.put(rvtx, true);
				if (rvtx.neighbors.containsKey(vtx2)) {
					return true;
				} else {
					Set<Vertex> nbrs = rvtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							stack.addFirst(nbr);
						}
					}

				}
			}

		}
		return false;

	}

	public void bft() {
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		Collection<Vertex> vtces = this.vertices.values();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				queue.add(vtx);
			}
			while (!queue.isEmpty()) {
				Vertex rvtx = queue.remove();
				if (!explored.containsKey(rvtx)) {
					explored.put(rvtx, true);
					System.out.println(rvtx.name);
					Set<Vertex> nbrs = rvtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							queue.add(nbr);
						}
					}

				}

			}
		}
	}

	public void dft() {
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		LinkedList<Vertex> stack = new LinkedList<>();
		Collection<Vertex> vtces = this.vertices.values();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				stack.addFirst(vtx);
			}
			while (!stack.isEmpty()) {
				Vertex rvtx = stack.removeFirst();
				if (!explored.containsKey(rvtx)) {
					explored.put(rvtx, true);
					System.out.println(rvtx.name);
					Set<Vertex> nbrs = rvtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							stack.addFirst(nbr);
						}
					}

				}

			}
		}
	}

	public boolean isConnected() {
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		Collection<Vertex> vtces = this.vertices.values();
		queue.add((Vertex) vtces.toArray()[0]);
		while (!queue.isEmpty()) {
			Vertex rvtx = queue.remove();
			if (!explored.containsKey(rvtx)) {
				explored.put(rvtx, true);
				// System.out.println(rvtx.name);
				Set<Vertex> nbrs = rvtx.neighbors.keySet();
				for (Vertex nbr : nbrs) {
					if (!explored.containsKey(nbr)) {
						queue.add(nbr);
					}
				}

			}

		}
		return this.vertices.size() == explored.size();

	}

	public ArrayList<ArrayList<String>> getCC() {
		ArrayList<ArrayList<String>> rv = new ArrayList<>();
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		Collection<Vertex> vtces = this.vertices.values();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				queue.add(vtx);
			}
			ArrayList<String> cc = new ArrayList<>();
			while (!queue.isEmpty()) {
				Vertex rvtx = queue.remove();
				if (!explored.containsKey(rvtx)) {
					explored.put(rvtx, true);
					// System.out.println(rvtx.name);
					cc.add(rvtx.name);
					Set<Vertex> nbrs = rvtx.neighbors.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							queue.add(nbr);
						}
					}

				}

			}
			if (cc.size() != 0) {
				rv.add(cc);
			}
		}
		return rv;

	}
	
	public boolean isBipartite(){
		LinkedList<Vertex> stack=new LinkedList<>();
		HashMap<Vertex, String> visited=new HashMap<>();
		Collection<Vertex> allVertices=this.vertices.values();
		for(Vertex vtx : allVertices){
			if(!visited.containsKey(vtx)){
				visited.put(vtx, "RED");
				stack.addFirst(vtx);
			}
			while(!stack.isEmpty()){
				Vertex v=stack.removeFirst();
				Set<Vertex> nbrs=v.neighbors.keySet();
				for(Vertex nbr:nbrs){
					String cov=visited.get(v);
					String colorToApply=cov.equals("RED")?"GREEN":"RED";
					if(!visited.containsKey(nbr)){
						stack.addFirst(nbr);
						visited.put(nbr, colorToApply);
					} else {
						String alreadyColor=visited.get(nbr);
						if(alreadyColor.equals(colorToApply)){
							continue;
						} else {
							return false;
						}
					}
				}
			}
		
		}
		return true;
			
	}
}