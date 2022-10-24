package br.com.drope.vuttrapi.modules.Tools.entities.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToolDTO {

  private Integer id;
  private String title;
  private String description;
  private String link;
  private List<String> tags;
}
