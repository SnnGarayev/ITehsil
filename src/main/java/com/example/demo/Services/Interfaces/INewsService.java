package com.example.demo.Services.Interfaces;

import com.example.demo.Dtos.OutputDto.DtoOutputNewsBig;
import com.example.demo.Dtos.OutputDto.DtoOutputNewsComp;
import com.example.demo.Dtos.OutputDto.DtoOutputNewsSearching;
import com.example.demo.Entities.News;
import com.example.demo.Repositories.INewsRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface INewsService {

DtoOutputNewsBig save(News news);
void deleteById(Long id);
Optional<DtoOutputNewsBig> findById(Long newsId);
Page<DtoOutputNewsComp> getAllNews(Pageable pageable);
Page<DtoOutputNewsComp> getNewsByTitle(@Param("title") String title, Pageable pageable);
Page<String> getNewsSearchingTitle(@Param("title") String title, Pageable pageable);



}
