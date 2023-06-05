INSERT INTO PUBLIC.themes (name)
VALUES ('Love'),
       ('Revenge'),
       ('Hero'),
       ('Bravery'),
       ('Friendship'),
       ('Humour');

INSERT INTO PUBLIC.libs (librarian_id, first_name, last_name)
VALUES (1, 'Sigurd', 'Snakeeye'),
       (2, 'Tihomir', 'Vodolaziv'),
       (3, 'Yan', 'Kazimir');

INSERT INTO PUBLIC.faculties (faculty_id, faculty_name)
VALUES (1, 'Mechanics'),
       (2, 'Physics'),
       (3, 'Mathematics'),
       (4, 'Literature');

INSERT INTO PUBLIC."groups" (group_id, group_name, faculty_id)
VALUES (1, 'first group', 1),
       (2, 'second group', 2),
       (3, 'third group', 3),
       (4, 'fourth group', 4);

INSERT INTO PUBLIC.students (student_id, first_name, last_name, group_id)
VALUES (1, 'Vasili', 'Tsekov', 1),
       (2, 'Teon', 'Greyjoy', 2),
       (3, 'Osvald', 'Barndshtuber', 3),
       (4, 'Till', 'Lindemann', 4);


INSERT INTO PUBLIC.press (name)
VALUES ('Prentise Hall'),
       ('HarperCollins'),
       ('Simon And Shuster'),
       ('Pearson'),
       ('Macmillan');

INSERT INTO PUBLIC.departments (name)
VALUES ('first'),
       ('second'),
       ('third');

INSERT INTO PUBLIC.categories (name)
VALUES ('Fiction'),
       ('Mystery'),
       ('History'),
       ('Poetry'),
       ('Romance'),
       ('History'),
       ('Humor'),
       ('Novel'),
       ('Biography');

INSERT INTO PUBLIC.authors (first_name, last_name)
VALUES ('Les', 'Podereviansky'),
       ('Homer', 'Simpson'),
       ('Stephen', 'King'),
       ('James', 'Corey'),
       ('George', 'Martin');

INSERT INTO PUBLIC.books (book_id, book_name, pages, "year", category_id, press_id, theme_id)
VALUES (1, 'Fascination in the evening', 300, 2021, 7, 4, 6),
       (2, 'The Expanse Rage of Thiamath', 450, 2018, 1, 2, 3),
       (3, 'Game of Thrones: Fire And Blood', 500, 2015, 5, 3, 2),
       (4, 'Game of Thrones: Battle of Kings', 600, 2013, 1, 4, 2),
       (5, 'The Expanse: Leviathan Fall', 350, 2019, 1, 2, 5),
       (6, 'Trias period', 250, 1987, 7, 4, 6),
       (7, 'It', 421, 1989, 8, 3, 5),
       (8, 'The Iliad', 1000, 1929, 5, 1, 5),
       (9, 'Odyssey', 1235, 1935, 6, 5, 4),
       (10, 'A tale about turnips', 150, 1993, 7, 2, 6);

INSERT INTO PUBLIC.books_authors (author_id, book_id)
VALUES (1, 1),
       (1, 10),
       (1, 6),
       (2, 8),
       (2, 9),
       (3, 7),
       (4, 2),
       (4, 5),
       (5, 3),
       (5, 4);



