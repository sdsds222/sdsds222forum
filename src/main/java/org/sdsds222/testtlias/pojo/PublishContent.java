package org.sdsds222.testtlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublishContent {

    private String author;

    private String title;

    private String content;

    private Integer cid;

    private String picurl;

    private Long posttime;

    private Integer id;

}
