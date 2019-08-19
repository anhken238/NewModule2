package com.codegym.repository;

import com.codegym.model.Author;
import com.codegym.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends PagingAndSortingRepository<Post,Long> {
    Iterable<Post> findAllByAuthor (Author author);
    Page<Post> findAllByTitleContaining(String title, Pageable pageable);

    @Query(value = "SELECT p FROM Post p INNER JOIN Author a ON p.author = a WHERE a.nameAuthor =:nameAuthor ")
    Page<Post> findPostsByAuthorName (@Param("nameAuthor")String nameAuthor, Pageable pageable);

    //xoa mem trang thai status
    Page<Post> findAllByStatus(boolean status, Pageable pageable);

    Page<Post> findAllByTitleContainingAndStatus (String title, boolean status, Pageable pageable);

    Page<Post> findAllByStatusAndAuthor_NameAuthor (boolean status,String nameAuthor, Pageable pageable);


}
