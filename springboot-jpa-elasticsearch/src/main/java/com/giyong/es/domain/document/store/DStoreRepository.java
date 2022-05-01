package com.giyong.es.domain.document.store;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DStoreRepository extends ElasticsearchRepository<DStore, Long> {

//    @Query("{\"match_phrase_prefix\":{\"storeText\":{\"query\":\"?0\",\"operator\":\"and\"}}}")
//    @Query("{\"bool\": {\"must\": [{\"match_phrase_prefix\": {\"store.storeText\": \"?0\"}}]}}")
    @Query("{\"match_phrase_prefix\": {\"storeText\": {\"query\": \"?0\"}}}")
    List<DStore> findAllByStoreTextMatchPhrasesPrefix(String text, Pageable pageable);

    @Query("{\"match\": {\"storeText\": {\"query\": \"?0\"}}}")
    List<DStore> findAllByStoreTextMatches(String text, Pageable pageable);
}
