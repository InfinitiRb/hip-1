var questionTime = 5000;
var countDownTime = 5000;
var flashTime = 5000;
var answerTime = 10000;
var startTimer = setInterval(function() {startTimerFunction()},3000);
var countdownTimer = 0;
var flashTimer = 0;
var answerTimer = 0;
var finTimer = 0;
var expDuration = 0;
var d;
var isStore = 0;

function startTimerFunction(){
        clearInterval(startTimer);
        document.getElementById("word1").style.visibility="visible";
        document.getElementById("word2").style.visibility="visible";
        document.getElementById("word3").style.visibility="visible";
        countdownTimer = setInterval(function() {countDownTimerFunction()},questionTime);
}

function countDownTimerFunction(){
    clearInterval(countdownTimer);
	document.getElementById("word1").style.visibility = "hidden";
	document.getElementById("word2").style.visibility = "hidden";
	document.getElementById("word3").style.visibility = "hidden";
    document.getElementById("counter").style.visibility = "visible";
    flashTimer = setInterval(function() {flashTimerFunction()},countDownTime);
}

function flashTimerFunction(){
        clearInterval(flashTimer);
        document.getElementById("counter").style.visibility = "hidden";
        document.getElementById("hopRabbit").style.visibility = "visible";
    	answerTimer = setInterval(function() {answerTimerFunction()},flashTime);
}

function answerTimerFunction(){
        clearInterval(answerTimer);
        document.getElementById("hopRabbit").style.visibility = "hidden";
        document.getElementById("firstWord").disabled = false;
    	document.getElementById("secondWord").disabled = false;
    	document.getElementById("thirdWord").disabled = false;
    	document.getElementById("countdownResult").disabled = false;
    	document.getElementById("SubmitButton").disabled = false;
    	finTimer = setInterval(function() {finishTimerFunction()},answerTime);
    	d = new Date();
    	expDuration = d.getTime();

}

function finishTimerFunction(){
        clearInterval(finTimer);
        document.getElementById("firstWord").disabled = true;
        document.getElementById("secondWord").disabled = true;
        document.getElementById("thirdWord").disabled = true;
        document.getElementById("countdownResult").disabled = true;
        d = new Date();
        expDuration = d.getTime()-expDuration;
        isStore = 1;
}

function submitButtonClick(){
     document.getElementById("firstWord").disabled = false;
     document.getElementById("secondWord").disabled = false;
     document.getElementById("thirdWord").disabled = false;
     document.getElementById("countdownResult").disabled = false;
     document.getElementById("usedTime").disabled = false;

     if (document.getElementById("countdownResult").value == ""){
        document.getElementById("countdownResult").value = "-99";
     }

     if (isStore == 0){
        d = new Date();
        expDuration = d.getTime()-expDuration;
        isStore = 1;
     }
     document.getElementById("usedTime").value = expDuration/1000;

}

