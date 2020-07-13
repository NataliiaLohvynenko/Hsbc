pipeline {
    agent any
    stages {
        stage('Starting Grid') {
            steps {
                   bat "docker-compose up -d selenium-hub chrome firefox opera"
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
             bat "docker-compose down"
    }
    }
}