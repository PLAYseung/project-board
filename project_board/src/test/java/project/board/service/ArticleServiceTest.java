package project.board.service;

import io.micrometer.core.instrument.search.Search;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project.board.repository.ArticleRepository;

import static com.mysema.commons.lang.Assert.assertThat;

// 스프링부트의 슬라이스 테스트 기능을 사용하지 않고 작성

// 디펜던시 추가되어야 하는 부분이 있다면 목킹 : mockito

@DisplayName(" 비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;


    @DisplayName("게시글을 검색하면 게시글 리스트를 반환한다")
    @Test
    void givenSearchParameters_whenSearchArticles_thenReturnArticleList() {
        // Given

        // When
        List<ArticleDto> articles = sut.searchArticles(SearchType.TITLE,"search header");

        // Then
        assertThat(articles).isNotNull();
    }

}