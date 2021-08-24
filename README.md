# Day 1:
## Java
Java fundamentals which includes operators, methods and passing data:

**Types of Operators**

 - Arithmetic Operators
 - Comparison Operators
 - Logical Operators
 - Bitwise Operators
 - Assignment Operators
 - Bit shift Operators

**Rules to follow when dealing with arithmetic operations in Java:**

 - Multiplicative operators (*, %, /) have a precedence over additive and subtractive operators (+, - ) when there are a different operators in the same operation. i.e. `int x = (5 * 3 + 2 / 20 - 5);`. 
 - Operators in the same group are evaluated from left to right.
 - We can use parenthesis to change evaluation order. i.e. `int z = (((5 / 2) * 3) + (5 / 20))`.
 

 - . Operand promotion: Operands smaller than **int** are promoted to **int**.               i.e. 125 (byte) + 2 (byte) --> 125 (int) + 2 (int) --> 127 (int).


## React JS


## DSA


# Day 2
# Day 3

# Day 9

## Java
**Information hiding** principle: It depends on **Encapsulation** which is a core concept of object oriented programming.

#### Encapsulation: Is a language facility that allows bundling of data and methods that operate on that data.

Data refers to variables, while methods are just functions, all of them found in a class.

We must know that "Encapsulation alone does not lead to a good design". 

***Why** we use information hiding?* 
- To get rid of issues caused by tight coupling. that lead to a bad program design.

Tight Coupling: is a way of design when client code, or data (public variables) are coupled with methods, and this design is bad for reasons:

 - You can't enforce invariant or range of possible values for that variable or method. I.e, you can't restrict gender for only ("male", "female", "transgender").
 - You can't change internal data representation. I.e, can't change gender from String to Int data type. 

> "In public classes use accessor methods, not public fields"
> ##### Effective Java by Joshua Bloch


*To solve tight coupling issues:*
- Use Private modifier instead of public, which prevent exposing of your data to the client, with getter and setter methods.
- Use checking for data input throw setter, to allow a fixed range of values.
- Use checking for type of input for preventing changing data type.
- Use exceptions to throw **IllegalArgumentException()** when there is an issue.
	
		//Getter and setter usage
	    public class Teacher{
	    	private String gender;
	    	private int genderCount;
	    	public void setGender(String gender){
	    		if(gender == "male") {
					genderCount = 1;	
				} else if ( gender == "female"){
					genderCount = 2;
				}else if(gender == "transgender"){
					genderCount  = 3;
				}

				if(genderCount == 0){
					throw new IllegalArgumentException("Wrong gender choice!");
				}
				this.gender = gender;
	    	}
	    
		  public String getGender(){
				return gender;	
			}
	    }



**Getter** methods or **accessor** methods are used only for returning fields content or data.

**Setter** methods or **mutate** methods are used to mutate fields content or data.

Now, this design is called **Loose coupling,** which is a good design principle, data is not exposed, less error prone technique.
