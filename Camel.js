String.prototype.toCamelCase = function() {
	words = this.split(' ')
	var upperCased = '';
	for (var i = 0; i < words.length; i++) {
		for (var y = 0; y < words[i].length; y++) {
			if (y == 0) {
				upperCased += words[i][y].toUpperCase();
			}
			else {
				upperCased += words[i][y];
			}
		}
		upperCased += ' ';	
	}//adding too many spaces, that's why the lengths don't add up	
	return trim(upperCased);
}


function assert(testCase, value){
	return testCase == value;

}



var testString1 = "i'm a test"
var testString2 = "little Bunny foo Foo riding through the Foresti"



for (var i = 0; i <= testString1.length; i++){
	console.log(testString1[i]);
	console.log(i);
}



function runTests() {
	console.log("running");
	var passed = 0
	if (assert(testString1.toCamelCase(),"I'm A Test")){
		console.log('True');
		passed += 1;
	}
	if (assert(testString2.toCamelCase(),"Little Bunny Foo Foo Riding Through The Forest")){
		passed +=1;
		console.log('True');
	}
	else {
		console.log("Passed Tests: " + passed);
	}

}


runTests();


