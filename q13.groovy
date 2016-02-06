String s="saloni is an employee at to the new digital"
List l=s.tokenize()
count=0
l.each{
//assuming that count of character 's' is being found
if(it.contains('s'))
count=count+1
}
print count