package baseball

import camp.nextstep.edu.missionutils.Console

class System {
    fun getUserInput(): String {
        print("숫자를 입력해주세요 : ")
        return Console.readLine() //플레이어 입력
    }

    //재시작 여부를 설정하는 함수
    fun setRestartFlag(userInput: String): Boolean {
        return when (userInput) {
            "1" -> true //재시작 O
            "2" -> false //재시작 X
            else -> throw IllegalArgumentException()
        }
    }

    //사용자 입력값  유효성 검사 함수
    fun checkUserInputValid(userInput: String) {
        val regex = "[1-9]{3}".toRegex() //1-9사이의 숫자로 구성된 세 자릿수 정규표현식
        //regex와 일치하면서 set을 이용해 중복된 수가 있는지 확인
        if (!regex.matches(userInput) || userInput.length != userInput.toSet().size) throw IllegalArgumentException()
    }

    //게임 결과를 출력하는 함수
    fun printGameResult(strike: Int, ball: Int, nothing: Int) {
        val resultText = when {
            strike > 0 && ball == 0 -> "${strike}스트라이크"
            strike < 0 && ball > 0 -> "${ball}볼"
            nothing > 0 -> "낫싱"
            else -> "${ball}볼 ${strike}스트라이크"
        }
        println(resultText)
    }
}