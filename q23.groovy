class Employee
{
    String name,dptname
    int age,sal,eid;
  
}
 List l=[new Employee(name:"Saloni",age:24,dptname:"admin",eid:1,sal:2000),
new Employee(name:"Japneet",age:22,dptname:"admin",eid:2,sal:2500),
new Employee(name:"Deepti",age:26,dptname:"infra",eid:3,sal:7500),
new Employee(name:"Sukrity",age:28,dptname:"infra",eid:4,sal:9000),
new Employee(name:"Manisha",age:28,dptname:"hr",eid:5,sal:12000)]

//a)
l.groupBy{
if(it.sal>0&&it.sal<=5000)
return "between 0 and 5000"
if(it.sal>=5001&&it.sal<=10000)
return "between 5000 and 10000"
if(it.sal>10000)
return "above 10000"
}

//b)
Map m=l.groupBy{
it.dptname
}
println m

m.each{key,value->
println "dname:${key},count:${value.size()}"
}

//c)
List list=new ArrayList();
l.each{
if(it.age>=18&&it.age<=35)
list.add(it.name)
}
println "employees with age btw 18 and 35 are :${list}"

//d)
Map alpha=l.groupBy{
it.name.getAt(0)
}
count=0
alpha.each{
it.value.each{
if(it.age>20)
count=count+1
}
println "${it.key} : ${count}"
count=0
}

//e)
print l.groupBy{
it.dptname
}
