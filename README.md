### 1.4 Коллекции для параллельной (конкурирующей) работы.
## Задача 1. Колл-центр
Код по [ссылке](https://github.com/A-Sakhmina/netology_mthreading_concur_collections/tree/master/src/main/java)
### Описание
Моделирование организации техподдержки у одного из провайдеров города. 
К нам поступают звонки от разных абонентов, 
а мы, силами нескольких специалистов, эти звонки "разбираем"
**Работа программы**
1. Создание и запуск потоков-специалистов(`Specialist`) и один поток-АТС (генерирует звонки)
2. Поток-АТС(`CallGenerator`) после запуска начинает генерировать несколько (например, 60) "звонков" раз в 1 секунду 
3. Потоки-специалисты берут доступные звонки в работу 
4. Методом `Thread.sleep()` нужно реализовать эмуляцию работы специалиста над вопросом (3-4 секунды, например)
5. Главный поток (main) ждет конца выполнения всех потоков

