package com.cooksys.pojo;

import java.util.List;

public class Graph {
	
	private List<Vertex> vertexes;
	
	private List<Edge> edges;
	
	public Graph(List<Vertex> vertexes, List<Edge> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public List<Vertex> getVertexes() {
		return vertexes;
	}

	public void setVertexes(List<Vertex> vertexes) {
		this.vertexes = vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
		result = prime * result + ((vertexes == null) ? 0 : vertexes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Graph other = (Graph) obj;
		if (edges == null) {
			if (other.edges != null)
				return false;
		} else if (!edges.equals(other.edges))
			return false;
		if (vertexes == null) {
			if (other.vertexes != null)
				return false;
		} else if (!vertexes.equals(other.vertexes))
			return false;
		return true;
	}

}
