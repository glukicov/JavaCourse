	/*
	 * 
	// Example use of "if; else if; else"
if (a > b) {
// Code written here is executed if:
// (1) a is greater than b
}
else if ( a > c ) {
// Code written here is executed if:
// (1) the block above was NOT executed, and
// (2) a is greater than c
}
else if ( a > d ) {
// Code written here is executed if:
// (1) Neither of the blocks above was executed, and
// (2) a is greater than d
}
else {
// Code written here is executed if:
// (1) None of the blocks above was executed.
} 
	 * // greater than or less than
if (a > b) { }
if (a < b) { }
// greater/less than or equal to
if (a >= b) { }
if (a <= b) { }
// equality
if (a == b) {}
if (a != b) {}
// you can AND and OR tests
if ( (a > b) && (b > c) ) {}
if ( (a > b) || (b > d) ) {}
// etc.
	 * 
	 
	
	boolean isValid;
	// Some code which sets "isValid" to be either true or false ...
	if (isValid) {
	// This code executes if "isValid" is true
	}
	if (!isValid) {
	// This code executes if "isValid" is false
	}
	
	
	
	int month = 2;
// Note the syntax of the "case" statement including the colon.
//
// Note the required "break" after the code for each case, which
// jumps to the code immediately following the final "}" at the
// end of the switch construction.
switch (month) {
case 1:
System.out.println("Jan");
break;
case 2:
System.out.println("Feb");
break;
case 3:
System.out.println("Mar");
break;
default:
System.out.println("???");
break;
}
	
	
	
	
}
	*/