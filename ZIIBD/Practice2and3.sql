--Practice 2

--1.
SELECT last_name,salary 
FROM employees 
WHERE salary>12000;

--2.
SELECT last_name,department_id 
FROM employees 
WHERE employee_id=176;

--3.
SELECT last_name,salary 
FROM employees 
WHERE salary NOT BETWEEN 5000 AND 12000;

--4.
SELECT last_name,job_id,hire_date
FROM employees 
WHERE last_name IN ('Matos', 'Taylor')
ORDER BY hire_date ASC;

--5.
SELECT last_name,department_id
FROM employees 
WHERE department_id IN (20, 50)
ORDER BY last_name ASC;

--6.
SELECT last_name AS Employee,salary AS Monthly_Salary
FROM employees 
WHERE (salary BETWEEN 5000 AND 12000) AND (department_id IN (20,50));

--7.
SELECT last_name,hire_date
FROM employees 
WHERE hire_date BETWEEN '94/01/01' AND '94/12/31';

--8.
SELECT last_name,job_id
FROM employees 
WHERE manager_id is null;

--9.
SELECT last_name,salary,commission_pct
FROM employees 
WHERE commission_pct is not null
ORDER BY salary,commission_pct DESC;

--10.
SELECT last_name,salary
FROM employees 
WHERE salary > &salary;

--11.
SELECT employee_id,last_name,salary,department_id
FROM employees 
WHERE manager_id = &manager_id
ORDER BY &employees;

--12.
SELECT last_name
FROM employees 
WHERE last_name LIKE '__a%';

--13.
SELECT last_name
FROM employees 
WHERE last_name LIKE '%a%' AND last_name LIKE '%e%';

--14.
SELECT last_name,job_id,salary
FROM employees 
WHERE (job_id IN ('SA_REP','ST_CLERK')) AND (salary NOT IN (2500,3500,7000));

--15.
SELECT last_name,salary,commission_pct
FROM employees 
WHERE commission_pct = 0.2;



--Practice 3

--1.
SELECT SYSDATE as "Date"
FROM dual;

--2,3.
SELECT employee_id,last_name,salary,salary+(salary*0.155) AS NewSalary
FROM employees;

--4.
SELECT employee_id,last_name,salary,salary+(salary*0.155) AS NewSalary, salary+(salary*0.155)-Salary AS Increase
FROM employees;

--5.
SELECT UPPER(SUBSTR(last_name,1,1))||LOWER(SUBSTR(last_name,2,LENGTH(last_name))) AS "Name", LENGTH(last_name) AS "Length"
FROM employees
WHERE last_name LIKE 'J%' OR last_name LIKE 'A%' OR last_name LIKE 'M%'
ORDER BY last_name;

SELECT UPPER(SUBSTR(last_name,1,1))||LOWER(SUBSTR(last_name,2,LENGTH(last_name))) AS "Name", LENGTH(last_name) AS "Length"
FROM employees
WHERE last_name LIKE '&start_letter%'
ORDER BY last_name;

SELECT UPPER(SUBSTR(last_name,1,1))||LOWER(SUBSTR(last_name,2,LENGTH(last_name))) AS "Name", LENGTH(last_name) AS "Length"
FROM employees
WHERE SUBSTR(last_name,1,1) = UPPER('&letter')
ORDER BY last_name;

--6.
SELECT last_name, ROUND(MONTHS_BETWEEN(SYSDATE,hire_date)) AS MONTHS_WORKED
FROM employees
ORDER BY MONTHS_WORKED;

--7.
SELECT last_name, LPAD(salary,15,'$') AS "SALARY"
FROM employees;

--8.
SELECT last_name, LPAD(' ',TRUNC(salary/1000)+1,'*') AS EMPLOYEES_AND_THEIR_SALARIES
FROM employees
ORDER BY salary DESC;

--9.
SELECT last_name, ROUND((SYSDATE - hire_date)/7) AS TENURE
FROM employees
WHERE department_id IN(90)
ORDER BY TENURE DESC;
