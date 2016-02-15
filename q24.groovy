//couldnt proceed further.
def returnValueOfKey()
{

String s="http://www.google.com?name=johny&age=20&hobby=cricket" 
List l=s.tokenize("?")
println l
List l3=[]
Map m=[:]
List l1= (l[1].tokenize("&"))
l1.each{ 
        l3=it.tokenize("=")
        println l3         
        m.put(l3[0],l3[1])
      }

}
println returnValueOfKey()