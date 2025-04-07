package com.example.demo.Repositories;

import com.example.demo.Dtos.OutputDto.DtoOutputNewsBig;
import com.example.demo.Dtos.OutputDto.DtoOutputNewsComp;
import com.example.demo.Dtos.OutputDto.DtoOutputNewsSearching;
import com.example.demo.Dtos.OutputDto.DtoOutputPodcast;
import com.example.demo.Entities.News;
import com.example.demo.Entities.Podcast;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IPodcastRepo extends JpaRepository<Podcast, Long> {

DtoOutputPodcast save(Podcast podcast);
void deleteById(Long podcastId);

Optional<Podcast> findById(Long podcastId);

@Query("SELECT new com.example.demo.Dtos.OutputDto.DtoOutputPodcast(p.id,p.title,p.movieLink,p.sharingDate) " +
		  "FROM Podcast p ORDER BY p.sharingDate DESC")
Page<DtoOutputPodcast> getAllPodcast(Pageable pageable);

@Query("SELECT new com.example.demo.Dtos.OutputDto.DtoOutputPodcast(p.id,p.title,p.movieLink,p.sharingDate) " +
		  "FROM Podcast p " +
		  "WHERE  LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%')) " +
		  "ORDER BY  p.sharingDate DESC ")
Page<DtoOutputPodcast> getPodcastsSearchingTitle(@Param("title") String title, Pageable pageable);

@Query("SELECT p.title FROM Podcast p " +
		  "WHERE  LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%')) " +
		  "ORDER BY  p.title DESC ")
Page<String> getPodcastsTitle(@Param("title") String title, Pageable pageable);
}
