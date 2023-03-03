package com.mapper;

import com.model.kream.cs.Notice;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Not;

import java.util.List;

public interface NoticeMapper {

    Notice getNotice(int no);

    List<Notice> getNotices(int offset);

    int getNoticePages();
}
