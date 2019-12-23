package gov.fws.daglongestpath.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class Request {
    @Valid
    @NotEmpty(message = "The graph cannot be empty")
    private List<Edge> graph;

    @NotEmpty(message = "The vertex cannot be empty")
    private String vertex;

    public List<Edge> getGraph() {
        return graph;
    }

    public void setGraph(List<Edge> graph) {
        this.graph = graph;
    }

    public String getVertex() {
        return vertex;
    }

    public void setVertex(String vertex) {
        this.vertex = vertex;
    }
}
