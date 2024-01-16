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
                sh 'docker build -t srijandev123/ai_painter_authentication_service:latest -f Dockerfile .'
            }
        }

        stage('Push Docker Image') {
            steps {
                sh 'docker push srijandev123/ai_painter_authentication_service:latest'
            }
        }
    }
}

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
