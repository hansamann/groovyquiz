class Answer {
    static belongsTo = [question:Question]

    String title
    String content
    Boolean correctAnswer

    static constraints = {
        title(blank:false)
        content(nullable:true, maxSize:1000)
        question()
    }


}
