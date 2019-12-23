package gov.fws.daglongestpath.vo;

import gov.fws.daglongestpath.dto.Edge;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

/**
 * This is a map of all the vertices in the graph and their corresponding list of adjacent vertices
 */
public class AdjacencyMap {
    private Map<String, List<String>> map;

    public AdjacencyMap(List<Edge> graph)
    {
        map = graph.stream().collect(groupingBy(Edge::getTo, mapping(Edge::getFrom, Collectors.toList())));
    }

    public List<String> retrieveAdjacentVertices(String vertex)
    {
        return !map.containsKey(vertex) ? new ArrayList<>() : map.get(vertex);
    }

    public Set<String> getVerticesInGraph()
    {
       return map.keySet();
    }
}
