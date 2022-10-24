package br.com.drope.vuttrapi.modules.Tools.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.drope.vuttrapi.modules.Tools.entities.Tool;

public interface ToolRepository extends JpaRepository<Tool, Integer> {

  public List<Tool> findByName(String name);
}
