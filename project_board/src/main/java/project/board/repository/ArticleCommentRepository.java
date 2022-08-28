package project.board.repository;

import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import project.board.domain.ArticleComment;
import project.board.domain.QArticleComment;

@RepositoryRestResource
public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,
        QuerydslPredicateExecutor<ArticleComment>, // 이 아티클 안에 있는 기본 검색 기능을 추가
        QuerydslBinderCustomizer<QArticleComment> {

    @Override // 검색에 대한 새부적 규칙
    default void customize(QuerydslBindings bindings, QArticleComment root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.content, root.createdBy, root.createdAt); // 검색이 되는 영역
        bindings.bind(root.content).first((StringExpression::containsIgnoreCase)); // 이그젝트 매치에서 룰 변경, 검색 파라미터 1개만 받음 // output : like '%s{v}%'
        bindings.bind(root.createdBy).first(((StringExpression::containsIgnoreCase)));
        bindings.bind(root.createdAt).first(((DateTimeExpression::eq)));

    }
}