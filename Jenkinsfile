#!groovy

node('node') {
    try {
        stage('Checkout') {
            checkout scm
        }

        withCredentials([usernamePassword(credentialsId: 'MyArtifactory', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            stage('Gradle Build') {
                sh '''
                     set +x
                     echo "Running Gradle Build"
                     ./gradle -b build.gradle -PUSERNAME=$USERNAME -PPASSWORD=$PASSWORD jar artifactoryPublish
                '''
            }
        }
    }
}