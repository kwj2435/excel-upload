package com.uijin.excel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_EXCEL_DATA")
public class ExcelDataEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "EXCEL_DATA_ID")
  private Long excelDataId;

  private String name;

  private int age;

  private float height;

  private LocalDateTime time;
}
