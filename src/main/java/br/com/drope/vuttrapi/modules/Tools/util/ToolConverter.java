package br.com.drope.vuttrapi.modules.Tools.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import br.com.drope.vuttrapi.modules.Tags.entities.Tag;
import br.com.drope.vuttrapi.modules.Tools.entities.Tool;
import br.com.drope.vuttrapi.modules.Tools.entities.dto.ToolDTO;

@Component
public class ToolConverter {

  public static Tool toData(ToolDTO toolDTO) {
    Tool tool = new Tool();
    Set<Tag> tags = new HashSet<>();
    toolDTO.getTags().forEach(t -> tags.add(new Tag(null, t)));

    tool.setId(toolDTO.getId());
    tool.setName(toolDTO.getTitle());
    tool.setDescription(toolDTO.getDescription());
    tool.setLink(toolDTO.getLink());
    tool.setTags(tags);
    return tool;
  }

  public static ToolDTO toDto(Tool tool) {
    ToolDTO dto = new ToolDTO();
    List<String> tags = new ArrayList<>();

    tool.getTags().forEach(tag -> tags.add(tag.getName()));

    dto.setId(tool.getId());
    dto.setTitle(tool.getName());
    dto.setDescription(tool.getDescription());
    dto.setLink(tool.getLink());
    dto.setTags(tags);

    return dto;
  }

  public static List<ToolDTO> toListDto(List<Tool> tools) {
    List<ToolDTO> toolDTOs = new ArrayList<>();

    tools.forEach(tool -> {
      toolDTOs.add(toDto(tool));
    });

    return toolDTOs;
  }
}
