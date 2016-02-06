def range=1..100
range.each
{
if((it%3==0)&&(it%5==0))
println "fizzbuzz"
else if(it%3==0)
println "fizz"
else if(it%5==0)
println "buzz"
else println it
}