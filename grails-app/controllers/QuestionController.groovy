class QuestionController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ questionList: Question.list( params ) ]
    }

    def show = {
        def question = Question.get( params.id )

        if(!question) {
            flash.message = "Question not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ question : question ] }
    }

    def delete = {
        def question = Question.get( params.id )
        if(question) {
            question.delete()
            flash.message = "Question ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "Question not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def question = Question.get( params.id )

        if(!question) {
            flash.message = "Question not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ question : question ]
        }
    }

    def update = {
        def question = Question.get( params.id )
        if(question) {
            question.properties = params
            if(!question.hasErrors() && question.save()) {
                flash.message = "Question ${params.id} updated"
                redirect(action:show,id:question.id)
            }
            else {
                render(view:'edit',model:[question:question])
            }
        }
        else {
            flash.message = "Question not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def question = new Question()
        question.properties = params
        return ['question':question]
    }

    def save = {
        def question = new Question(params)
        if(!question.hasErrors() && question.save()) {
            flash.message = "Question ${question.id} created"
            redirect(action:show,id:question.id)
        }
        else {
            render(view:'create',model:[question:question])
        }
    }
}
