pipeline {
    agent any
    stages {
        stage('Starting Grid') {
            steps {
                bat "docker-compose up"
            }
        }
        stage('Running test') {
            steps {
                        bat "mvn test"
            }
        }
    }
    post{
        always{
             archiveArtifacts artifacts: 'output/**'
             bat "docker-compose down"
        }
    }
}