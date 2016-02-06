List l=[1, 2, 3, "element1", 0.3, [2, 4, 6], 0..10 ]
l.each{it-> 
println it.class
}

print l.get(6).get(9)
 