package gov.fws.daglongestpath.controller;

import gov.fws.daglongestpath.dto.Request;
import gov.fws.daglongestpath.service.GraphService;
import gov.fws.daglongestpath.vo.AdjacencyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/graphs")
public class GraphController {
    @Autowired
    private GraphService graphService;

    @PostMapping
    public ResponseEntity<String> computeLongestPath(@RequestBody @Valid Request request)
    {
        return ResponseEntity.ok(graphService.calculateLongestPath(new AdjacencyMap(request.getGraph()), request.getVertex()));
    }
}
