CREATE TABLE child(
    id INT PRIMARY KEY,
    name VARCHAR(255),
    parent_id INT,
    FOREIGN KEY (parent_id) REFERENCES child(id)
);

INSERT INTO child (id, name) VALUES (1, 'Zaki'),
                                    (2, 'Ilham'),
                                    (3, 'Irwan'),
                                    (4, 'Arka');
UPDATE child SET parent_id = 2 WHERE id = 1;
UPDATE child SET parent_id = 2 WHERE id = 3;
UPDATE child SET parent_id = 3 WHERE id = 4;

SELECT * FROM child;
SELECT c1.id, c1.name, c2.name AS parent_name FROM child AS c1
    JOIN child AS c2 ON c1.parent_id = c2.id
UNION
SELECT c1.id, c1.name, c2.name AS parent_name FROM child AS c1
    LEFT JOIN child AS c2 ON c1.parent_id = c2.id
    WHERE c1.parent_id IS NULL
ORDER BY id;