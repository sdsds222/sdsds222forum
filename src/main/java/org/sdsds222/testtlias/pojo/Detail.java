package org.sdsds222.testtlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detail {

    private String author;

    private String title;

    private Long posttime;

    private String content;

    private Integer classid;

    private  Integer id;

    private String picurl;

}
