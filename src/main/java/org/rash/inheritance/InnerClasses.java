package org.rash.inheritance;
/*package org.rash.interview;

public class InnerClasses {
	static int staicClassMember;
	int nonStaicClassMember;

	public InnerClasses() {
	}
	public class MemberClass {

		public final void memberClassNonStaic() {
			objectMember();// non static parent class method can access only from non-static inner class method or its member Object  
			System.out.println("Member Class non-Staic");
		}

		public static void memberClassStaic() { // you cannot define static member inside non-static inner class
			System.out.println("You can not define static method inside member class or non static class");
		}
	}

	private static class PrivateStaticClass { // you can declare class as private and this class you can use inside its parent class only, or outside world of its parent class doesn't know abt this class, even though it s staic
		int staicInnerClassnonStatic;
		static int staicInnerClassStatic;

		public static void staticClassStaic() {
			System.out.println("Static inner Class Staic");
		}

		public void staticClassNonStaic() {
			objectMember(); // non static parent class method you can't access from static inner class method or its class method , bcz allocate memory for static method into JVM memory, when class is loaded in JVM, that time instance member u can't refer
			System.out.println("Static inner Class Non-Staic");
		}
	}
	
	static class StaticClass{
		
	}
	

	public static void classMethod() {
		objectMember(); // staic member can't reference non-static member, bcz allocate memory for static method or member into JVM memory, when class is loaded in JVM, that time instance member u can't refer
		classMethod(); 
		System.out.println("classMember" + nonStaicClassMember + staicClassMember); //bcz allocate memory for static method or member into JVM memory, when class is loaded in JVM, that time instance member u can't refer
	}

	public void objectMember() {
		objectMember();
		classMethod();
		System.out.println("objectMember" + nonStaicClassMember + staicClassMember);

	}


}
*/