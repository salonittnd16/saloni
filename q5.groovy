List l=new ArrayList();
l=[1,2,3,4,5,6]
List oddIndexElements=[];
l.eachWithIndex{p,index -> 
if(index%2!=0)
oddIndexElements.add(p);
}
l.removeAll(oddIndexElements);
print l
