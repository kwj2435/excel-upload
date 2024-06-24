package com.uijin.excel.repository;

import com.uijin.excel.entity.ExcelDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcelDataRepository extends JpaRepository<ExcelDataEntity, Long> {
}
