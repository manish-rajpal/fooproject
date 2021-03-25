pipeline {
	agent any
		stages {
			stage('Checkout') {
				steps 	{
					git 'https://github.com/manish-rajpal/fooproject/'
					}
					}
			stage ('Build') {
				steps {
					sh "mvn compile"
					  
					 }
							}

			stage('Test') {
				steps {
					sh "mvn test"
					
					  }
				post  {
					always {
					junit '**/target/surefire-reports/TEST*.xml'
							}
						}
					}

				
				stage('Robot') {
					steps {
						sh 'robot --variable BROWSER:headlesschrome -d Results Tests'
							}
					post {
						always {
							script {
								step(
									[
								$class : 'RobotPublisher',
								outputPath : 'Results',
								outputFileName : '**/output.xml',
								reportFileName : '**/report.html',
								logFileName : '**/log.html',
								disableArchiveOutput : false,
								passThreshold : 50,
								unstableThreshold : 40,
								otherFiles : "**/*.png,**/*.jpg",
									]
									)
									}
								}
						}

								}
				stage('newman') {
					steps {
						sh 'newman run RestfulBooker.postman_collection.json --environment RestfulBooker.postman_environment.json --reporters junit'
							}
				post {
					always {
						junit '**/*xml'
							}
					}	
								}


		}
	}
