package com.example.demo.Services.impl;

import com.example.demo.Dtos.OutputDto.DtoOutputNewsBig;
import com.example.demo.Dtos.OutputDto.DtoOutputNewsComp;
import com.example.demo.Dtos.OutputDto.DtoOutputNewsSearching;
import com.example.demo.Entities.News;
import com.example.demo.Repositories.INewsRepo;
import com.example.demo.Services.Interfaces.INewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsService implements INewsService {

private final INewsRepo iNewsRepo;


@Override
public DtoOutputNewsBig save(News news) {
	 if(news!=null){
		  return iNewsRepo.save(news);
	 }
	 return null;
}

@Override
public void deleteById(Long newsId) {
	iNewsRepo.deleteById(newsId);
}

@Override
public Optional<DtoOutputNewsBig> findById(Long newsId) {
	 if(newsId != null) {
		  News news = iNewsRepo.findById(newsId).orElse(null);
		  if(news != null) {
				return Optional.of(DtoOutputNewsBig.builder().id(news.getId()).title(news.getTitle())
						  .newsTxt(news.getNewsTxt()).firstPhoto(news.getFirstPhoto()).photos(news.getPhotos()).build());
		  }
		  else return Optional.empty();

	 }
	 return Optional.empty();
}

@Override
public Page<DtoOutputNewsComp> getAllNews(Pageable pageable) {

	 return iNewsRepo.getAllNews(pageable);
}

@Override
public Page<DtoOutputNewsComp> getNewsByTitle(String title, Pageable pageable) {
	 return iNewsRepo.getNewsByTitle(title, pageable);
}

@Override
public Page<String> getNewsSearchingTitle(String title, Pageable pageable) {
	 return iNewsRepo.getNewsSearchingTitle(title, pageable);
}
}
