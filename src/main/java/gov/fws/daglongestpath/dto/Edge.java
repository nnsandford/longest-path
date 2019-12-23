package gov.fws.daglongestpath.dto;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Edge {
    @NotEmpty(message = "The to vertex cannot be null")
    private String to;

    @NotEmpty(message = "The from vertex cannot be null")
    private String from;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(to, edge.to) &&
                Objects.equals(from, edge.from);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, from);
    }
}
