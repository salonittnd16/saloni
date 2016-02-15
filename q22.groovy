
Map m = ['Computing' : ['Computing' : 600, 'Information Systems' : 300],'Engineering' : ['Civil' : 200, 'Mechanical' : 100],'Management' : ['Management' : 800] ]

//a) there are 3 university departments
//b)2 programs delivered
//c)200 students enrolled in civil engineering program
​Map m = ['Computing' : ['Computing' : 600, 'Information Systems' : 300],'Engineering' : ['Civil' : 200, 'Mechanical': 100],
'Management' : ['Management' : 800] ]

//a)
println m.keySet().size()

//b)
println m.get('Computing').size()

//c)
println m.get('Engineering').get('Civil')
​
