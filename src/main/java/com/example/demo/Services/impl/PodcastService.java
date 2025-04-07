package com.example.demo.Services.impl;
import com.example.demo.Dtos.OutputDto.DtoOutputPodcast;
import com.example.demo.Entities.Podcast;
import com.example.demo.Repositories.IPodcastRepo;
import com.example.demo.Services.Interfaces.IPodcastService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PodcastService implements IPodcastService {

IPodcastRepo podcastRepo;

@Override
public DtoOutputPodcast save(Podcast podcast) {
	 if(podcast!=null){
		  return podcastRepo.save(podcast);
	 }
	 return null;
}

@Override
public void deleteById(Long id) {
	 podcastRepo.deleteById(id);
}

@Override
public Optional<DtoOutputPodcast> findById(Long podcastId) {
	 if(podcastId != null) {
		  Podcast podcast = podcastRepo.findById(podcastId).orElse(null);
		  if(podcast != null) {
				return Optional.of(DtoOutputPodcast.builder().id(podcast.getId()).title(podcast.getTitle())
						  .movieLink(podcast.getMovieLink()).sharingDate(podcast.getSharingDate()).build());
		  }
		  else return Optional.empty();

	 }
	 return Optional.empty();
}

@Override
public Page<DtoOutputPodcast> getAllPodcast(Pageable pageable) {
	 return podcastRepo.getAllPodcast(pageable);
}

@Override
public Page<DtoOutputPodcast> getPodcastByTitle(String title, Pageable pageable) {
	 return podcastRepo.getPodcastsSearchingTitle(title, pageable);
}

@Override
public Page<String> getPodcastSearchingTitle(String title, Pageable pageable) {
	 return podcastRepo.getPodcastsTitle(title, pageable);
}
}
