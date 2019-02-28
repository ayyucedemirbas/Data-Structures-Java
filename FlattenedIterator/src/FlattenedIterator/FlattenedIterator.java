package FlattenedIterator;

import java.util.Iterator;




public class FlattenedIterator implements Iterator{
	  list bas;
	    list son;
	   public boolean nulls(){
	        return bas==null;
	    }
	   public void add(list newbie){
	       if(nulls()){
	           bas=newbie;
	           son=newbie;
	           }
	       else{
	           son.ileri=newbie;
	           son=newbie;
	       }
	       
	       
	   
	    
	   }
	  

	    public void flattened() {
	    	FlattenedIterator a=new FlattenedIterator ();
	    	FlattenedIterator b=new FlattenedIterator ();
	    	FlattenedIterator r=new FlattenedIterator ();
	          list c;
	          int t=(int)(7*Math.random());
	          int k=(int)(10*Math.random());
	          int l=(int)(10*Math.random());
	          int o=(int)(10*Math.random());
	          for(int i=0;i<=k;i++){
	              c=new list(t);
	              a.add(c);
	              t=(int)(5*Math.random());
	              }
	           for(int i=0;i<=l;i++){
	              c=new list(t);
	              b.add(c);
	              t=(int)(5*Math.random());
	              }
	              for(int i=0;i<=o;i++){
	              c=new list(t);
	              r.add(c);
	              t=(int)(5*Math.random());
	              }
	              list yy=a.bas;
	              list ya=b.bas;
	              list yc=r.bas;
	                 System.out.print("Array 1 = ");//random
	              while(yy.ileri!=null){
	                  System.out.print(yy.w+",");
	                  yy=yy.ileri;
	              }
	              System.out.println("");
	                 System.out.print("Array 2 = ");//random
	               while(ya.ileri!=null){
	                  System.out.print(ya.w+",");
	                  ya=ya.ileri;
	              }
	               System.out.println("");
	                  System.out.print("Array 3 = ");//random
	                while(yc.ileri!=null){
	               
	                  System.out.print(yc.w+",");
	                  yc=yc.ileri;
	              }
	                System.out.println("");


	                

	        list tmp=a.bas;
	        list tmp2=b.bas;
	        list tmp3=r.bas;
	         while(tmp.ileri!=null || tmp2.ileri!=null || tmp3.ileri!=null){
	            if(tmp.ileri!=null && tmp2.ileri!=null && tmp3.ileri!=null){
	                System.out.print(tmp.w+","+tmp2.w+","+tmp3.w);
	             
	                tmp=tmp.ileri;
	                tmp2=tmp2.ileri;
	                tmp3=tmp3.ileri;
	            }
	            else if(tmp.ileri!=null && tmp2.ileri!=null){
	                System.out.print(tmp.w+","+tmp2.w); 
	               
	                tmp=tmp.ileri;
	                tmp2=tmp2.ileri;
	            }
	            else if(tmp.ileri!=null && tmp3.ileri!=null){
	                System.out.print(tmp.w+","+tmp3.w);
	            
	                tmp=tmp.ileri;
	                tmp3=tmp3.ileri;
	            }
	            else if(tmp2.ileri!=null && tmp3.ileri!=null){
	                System.out.print(tmp2.w+","+tmp3.w);
	           
	                tmp2=tmp2.ileri;
	                tmp3=tmp3.ileri;
	            }
	            else{
	                if(tmp.ileri!=null){
	                    System.out.print(","+tmp.w);
	                 
	                    tmp=tmp.ileri;
	                }
	                else if(tmp2.ileri!=null){
	                    System.out.print(","+tmp2.w);
	                  
	                    tmp2=tmp2.ileri;
	                    
	            }
	                else if(tmp3.ileri!=null){
	                    System.out.print(","+tmp3.w);
	                   
	                    tmp3=tmp3.ileri;
	                }
	      
	            
	            
	        }
	             System.out.print(",");
	   
	        
	        
	    

	 
	    
	         }
	         
	         
	        /* while(itr.hasNext()) {
	     		System.out.print(", "+itr.next());
	     	}*/
	         
	   
	      
	}
	    
	   
	    
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return null;
		}
		 public boolean hasNext(list a) {
		        return a.ileri==null;
		       
		    }

		    public list next(list a) {
		    list b=a;
		   a=a.ileri;
		    return b;
		     }
}