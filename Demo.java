import java.io.*;
import java.lang.*;
class Person implements Cloneable 
{
   // Data members
   private int handLengths[] = {5, 5};
   private String name;
   int age;

   // Helping function
   private void trace(String s) {
      System.out.println(s);
   }

   // Manager function
   public Person(int handLengths1[], String name1 ,int age1) {
      handLengths=null;
      handLengths=(int [])handLengths1.clone(); 
      name=name1;
      age=age1;
      trace("constructor");
   }

   // Access function
   // get
   public int getHandLengths(int i) { return handLengths[i]; }
   public int [] getHandLengths() { return handLengths; }
   public String getName() { return name; }
   public int getAge() {return age;}
   // set
   public void setHandLengths(int i, int length) { handLengths[i] = length; }
   public void setHandLength(int handLengths1[]) {
      handLengths=null;
      handLengths=(int [])handLengths1.clone(); 
   }
   public void setName(String name1) { name=name1; }
   public void setAge(int age1) {age=age1;}

   // predicate
   public boolean isDisabled() { return handLengths[0] == 0 ||
                                        handLengths[1] == 0; }
   public boolean isHenry() { return name.equals("Henry"); }
   public boolean isOld() {return age > 65;}

   // Implementor
   public void changeName(String name1) { setName(name1); }
   public void cutBothHands() { handLengths[0] = handLengths[1] = 0; }
   public String toString() { 
       StringBuffer s = new StringBuffer();
       for (int i=0; i< handLengths.length; i++)
          s.append("hand " + (i + 1) + " : " + handLengths[i] + "\n");
       s.append("name " + name + "\n");
       s.append("age "  + age + "\n");
       return s.toString();
   }
   public boolean equals(Object obj) {
      Person tstA;

      if (!(obj instanceof Person)) return false;
      tstA = (Person) obj;
 
      // for (int i=0; i < handLengths.length; i++)
      //    if (getHandLengths(i) != tstA.getHandLengths(i))
      //       return false;
      // return true;
      return (handLengths.equals(tstA.handLengths) && name.equals(tstA.name)); 
   }
   public Object clone() {
      try
      { return super.clone();
      }
      catch (CloneNotSupportedException e)
      {
         // return null;
         throw new InternalError(e.getMessage());
      }
   }
}

// Print
//   constructor
//   call toString()
//   hand 1 : 3
//   hand 2 : 4
//   name Jack
//   
//   constructor
//   p is not equal to P1
//   p is equal to P2
public class Demo {
   public static void main (String argv[])
   {
      int handLengths[] = {3, 4};
      Person p = new Person(handLengths, "Jack",40);
      System.out.println("call toString()");
      System.out.println(p);
         
      int handLengths1[] = {4, 5};
      Person p1 = new Person(handLengths1, "Bruce",70);
      if (p.equals(p1))
         System.out.println("p is equal to P1");
      else
         System.out.println("p is not equal to P1");
      Person p2 = (Person)p.clone(); 
      if (p.equals(p2))
         System.out.println("p is equal to P2");
      else
         System.out.println("p is not equal to P2");
         
      if (p.isOld())
        System.out.println(p.getName() + " is old ");
      else
        System.out.println(p.getName() + " is not old ");
      if (p1.isOld())
        System.out.println(p1.getName() + " is old ");
      else
        System.out.println(p1.getName() + " is not old ");
        
   }
}


