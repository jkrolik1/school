--Practice 8

--1.
SELECT department_id
FROM departments
MINUS
SELECT department_id
FROM employees
WHERE job_id='ST_CLERK';

--2.
SELECT country_id, country_name
FROM countries
MINUS
SELECT country_id, country_name
FROM countries c
JOIN locations l
USING (country_id)
JOIN departments d
ON (l.location_id = d.location_id);

--3.
SELECT DISTINCT job_id, department_id
FROM employees
WHERE department_id = 10
UNION ALL
SELECT DISTINCT job_id, department_id
FROM employees
WHERE department_id = 50
UNION ALL
SELECT DISTINCT job_id, department_id
FROM employees
WHERE department_id = 20;

--4.
SELECT employee_id, job_id
FROM employees
INTERSECT
SELECT employee_id, job_id
FROM job_history;

--5.
SELECT last_name, department_id, TO_CHAR(NULL) "department_name"
FROM employees
UNION 
SELECT TO_CHAR(NULL) "last_name", department_id, department_name
FROM departments;



--Practice 9

--1.
CREATE TABLE my_employee
    (id NUMBER(4) CONSTRAINT my_employee_id_nn NOT NULL,
    last_name VARCHAR(25),
    first_name VARCHAR(25),
    userid VARCHAR(8),
    salary NUMBER(9,2));

--2.
DESCRIBE my_employee;

--3.
INSERT INTO my_employee 
VALUES (1,'Patel','Ralph','rpatel',895);

--4.
INSERT INTO my_employee (id, last_name, first_name, userid, salary) 
VALUES (2,'Dancs','Betty','bdancs',860);

--5.
SELECT *
FROM my_employee;
COMMIT;

--6.
INSERT INTO my_employee
VALUES(&id, '&last_name', '&first_name', '&userid', &salary);

--7.
SELECT *
FROM my_employee
ORDER BY id;

--8.
SELECT *
FROM my_employee
ORDER BY id;

--9.
COMMIT;

--10.
UPDATE my_employee 
SET last_name='Drexler'
WHERE id=3;

--11.
UPDATE my_employee 
SET salary=1000
WHERE salary < 900;

--12.
SELECT *
FROM my_employee
ORDER BY id;

--13.
DELETE FROM my_employee
WHERE first_name='Betty' AND last_name='Dancs';

--14.
SELECT *
FROM my_employee
ORDER BY id;

--15.
COMMIT;

--16.
INSERT INTO my_employee
VALUES(&id, '&last_name', '&first_name', '&userid', &salary);

--17.
SELECT *
FROM my_employee
ORDER BY id;

--18.
SAVEPOINT mark1;

--19.
DELETE FROM my_employee;

--20.
SELECT * 
FROM my_employee;

--21.
ROLLBACK TO mark1;

--22.
SELECT * 
FROM my_employee;

--23.
COMMIT;

--24.
INSERT INTO my_employee
VALUES(&id, '&&last_name', '&&first_name', 
    LOWER(CONCAT(SUBSTR('&first_name',1,1),SUBSTR('&last_name',1,7))), &salary);

--25.
SELECT *
FROM my_employee
ORDER BY id;

--26.
SELECT *
FROM my_employee
ORDER BY id;
