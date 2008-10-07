class QuizController {

    def index = { redirect(action:'level', params:params) }

    def level = {
        def questions = Question.findAllByLevel(params.id ?: 'easy')

        if (!session.answered)
            session.answered = []

        [questions: questions.findAll { !session.answered.contains(it.id) }]
    }

    def answer = {
        def answer = Answer.get(params.answerId)

        if (answer.correctAnswer)
        {
            session.answered << answer.question.id
            flash.message = 'Correct, well done!'
        }
        else
        {
             flash.message = 'Nope, try again!'
        }
        
        redirect(action:'level', params:params)
    }
}
