Нужно написать сервис для маркетплейса, задачами сервиса будет регистрация новых заказов, а также выдача списка заказов по определенным критериям.

Обязательные поля для товара/услуги (могут быть расширены по вашему желанию):
    • цена
    • удалена или нет
    • Артикул
    • название

Обязательные поля заказа (могут быть расширены по вашему желанию):
    • Номер заказа (хеш от даты-время добавления заказа)
    • E-mail покупателя
    • Дата время создания
    • Список позиций заказа (товары/услуги)

Список функций, которые должны быть доступны по REST API:
    • Добавление сущности заказа.
    • Получение списка заказов по определенному e-mail (передается как параметры запроса)
    • Получение списка заказов между двумя датами (передаются как параметры запроса)
    • Получение списка заказов, в которых есть позиция с определенным артикулом (передается как параметры запроса)

Используем java 11 или выше, используем postgres, схема на ваше усмотрение. Своё решение нужно разместить на github, также приложить к нему sql script с предварительным заполнением базы и приложить скриншоты с примерами вызова рест апи.

_______________________________________________________________________________________________________________
Cкрипт для инициализации БД в resources/static
логин дб: alexx;
пароль: zdz77afd
