package com.mapper;

import com.model.kream.cs.Notice;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Not;

import java.util.List;
import java.util.Map;

public interface NoticeMapper {

    Notice getNotice(int no);

    List<Notice> getNotices(int offset);

    int getNoticePages();

    void addNotice(Notice notice);

    void updateNotice(Map<String,Object> data);

    void deleteNotice(int no);
}
