class Question {
    static hasMany = [answers:Answer]

    Date created = new Date()
    String title
    String content
    String level = 'easy'

    static constraints = {
        title(blank:false)
        content(nullable:true, maxSize:1000)
        level(inList:['easy','medium','hard'])
        answers(maxSize:5)
    }
}
