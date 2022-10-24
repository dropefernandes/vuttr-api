package br.com.drope.vuttrapi.modules.Tools.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.drope.vuttrapi.exceptions.ApiException;
import br.com.drope.vuttrapi.modules.Tags.repositories.TagRepository;
import br.com.drope.vuttrapi.modules.Tools.entities.Tool;
import br.com.drope.vuttrapi.modules.Tools.entities.dto.ToolDTO;
import br.com.drope.vuttrapi.modules.Tools.repositories.ToolRepository;
import br.com.drope.vuttrapi.modules.Tools.util.ToolConverter;

@Service
public class ToolService {

  @Autowired
  private ToolRepository toolRepository;

  @Autowired
  private TagRepository tagRepository;

  public List<ToolDTO> findAll() {
    List<Tool> tools = toolRepository.findAll();
    return ToolConverter.toListDto(tools);
  }

  public ToolDTO findById(Integer id) throws ApiException {
    var tool = toolRepository.findById(id).orElseThrow(
        () -> ApiException.badRequest("Ferramenta não encontrada", "Ferramenta não encontrada ou não existe!"));
    return ToolConverter.toDto(tool);
  }

  public ToolDTO create(ToolDTO toolDTO) {
    Tool tool = ToolConverter.toData(toolDTO);
    tagRepository.saveAll(tool.getTags());
    var response = toolRepository.save(tool);
    return ToolConverter.toDto(response);
  }

  public void deleteById(Integer id) {
    toolRepository.deleteById(id);
  }

  public List<ToolDTO> findByTagName(String name) {
    List<Tool> tools = toolRepository.findByName(name);
    return ToolConverter.toListDto(tools);
  }
}
