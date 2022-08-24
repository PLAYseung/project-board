package project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.board.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {


}