package br.com.drope.vuttrapi.modules.Tags.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.drope.vuttrapi.modules.Tags.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
