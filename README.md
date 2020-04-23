# 회의실 등록/예약 시스템

- [이벤트 스토밍]
http://msaez.io/#/storming/v6yaEno8WqfCemrDXoccLRh7I922/mine/433769c9d91ff363818e546d59bf2586/-M5U_szBMbDiuaV-GcpC
![event_storming](https://user-images.githubusercontent.com/63284387/80049019-cb1e7100-854c-11ea-8cc5-05695b0fd2aa.PNG)

- [서비스 개요]

  - 서비스명: 회의실 등록 예약 시스템
  - 개요: 관리자가 사용할 수 있는 회의실을 등록하면 직원이 회의실을 예약하고, 취소한다.
  - 시나리오:
      - 기능적 요구사항
        1) 관리자는 회의실 번호와 회의실 장소를 등록한다.
        2) 관리자는 회의실 번호와 회의실 장소를 삭제한다.
        3) 사용자는  관리자가 등록하여 상태가 변경된 회의실을 가지고 회의실 번호와 장소를 예약한다.
        4) 사용자는 회의실 번호와 장소를 예약 취소한다.
        5) 사용자가 예약을 완료하면 메일로 확인알림을 발송한다.
        
     - 비기능적 요구사항
        1) 트랜잭션: 예약완료 되지 않은 회의실은 아예 예약자체가 성립되지 않아야 한다.
        2) 장애관리: 메일발송 관리가 장애로 인해 진행되지 않더라도 회의실 예약 기능은 365*24 가능해야 한다.
        3) 성능: 예약이 완료될 때마다 메일 발송으로 예약 확인 완료를 해줘야 한다.
