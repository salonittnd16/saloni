class Employee extends Person
{
  String company;
  Integer eid,salary;
  
  String  getCompany()
  {
   return company;
  }
 
  void  setCompany(String company)
  {
   this.company=company
   println "this is company setter"
   
  }
  Integer getEid()
  {
   return eid;
  }
   void setEid(Integer eid)
  {
   this.eid=eid;
  }
  Integer geSalary()
  {
   return salary;
  }
  
  void setSalary(Integer salary)
  {
  this.salary=salary
 
  }
  
  }
  
 Employee e=new Employee();
 e.name="saloni"
 println "${e.name}"
 e.company="TTND"
 println "${e.company}"
 e.@company="NIIT"
  println "${e.@company}"
 