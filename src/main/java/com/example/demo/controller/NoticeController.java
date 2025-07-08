package com.example.demo.controller;

import com.example.demo.entity.Faculty;
import com.example.demo.entity.Notice;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notices")
@CrossOrigin(origins = "*")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private FacultyRepository facultyRepository;

    @PostMapping
    public ResponseEntity<?> addNotice(@RequestBody Notice notice) {
        if (notice.getFaculty() == null || notice.getFaculty().getFacultyId() == null) {
            return ResponseEntity.badRequest().body("Faculty ID is required");
        }

        Faculty faculty = facultyRepository.findByFacultyId(notice.getFaculty().getFacultyId())
                .orElseThrow(() -> new RuntimeException("Faculty not found"));

        notice.setFaculty(faculty);
        return ResponseEntity.ok(noticeService.saveNotice(notice));
    }

    @GetMapping
    public List<Notice> getAllNotices() {
        return noticeService.getAllNotices();
    }

    @GetMapping("/faculty/{facultyId}")
    public List<Notice> getNoticesByFaculty(@PathVariable String facultyId) {
        return noticeService.getNoticesByFacultyId(facultyId);
    }
    @CrossOrigin(origins = "*", methods = {RequestMethod.DELETE})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Integer id) {
        noticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }
}
