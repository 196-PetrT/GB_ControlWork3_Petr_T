
CREATE DATABASE IF NOT EXISTS HumanFriends;

USE HumanFriends;

-- Создать таблицы, соответствующие иерархии из вашей диаграммы классов.
CREATE TABLE animals(
    animals_id INT NOT NULL,
    type_animals VARCHAR(50) NOT NULL PRIMARY KEY
);

INSERT INTO animals(animals_id, type_animals)
VALUES
    (1, 'Pets'),
    (2, 'Packed Animals');

CREATE TABLE pets(
    pets_id INT NOT NULL,
    species_pets VARCHAR(50) NOT NULL PRIMARY KEY,
    type_animals VARCHAR(50) NOT NULL,
    FOREIGN KEY (type_animals) REFERENCES animals (type_animals) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pets(pets_id, species_pets, type_animals)
VALUES
    (1, 'cats', 'Pets'), 
    (2, 'dogs', 'Pets'),
    (3, 'hamsters', 'Pets');
    
CREATE TABLE packed_animals(
	packed_animals_id INT NOT NULL,
    species_packedanimals VARCHAR (50) NOT NULL PRIMARY KEY,
    type_animals VARCHAR(50) NOT NULL,
    FOREIGN KEY (type_animals) REFERENCES animals (type_animals) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO packed_animals(packed_animals_id, species_packedanimals, type_animals)
VALUES 
    (1, 'horses', 'Packed Animals'),
    (2, 'camels', 'Packed Animals'),  
    (3, 'donkeys', 'Packed Animals'); 

CREATE TABLE cats(       
    cats_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
    name VARCHAR(20) NOT NULL, 
    birthday DATE NOT NULL,
    age VARCHAR(50) NOT NULL, 
    sex VARCHAR(50) NOT NULL, 
    color VARCHAR(50) NOT NULL, 
    learned_commands VARCHAR(50),
    learnability BOOLEAN NOT NULL,
    species_pets VARCHAR(50) NOT NULL,
    Foreign KEY (species_pets) REFERENCES pets (species_pets) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE dogs(       
    dogs_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
    name VARCHAR(20) NOT NULL, 
    birthday DATE NOT NULL,
    age VARCHAR(50) NOT NULL, 
    sex VARCHAR(50) NOT NULL, 
    color VARCHAR(50) NOT NULL, 
    learned_commands VARCHAR(50),
    learnability BOOLEAN NOT NULL,
    species_pets VARCHAR(50) NOT NULL,
    Foreign KEY (species_pets) REFERENCES pets (species_pets) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE humsters(       
    humsters_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
    name VARCHAR(20) NOT NULL, 
    birthday DATE NOT NULL,
    age VARCHAR(50) NOT NULL, 
    sex VARCHAR(50) NOT NULL, 
    color VARCHAR(50) NOT NULL, 
    learned_commands VARCHAR(50),
    learnability BOOLEAN NOT NULL,
    species_pets VARCHAR(50) NOT NULL,
    Foreign KEY (species_pets) REFERENCES pets (species_pets) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE horses(       
    horses_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
    name VARCHAR(20) NOT NULL, 
    birthday DATE NOT NULL,
    age VARCHAR(50) NOT NULL, 
    sex VARCHAR(50) NOT NULL, 
    color VARCHAR(50) NOT NULL, 
    learned_commands VARCHAR(50),
    learnability BOOLEAN NOT NULL,
    species_packedanimals VARCHAR(50) NOT NULL,
    Foreign KEY (species_packedanimals) REFERENCES packed_animals (species_packedanimals) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE camels(       
    camels_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
    name VARCHAR(20) NOT NULL, 
    birthday DATE NOT NULL,
    age VARCHAR(50) NOT NULL, 
    sex VARCHAR(50) NOT NULL, 
    color VARCHAR(50) NOT NULL, 
    learned_commands VARCHAR(50),
    learnability BOOLEAN NOT NULL,
    species_packedanimals VARCHAR(50) NOT NULL,
    Foreign KEY (species_packedanimals) REFERENCES packed_animals (species_packedanimals) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE donkeys(       
    donkeys_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
    name VARCHAR(20) NOT NULL, 
    birthday DATE NOT NULL,
    age VARCHAR(50) NOT NULL, 
    sex VARCHAR(50) NOT NULL, 
    color VARCHAR(50) NOT NULL, 
    learned_commands VARCHAR(50),
    learnability BOOLEAN NOT NULL,
    species_packedanimals VARCHAR(50) NOT NULL,
    Foreign KEY (species_packedanimals) REFERENCES packed_animals (species_packedanimals) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Заполнить таблицы данными о животных, их командах и датами рождения.
INSERT INTO cats(name, birthday, age, sex, color, learned_commands, learnability, species_pets)
VALUES
    ('Whiskers', '2019-05-15', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'male', 'black', 'Meow', 0, 'cats'),
    ('Smudge', '2022-02-20', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'female', 'white', 'Meow', 0, 'cats'),
    ('Oliver', '2023-06-30', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'male', 'black', 'Meow', 0, 'cats');
    
INSERT INTO dogs(name, birthday, age, sex, color, learned_commands, learnability, species_pets)
VALUES
    ('Fido', '2021-01-01', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'male', 'black', 'Sit, Stay, Fetch', 1, 'dogs'),
    ('Buddy', '2018-12-10', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'male', 'white', 'Sit, Paw, Bark', 1, 'dogs'),
    ('Bella', '2012-11-11', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'female', 'black', 'Sit, Stay, Roll', 1, 'dogs');
    
INSERT INTO humsters(name, birthday, age, sex, color, learned_commands, learnability, species_pets)
VALUES
    ('Hammy', '2024-03-10', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'male', 'grey', '', 0, 'hamsters'),
    ('Peanut', '2024-08-01', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'male', 'red', '', 0, 'hamsters');
    
INSERT INTO horses(name, birthday, age, sex, color, learned_commands, learnability, species_packedanimals)
VALUES
    ('Thunder', '2015-07-21', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'male', 'grey', 'Trot, Canter, Gallop', 1, 'horses'),
    ('Storm', '2021-08-01', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'male', 'red', 'Trot, Canter', 1, 'horses');
    
INSERT INTO camels(name, birthday, age, sex, color, learned_commands, learnability, species_packedanimals)
VALUES
    ('Sandy', '2016-11-03', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'male', 'orange', 'Walk, Carry Load', 0, 'camels'),
    ('Dune', '2018-12-12', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'male', 'broun', 'Walk, Sit', 0, 'camels');
    
INSERT INTO donkeys(name, birthday, age, sex, color, learned_commands, learnability, species_packedanimals)
VALUES
    ('Eeyore', '2017-09-18', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'female', 'grey', 'Walk, Bray', 0, 'donkeys'),
    ('Burro', '2019-01-23', 
    CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' y ', TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' m '), 'male', 'grey', 'Walk, Bray', 0, 'donkeys');

-- Удалить записи о верблюдах и объединить таблицы лошадей и ослов.
DELETE FROM camels;

CREATE TABLE horses_and_donkeys
    SELECT * FROM horses
    UNION
    SELECT * FROM donkeys;
    
-- Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам (изменил последовательсность - считаю что так проще).
CREATE TABLE all_animal(
    id INT, 
    name VARCHAR(20) NOT NULL, 
    birthday DATE NOT NULL,
    age VARCHAR(50) NOT NULL, 
    sex VARCHAR(50) NOT NULL, 
    color VARCHAR(50) NOT NULL, 
    learned_commands VARCHAR(50),
    learnability BOOLEAN NOT NULL, 
    species_animals VARCHAR(50)
);

START TRANSACTION;
INSERT INTO all_animal(id, name, birthday, age, sex, color, learned_commands, learnability, species_animals) SELECT * FROM cats;
INSERT INTO all_animal(id, name, birthday, age, sex, color, learned_commands, learnability, species_animals) SELECT * FROM dogs;
INSERT INTO all_animal(id, name, birthday, age, sex, color, learned_commands, learnability, species_animals) SELECT * FROM humsters;
INSERT INTO all_animal(id, name, birthday, age, sex, color, learned_commands, learnability, species_animals) SELECT * FROM horses;
INSERT INTO all_animal(id, name, birthday, age, sex, color, learned_commands, learnability, species_animals) SELECT * FROM camels;
INSERT INTO all_animal(id, name, birthday, age, sex, color, learned_commands, learnability, species_animals) SELECT * FROM donkeys;
COMMIT;

-- Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.
#DROP TABLE if EXISTS yang_animal;
CREATE TABLE yang_animal(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, 
    name VARCHAR(20) NOT NULL, 
    birthday DATE NOT NULL,
    age VARCHAR(50) NOT NULL, 
    sex VARCHAR(50) NOT NULL, 
    color VARCHAR(50) NOT NULL, 
    learned_commands VARCHAR(50),
    learnability BOOLEAN NOT NULL, 
    species_animals VARCHAR(50)
);

INSERT INTO yang_animal (id, name, birthday, age, sex, color, learned_commands, learnability, species_animals)
    SELECT * FROM all_animal
        WHERE birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
