package qna.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeleteHistoryRepository extends JpaRepository<DeleteHistory, Long> {
    DeleteHistory findByContentId(Long expected);
}
