package com.model.kream.style.interaction;

import com.model.common.Time;
import lombok.Data;

@Data
public class StyleCommentLike extends Time {
    private int style_comment_no;
    private int style_user_no;
}
