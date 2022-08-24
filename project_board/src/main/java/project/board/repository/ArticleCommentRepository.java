package project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.board.domain.ArticleComment;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {

}
