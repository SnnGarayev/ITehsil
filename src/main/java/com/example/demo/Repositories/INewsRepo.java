package com.example.demo.Repositories;

import com.example.demo.Dtos.OutputDto.DtoOutputCity;
import com.example.demo.Dtos.OutputDto.DtoOutputNewsBig;
import com.example.demo.Dtos.OutputDto.DtoOutputNewsComp;
import com.example.demo.Dtos.OutputDto.DtoOutputNewsSearching;
import com.example.demo.Entities.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface INewsRepo extends JpaRepository<News, Long> {


	 DtoOutputNewsBig save(News news);
	 void deleteById(Long id);

	 Optional<News> findById(Long id);

	 @Query("SELECT new com.example.demo.Dtos.OutputDto.DtoOutputNewsComp(n.id,n.title,n.firstPhoto,n.sharingDate) " +
				"FROM News n ORDER BY n.sharingDate DESC")
	 Page<DtoOutputNewsComp> getAllNews(Pageable pageable);

	 @Query("SELECT new com.example.demo.Dtos.OutputDto.DtoOutputNewsComp(n.id,n.title,n.firstPhoto,n.sharingDate) " +
				"FROM News n WHERE  LOWER(n.title) LIKE LOWER(CONCAT('%', :title, '%')) " +
				"ORDER BY  n.sharingDate DESC ")
	 Page<DtoOutputNewsComp> getNewsByTitle(@Param("title") String title, Pageable pageable);

	 @Query("SELECT n.title FROM News n " +
				"WHERE  LOWER(n.title) LIKE LOWER(CONCAT('%', :title, '%')) " +
				"ORDER BY  n.title DESC ")
	 Page<String> getNewsSearchingTitle(@Param("title") String title, Pageable pageable);



}
