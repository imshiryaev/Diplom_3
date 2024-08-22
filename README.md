# UI
## Использованные технологии
Java 11, Maven, JUnit 4, Rest Assured, Selenium, Allure

## Полезные команды
Запуск тестов в браузере Chrome - `mvn clean test`

Запуск тестов в браузере Yandex - `mvn clean test -Dbrowser=yandex`

Запуск сервера с Allure отчетом - `mvn allure:serve`

Драйвер Яндекс Браузера хранится по пути `src/main/resources/yandexdriver.exe`
