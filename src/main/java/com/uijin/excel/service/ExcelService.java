package com.uijin.excel.service;

import com.uijin.excel.entity.ExcelDataEntity;
import com.uijin.excel.repository.ExcelDataRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelService {

  private final ExcelDataRepository excelDataRepository;

  public void uploadExcel(MultipartFile file) {
    List<ExcelDataEntity> excelData = new ArrayList<>();

    if(file.isEmpty()) {
      throw new IllegalArgumentException();
    }

    try {
      Workbook workbook = WorkbookFactory.create(file.getInputStream());
      Sheet sheet = workbook.getSheetAt(0);

      for(Row row : sheet) {
        if(row.getRowNum() == 0) continue;
        ExcelDataEntity entity = ExcelDataEntity.builder()
                .name(row.getCell(0).getStringCellValue())
                .age((int)row.getCell(1).getNumericCellValue())
                .height((float)row.getCell(2).getNumericCellValue())
                .time(row.getCell(3).getLocalDateTimeCellValue())
                .build();
        excelData.add(entity);
      }
      excelDataRepository.saveAll(excelData);
    } catch (IOException e) {
      throw new InvalidParameterException();
    }
  }
}
