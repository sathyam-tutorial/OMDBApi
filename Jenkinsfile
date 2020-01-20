#!groovy

pipeline {
    agent any
        triggers {
            pollSCM '*/10 * * * *'
        }
        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }

            stage('Gradle Build') {
                steps {
                    withCredentials([usernamePassword(credentialsId: 'MyArtifactory', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                        sh '''
                             set +x
                             echo "Running Gradle Build"
                             ./gradle -b build.gradle -PUSERNAME=$USERNAME -PPASSWORD=$PASSWORD jar artifactoryPublish
                        '''
                    }
                }
            }
        }
}