File f=new File("/home/saloni/Desktop/BOOTCAMP/demo/demo1")
println f.text
String s=f.text.replaceAll("[\t\n ]","");
f.text=s
print f.text
