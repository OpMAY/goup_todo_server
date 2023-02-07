package com.model.todo;

import com.model.common.Time;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class Task extends Time {
    private int no;
    private String userToken;
    private String title;
    private String content;
    private boolean complete;
}
