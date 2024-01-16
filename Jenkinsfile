pipeline {
    agent any

    stages {
        stage('Build Package') {
            steps {
                echo 'mvn clean package'
                sh 'mvn clean package'
            }
        }

        stage('Create Docker Image') {
            steps {
                script {
                    docker build -t srijandev123/ai_painter_authentication_service:latest -f Dockerfile .
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                  docker push srijandev123/ai_painter_authentication_service:latest
                }
            }
        }
    }
}

