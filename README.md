## Excel Upload Sample
MicroSoft Excel 97-2004(.xls) 혹은 .xlsx 엑셀 파일들에 대한 업로드후 데이터 DB 저장 샘플 기능 구현

---
### Implemented Feature.
1. Apache POI Library 이용 MultipartFile로 전달된 .xls, .xlsx 엑셀 파일 읽은 후 DB 저장
---
### How To Run.

~~~
프로젝트 Root 경로 이동 후 아래 gradle 명령어 실행
./gradlew clean build
./gradlew bootRun
~~~
~~~
// 엑셀 업로드 및 DB 저장 API curl
curl --location 'localhost:8080/excel' \
--form 'file=@"엑셀 파일 경로"'
~~~
---
### Description By Feature.
MS Excel 파일을 읽기 위해, Apache 재단에서 개발한 Apache POI 라이브러리를 이용  

MS Excel파일은 확장자(.xls, .xlsx)에 따라 파일구성 기반 기술이 다르게 되어 있다.  
.xls의 경우 Excel 2003 이전 버전에서 생성된 파일 형식이고, .xlsx는 Excel 2007 이후 버전에서 생성된 파일 형식이다.  
이에 따라 POI에서 excel을 읽는 방식또한 HSSF(.xls), XSSF(.xlsx)로 구분하여 기능을 제공하고 있다.  

즉 xls 확장자는 HSSF 패키지의 기능을, xlsx 확장자는 XSSF 패키지 하위의 메서드를 사용해야 하는데,  
이런 번거로움을 줄일 수 있도록 WorkbookFactory 클래스를 제공하여 해당 클래스 팩토리를 이용하여 모든 확장자를 한번에 처리  
할 수 있도록 기능을 제공 하고 있다.  

해당 프로젝트는 WorkbookFactory 클래스를 사용하여 업로드된 엑셀 파일을 읽고, DB에 업로드하는 기능을 구현해두었으며  
POI를 이용하여 엑셀파일을 읽는 것 뿐만 아니라 작성 및 수정 그리고 다양한 메서드를 통해 자유롭게 엑셀 파일을 다룰 수 있도록  
기능 제공을 하고 있다.  
