package project.board.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import project.board.config.SecurityConfig;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 - 게시글")
@Import(SecurityConfig.class)
@WebMvcTest(ArticleController.class) // 테스트 대상이 되는 컨트롤러만 불러온다
class ArticleControllerTest {

    private final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }


//    @Disabled("구현 중") // 단위 메소드들을 테스트에서 제외시킬 수 있다
    @DisplayName("[view] [GET] 게시글 리스트 {게시판} 페이지 - 정상 호출")
    @Test
    public  void givenNothing_whenRequestingArticlesView_thenReturnArticlesView() throws Exception {
        // Given

        // When & Then
        mvc.perform(MockMvcRequestBuilders.get("/articles"))
                .andExpect(status().isOk()) // 요청응답이 ok 인가?
                // CompatibleWith : 호환되는 타입 까지 맞다고 인정 해줌
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)) // 컨텐트 내용에 타입이 무엇인가?, view 라서 TEXT_HTML
                .andExpect(view().name("articles/index")) // 여기에 뷰가 있어야 한다
                .andExpect(model().attributeExists("articles")); // 이 뷰는 데이터가 있을 것이다 왜냐하면 이번페이지 게시글 목록이 보여야 하기 때문에 모델에트리뷰트로 밀어 넣어준다
    }

    @DisplayName("[view] [GET] 게시글 상세 페이지 - 정상 호출")
    @Test
    public  void givenNothing_whenRequestingArticleView_thenReturnArticleView() throws Exception {
        // Given

        // When & Then
        mvc.perform(MockMvcRequestBuilders.get("/articles/1"))
                .andExpect(status().isOk()) // 요청응답이 ok 인가?
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)) // 컨텐트 내용에 타입이 무엇인가?, view 라서 TEXT_HTML
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("article")) // 이 뷰는 데이터가 있을 것이다 왜냐하면 이번페이지 게시글 목록이 보여야 하기 때문에 모델에트리뷰트로 밀어 넣어준다
                .andExpect(model().attributeExists("articleComments"));
    }

    @Disabled("구현 중")
    @DisplayName("[view] [GET] 게시글 검색 전용 페이지 - 정상 호출")
    @Test
    public  void givenNothing_whenRequestingArticleSearchView_thenReturnArticleSearchView() throws Exception {
        // Given

        // When & Then
        mvc.perform(MockMvcRequestBuilders.get("/articles/search"))
                .andExpect(status().isOk()) // 요청응답이 ok 인가?
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)) // 컨텐트 내용에 타입이 무엇인가?, view 라서 TEXT_HTML
                .andExpect(model().attributeExists("articles/search"));
    }

    @Disabled("구현 중")
    @DisplayName("[view] [GET] 게시글 해시태그 검색 페이지 - 정상 호출")
    @Test
    public  void givenNothing_whenRequestingArticleHashtagSearchView_thenReturnArticleHashtagSearchView() throws Exception {
        // Given

        // When & Then
        mvc.perform(MockMvcRequestBuilders.get("/articles/search-hashtag"))
                .andExpect(status().isOk()) // 요청응답이 ok 인가?
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)) // 컨텐트 내용에 타입이 무엇인가?, view 라서 TEXT_HTML
                .andExpect(model().attributeExists("articles/search-hashtag"));
    }


}