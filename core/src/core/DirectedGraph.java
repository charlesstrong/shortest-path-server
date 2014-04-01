/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.ArrayList;
import java.util.Dictionary;
/**
 *
 * @author charles.strong
 */
public class DirectedGraph {
    
    //constructor
    DirectedGraph( List<Edge> edges, Integer edgeCount)
    {
        
        this._isAcyclic = NullableBoolean.NOTSET;
        this._vertices = new ArrayList<Vertex>();
        
        this.BuildGraph();

        //determine if is acyclic
        this.IsAcyclic();
       
    }
    
    //private member variables
    private NullableBoolean _isAcyclic;
    
    private List<Vertex> _vertices;
    
    //private instance methods
    private void BuildGraph()
    {
        
    }
    
    private void AddVertex(Vertex vertex)
    {
        this._vertices.add(vertex);
    }
    
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
      
    public List<Vertex> GetVertices()
    {
        return this._vertices;
    }
    
    public void FindShortestPath(int originID, int destinationID)
    {
        if(!this.IsAcyclic())
            return;//Add error: Wee only want Acyclic Graphs
        
        //logic here
    }
    
}
