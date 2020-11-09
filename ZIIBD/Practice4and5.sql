--Practice 4

--1.
SELECT 
CONCAT(
    CONCAT(
        CONCAT(last_name,' earns'),
        CONCAT(
            CONCAT(
                TO_CHAR(salary,'$99,999.00'),
                ' monthly but wants'),
            TO_CHAR(salary*3,'$99,999.00'))),
    '.')
    AS Dream_Salaries
FROM EMPLOYEES; 

--2.
SELECT last_name, TO_CHAR(hire_date,'DD-MON-YY'), TO_CHAR(NEXT_DAY(ADD_MONTHS(hire_date,6),'PONIEDZIAŁEK'),'fmDay," the " Ddspth " of " Month, YYYY') REVIEW
FROM EMPLOYEES;

--3.
SELECT last_name, TO_CHAR(hire_date,'DD-MON-YY'), TO_CHAR(hire_date,'DAY') DAY
FROM EMPLOYEES 
ORDER BY TO_CHAR(hire_date,'D');

--4.
SELECT last_name, NVL2(commission_pct,TO_CHAR(commission_pct,'fm.99'), 'No Commission') COMM
FROM EMPLOYEES;

--5.
SELECT job_id, DECODE(job_id,'AD_PRES','A',
                             'ST_MAN','B',
                             'IT_PROG','C',
                             'SA_REP','D',
                             'ST_CLERK','E',
                             0)
                             GRADE
FROM EMPLOYEES;

--6.
SELECT job_id, CASE job_id WHEN 'AD_PRES' THEN 'A'
                           WHEN 'ST_MAN' THEN 'B'
                           WHEN 'IT_PROG' THEN 'C'
                           WHEN 'SA_REP' THEN 'D'
                           WHEN 'ST_CLERK' THEN 'E'
                           ELSE '0' END "GRADE"
FROM EMPLOYEES;





--Practice 5

--1.
True

--2.
False

--3.
False

--4.
SELECT ROUND(MAX(salary),0) AS Maximum ,ROUND(MIN(salary),0) AS Minimum,ROUND(SUM(salary),0) AS Sum ,ROUND(AVG(salary),0) AS Average
FROM employees;   

--5.
SELECT job_id, ROUND(MAX(salary),0) AS Maximum ,ROUND(MIN(salary),0) AS Minimum,ROUND(SUM(salary),0) AS Sum ,ROUND(AVG(salary),0) AS Average
FROM employees           
GROUP BY job_id;

--6.
SELECT job_id, COUNT(job_id)
FROM employees
GROUP BY job_id;

SELECT job_id, COUNT(job_id)
FROM employees
GROUP BY job_id
HAVING job_id = '&job_title';

--7.
SELECT COUNT(DISTINCT(manager_id)) AS "Number Of Managers"
FROM employees;

--8.
SELECT MAX(salary) - MIN(salary) AS DIFFERENCE
FROM employees;

--9.
SELECT manager_id, MIN(salary)
FROM employees
WHERE manager_id IS NOT NULL
GROUP BY manager_id
HAVING MIN(salary) > 6000
ORDER BY MIN(salary) DESC;

--10.
SELECT COUNT(*) total, 
    SUM(DECODE(TO_CHAR(hire_date, 'YYYY'),1995,1,0)) "1995", 
    SUM(DECODE(TO_CHAR(hire_date, 'YYYY'),1996,1,0)) "1996",
    SUM(DECODE(TO_CHAR(hire_date, 'YYYY'),1997,1,0)) "1997",
    SUM(DECODE(TO_CHAR(hire_date, 'YYYY'),1998,1,0)) "1998"
FROM employees;

--11.
SELECT job_id Job, 
    SUM(DECODE(TO_CHAR(department_id),20,salary,null)) "Dept 20", 
    SUM(DECODE(TO_CHAR(department_id),50,salary,null)) "Dept 50",
    SUM(DECODE(TO_CHAR(department_id),80,salary,null)) "Dept 80",
    SUM(DECODE(TO_CHAR(department_id),90,salary,null)) "Dept 90",
    SUM(salary) Total
FROM employees group by job_id;