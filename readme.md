### How-to use

1. Open project dir in terminal.
2. Execute `docker-compose up -d`
3. Open http://localhost:5433 Login: `test@postgres` password: `postgres`
5. Create new server:
	- name: `my-db`
	- host: `host.docker.internal`
	- port: 5432
	- database: `postgres`
	- username: `postgres`
	- password: `postgres`
6. Click Save button

Open demo database and do requests

#### Database schema

![](images/demodb-bookings-schema.svg) 

```
    Имя          |     Тип       |       Описание
-----------------+---------------+-------------------------
 airports        | представление | Аэропорты
 aircrafts       | представление | Самолеты
 flights_v       | представление | Рейсы
 routes          | представление | Маршруты
 airports_data   | таблица       | Аэропорты (переводы)
 aircrafts_data  | таблица       | Самолеты (переводы)
 flights         | таблица       | Рейсы
 bookings        | таблица       | Бронирования
 boarding_passes | таблица       | Посадочные талоны
 seats           | таблица       | Места
 tickets         | таблица       | Билеты
 ticket_flights  | таблица       | Перелеты
```

See description [here](https://postgrespro.ru/docs/postgrespro/10/apjs04.html#id-1.11.11.11.3)