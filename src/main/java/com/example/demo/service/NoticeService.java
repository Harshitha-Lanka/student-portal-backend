package com.example.demo.service;

import com.example.demo.entity.Notice;
import java.util.List;

public interface NoticeService {
    Notice saveNotice(Notice notice);
    List<Notice> getAllNotices();
    List<Notice> getNoticesByFacultyId(String facultyId);
    void deleteNotice(Integer id);

}
