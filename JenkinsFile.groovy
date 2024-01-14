pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo "This is the authentication service pipeline.."
            }
        }
    }
}

post {
    success {
        echo 'Build successful!'
    }

    failure {
        echo 'Build failed!'
    }
}

