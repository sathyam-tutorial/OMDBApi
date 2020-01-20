#!groovy

pipeline {
    agent any
        stages {
            stage('Checkout') {
                steps {
                    triggers {
                        cron(env.BRANCH_NAME == 'customer-mobile-feature' ? 'H */12 * * *' : '')
                      }
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