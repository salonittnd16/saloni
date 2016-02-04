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
  
  
  public String toString()
  {
  "$name is a $gender who lives in $address She works for $company with employee id $eid and draws  $salary "
  
  
  }
  
  }
  
 Employee p=new Employee(name:"saloni",gender:"female",address:"delhi",company:"TTND",eid:30,salary:500000);
 println p