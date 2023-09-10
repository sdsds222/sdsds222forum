package org.sdsds222.testtlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {

    private String author;

    private Integer classid;

    private String hits;

    private String id;

    private String picurl;

    private Long posttime;

    private String title;

}
