package br.com.drope.vuttrapi.modules.Tools.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.drope.vuttrapi.exceptions.ApiException;
import br.com.drope.vuttrapi.modules.Tools.entities.dto.ToolDTO;
import br.com.drope.vuttrapi.modules.Tools.services.ToolService;

@RestController
@RequestMapping(value = "/api/v1/tools")
public class ToolController {

  @Autowired
  private ToolService toolService;

  @GetMapping
  public ResponseEntity<List<ToolDTO>> findAll() {
    return ResponseEntity.ok().body(toolService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ToolDTO> findById(@PathVariable Integer id) throws ApiException {
    return ResponseEntity.ok().body(toolService.findById(id));
  }

  @PostMapping
  public ResponseEntity<ToolDTO> create(@RequestBody ToolDTO toolDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(toolService.create(toolDTO));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    toolService.deleteById(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
