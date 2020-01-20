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
                    def gradle = tool 'Gradle-6.0.1'
                    withCredentials([usernamePassword(credentialsId: 'MyArtifactory', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                        sh '''
                             set +x
                             echo "Running Gradle Build"
                             $gradle/gradle -b build.gradle -PUSERNAME=$USERNAME -PPASSWORD=$PASSWORD jar artifactoryPublish
                        '''
                    }
                }
            }
        }
}