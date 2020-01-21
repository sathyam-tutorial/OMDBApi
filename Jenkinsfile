#!groovy

pipeline {
    agent any
        triggers {
            pollSCM '*/10 * * * *'
        }
        tools {
            gradle "Gradle-6.0.1"
            jdk "JDK-1.8.0.211"
        }

        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }

            stage('Gradle Build and Artifactory upload') {
                steps {
                    withCredentials([usernamePassword(credentialsId: 'MyArtifactory', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                        sh '''
                             set +x
                             echo "Running Gradle Build and uploading jar to Artifactory"
                             gradle -b build.gradle -PUSERNAME=$USERNAME -PPASSWORD=$PASSWORD jar artifactoryPublish
                        '''
                    }
                }
            }

            stage('Docker Build') {
                steps {
                    withCredentials([usernamePassword(credentialsId: 'MyArtifactory', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh '''
                        set +x
                        echo "Running Docker Compose Build"
                        docker-compose build
                    '''
                    }
                }
            }

            stage('Docker Push') {
                steps {
                    withCredentials([usernamePassword(credentialsId: 'DockerHubCreds', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                        sh '''
                        set +x
                        echo "Uploading image to Docker Registry"
                        docker push techsathya/simple-mobile-app:1.0-SNAPSHOT
                        '''
                    }
                }
            }
        }
}