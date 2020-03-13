# thymeleaf-board

>> 단순히 thymeleaf 를 사용하고 싶어서 사용함.
>> static file 이 spring tomcat에서 작동하는 부분을 해결하기 위해서 react.js 를 이용하여 수정할 계획임.



# thymeleaf-frontend

"thymeleaf-frontend" 프로젝트는 게시판의 화면을 구성하는 프로젝트입니다. 게시판 목록 호출 및 게시글 등록, 수정, 삭제는 아래의 링크에서 확인할 수 있는 "thymeleaf-backend" 프로젝트를 같이 구동해줘야 합니다.

이 프로젝트를 로컬 환경으로 내려받기 하셨다면 "src/main/java/com/acma/app/" 경로에 있는 "ThymeleafFrontendApplication.java" 파일을 열어 "마우스 우클릭 > Run As(또는 Debug As) > Spring Boot App" 을 선택하여 실행하시면 됩니다.

기본 url은 http://localhost:8080/board/list 로 접근하시면 됩니다.



# thymeleaf-backend

"thymeleaf-backend" 프로젝트는 게시판의 서버를 구성하는 Rest Api Server 프로젝트입니다.

이 프로젝트를 로컬 환경으로 내려받기 하셨다면 "src/main/java/com/acma/app/" 경로에 있는 "ThymeleafBackendApplication.java" 파일을 열어 "마우스 우클릭 > Run As(또는 Debug As) > Spring Boot App" 을 선택하여 실행하시면 됩니다.

기본 url은 http://localhost:8081/api/boards 로 접근하시면 데이터를 확인하실 수 있습니다.

화면을 통해서 게시판 목록 확인 및 게시글 등록, 수정, 삭제가 필요한 경우, 아래의 링크에서 확인할 수 있는 "thymeleaf-frontend" 프로젝트를 같이 구동해줘야 합니다.
