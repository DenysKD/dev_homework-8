INSERT INTO worker(name, birthday, level, salary) VALUES ('Joseps Joestar', '1928.08.16', 'Senior', '9999'), ('John Doe', '1986.01.11', 'Middle', '5001'),
('Stepan Andriyovych Bandera', '1909.01.01', 'Senior', '99999'), ('Tyler Darden', '1975.06.23', 'Senior', '3000'), ('Ivan Bobuliak', '1952.03.31', 'Junior', '3000'),
('Roronoa Zoro', '1984.06.18', 'Middle', '7777'), ('Mariana Bezuhla', '1987.11.29', 'Trainee', '200'), ('Arnold Shwartsnegr', '1967.05.06', 'Senior', '7834'),
('Angela Merkel', '1901.08.08', 'Trainee', '623'), ('Julia Timoshenko', '1962.09.29', 'Trainee', '40000');

INSERT INTO client(name) VALUES ('Tony Stark'), ('Joe Biden'), ('Robert Soros'), ('Petro Poroshenko'), ('Twopack Shakur');

INSERT INTO project(client_id, start_date, finish_date) VALUES (1, '2023.01.06', '2024.06.02'), (2, '2025.08.14', '2027.01.31'), (3, '2024.05.21', '2024.09.11'), (4, '2021.12.31', '2026.07.19'),
(5, '2020.04.04', '2026.02.17'), (1, '2019.11.03', '2020.11.05'), (1, '2019.12.02', '2020.05.01'), (3, '2018.11.03', '2026.11.05'), (1, '2023.02.11', '2026.12.08'), (5, '2022.07.09', '2028.12.12');

INSERT INTO project_worker(project_id, worker_id) VALUES (1, 1), (1, 5), (1, 9), (2, 4), (3, 7), (3, 1), (3, 6), (3, 3), (3, 2), (4, 8), (4, 10),
(4, 3), (4, 7), (5, 1), (5, 6), (5, 9), (5, 2), (6,10);