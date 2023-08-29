job('segundo-ejemplo-job-DSL'){
	description('Job DSL de ejemplo')
 	scm{
      git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node ->
   			node / gitConfigName('Qudopro')
 			node / gitConfigEmail('cabrera.islas.diego@gmail.com')            
      }          
    }
  	parameters {
  	 stringParam('nombre',defaultValue='Diego', description = 'Parametro String')
     choiceParam('planeta', ['Mercurio','Venus', 'Tierra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno', 'Pluton'])
     booleanParam('agente', false)
    }
    triggers{
     cron('H/7 * * * *') 
    }
    steps{
     shell("bash jobscript.sh")
    }
    publishers{
     mailer('cabrera.islas.diego@gmail.com', true, true)
    }
 }
