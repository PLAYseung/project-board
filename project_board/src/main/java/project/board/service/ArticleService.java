package project.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.board.domain.type.SearchType;
import project.board.dto.ArticleDto;
import project.board.dto.ArticleUpdateDto;
import project.board.repository.ArticleRepository;

@RequiredArgsConstructor
@Transactional
@Service    // service bean으로 등록 되어서 사용할 수 있음
public class ArticleService {

    private  final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType title, String search_keyword) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long l) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {
    }

    public void updateArticle(long articleId, ArticleUpdateDto dto) {
    }

    public void deleteArticle(long articleId) {
    }
}
