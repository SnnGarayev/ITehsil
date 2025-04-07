package com.example.demo.Services.Interfaces;

import com.example.demo.Dtos.OutputDto.DtoOutputNewsBig;
import com.example.demo.Dtos.OutputDto.DtoOutputNewsComp;
import com.example.demo.Dtos.OutputDto.DtoOutputPodcast;
import com.example.demo.Entities.News;
import com.example.demo.Entities.Podcast;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IPodcastService {

DtoOutputPodcast save(Podcast podcast);
void deleteById(Long id);
Optional<DtoOutputPodcast> findById(Long newsId);
Page<DtoOutputPodcast> getAllPodcast(Pageable pageable);
Page<DtoOutputPodcast> getPodcastByTitle(@Param("title") String title, Pageable pageable);
Page<String> getPodcastSearchingTitle(@Param("title") String title, Pageable pageable);
}
