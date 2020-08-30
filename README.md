# Сервис учёта использования печатных устройств

### Ограничения

* Версия java: 1.8+

### Развертывание

* Распаковать архив
* В корне архива выполнить команду ./build.sh, убедившись, что на файле выставлен флаг +x
* В корне архива выполнить команду ./start.sh, убедившись, что на файле выставлен флаг +x
* Приложение будет развернуто на порту 10001 и доступно по адресу http://localhost:10001

### Примеры запросов

* curl -X POST -H "Content-Type: application/xml" -d '<jobs><job id="4"><type>fax</type><user>user1</user><device>device4</device><amount>10</amount></job> <job id="5"><type>print</type><user>user2</user><device>device3</device><amount>22</amount></job> <job id="4"><type>copy</type><user>user2</user><device>device3</device><amount>11</amount></job></jobs>' http://localhost:10001/api/upload/jobs
* curl "http://localhost:10001/api/statistics?type=print"
* curl "http://localhost:10001/api/statistics?type=copy&user=user3&timeTo=30.08.2020T20:00"

