File f=new File("/home/saloni/Desktop/BOOTCAMP/demo/demo1")

f.eachLine{content,index->
 if(!(index%2==0))
println "$index, $content"

}
