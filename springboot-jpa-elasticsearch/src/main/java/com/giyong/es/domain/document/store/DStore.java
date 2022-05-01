package com.giyong.es.domain.document.store;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import static org.springframework.data.elasticsearch.annotations.FieldType.Keyword;
import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "store")
public class DStore {

    @Id
    private Long id;

    @Field(type = Text)
    private String storeName;

    @Field(type = Text)
    private String storeText;

    @Field(type = Text)
    private String address;

    @Field(type = Keyword)
    private String[] tags;

    @Field(type = FieldType.Double)
    private Double lat;

    @Field(type = FieldType.Double)
    private Double lng;

    public void update(String storeText){
        this.storeText = storeText;
    }
}
