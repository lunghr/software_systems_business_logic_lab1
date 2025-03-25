# Software Systems Business Logic | Lab 1 | Tupichenko Mila | Konstantinova  Maria

## Задание

Описать бизнес-процесс в соответствии с нотацией BPMN 2.0, после чего реализовать его в виде приложения на базе Spring
Boot.

    Вариант №890: OZON маркетплейс — миллионы товаров по выгодным ценам — https://www.ozon.ru. 
    Бизнес-процесс: поиск товара, работа с корзиной и покупка товара.

**Порядок выполнения работы:**

- Выбрать один из бизнес-процессов, реализуемых сайтом из варианта задания.
- Утвердить выбранный бизнес-процесс у преподавателя.
- Специфицировать модель реализуемого бизнес-процесса в соответствии с требованиями BPMN 2.0.
- Разработать приложение на базе Spring Boot, реализующее описанный на предыдущем шаге бизнес-процесс. Приложение должно
  использовать СУБД PostgreSQL для хранения данных, для всех публичных интерфейсов должны быть разработаны REST API.
- Разработать набор curl-скриптов, либо набор запросов для REST клиента Insomnia для тестирования публичных интерфейсов
  разработанного программного модуля. Запросы Insomnia оформить в виде файла экспорта.
- Развернуть разработанное приложение на сервере ```helios```.