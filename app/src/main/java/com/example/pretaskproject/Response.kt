package com.example.pretaskproject

data class Response(
    //받아올 정보
    val FCLTY_NM : String,  //시설 명
    val FCLTY_LA : String,  //시설 위도
    val FCLTY_LO : String   //시설 경도
) {
    override fun toString(): String {
        return "서점 : [\n" +
                "   시설 명 : ${FCLTY_NM}\n" +
                "   시설 위도 : ${FCLTY_LA}\n" +
                "   시설 경도 : ${FCLTY_LO}\n\n"
    }
}
