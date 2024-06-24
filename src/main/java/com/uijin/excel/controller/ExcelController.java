package com.uijin.excel.controller;

import com.uijin.excel.service.ExcelService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/excel")
public class ExcelController {

  private final ExcelService excelService;

  @PostMapping
  public void uploadExcel(@RequestParam MultipartFile file) throws IOException {
    excelService.uploadExcel(file);
  }
}
