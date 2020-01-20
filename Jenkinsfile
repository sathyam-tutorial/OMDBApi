#!groovy

pipeline {
    agent any
        triggers {
            pollSCM '*/10 * * * *'
        }
        tools {
            gradle 'Gradle-6.0.1'
            jdk 'JDK-1.8.0.211'
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
                             $gradle/gradle -b build.gradle -PUSERNAME=$USERNAME -PPASSWORD=$PASSWORD jar artifactoryPublish
                        '''
                    }
                }
            }
        }
}