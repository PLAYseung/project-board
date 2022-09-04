package project.board.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import project.board.domain.Article;
import project.board.domain.type.SearchType;
import project.board.dto.ArticleCommentDto;
import project.board.dto.ArticleDto;
import project.board.dto.ArticleUpdateDto;
import project.board.repository.ArticleRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

// 스프링부트의 슬라이스 테스트 기능을 사용하지 않고 작성

// 디펜던시 추가되어야 하는 부분이 있다면 목킹 : mockito

@DisplayName(" 비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면 게시글을 반환한다")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnArticleList() {
        // Given


        // When
       Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE,"search keyword"); // 제목, 본문, ID, 닉네임, 해시태그

        // Then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 검색하면 게시글을 반환한다")
    @Test
    void givenArticleID_whenSearchingArticle_thenReturnArticle() {
        // Given


        // When
        ArticleDto articles = sut.searchArticle(1L); // ID

        // Then
        assertThat(articles).isNotNull();
    }


    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {
        // Given
        given(articleRepository.save(any(Article.class))).willReturn(null);  // 실제로 저장이 잘 일어나는지 확인 // Article 이면 아무거나 // 'saveArticle에서 내부적으로 save가 호출 될 것이다' 라는 코드

        // When
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(),"Yu", "title", "content", "hashtag"));

        // Then
        then(articleRepository).should().save(any(Article.class)); // save를 한번 호출 했는가?
    }

    @DisplayName("게시글의 ID와 수정 정보를 입력하면, 게시글을 수정한다")
    @Test
    void givenArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdatesArticle() {
        // Given
        given(articleRepository.save(any(Article.class))).willReturn(null);  // 실제로 저장이 잘 일어나는지 확인 // Article 이면 아무거나 // 'saveArticle에서 내부적으로 save가 호출 될 것이다' 라는 코드

        // When
        sut.updateArticle(1L , ArticleUpdateDto.of("title", "content", "hashtag"));

        // Then
        then(articleRepository).should().save(any(Article.class)); // save를 한번 호출 했는가?
    }

    @DisplayName("게시글의 ID를 입력하면, 게시글을 삭제한다")
    @Test
    void givenArticleId_whenUpdatingArticle_thenDeletesArticle() {
        // Given
        willDoNothing().given(articleRepository).delete(any(Article.class));  // 실제로 저장이 잘 일어나는지 확인 // Article 이면 아무거나 // 'saveArticle에서 내부적으로 save가 호출 될 것이다' 라는 코드

        // When
        sut.deleteArticle(1L );

        // Then
        then(articleRepository).should().save(any(Article.class)); // save를 한번 호출 했는가?
    }


}