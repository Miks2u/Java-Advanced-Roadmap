-- 1. 查询员工的姓名 , 及所属的部门名称 (隐式内连接实现)
select e.name,d.name from tb_emp e, tb_dept d where e.dept_id=d.id;

-- 2. 查询员工的姓名 , 及所属的部门名称 (显式内连接实现)
select e.name,d.name from tb_emp e join tb_dept d on e.dept_id=d.id;

-- 3. 查询员工的 姓名、性别、职位、部门名称 （隐式内连接）
select e.name,e.gender,e.job,d.name from tb_emp e,tb_dept d where e.dept_id=d.id;

-- 4. 查询 薪资 高于 10000 的员工的姓名、性别、职位、部门名称（显式内连接）
select e.salary,e.name,e.gender,e.job,d.name from tb_emp e join tb_dept d on e.dept_id=d.id where e.salary>10000;

-- 5. 查询员工表 所有 员工的姓名, 和对应的部门名称 (左外连接)
select e.name,d.name from tb_emp e left join tb_dept d on e.dept_id=d.id;

-- 6. 查询员工表 所有 员工的姓名, 和对应的部门名称 (右外连接)
select e.name,d.name from tb_dept d right join tb_emp e on e.dept_id=d.id;

-- 7. 查询部门表 所有 部门的名称, 和对应的员工名称 (右外连接)
select d.name,e.name from tb_emp e right join tb_dept d on e.dept_id=d.id;

-- 8. 查询 "教研部" 的所有员工信息 （标量子查询）
select * from tb_emp where dept_id = (select id from tb_dept where name='教研部');

-- 9. 查询在 "方东白" 入职之后的员工信息 （标量子查询）
select * from tb_emp where entrydate>(select entrydate from tb_emp where name='方东白');

-- 10. 查询 "教研部" 和 "咨询部" 的所有员工信息 （列子查询）
select * from tb_emp where dept_id in (select id from tb_dept where name in ('教研部','咨询部'));

-- 11. 查询与 "韦一笑" 的入职日期 及 职位都相同的员工信息 （行子查询）
select * from tb_emp where (entrydate,job) = (select entrydate,job from tb_emp where name='韦一笑');

-- 12. 查询入职日期是 "2006-01-01" 之后的员工信息 , 及其部门信息 （表子查询）
select * from (select * from tb_emp where entrydate>'2006-01-01') e, tb_dept d where e.dept_id=d.id;

-- 13. 查询 拥有员工的 部门ID、部门名称 (没有员工的部门无需展示)
select d.id,d.name from tb_dept d,(select distinct dept_id from tb_emp) e where d.id=e.dept_id;

-- 14. 查询所有 在 2010-01-01 之后入职的员工, 及其归属的部门名称; 如果员工没有分配部门, 也需要展示出来
-- select * from tb_emp where entrydate>'2010-01-01';
select e.*,d.name from (select * from tb_emp where entrydate>'2010-01-01') e left join tb_dept d on e.dept_id=d.id;

-- 15. 查询 "教研部" 员工的平均工资
-- select id from tb_dept where name='教研部';
select avg(salary) from tb_emp where dept_id = (select id from tb_dept where name='教研部');

-- 16. 查询工资比 "俞莲舟" 高的员工信息。
select * from tb_emp where salary>(select salary from tb_emp where name='俞莲舟');

-- 17. 查询 工资 比该企业员工的平均薪资 还要高的员工信息
-- select avg(salary) from tb_emp;
select * from tb_emp where salary > (select avg(salary) from tb_emp);

-- 18. 查询所有的部门信息, 并统计部门的员工人数
-- select count(*) from tb_emp group by dept_id;
select * from tb_dept d left join (select dept_id,count(*) from tb_emp group by dept_id) e on d.id=e.dept_id;

-- 19. 查询所有员工的 姓名, 工资 , 及 工资等级 (有难度的哦)
select e.name,e.salary,s.grade from tb_emp e join tb_salgrade s on e.salary between s.losal and s.hisal;

-- 20. 查询 "教研部" 所有员工的信息 及 工资等级 (有难度的哦)
select *
    from tb_emp e
    join tb_dept d on e.dept_id=d.id
    join tb_salgrade s on e.salary between s.losal and s.hisal
where d.name='教研部';


-- 21. 查询 工资 低于 本部门平均工资的员工信息 (有难度的哦)
-- select dept_id,avg(salary) from tb_emp group by dept_id;
select * from tb_emp e1，(select dept_id,avg(salary) avg_sal from tb_emp group by dept_id) e2 where e1.salary<e2.avg_sal;

-- 22. 列出所有部门的详细信息(包括部门ID, 部门名称)和人数
-- select dept_id,count(*) from tb_emp group by dept_id;
select * from tb_dept d left join (select dept_id,count(*) from tb_emp group by dept_id) e on d.id=e.dept_id;

-- 23、取得每个薪资等级有多少员工  (有难度的哦)
select s.grade,count(*) from tb_emp e left join tb_salgrade s on e.salary between s.losal and s.hisal group by s.grade;

-- 24. 取得每个部门最高薪水的人员名称
-- select dept_id,max(salary) from tb_emp group by dept_id;
select name from tb_emp where (dept_id,salary) in (select dept_id,max(salary) from tb_emp group by dept_id);
