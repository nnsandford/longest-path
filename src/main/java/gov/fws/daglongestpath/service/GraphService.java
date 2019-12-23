package gov.fws.daglongestpath.service;

import gov.fws.daglongestpath.vo.AdjacencyMap;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GraphService {
    public String calculateLongestPath(AdjacencyMap graph, String vertex)
    {
        Deque<String> sorted = topologicalSort(graph);
        Map<String, Integer> distances = graph.getVerticesInGraph().stream().collect(Collectors.toMap(Function.identity(), x -> Integer.MAX_VALUE));

        distances.put(vertex, 0);

        while (!sorted.isEmpty())
        {
            String next = sorted.pop();

            if (distances.get(next) != null && distances.get(next) != Integer.MAX_VALUE)
            {
                for (String neighbor : graph.retrieveAdjacentVertices(next))
                {
                    if (distances.get(neighbor) != null && distances.get(neighbor) > distances.get(next))
                    {
                        distances.put(neighbor, distances.get(next) + 1);
                    }
                }
            }
        }

        return sorted.stream().collect(Collectors.joining(" -> "));
    }

    private Deque<String> topologicalSort(AdjacencyMap graph)
    {
        Set<String> vertices = graph.getVerticesInGraph();
        Map<String, Boolean> visited = vertices.stream().collect(Collectors.toMap(Function.identity(), x -> false));
        Deque<String> deque = new ArrayDeque<>();

        for (String v : vertices)
        {
            if (visited.get(v) != null && !visited.get(v))
            {
                sortUtil(graph, v, visited, deque);
            }
        }

        return deque;
    }

    private void sortUtil(AdjacencyMap graph, String vertex, Map<String, Boolean> visited, Deque deque)
    {
        visited.put(vertex, true);

        graph.retrieveAdjacentVertices(vertex).stream().forEach(next -> {
            if (visited.get(next) != null && !visited.get(next))
            {
                sortUtil(graph, next, visited, deque);
            }
        });

        deque.push(vertex);
    }
}
