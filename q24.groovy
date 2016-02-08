//couldnt proceed further.
def returnValueOfKey()
{

String s="http://www.google.com?name=johny&age=20&hobby=cricket" 
List l=s.tokenize("?")
println l
List l1= (l[1].tokenize("&"))
return l1[0].tokenize("=")

}
println returnValueOfKey()