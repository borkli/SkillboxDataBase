# SkillboxDataBase
База данных Skillbox, состоящая из таблиц: students(id, name, age, registration_date) courses(id, name, duration, type, description, teacher_id, students_count, price, price_per_hour) teachers(id, name, salary, age) subscription(student_id, course_id, subscription_date) purchaseList(student_name, course_name, price, subscription_date).

На основе таблицы purchaseList программа создает и заполняет таблицу LinkedPurchaseList(student_id, course_id, price, subscription_date).
