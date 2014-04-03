/*
 * This file is part of Shortest-Path-Server.
 * 
 * Copyright (c) 2014 Charles Strong
 * 
 * Shortest-Path-Server is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * Shortest-Path-Server is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with Shortest-Path-Server.
 * If not, see http://www.gnu.org/licenses/.
 */

package core;

import java.util.Set;
import java.util.HashSet;
/*
 * @author charles.strong
 */
public class DirectedGraph {
    
    //constructor
    DirectedGraph(Set<Vertex> vertices, Set<Edge> edges)
    {
        this._isAcyclic = NullableBoolean.NOTSET;
        this._vertices = vertices;
        this._edges = edges;
        
        //determine if is acyclic
        this.IsAcyclic();
       
    }
    
    //private member variables
    private NullableBoolean _isAcyclic;
    
    private Set<Vertex> _vertices;
    private Set<Edge> _edges;
      
    //public methods
    public boolean IsAcyclic()
    {
        //A directed graph can be Acyclic only if there are no Directed loops
        //Meaning you cannot start and return to any given vertex
        //(following path direction)
        
        if(this._isAcyclic == NullableBoolean.NOTSET)
        {
            //add logic to determine if this DirectedGraph is acyclic
        	//currently unneeded because we are told that all input graphs are acyclic
        	//but if you would like to expand the program this makes it possible.
        	//for now just set to true
        	this._isAcyclic = NullableBoolean.TRUE;
        }
        
        return (this._isAcyclic == NullableBoolean.TRUE);
    }
    
    public int GetGraphSize()//Graph size is defined as the number of edges in a directed graph
    {
    	return this._edges.size();
    }
    
    public int GetGraphOrder()//graph order is defined as the number of vertices in a graph
    {
    	return this._vertices.size();
    }
      
    public Set<Vertex> GetVertices()
    {
        return this._vertices;
    }
    
    public Set<Edge> GetEdges()
    {
        return this._edges;
    }    
    
    public String FindShortestPath(int origin, int destination)
    {
        if(!this.IsAcyclic())
            return "Error: Graph is not acyclic" ;//Add error: We only want Acyclic Graphs
        
        Vertex startVertex = this.GetVertexWithIdentifier(origin);
                
        int totalDistance = Integer.MAX_VALUE;
        
        String decision = "";
        
        //quick answers
    	//is the start also the end?
        if(origin == destination)
        {
    		totalDistance = 0;
    		decision = String.format("%d->%d (0) START AND END ARE EQUAL", origin, destination);
        }
    	else//is the end directly connected to the start via a single edge?
    	{
    		//we can assume this is correct because the weights are all unsigned integers 
    		//All paths will be positive
    		for(Edge edge : startVertex.GetEdges())
    		{
    			if(edge.GetDestination() == destination)
    			{
    				totalDistance = edge.GetDistance();
    				decision = String.format("%d->%d (%d)", origin, destination, totalDistance);
    			}
    		}
    	}
        
        Vertex currentVertex = startVertex;
        if(totalDistance == Integer.MAX_VALUE)
        {
        	
        }
        
       
    }
    
    //private methods
    
    private Set<Vertex> GetUncheckedVertices()
    {
    	Set<Vertex> uncheckedVertices = new HashSet<Vertex>();
    	for(Vertex vertex : this._vertices)
    	{
    		if(!vertex.HasBeenChecked())
    		{
    			uncheckedVertices.add(vertex);
    		}
    	}
    	
    	return uncheckedVertices;
    }

    private Vertex GetVertexWithIdentifier(int identifier)
    {
    	Vertex identifiedVertex = null;
    	for(Vertex vertex : this._vertices)
    	{
    		if(vertex.GetIdentifier() == identifier)
    		{
    			identifiedVertex = vertex;
    		}
    	}
    	return identifiedVertex;
    }
}
