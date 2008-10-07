class BootStrap {

     def init = { servletContext ->

        def questionsAndAnswers =
        [
            [title:'Who is the current Grails Project Lead?', content:null, level:'easy', answers:
                [ [title:'Graeme Rocher', content:null, correctAnswer:true],
                  [title:'Guillaume Laforge', content:null, correctAnswer:false],
                  [title:'Dierk Koenig', content:null, correctAnswer:false] ]
            ],
            [title:'Who is the current Groovy Project Lead?', content:null, level:'easy', answers:
                [ [title:'Graeme Rocher', content:null, correctAnswer:false],
                [title:'Guillaume Laforge', content:null, correctAnswer:true],
                [title:'Guillaume Laforge', content:null, correctAnswer:true],
                [title:'Guillaume Laforge', content:null, correctAnswer:true],
                [title:'Guillaume Laforge', content:null, correctAnswer:true],
                [title:'Guillaume Laforge', content:null, correctAnswer:true],
                [title:'Dierk Koenig', content:null, correctAnswer:false] ]
            ],
            [title:'When was Griffon first released?', content:null, level:'easy', answers:
                [ [title:'2007', content:null, correctAnswer:false],
                  [title:'2008', content:null, correctAnswer:true] ]
            ],
            [title:'What are the two important paradigms Grails borrowed from Rails?', content:null, level:'easy', answers:
                [ [title:'CoC and DRY', content:null, correctAnswer:true],
                  [title:'DRY and FLY', content:null, correctAnswer:false],
                  [title:'MAI and TAI', content:null, correctAnswer:false],
                  [title:'YEY and NEY', content:null, correctAnswer:false] ]
            ],
            [title:'Who created the Mail Plugin?', content:null, level:'medium', answers:
                [ [title:'Marc Palmer', content:null, correctAnswer:true],
                  [title:'Graeme Rocher', content:null, correctAnswer:false],
                  [title:'Sven Haiges', content:null, correctAnswer:false],
                  [title:'Glen Smith', content:null, correctAnswer:false] ]
            ],
            [title:'From which episode on did Glen Smith join Sven Haiges for the Grails Podcast?', content:null, level:'hard', answers:
                [ [title:'30', content:null, correctAnswer:false],
                  [title:'45', content:null, correctAnswer:false],
                  [title:'49', content:null, correctAnswer:true],
                  [title:'53', content:null, correctAnswer:false],
                  [title:'60', content:null, correctAnswer:false] ]
            ],
            [title:'Are Grails Controller Singleton instances?', content:null, level:'medium', answers:
                [ [title:'Yes, there is only one instance per app per controller', content:null, correctAnswer:false],
                  [title:'No, each request creates a new instance of a controller', content:null, correctAnswer:true] ]
            ],
            [title:'What does grails generate-all do?', content:null, level:'easy', answers:
                [ [title:'It creates Views and Controller for a Domain class', content:null, correctAnswer:true],
                  [title:'It creates a new Domain Class, a scaffolded View and a Controller', content:null, correctAnswer:false] ]
            ],
            [title:'Which servlet engine does grails run-app use?', content:null, level:'medium', answers:
                [ [title:'Jetty', content:null, correctAnswer:true],
                  [title:'Tomcat', content:null, correctAnswer:false] ]
            ],
            [title:'What is Griffon?', content:null, level:'easy', answers:
                [ [title:'A cool Jacket from Nike', content:null, correctAnswer:false],
                  [title:'A Grails-like framework for Swing', content:null, correctAnswer:true] ]
            ]
        ]

        questionsAndAnswers.each
        {
            def q = new Question(title:it.title, content:it.content, level:it.level).save()
            it.answers.each
            {
                def a = new Answer(title:it.title,content:it.content,correctAnswer:it.correctAnswer)
                q.addToAnswers(a)
                a.save()
            }

        }
        
        //def q = new Question(title:'Who is the current Grails Project Lead?', content:null, level:'easy').save()
        //def a = new Answer(title:'Graeme Rocher',content:null,correctAnswer:true)
        //q.addToAnswers(a)
        //a.save()
        
     }
     def destroy = {
     }
} 