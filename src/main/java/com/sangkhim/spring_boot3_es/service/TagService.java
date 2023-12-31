package com.sangkhim.spring_boot3_es.service;

import com.sangkhim.spring_boot3_es.exception.BadRequestException;
import com.sangkhim.spring_boot3_es.exception.DataNotFoundException;
import com.sangkhim.spring_boot3_es.model.entity.Tag;
import com.sangkhim.spring_boot3_es.repository.jpa.TagRepository;
import com.sangkhim.spring_boot3_es.utils.Translator;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {

  private final TagRepository tagRepository;

  public List<Tag> getAllTags() {
    List<Tag> tagList = tagRepository.findAll();
    return tagList;
  }

  public Tag getById(Long id) {
    return tagRepository
        .findById(id)
        .orElseThrow(
            () ->
                new DataNotFoundException(
                    MessageFormat.format("Tag id {0} not found", String.valueOf(id))));
  }

  public Tag createOrUpdate(Tag tagRequest) {
    Optional<Tag> existingTag = tagRepository.findById(tagRequest.getId());

    if (existingTag.isPresent()) {
      Tag tagUpdate = existingTag.get();

      tagUpdate.setName(tagRequest.getName());

      return tagRepository.save(tagUpdate);
    } else {
      return tagRepository.save(tagRequest);
    }
  }

  public void deleteById(Long id) {
    Optional<Tag> tag = tagRepository.findById(id);
    if (tag.isPresent()) {
      tagRepository.deleteById(id);
    } else {
      throw new BadRequestException(Translator.toLocale("DELETE_ERROR_PLEASE_CHECK_ID"));
    }
  }
}
