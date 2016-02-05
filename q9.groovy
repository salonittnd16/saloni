File f=new File("/home/saloni/Desktop/BOOTCAMP/demo")
File newFile=new File("/home/saloni/Desktop/BOOTCAMP/newFile");
f.eachFileRecurse(groovy.io.FileType.FILES){
newFile.append(it.text);
}
println newFile.text