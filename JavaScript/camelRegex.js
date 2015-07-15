String.prototype.toCamelCase = function() {
	/*
	Uses regex to take a string and capitalize all first letters of every word.
	Current implementation of regex finds spaces as well, so it's not a perfect
	regex. Still, it's much cleaner than looping. Note: not a true camel case
	as words come out First Word instead of firstWord.
	*/
	return this.replace(/(^|\s)[a-z]/g, function (x) { return x.toUpperCase() });
}


function assert(test,result){
	return test == result;
}

function test(){
	var numTestsPassed = 0;
	firstString = "This is a test";
	secondString = "hi I'm a Test string"

	var numTestsPassed = 0
	if (assert(firstString.toCamelCase(), "This Is A Test")){
		numTestsPassed +=1;
}
	if (assert(secondString.toCamelCase(), "Hi I'm A Test String")){
		numTestsPassed +=1;
	console.log("Num Tests passed: ", numTestsPassed);
	}
}

test()


