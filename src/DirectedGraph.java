/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.util.HashSet;
/**
 *
 * @author charles.strong
 */
public class DirectedGraph {
    
    //constructor
    DirectedGraph(HashSet vertices, HashSet<Edge> edges)
    {
        this._isAcyclic = NullableBoolean.NOTSET;
        this._vertices = vertices;
        this._edges = edges;
        
        //determine if is acyclic
        this.IsAcyclic();
       
    }
    
    //private member variables
    private NullableBoolean _isAcyclic;
    
    private HashSet _vertices;
    private HashSet<Edge> _edges;
      
    //public methods
    public boolean IsAcyclic()
    {
        //A digraph can be Acyclic only if there are no Directed loops
        //Meaning you cannot start and return to any given vertex
        //(following path direction)
        
        if(this._isAcyclic == NullableBoolean.NOTSET)
        {
            //add logic to determine if this DirectedGraph is acyclic
        }
        
        return (this._isAcyclic == NullableBoolean.TRUE);
    }
      
    public HashSet GetVertices()
    {
        return this._vertices;
    }
    
    public HashSet<Edge> GetEdges()
    {
        return this._edges;
    }
    
    public int GetNumberOfEdges()
    {
        return this._edges.size();
    }
    
    public void FindShortestPath(int originID, int destinationID)
    {
        if(!this.IsAcyclic())
            return;//Add error: Wee only want Acyclic Graphs
        
        //logic here
    }
    
}
