 /*Consider a class named "Stack" that holds a list of objects and has the following operations associated:
  1) POP - Pops the last element off the stack 
  2) PUSH - Pushes an element on top of the stack 
  3) TOP - Returns the element at the top of the list
   Implement the aforesaid class */
   
   class Stack
   {
   List l=new ArrayList();
   int top;
   
   def push(int el)
   {
   l.add(el)
   top=l.size()
   
   }
   
   def pop()
   {
   l.pop()
   top=l.size()
   
   }
   }
   
   Stack s=new Stack(l:[10,20,30],top:0)
   s.push(50)
   println s.l
   println s.top
   s.pop()
   println s.l
   println s.top