Create database  if not exists Training  ;
use Training;
CREATE TABLE Worker (
    WORKER_ID INT NOT NULL PRIMARY KEY,
    FIRST_NAME CHAR(25),
    LAST_NAME CHAR(25),
    SALARY INT,
    JOINING_DATE DATETIME,
    DEPARTMENT CHAR(25)
);

INSERT INTO Worker (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
    (1, 'Monika', 'Arora', 100000, '2021-02-20 09:00:00', 'HR'),
    (2, 'Niharika', 'Verma', 80000, '2021-06-11 09:00:00', 'Admin'),
    (3, 'Vishal', 'Singhal', 300000, '2021-02-20 09:00:00', 'HR'),
    (4, 'Amitabh', 'Singh', 500000, '2021-02-20 09:00:00', 'Admin'),
    (5, 'Vivek', 'Bhati', 500000, '2021-06-11 09:00:00', 'Admin'),
    (6, 'Vipul', 'Diwan', 200000, '2021-06-11 09:00:00', 'Account'),
    (7, 'Satish', 'Kumar', 75000, '2021-01-20 09:00:00', 'Account'),
    (8, 'Geetika', 'Chauhan', 90000, '2021-04-11 09:00:00', 'Admin');

CREATE TABLE Bonus (
    WORKER_REF_ID INT,
    BONUS_AMOUNT INT,
    BONUS_DATE DATETIME,
    FOREIGN KEY (WORKER_REF_ID) REFERENCES Worker(WORKER_ID) ON DELETE CASCADE
);

INSERT INTO Bonus (WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE) VALUES
    (1, 5000, '2023-02-20'),
    (2, 3000, '2023-06-11'),
    (3, 4000, '2023-02-20'),
    (1, 4500, '2023-02-20'),
    (2, 3500, '2023-06-11');

CREATE TABLE Title (
    WORKER_REF_ID INT,
    WORKER_TITLE CHAR(25),
    AFFECTED_FROM DATETIME,
    FOREIGN KEY (WORKER_REF_ID) REFERENCES Worker(WORKER_ID) ON DELETE CASCADE
);

INSERT INTO Title (WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM) VALUES
    (1, 'Manager', '2023-02-20 00:00:00'),
    (2, 'Executive', '2023-06-11 00:00:00'),
    (8, 'Executive', '2023-06-11 00:00:00'),
    (5, 'Manager', '2023-06-11 00:00:00'),
    (4, 'Asst. Manager', '2023-06-11 00:00:00'),
    (7, 'Executive', '2023-06-11 00:00:00'),
    (6, 'Lead', '2023-06-11 00:00:00'),
    (3, 'Lead', '2023-06-11 00:00:00');
    
/*
Q-1. Write an SQL query to fetch “FIRST_NAME” from the Worker table 
	   using the alias name <WORKER_NAME>.
*/
#Answer1
select FIRST_NAME as WORKER_NAME from worker ;

/*
Q-2. Write an SQL query to fetch “FIRST_NAME” from the Worker table in upper case.
*/
#Ans2
select upper(FIRST_NAME) as WORKER_NAME from worker ;

/*
Q-3. Write an SQL query to fetch unique values of DEPARTMENT from the Worker table.

*/
#Ans3
select distinct DEPARTMENT from  Worker;

/*
Q-4. Write an SQL query to print the first three characters of  FIRST_NAME 
from the Worker table.
*/
#Ans4

select mid(FIRST_NAME,1,3)  from worker ;


/*
Q-5. Write an SQL query to find the position of the alphabet (‘a’) 
	   in the first name column ‘Amitabh’ from the Worker table
*/
#Ans5
select locate('a',FIRST_NAME)  from worker where FIRST_NAME='Amitabh';
# we can use also use INSTR() Instead of locate;

/*
Q-6. Write an SQL query to print the FIRST_NAME from the Worker table 
		after removing white spaces from the right side.
*/
#Ans6
Select RTRIM(FIRST_NAME) from Worker; #remove from trailing
# LTRIM remove from leading
# TRIM remove from both Leadin and trailing
/*
Q-7. Write an SQL query to print the DEPARTMENT from the Worker table
		after removing white spaces from the left side.
*/
#Ans7
Select lTRIM(DEPARTMENT) from Worker; 
/*
Q-8. Write an SQL query that fetches the unique values of DEPARTMENT 
		from the Worker table and prints its length.
*/
#Ans8
select distinct DEPARTMENT , length(DEPARTMENT) from worker;
/*
Q-9. Write an SQL query to print the FIRST_NAME 
		from the Worker table after replacing ‘a’ with ‘A’.
        */
#Ans9
select replace(FIRST_NAME,'a','A')from worker;

/*
Q-10. Write an SQL query to print the FIRST_NAME and LAST_NAME from the Worker table
		into a single column COMPLETE_NAME. A space char should separate them.
*/
#Ans10
select concat_ws(' ',FIRST_NAME,LAST_NAME) as COMPLETE_NAME from worker ;

#####important Note####
#MySQL is different from most DBMSs' use of + or || for concatenation but MYSQL does'nt

/*
Q-11. Write an SQL query to print all Worker details from the Worker table
		order by FIRST_NAME Ascending.
*/
#Ans11
select * from worker order by FIRST_NAME asc ;
/*
Q-12. Write an SQL query to print all Worker details from the Worker table 
		order by FIRST_NAME Ascending and DEPARTMENT Descending.
Ans.
*/
#Ans12
select * from worker order by FIRST_NAME asc,DEPARTMENT desc ;




/*
Q-13. Write an SQL query to print details for Workers with 
		the first names “Vipul” and “Satish” from the Worker table.
*/
#Ans13
select * from worker where FIRST_NAME in ('Vipul','Satish');




/*
Q-14. Write an SQL query to print details of workers 
	  excluding first names, “Vipul” and “Satish” from the Worker table.
*/
#Ans14

select * from worker where FIRST_NAME not in ('Vipul','Satish');



/*
Q-15. Write an SQL query to print details of Workers with DEPARTMENT name as “Admin”.

*/
#Ans15
select * from worker where DEPARTMENT='Admin';



/*
Q-16. Write an SQL query to print details of the Workers whose FIRST_NAME 
contains ‘a’.
*/
#Ans16
select * from worker where FIRST_NAME like'%a%';



/*
Q-17. Write an SQL query to print details of 
		the Workers whose FIRST_NAME ends with ‘a’.
*/
#Ans17
select * from worker where FIRST_NAME like '%a';



/*
Q-18. Write an SQL query to print details of the Workers whose FIRST_NAME 
		ends with ‘h’ and contains six alphabets.

*/
#Ans18
select * from worker where FIRST_NAME like '_____h';







/*
Q-19. Write an SQL query to print details of the Workers whose SALARY lies 
		between 100000 and 500000.

*/
#Ans19
select * from worker where SALARY between 100000 and 500000;





/*
Q-20. Write an SQL query to print details of the Workers who joined in Feb 2021.

*/
#Ans20
select * from worker where date_format(JOINING_DATE,'%y')=21 and 
	date_format(JOINING_DATE,'%m')=02 ;

/*
Q-21. Write an SQL query to fetch the count of employees working in the department
 ‘Admin’.

*/
#Ans21
select count(*) from worker where DEPARTMENT ='Admin';




/*
Q-22. Write an SQL query to fetch worker names with salaries >= 50000 and <= 100000.

*/
#Ans22
select concat_ws(' ', FIRST_NAME,LAST_NAME) as COMPLETE_NAME from worker where SALARY between 50000 and 100000;



/*
Q-23. Write an SQL query to fetch the number of workers for each department
		in descending order.
	

*/
#Ans23
select DEPARTMENT,count(WORKER_ID) from worker group by DEPARTMENT order by count(*) desc;


/*
Q-24. Write an SQL query to print details of the Workers who are also Managers.

*/
#Ans24

select  * from worker w inner join Title t on w.WORKER_ID=t.WORKER_REF_ID and t.WORKER_TITLE='Manager';


/*
Q-25. Write an SQL query to fetch duplicate records having matching data 
in some fields of a table.

*/
#Ans25

select WORKER_TITLE, AFFECTED_FROM, count(*) from title 
group by  WORKER_TITLE, AFFECTED_FROM having count(*) > 1;


/*
Q-26. Write an SQL query to show only odd rows from a table.

*/
#Ans26
select * from Worker where WORKER_ID%2 <> 0;
/*
Q-27. Write an SQL query to show only even rows from a table.

*/
#Ans27
select * from Worker where WORKER_ID%2 = 0;

/*
Q-28. Write an SQL query to clone a new table from another table.

*/
#Ans28

CREATE TABLE newWorker AS SELECT * FROM Worker;
/*
Q-29. Write an SQL query to fetch intersecting records of two tables.

*/
#Ans29
select w.FIRST_NAME , b.BONUS_AMOUNT from Worker as w inner join Bonus as b
 on w.WORKER_ID=b.WORKER_REF_ID;
/*
Q-30. Write an SQL query to show records from one table that another table
 does not have.

*/
#Ans30
select w.FIRST_NAME , b.BONUS_AMOUNT from Worker as w left join Bonus as b
 on w.WORKER_ID=b.WORKER_REF_ID;
 
/*
Q-31. Write an SQL query to show the current date and time.

*/
#Ans31
select current_timestamp();
select current_date() , current_time();

/*
Q-32. Write an SQL query to show the top n (say 5) records of a table.

*/
#Ans32
select * from Worker order by SALARY desc limit 5;

/*
Q-33. Write an SQL query to determine the nth (say n=5) highest salary from a table.

*/
#Ans33
select * from Worker order by SALARY desc limit 1 offset 4;

/*
Q-34. Write an SQL query to determine the 5th highest salary without using the TOP
 or limit method.

*/
#Ans34
SELECT Salary FROM Worker W1 WHERE 4 = (SELECT COUNT(DISTINCT W2.Salary) 
FROM Worker W2 WHERE W2.Salary >= W1.Salary);


/*
Q-35. Write an SQL query to fetch the list of employees with the same salary.

*/
#Ans35
select  distinct* from Worker w1 ,Worker w2 where w1.Salary = w2.Salary 
and W1.WORKER_ID <> W2.WORKER_ID;

/*
Q-36. Write an SQL query to show the second-highest salary from a table.

*/
#Ans36
select max(Salary) from Worker where Salary not IN (select max(Salary) from Worker);
/*
Q-37. Write an SQL query to show one row twice in the results from a table.

*/
#Ans37
select * from Worker w1 where w1.WORKER_ID =1
union all
select * from Worker w2 where w2.WORKER_ID =1 ;
/*
Q-38. Write an SQL query to fetch intersecting records of two tables.

*/
#Ans38
select w.FIRST_NAME , b.BONUS_AMOUNT from Worker as w inner join Bonus as b
 on w.WORKER_ID=b.WORKER_REF_ID;
/*
Q-39. Write an SQL query to fetch the first 50% of records from a table.

*/
#Ans39
SELECT * FROM WORKER WHERE WORKER_ID <= (SELECT count(WORKER_ID)/2 from Worker);

/*
Q-40. Write an SQL query to fetch the departments that have less than five people 
	in them.

*/
#Ans40
select DEPARTMENT, count(WORKER_ID) n  from Worker group by DEPARTMENT having n <5;
/*
Q-41. Write an SQL query to show all departments along with the number of people
 in there.


*/
#Ans41
select DEPARTMENT, count(WORKER_ID) n  from Worker group by DEPARTMENT;

/*
Q-42. Write an SQL query to show the last record from a table.


*/
#Ans42
select* from Worker order by WORKER_ID desc limit 1 ;
#another solution 
Select * from Worker where WORKER_ID = (SELECT max(WORKER_ID) from Worker);
/*
Q-43. Write an SQL query to fetch the first row of a table.


*/
#Ans43
Select * from Worker where WORKER_ID = (SELECT min(WORKER_ID) from Worker);

/*
Q-44. Write an SQL query to fetch the last five records from a table.


*/
#Ans44
Select * from Worker w1 where 5 > (SELECT count(WORKER_ID) from Worker w2 where w1.WORKER_ID <w2.WORKER_ID );
#Aonther Solution
SELECT * FROM Worker ORDER BY WORKER_ID DESC LIMIT 5;



/*
Q-45. Write an SQL query to print the names of employees having the highest salary
	in each department.

*/
#Ans45
select FIRST_NAME,DEPARTMENT , Salary from Worker w1 where Salary in  
(select max(Salary)  from Worker w2 group by DEPARTMENT);



/*
Q-46. Write an SQL query to fetch three max salaries from a table.


*/
#Ans46
select distinct Salary from Worker w1 where 3 >= (select count(WORKER_ID) from Worker w2
 where w1.Salary < w2.Salary );



/*
Q-47. Write an SQL query to fetch three min salaries from a table.
*/
#Ans47
select distinct Salary from Worker w1 where 3> (select count(WORKER_ID) 
from Worker w2 where w1.Salary > w2.Salary );


/*
Q-48. Write an SQL query to fetch nth max salaries from a table.


*/
#Ans48
select distinct Salary from Worker w1 where 2= (select count(WORKER_ID) 
from Worker w2 where w1.Salary< w2.Salary );


/*
Q-49. Write an SQL query to fetch departments along with the total salaries
 paid for each of them.


*/
#Ans49
select DEPARTMENT , sum(Salary) from Worker group by DEPARTMENT;


/*
QQ-50. Write an SQL query to fetch the names of workers who earn the highest salary.

*/
#Ans50
SELECT FIRST_NAME, SALARY from Worker WHERE SALARY=(SELECT max(SALARY) from Worker);
