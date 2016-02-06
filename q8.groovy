class Employee
{
String name;
Integer salary,age;

}
Employee e1=new Employee(name:"saloni",age:23,salary:50000)
Employee e2=new Employee(name:"japneet",age:23,salary:55000);
Employee e3=new Employee(name:"deepti",age:18,salary:15000);
Employee e4=new Employee(name:"akash",age:40,salary:10000);
Employee e5=new Employee(name:"sumit",age:30,salary:4000);
//8a
List l=[e1,e2,e3,e4,e5];
 println l.findAll{it->
it.salary<5000
}
//8b
def youngestage=e1.age
l.each{it->
if(it.age<youngestage)
{
    youngestage=it.age
    youngestEmployee=it
}    }
println "employee with youngest age is: ${youngestEmployee.name}"


def oldestage=e1.age
l.each{it->
if(it.age>oldestage)
{
    oldestage=it.age
    oldestEmployee=it
}    }
println "employee with oldest age is: ${oldestEmployee.name}"

//8c
def highestsal=e1.salary
l.each{it->
if(it.salary>highestsal)
{
    highestsal=it.salary
    highestSalEmployee=it
}    }
println "employee with highest salary is: ${highestSalEmployee.name}"

//8d
print l.each{
 }*.name
