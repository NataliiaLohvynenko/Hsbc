pipeline {
    agent any
    stages {
        stage('Starting Grid') {
            steps {
                   dir('D:\\education\\Git\\projects\\project1'){
                   bat "docker-compose up -d selenium-hub chrome firefox opera"
                   }

            }
        }
        stage('Running test') {
            steps {
                     dir('D:\\education\\Git\\projects\\project1'){
                       bat "mvn test"
                     }
            }
        }
    }
    post{
        always{
             dir('D:\\education\\Git\\projects\\project1'){
             bat "docker-compose down"
        }
    }
    }
}