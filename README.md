MSISDN search/reserve REST API.
H2 in-memory database was used for entity storage. (DB can be accessed via http://localhost:8080/h2)

1) Use following endpoint in order to import CSV sample data into DB:
   http://localhost:8080/upload

2) List available(not reserved) MSISDNs via pattern, use following endpoint (X-can be any number):
   http://localhost:8080/search?category=all&msisdn=99XXXXX17

3) In order to book MSISDN for specific customer, use following endpoint:
   http://localhost:8080/reserve/991111111

POSTMAN scripts are provided.
