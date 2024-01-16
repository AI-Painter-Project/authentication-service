pipeline {
    agent any
    stages {
        stage('Build Package') {
            steps {
                echo 'mvn clean package'
                sh 'mvn clean package'
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                script {
                    withDockerRegistry([credentialsId: 'jenkins-docker', url: '']) {
                        def dockerImage = docker.build('srijandev123/ai_painter_authentication_service:latest', '-f path/to/Dockerfile .')
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
