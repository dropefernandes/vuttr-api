package br.com.drope.vuttrapi.modules.Tags.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.drope.vuttrapi.modules.Tags.entities.Tag;
import br.com.drope.vuttrapi.modules.Tags.repositories.TagRepository;

@Service
public class TagService {

  @Autowired
  private TagRepository tagRepository;

  public void create(Tag tag) {
    tagRepository.save(tag);
  }
}
