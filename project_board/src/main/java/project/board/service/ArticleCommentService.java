package project.board.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.board.dto.ArticleCommentDto;

import java.util.List;

@Service
public class ArticleCommentService {

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComment(Long articleId) {
        return List.of();
    }
}
