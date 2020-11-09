--Practice 6

--1.
SELECT l.location_id, l.street_address, l.city, l.state_province, c.country_name
FROM locations l
NATURAL JOIN countries c;

--2.
SELECT e.last_name, d.department_id, d.department_name
FROM departments d
JOIN employees e
ON (d.department_id = e.department_id);

--3.
SELECT e.last_name, e.job_id, d.department_id, d.department_name
FROM departments d
JOIN employees e
ON (d.department_id = e.department_id)
JOIN locations l
ON (d.location_id = l.location_id)
WHERE l.city = 'Toronto';

--4.
SELECT e.last_name Employee, e.employee_id EMP#, f.last_name Manager, f.employee_id Mgr#
FROM employees e
JOIN employees f
ON (e.manager_id = f.employee_id);

--5.
SELECT e.last_name, e.employee_id, f.last_name, f.employee_id
FROM employees e
LEFT OUTER JOIN employees f
ON (e.manager_id = f.employee_id)
ORDER BY e.employee_id;

--6.
SELECT d.department_id as department, e.last_name employee, f.last_name colleague
FROM departments d
JOIN employees e
ON (d.department_id = e.department_id)
JOIN employees f
ON (e.department_id = f.department_id)
WHERE e.last_name != f.last_name
ORDER BY department;

--7. 
SELECT e.last_name, e.job_id, d.department_name, e.salary, g.grade_level
FROM employees e
JOIN jobs j
ON (e.job_id = j.job_id)
JOIN departments d
ON (d.department_id = e.department_id)
JOIN job_grades g
ON e.salary 
BETWEEN g.lowest_sal AND g.highest_sal
ORDER BY g.grade_level;

--8.
SELECT e.last_name, e.hire_date
FROM employees e
JOIN employees f
ON (f.last_name = 'Davies')
WHERE e.hire_date > f.hire_date;

--9.
SELECT f.last_name, f.hire_date, e.last_name, e.hire_date
FROM employees e
JOIN employees f
ON (e.employee_id = f.manager_id)
WHERE e.hire_date > f.hire_date;



--Practice 7

--1.
SELECT last_name, hire_date
FROM employees
WHERE department_id = 
        (SELECT department_id 
        FROM employees
        WHERE last_name LIKE '&&enter_name')
    AND last_name != '&enter_name';

--2.
SELECT employee_id, last_name, salary
FROM employees
WHERE salary > 
    (SELECT avg(salary) FROM employees)
ORDER BY salary;

--3.
SELECT employee_id, last_name
FROM employees
WHERE department_id IN
    (SELECT department_id 
    FROM employees
    WHERE last_name LIKE '%u%');

--4.
SELECT e.last_name, e.department_id, e.job_id
FROM employees e
WHERE department_id IN
    (SELECT department_id
    FROM departments
    WHERE location_id LIKE 1700);

SELECT e.last_name, e.department_id, e.job_id
FROM employees e
WHERE department_id IN
    (SELECT department_id
    FROM departments
    WHERE location_id LIKE &id);

--5.
SELECT last_name, salary
FROM employees
WHERE manager_id IN
        (SELECT employee_id FROM employees WHERE last_name='King');

--6.
SELECT department_id, last_name, job_id
FROM employees
WHERE department_id IN
    (SELECT department_id
    FROM departments
    WHERE department_name LIKE 'Executive');

--7.
SELECT employee_id, last_name, salary
FROM employees
WHERE salary > 
        (SELECT avg(salary) FROM employees) 
    AND
        department_id IN
        (SELECT department_id 
        FROM employees
        WHERE last_name LIKE '%u%');

